package com.naoya.slacker.ui;

import com.naoya.slacker.R;
import com.naoya.slacker.data.disk.DiskDataSource;
import com.naoya.slacker.data.memory.MemoryDataSource;
import com.naoya.slacker.data.remote.RemoteDataSource;
import com.naoya.slacker.model.UserList;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class UsersListActivity extends BaseActivity {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    Subscription mSubscription;

    @Inject
    RemoteDataSource mRemoteDataSource;

    @Inject
    MemoryDataSource mMemoryDataSource;

    @Inject
    DiskDataSource mDiskDataSource;

    private UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUsersAdapter = new UsersAdapter(null);
        mRecyclerView.setAdapter(mUsersAdapter);
        mSubscription = Observable.defer(
                new Func0<Observable<UserList>>() {
                    @Override
                    public Observable<UserList> call() {
                        if (mMemoryDataSource.isCached()) {
                            return mMemoryDataSource.getUsers();
                        } else if (!isNetworkAvailable()) {
                            return mDiskDataSource.getUsers();
                        } else {
                            return mRemoteDataSource.getUsers();
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR))
                .subscribe(new Action1<UserList>() {
                    @Override
                    public void call(UserList userList) {
                        mUsersAdapter.setUsers(userList.getMembers());
                        mUsersAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscription.unsubscribe();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
