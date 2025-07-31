package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<Users> userList;

    public UserAdapter(List<Users> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users users = userList.get(position);
        holder.usernameTextView.setText(users.getUsername());
        holder.passwordTextView.setText(users.getPassword());
        holder.mobileTextView.setText(String.valueOf(users.getMobile()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView;
        TextView passwordTextView;
        TextView mobileTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.item_username);
            passwordTextView = itemView.findViewById(R.id.item_password);
            mobileTextView = itemView.findViewById(R.id.item_mobile);
        }
    }

    public void updateData(List<Users> newUserList) {
        this.userList = newUserList;
        notifyDataSetChanged();
    }
}
