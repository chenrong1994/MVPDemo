package com.example.chenrong.mvpdemo.presenler;

import android.os.AsyncTask;
import android.util.Log;

import com.example.chenrong.mvpdemo.biz.IDownLoad;
import com.example.chenrong.mvpdemo.biz.IDownLoadView;

/**
 *
 * Created by chenrong on 2016/11/13.
 */
public class MainPresenter implements IDownLoad{

    IDownLoadView downLoadView;

    private MyTask myTask;

    public MainPresenter(IDownLoadView downLoadView) {
        this.downLoadView = downLoadView;
        this.myTask = new MyTask();

    }

    public void goToNext(){
        downLoadView.goToNext();
    }

    @Override
    public void doDownLoad() {
        myTask.execute();
    }

    @Override
    public void doCancel() {
        myTask.cancel(true);
    }

    private  class MyTask extends AsyncTask<Object, Integer, Integer> {
        @Override
        protected Integer doInBackground(Object... objects) {
            int i;
            for (i = 0; i <= 100; i += 10) {
                if (isCancelled()) return 0;
                publishProgress(i);
                Log.w("++++++++++", i + "");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (isCancelled()) return;
            int i = values[0];
            downLoadView.setDownLoadProgress(i);
            downLoadView.setDownLoadingText(i);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            downLoadView.setDownLoadText();
            downLoadView.setDownLoadImage();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

        }
    }
}
