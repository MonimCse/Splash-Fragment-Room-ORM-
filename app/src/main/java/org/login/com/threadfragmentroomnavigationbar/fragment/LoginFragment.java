package org.login.com.threadfragmentroomnavigationbar.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.login.com.threadfragmentroomnavigationbar.ICallBack;
import org.login.com.threadfragmentroomnavigationbar.R;

public class LoginFragment extends Fragment {


    TextView mTvRegistrationPage;
    Button mBtnLogin;

    EditText mEdtEmail;
    EditText mEdtPassword;
    public static ICallBack mICallBack;

    @SuppressLint("ValidFragment")
    private LoginFragment()
    {

    }

    public static LoginFragment newInstant(ICallBack iCallBack)
    {
        mICallBack=iCallBack;
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_login, viewGroup, false);
        init(view);
        return view;


    }

    public void init(View view) {
        mEdtEmail = view.findViewById(R.id.edt_email);
        mEdtPassword = view.findViewById(R.id.edt_password);
        mTvRegistrationPage = view.findViewById(R.id.tv_create_new_account);
        mBtnLogin = view.findViewById(R.id.btn_login);
        mTvRegistrationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mICallBack.replaceRegistrationFragment();
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mICallBack.login(mEdtEmail.getText().toString(),mEdtPassword.getText().toString());
            }
        });
    }

}
