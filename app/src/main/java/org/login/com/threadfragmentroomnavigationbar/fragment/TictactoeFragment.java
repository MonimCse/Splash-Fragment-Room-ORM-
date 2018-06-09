package org.login.com.threadfragmentroomnavigationbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.login.com.threadfragmentroomnavigationbar.R;

public class TictactoeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_tictactoe, viewGroup, false);
        init(view);
        return view;


    }

    private void init(View view)
    {

    }
}
