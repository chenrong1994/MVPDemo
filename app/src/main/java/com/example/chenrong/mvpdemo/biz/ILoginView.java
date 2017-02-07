package com.example.chenrong.mvpdemo.biz;

/**
 * Created by chenrong on 2016/11/7.
 */
public interface ILoginView {


    String getUsername ();

    String getPassword();

    void clear();

    void showError();

    void goToNextActivity();

    void showProgressBar();

    void hideProgressBar();

}
