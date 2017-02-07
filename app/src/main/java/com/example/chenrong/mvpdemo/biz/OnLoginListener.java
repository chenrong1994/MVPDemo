package com.example.chenrong.mvpdemo.biz;

import com.example.chenrong.mvpdemo.model.User;

/**
 * Created by chenrong on 2016/11/7.
 */
public interface OnLoginListener {
    void success(User user);

    void failed();

}
