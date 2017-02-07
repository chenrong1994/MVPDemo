package com.example.chenrong.mvpdemo.presenler;

import android.util.Log;
import android.widget.Toast;

import com.example.chenrong.mvpdemo.biz.IMovie;
import com.example.chenrong.mvpdemo.biz.IMovieView;
import com.example.chenrong.mvpdemo.net.ApiException;
import com.example.chenrong.mvpdemo.net.HttpResult;
import com.example.chenrong.mvpdemo.net.MovieEntity;
import com.example.chenrong.mvpdemo.net.MovieService;
import com.example.chenrong.mvpdemo.net.Subject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by chenrong on 2016/11/18.
 */
public class MoviePresenter implements IMovie {
    private IMovieView movieView;

    public MoviePresenter(IMovieView movieView){
        this.movieView = movieView;
    }

    @Override
    public void getMovie() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        final MovieService movieService = retrofit.create(MovieService.class);

        Subscriber subscriber = new Subscriber<List<Subject>>() {
            @Override
            public void onCompleted() {
                Log.w("++++++++++++","onCompleted");
//                movieView.setToast();
            }

            @Override
            public void onError(Throwable e) {
//                movieView.setResultText(e);
                Log.w("++++++++++++","onError");

            }

            @Override
            public void onNext(List<Subject> subjects) {
//                movieView.setResultText(subjects);
                Log.w("++++++++++++","onNext");
            }
        };

        movieService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }
    }
}
