package org.login.com.threadfragmentroomnavigationbar;

import org.login.com.threadfragmentroomnavigationbar.db.entities.User;

public interface ICallBack {

    void replaceRegistrationFragment();
    void replaceLoginFragment();
    void login(String email,String password);
    void registration(User user);
}
