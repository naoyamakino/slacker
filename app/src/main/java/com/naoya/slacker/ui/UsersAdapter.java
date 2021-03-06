package com.naoya.slacker.ui;

import com.naoya.slacker.R;
import com.naoya.slacker.model.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Naoya on 15-08-01.
 */
public class UsersAdapter extends RecyclerView.Adapter <UsersAdapter.UserItemViewHolder>{
    private List<User> mUsers;

    public UsersAdapter(List<User> users) {
        mUsers = users != null? users: new ArrayList<User>();
    }

    public void setUsers(List<User> users) {
        mUsers = users;
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        final User user = mUsers.get(position);
        //TODO: handle poor names with 1 letter
        String name = user.getProfile().getRealName();
        if (name != null && name.length() >= 2) {
            String initial = name.substring(0, 1).toUpperCase();
            String upperString = initial + name.substring(1);
            holder.mInitialTextView.setText(initial);
            holder.mUserNameTextView.setText(upperString);
        }
        holder.mUserNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = UserDetailActivity.getStartIntent(context, user);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserItemViewHolder(view);
    }

    class UserItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.userNameTextView)
        TextView mUserNameTextView;

        @Bind(R.id.initialTextView)
        TextView mInitialTextView;
        public UserItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
