package com.example.chenrong.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenrong.mvpdemo.R;
import com.example.chenrong.mvpdemo.biz.IMovieView;
import com.example.chenrong.mvpdemo.net.MovieEntity;
import com.example.chenrong.mvpdemo.net.Subject;
import com.example.chenrong.mvpdemo.presenler.MoviePresenter;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by chenrong on 2016/11/18.
 */
public class MovieActivity extends AppCompatActivity implements IMovieView {


    private Button btnGetMovie;
    private MoviePresenter moviePresenter;
    private TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        moviePresenter = new MoviePresenter(this);
        initView();
        initEvent();
    }

    private void initEvent() {
        btnGetMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moviePresenter.getMovie();
            }
        });
    }

    private void initView() {
        btnGetMovie = (Button) findViewById(R.id.btn_getMovie);
        result = (TextView) findViewById(R.id.tv_result);
    }


    @Override
    public void setResultText(Throwable e) {
        result.setText(e.getMessage());
    }

    @Override
    public void setResultText(MovieEntity movieEntity) {
        result.setText(movieEntity.toString());
    }

    @Override
    public void setResultText(List<Subject> subjects) {
        result.setText(subjects.get(0).toString());
    }

    @Override
    public void setToast() {
        Toast.makeText(this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
    }
}
