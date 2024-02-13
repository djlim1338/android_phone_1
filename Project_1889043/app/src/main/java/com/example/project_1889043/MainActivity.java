package com.example.project_1889043;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.CustomDescription;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnOption;
    private Login loginDialog;
    SharedPreferences pref;
    SharedPreferences.Editor prefEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnOption = (Button) findViewById(R.id.btnOption);

        pref = getSharedPreferences("com.example.project_1889043_preferences", Context.MODE_PRIVATE);
        prefEdit = pref.edit();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
            }
        });

        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        if(pref.getBoolean("password", false) == true) {    // 비밀번호 안정하고 강제로 껐을 때 비밀번호 설정 꺼버림
            String passwordValue = pref.getString("passwordValue", "");
            if (passwordValue == "") {
                prefEdit.putBoolean("password", false);
                prefEdit.commit();
            }
            else{
                loginDialog = new Login(this, passwordValue);
                loginDialog.setCancelable(false);   // 로그인 안하면 못들어가게 뒤 화면 터지 불가
                loginDialog.show();
            }
        }
    }
}