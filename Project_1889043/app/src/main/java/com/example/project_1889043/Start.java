package com.example.project_1889043;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Start extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor prefEdit;

    EditText pass, bg, loc, cam, sp, se, sc, ssid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        pref = getSharedPreferences("com.example.project_1889043_preferences", Context.MODE_PRIVATE);
        prefEdit = pref.edit();

        pass = (EditText) findViewById(R.id.etPass);
        bg = (EditText) findViewById(R.id.etBg);
        loc = (EditText) findViewById(R.id.etLoc);
        cam = (EditText) findViewById(R.id.etCam);
        sp = (EditText) findViewById(R.id.etSendP);
        se = (EditText) findViewById(R.id.etSendE);
        sc = (EditText) findViewById(R.id.etSendC);
        ssid = (EditText) findViewById(R.id.etSsid);

        String passStr = "비밀번호 : ";
        if(pref.getBoolean("password", false)) passStr+="[사용함] ";
        else passStr+="[사용안함] ";
        passStr += pref.getString("passwordValue", " ");
        pass.setText(passStr);

        String bgStr = "백그라운드 실행 : ";
        if(pref.getBoolean("background", false)) bgStr+="[사용함] ";
        else bgStr+="[사용안함] ";
        bg.setText(bgStr);

        String locStr = "위치서비스 : ";
        if(pref.getBoolean("location", false)) locStr+="[사용함] ";
        else locStr+="[사용안함] ";
        loc.setText(locStr);

        String camStr = "카메라 : ";
        if(pref.getBoolean("camera", false)) camStr+="[사용함] ";
        else camStr+="[사용안함] ";
        if(pref.getBoolean("cameraBCk", false)) camStr+="[후면 사용함] ";
        else camStr+="[후면 사용안함] ";
        if(pref.getBoolean("cameraFCk", false)) camStr+="[전면 사용함] ";
        else camStr+="[전면 사용안함] ";
        cam.setText(camStr);

        String spStr = "휴대폰 : ";
        if(pref.getBoolean("sendPhone", false)) spStr+="[사용함] \n";
        else spStr+="[사용안함] ";
        spStr += pref.getString("phoneValue", " ").toString();
        sp.setText(spStr);

        String seStr = "이메일 : ";
        if(pref.getBoolean("sendEmail", false)) seStr+="[사용함] \n";
        else seStr+="[사용안함] ";
        seStr += pref.getString("emailValue", " ").toString();
        se.setText(seStr);

        String scStr = "전송 : ";
        if(pref.getBoolean("send", false)) scStr+="[사용함] ";
        else scStr+="[사용안함] ";
        scStr += ("송신주기:" + pref.getString("sendCycle", " "));
        sc.setText(scStr);

        String ssidStr = "ssid수집 : ";
        if(pref.getBoolean("ssid", false)) ssidStr+="[사용함] ";
        else ssidStr+="[사용안함] ";
        ssid.setText(ssidStr);


    }
}