package com.example.chenrong.mvpdemo.view;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenrong.mvpdemo.R;
import com.example.chenrong.mvpdemo.biz.ILoginView;
import com.example.chenrong.mvpdemo.presenler.LoginPresenter;
import com.example.chenrong.mvpdemo.widget.LoadingDialog;
import com.example.chenrong.mvpdemo.widget.LoadingDialogUtil;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnCancel;

    private LoadingDialog.Builder builder;

    private LoadingDialog mLoadingDialog;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    private void initEvent() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.clear();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin();
            }
        });
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }


    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void clear() {
        etPassword.setText("");
        etUsername.setText("");
        Toast.makeText(this,"清空！",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"登陆失败！",Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToNextActivity() {
        Toast.makeText(this,"登陆成功！",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    public void showProgressBar() {
        mLoadingDialog = new LoadingDialog.Builder(this)
                .setMsg("正在登陆。。。")
                .create();
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.show();
    }

    @Override
    public void hideProgressBar() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

}
