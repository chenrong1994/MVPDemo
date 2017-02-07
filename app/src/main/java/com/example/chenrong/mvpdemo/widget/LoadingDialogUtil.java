package com.example.chenrong.mvpdemo.widget;

import android.content.Context;

/**
 * Created by chenrong on 2016/11/17.
 */
public class LoadingDialogUtil {

    private static LoadingDialog.Builder builder;

    private static LoadingDialog mLoadingDialog;

    public static void showLoadingDialog(Context context, String s){
        if (builder == null) {
            builder = new LoadingDialog.Builder(context);
        }
        builder.setMsg(s);
        if (mLoadingDialog == null) {
            mLoadingDialog = builder.create();
        }
        mLoadingDialog.show();
    }

    public static void hideLoadingDialog(){
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
            builder = null;
            mLoadingDialog = null;
        }
    }
}
