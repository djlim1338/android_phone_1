package com.example.project_1889043;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Dialog {
    Button btnLogin, btnLoginPass;
    EditText inPass;
    TextView loginStr;
    SharedPreferences pref;
    SharedPreferences.Editor prefEdit;

    int loginFail = 0;

    public Login(@NonNull Context context, String contents){
        super(context);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        inPass = (EditText) findViewById(R.id.etPass);
        loginStr = (TextView) findViewById(R.id.tvLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPass = inPass.getText().toString();
                if(inputPass.equals(contents) == true){
                    loginStr.setText("로그인 성공!");
                    loginFail = 0;
                    dismiss();
                }
                else if(inputPass.equals("") == true){
                    loginStr.setText("비밀번호를 입력하세요!");
                }
                else{
                    loginFail++;
                    loginStr.setText("비밀번호가 틀렸습니다!["+loginFail+"]");
                }
            }
        });
    }

    @Override
    public void onBackPressed(){ // 뒤로가기 막음
        //super.onBackPressed();
    }
}