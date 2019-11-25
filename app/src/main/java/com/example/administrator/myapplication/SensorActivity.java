package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2019/11/20.
 */

public class SensorActivity extends Activity {

    EditText et3, et4;
    Button btn2, btn3,btn4,btn5;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        textView=findViewById(R.id.textView8);
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    StringBuilder response = (StringBuilder) msg.obj;
                 //   textView.setText(response.toString());
                    Gson gson = new Gson();
                    TokenActivity tokenActivity = gson.fromJson(response.toString(),
                            TokenActivity.class);
                    if (tokenActivity.getStatusCode() == 0) {
                        String value= tokenActivity.getResultObj().get(0).getValue();
                        String unit= tokenActivity.getResultObj().get(0).getUnit();
                        et3.setText(value+unit);
                        String value1= tokenActivity.getResultObj().get(1).getValue();
                        String unit1= tokenActivity.getResultObj().get(1).getUnit();
                        et4.setText(value1+unit1);

                    } else {
                        //获取失败 } }
                    }
                    break;
            }
        }
    };

    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    StringBuilder response = (StringBuilder) msg.obj;
                    //   textView.setText(response.toString());
                    Gson gson = new Gson();
                    TokenoneBean tokenoneBean = gson.fromJson(response.toString(),
                            TokenoneBean.class);
                    if (tokenoneBean.getStatusCode() == 0) {
                        Toast.makeText(SensorActivity.this,"成功",Toast.LENGTH_LONG).show();
                    } else {
                        //获取失败 } }
                    }
                    break;
            }
        }
    };


    Runnable r = new Runnable() {
        @Override
        public void run() {
            requestProject();
            requestProject1();
        }
    };

    public void onClick(View view) {
        new Thread(r).start();
        switch (view.getId()){
            case R.id.btn2:

                break;
            case R.id.btn4:

                break;
            case R.id.btn3:

                break;
            case R.id.btn5:

                break;
        }
    }

    private void requestProject() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://api.nlecloud.com/Projects/47141/Sensors?AccessToken="+Api.getToken());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json");
       //     connection.setRequestProperty("AccessToken",Api.getToken() ); //设置Token
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                Gson gson = new Gson();
                UseroneBean useroneBean = gson.fromJson(response.toString(), UseroneBean.class);
                if (useroneBean.getStatusCode() == 0) {//获取成功
                    //把解析出来的msg内容发送给主线程进行显示
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = response;
                    handler.sendMessage(msg);
                } else {
                    //获取失败 } }
                }
                }
            }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void requestProject1() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://api.nlecloud.com/Cmds?deviceId=60367&apiTag=ufodhdmndupl &AccessToken="+Api.getToken());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json");
            //     connection.setRequestProperty("AccessToken",Api.getToken() ); //设置Token
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                Gson gson = new Gson();
                TokenoneBean tokenoneBean = gson.fromJson(response.toString(), TokenoneBean.class);
                if (tokenoneBean.getStatusCode() == 0) {//获取成功
                    //把解析出来的msg内容发送给主线程进行显示
                    Message msg = new Message();
                    msg.what = 0;
                    msg.obj = response;
                    handler1.sendMessage(msg);
                } else {
                    //获取失败 } }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
