package org.login.com.threadfragmentroomnavigationbar.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.login.com.threadfragmentroomnavigationbar.ICallBack;
import org.login.com.threadfragmentroomnavigationbar.R;
import org.login.com.threadfragmentroomnavigationbar.db.AppDatabase;
import org.login.com.threadfragmentroomnavigationbar.db.entities.User;
import org.login.com.threadfragmentroomnavigationbar.fragment.LoginFragment;
import org.login.com.threadfragmentroomnavigationbar.fragment.RegistrationFragment;

import java.util.List;

public class AccountActivity extends AppCompatActivity implements ICallBack {


    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        db = AppDatabase.newInstant(getApplicationContext());
        initFragment(LoginFragment.newInstant(AccountActivity.this));
    }


    private void initFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void replaceRegistrationFragment() {
        initFragment(RegistrationFragment.newInstant(AccountActivity.this));
    }

    @Override
    public void replaceLoginFragment() {
        initFragment(LoginFragment.newInstant(this));
    }

    @Override
    public void login(String email, String password) {

        User user = db.userDao().checkLogin(email, password);
        if (user != null) {
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);


            Bundle bundle = new Bundle();
            bundle.putString("Email", email);
            bundle.putString("Name", user.getUserName());

            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }
    }

    @Override
    public void registration(User user) {
        long id = db.userDao().insert(user);

        List<User> users = db.userDao().getAll();

        if (id > 0) {

            Intent  intent = new Intent(AccountActivity.this, MainActivity.class);



            Bundle bundle = new Bundle();
            bundle.putString("Email", user.getEmail());
            bundle.putString("Name", user.getUserName());

            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
