package com.example.chenrong.mvpdemo.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.chenrong.mvpdemo.R;
import com.example.chenrong.mvpdemo.biz.IDownLoadView;
import com.example.chenrong.mvpdemo.presenler.MainPresenter;

/**
 * Created by chenrong on 2016/11/7.
 */
public class MainActivity extends AppCompatActivity implements IDownLoadView {

    private ProgressBar progressBar;
    private TextView textView;
    private ImageView imageView;
    private Button button;
    private Button btnNext;

    private MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();

    }

    private void initEvent() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.doDownLoad();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.doCancel();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.goToNext();
            }
        });
    }

    private void initView() {
        progressBar = (ProgressBar) findViewById(R.id.pb_main);
        textView = (TextView) findViewById(R.id.tv_main);
        imageView = (ImageView) findViewById(R.id.iv_main);
        button = (Button) findViewById(R.id.btn_main_cancel);
        btnNext = (Button) findViewById(R.id.btn_next);
    }

    @Override
    public void setDownLoadText() {
        textView.setText("完成。");
    }

    @Override
    public void setDownLoadingText(int i) {
        switch (i % 6) {
            case 1:
                textView.setText("等待服务器响应: .");
                break;
            case 2:
                textView.setText("等待服务器响应: . .");
                break;
            case 3:
                textView.setText("等待服务器响应: . . .");
                break;
            case 4:
                textView.setText("等待服务器响应: . . . .");
                break;
            case 5:
                textView.setText("等待服务器响应: . . . . .");
                break;
            case 0:
                textView.setText("等待服务器响应: . . . . . .");
                break;
        }
    }

    @Override
    public void setDownLoadProgress(int i) {
        progressBar.setProgress(i);
    }

    @Override
    public void setDownLoadImage() {
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void goToNext() {
        Intent intent = new Intent(MainActivity.this,MovieActivity.class);
        startActivity(intent);
    }

}
