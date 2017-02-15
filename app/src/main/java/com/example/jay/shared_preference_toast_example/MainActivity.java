package com.example.jay.shared_preference_toast_example;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mName;
    EditText mAge;
    EditText mPhone;
    EditText mCity;

    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.nameInput);
        mAge = (EditText) findViewById(R.id.ageInput);
        mPhone =(EditText) findViewById(R.id.phoneInput);
        mCity =(EditText) findViewById(R.id.cityInput);
        dataView = (TextView) findViewById(R.id.dataTextView);

    }

    // Lesson 64
    //Save login info
    public void saveData(View view) {
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("Name", mName.getText().toString());
        editor.putString("Age", mAge.getText().toString());
        editor.putString("Phone", mPhone.getText().toString());
        editor.putString("City", mCity.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void getData(View view) {
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("Name", "");
        String age = loginData.getString("Age", "");
        String phone = loginData.getString("Phone", "");
        String city = loginData.getString("City", "");
        String msg = "Name: " + name + "\nAge: " + age + "\nPhone: " + phone + "\nCity: " +city ;
//        dataView.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}