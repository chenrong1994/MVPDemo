package com.example.chenrong.mvpdemo.presenler;

import android.os.Handler;

import com.example.chenrong.mvpdemo.biz.ILogin;
import com.example.chenrong.mvpdemo.biz.ILoginView;
import com.example.chenrong.mvpdemo.biz.LoginBiz;
import com.example.chenrong.mvpdemo.biz.OnLoginListener;
import com.example.chenrong.mvpdemo.model.User;

/**
 * Created by chenrong on 2016/11/7.
 */
public class LoginPresenter {

    private ILogin login;

    private ILoginView iLoginView;

    private Handler handler = new Handler();

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.login = new LoginBiz();
    }

    public void doLogin(){
        iLoginView.showProgressBar();

        login.doLogin(iLoginView.getUsername(), iLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void success(User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideProgressBar();
                        iLoginView.goToNextActivity();
                    }
                });
            }

            @Override
            public void failed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hideProgressBar();
                        iLoginView.showError();
                    }
                });
            }
        });
     }

    public void clear() {
        iLoginView.clear();
    }
}
