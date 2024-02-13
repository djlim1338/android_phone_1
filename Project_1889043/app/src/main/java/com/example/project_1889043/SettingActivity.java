package com.example.project_1889043;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor prefEdit;
    Button btnSubmit, btnReset, btnEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnEmail = (Button) findViewById(R.id.btnSendEmail);

        pref = getSharedPreferences("com.example.project_1889043_preferences", Context.MODE_PRIVATE);
        prefEdit = pref.edit();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pref.getBoolean("password", false) == true) {
                    if (pref.getString("passwordValue", "") == "") {
                        Toast.makeText(getApplicationContext(), "비밀번호를 입력하셔야 합니다!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(SettingActivity.this);
                ad.setTitle("초기화");
                ad.setMessage("설정값을 기본값으로 초기화 시키겠습니까?");

                ad.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        prefEdit.clear();
                        prefEdit.commit();
                        finish();
                    }
                });
                ad.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ad.show();
            }
        });

        btnEmail.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                String[] address = {"1889043@pcu.ak.kr"};
                String tStr = "--------------------------------------------------\n"
                        + "보내는 유형을 작성해주세요.\n[문의, 버그발견, 요청사항, 기타]\n"
                        + "유형 : \n"
                        + "--------------------------------------------------\n";
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT, "APP_휴대폰_위치찾기_사용자로부터");
                email.putExtra(Intent.EXTRA_TEXT, tStr);
                startActivity(email);
            }
        });


    }

    @Override
    public void onBackPressed(){ // 뒤로가기 비밀번호 확인
        if(pref.getBoolean("password", false) == true) {
            if (pref.getString("passwordValue", "") == "") {
                Toast.makeText(getApplicationContext(), "비밀번호를 입력하셔야 합니다!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        super.onBackPressed();
    }

}