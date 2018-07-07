package org.login.com.threadfragmentroomnavigationbar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.login.com.threadfragmentroomnavigationbar.activities.MainActivity;
import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<User> users;

    public MyAdapter(List<User> a)
    {
        this.users = a;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = users.get(position);

                holder.mTvName.setText(user.getUserName());
                holder.mTvEmail.setText(user.getEmail());
                holder.mTvPhoneno.setText(user.getPhoneNo());
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName;
        TextView mTvEmail;
        TextView mTvPhoneno;
        public MyViewHolder(View itemView) {
            super(itemView);

            mTvName = itemView.findViewById(R.id.tv_name);
            mTvEmail = itemView.findViewById(R.id.tv_email);
            mTvPhoneno = itemView.findViewById(R.id.tv_phone_no);
        }
    }
}
