package com.naoya.slacker.ui;

import com.naoya.slacker.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Naoya on 15-08-01.
 */
public class UsersAdapter extends RecyclerView.Adapter <UsersAdapter.UserItemViewHolder>{

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserItemViewHolder(view);
    }

    class UserItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.user_name_text_view)
        public TextView mUserNameTextView;
        public UserItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
