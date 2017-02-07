package com.example.chenrong.mvpdemo.biz;

/**
 * Created by chenrong on 2016/11/7.
 */
public interface ILogin {
    void doLogin(String username, String password, OnLoginListener onLoginListener);

}
