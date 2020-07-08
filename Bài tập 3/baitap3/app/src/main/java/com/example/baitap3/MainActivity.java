package com.example.baitap3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.baitap3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        mainBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // mainBinding.txttitle.setText("Login page");
                mainBinding.toggleButton.setChecked(false);
                mainBinding.editText.setText("Dịch là Đóng");
            }
        });
        mainBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mainBinding.txttitle.setText("Logout page");
                mainBinding.toggleButton.setChecked(true);
                mainBinding.editText.setText("Dịch là mở");
            }
        });
        mainBinding.toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean check = mainBinding.toggleButton.isChecked();
                //if(check){
               //     mainBinding.txttitle.setText("Turn on");
               // }
               // else {
               //     mainBinding.txttitle.setText("Turn off");
              //  }
            }
        });
        mainBinding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 boolean check = mainBinding.toggleButton.isChecked();
                 if(check){
                     mainBinding.txttitle.setText("Turn on ");
                     mainBinding.editText.setText("Dịch là mở");
                     mainBinding.checkBox.setText("Cái này tích rồi");


                 }else {
                     mainBinding.txttitle.setText("Turn off");
                     mainBinding.editText.setText("Dịch là đóng");
                     mainBinding.checkBox.setText("cái này chưa tích!");

                 }
                 // checkbox
                mainBinding.checkBox.toggle();



            }
        });
        mainBinding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainBinding.editText.setText("Bấm được rồi nè");

                Toast.makeText(MainActivity.this,"Text on", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
