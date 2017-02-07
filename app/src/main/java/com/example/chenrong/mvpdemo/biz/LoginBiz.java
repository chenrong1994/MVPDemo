package com.example.chenrong.mvpdemo.biz;

import com.example.chenrong.mvpdemo.model.User;

/**
 * Created by chenrong on 2016/11/7.
 */
public class LoginBiz implements ILogin {

    private User user = new User();

    @Override
    public void doLogin(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("".equals(username) && ("").equals(password)) {
                    user.setPassword(password);
                    user.setUsername(username);
                    onLoginListener.success(user);
                } else {
                    onLoginListener.failed();
                }
            }
        }).start();

    }
}
