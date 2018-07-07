package org.login.com.threadfragmentroomnavigationbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.login.com.threadfragmentroomnavigationbar.MyAdapter;
import org.login.com.threadfragmentroomnavigationbar.R;
import org.login.com.threadfragmentroomnavigationbar.db.AppDatabase;
import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    RecyclerView mRvUsers;
    List<User> users;

    AppDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_home, viewGroup, false);
        db = AppDatabase.newInstant(getContext());
        init(view);
        return view;


    }

    private void init(View view)
    {

        users = db.userDao().getAll();

        mRvUsers = view.findViewById(R.id.rv_user);
        mRvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvUsers.setAdapter(new MyAdapter(users));
    }
}
