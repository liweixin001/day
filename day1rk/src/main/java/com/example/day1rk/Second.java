package com.example.day1rk;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

public class Second  extends AppCompatActivity {

    private ListView lv;
    private String myurl="https://www.apiopen.top/satinCommentApi?id=27610708&page=1";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        lv = findViewById(R.id.lv);
        MyTask myTask = new MyTask();
        myTask.execute(myurl);
    }

    private class MyTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            String str=null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                str=zhuanhuan(inputStream);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            bean1 bean1 = gson.fromJson(s, bean1.class);
            List<bean1.DataBean.NormalBean.ListBeanX> data=bean1.getData().getNormal().getList();
            ListviewAdapter adapter = new ListviewAdapter(data,Second.this);
            lv.setAdapter(adapter);
        }
    }

    private String zhuanhuan(InputStream inputStream) {
        StringBuilder builder = new StringBuilder();
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((str=reader.readLine())!=null){
                builder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

