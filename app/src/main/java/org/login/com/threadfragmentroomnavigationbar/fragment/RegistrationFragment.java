package org.login.com.threadfragmentroomnavigationbar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.login.com.threadfragmentroomnavigationbar.ICallBack;
import org.login.com.threadfragmentroomnavigationbar.R;
import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

public class RegistrationFragment extends Fragment {

    private Button mBtnRegistration;
    private TextView mTvLoginPage;
    EditText mEdtEmail;
    EditText mEdtPassword;
    EditText mEdtUserName;
    EditText mEdtPhoneNo;
    public static ICallBack mICallBack;

    public static RegistrationFragment newInstant(ICallBack iCallBack) {
        mICallBack = iCallBack;
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_registration, viewGroup, false);
        init(view);
        return view;


    }

    public void init(View view) {

        mEdtEmail = view.findViewById(R.id.edt_email);
        mEdtPassword = view.findViewById(R.id.edt_password);
        mEdtUserName = view.findViewById(R.id.edt_user_name);
        mEdtPhoneNo = view.findViewById(R.id.edt_phoneno);

        mBtnRegistration = view.findViewById(R.id.btn_registation);
        mTvLoginPage = view.findViewById(R.id.tv_login_page);
        mTvLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mICallBack.replaceLoginFragment();
            }
        });


        mBtnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();

                user.setEmail(mEdtEmail.getText().toString());
                user.setPassword(mEdtPassword.getText().toString());
                user.setPhoneNo(mEdtPhoneNo.getText().toString());
                user.setUserName(mEdtUserName.getText().toString());
                mICallBack.registration(user);
            }
        });

    }

}
