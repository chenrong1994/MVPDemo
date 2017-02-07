package com.example.chenrong.mvpdemo.biz;

import com.example.chenrong.mvpdemo.net.MovieEntity;
import com.example.chenrong.mvpdemo.net.Subject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by chenrong on 2016/11/18.
 */
public interface IMovieView {

    void setResultText(Throwable e);

    void setResultText(MovieEntity movieEntity);

    void setResultText(List<Subject> subjects);

    void setToast();
}
