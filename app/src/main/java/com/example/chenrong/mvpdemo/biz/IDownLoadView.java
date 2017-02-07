package com.example.chenrong.mvpdemo.biz;

/**
 * Created by chenrong on 2016/11/13.
 */
public interface IDownLoadView {

    void setDownLoadText();

    void setDownLoadingText(int i);

    void setDownLoadProgress(int i);

    void setDownLoadImage();

    void goToNext();
}
