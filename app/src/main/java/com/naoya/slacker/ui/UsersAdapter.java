package com.naoya.slacker.ui;

import com.naoya.slacker.R;
import com.naoya.slacker.model.User;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Naoya on 15-08-01.
 */
public class UsersAdapter extends RecyclerView.Adapter <UsersAdapter.UserItemViewHolder>{
    private List<User> mUsers;

    public UsersAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.mUserNameTextView.setText(user.getName());
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
        @Bind(R.id.user_name_text_view)
        TextView mUserNameTextView;
        public UserItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
