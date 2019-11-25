package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends Activity {
    EditText et1;
    EditText et2;
    Button btn1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btn1=findViewById(R.id.btn1);
        textView=findViewById(R.id.textView3);
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    StringBuilder response = (StringBuilder) msg.obj;
                    textView.setText(response.toString());
                    Gson gson = new Gson();
                    LoginResult loginResult = gson.fromJson(response.toString(),
                            LoginResult.class);
                    if (loginResult.getStatusCode() == 0) {
                       String token= loginResult.getResultObj().getAccessToken();
                       Api.setToken(token);
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
        }
    };


    public void onClick(View view) {
        new Thread(r).start();
        Intent intent=new Intent(MainActivity.this,SensorActivity.class);
        startActivity(intent);
    }


    private void requestProject() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://api.nlecloud.com/Users/Login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json");
      //      connection.setRequestProperty("AccessToken", Api.getToken()); //设置Token
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStream outputStream=connection.getOutputStream();
//            jsonMaker.addParams("Account","13616575283");
//            jsonMaker.addParams("Password","135790");
//            jsonMaker.addParams("IsRememberMe",true);

            UserBean userBean = new UserBean();
            userBean.setAccount(et1.getText().toString());
            userBean.setPassword(et2.getText().toString());
            userBean.setIsRememberMe(true);
            String jsonStr = new Gson().toJson(userBean);

            //     String jsonstr=jsonMaker.getJSONString();
            outputStream.write(jsonStr.getBytes());
            outputStream.flush();
            outputStream.close();
            int code=connection.getResponseCode();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                Gson gson = new Gson();
                LoginResult loginResult = gson.fromJson(response.toString(),
                      LoginResult.class);
                if (loginResult.getStatusCode() == 0) {//获取成功
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
}