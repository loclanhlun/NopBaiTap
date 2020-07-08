package com.example.formregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.formregister.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        final View view =  mainBinding.getRoot();
        setContentView(view);

        //sự kiện togglebutton
        mainBinding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean check = mainBinding.toggleButton.isChecked();
                if(check){
                    mainBinding.toggleButton.setChecked(true);
                    Toast.makeText(MainActivity.this,"Nữ",Toast.LENGTH_SHORT).show();

                }
                else {
                    mainBinding.toggleButton.setChecked(false);
                    Toast.makeText(MainActivity.this,"Nam", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //sự kiện checkbox
        mainBinding.single.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean check1 = mainBinding.single.isChecked();
                if(check1){
                    mainBinding.single.setChecked(true);
                    Toast.makeText(MainActivity.this,"Đã có gia đình",Toast.LENGTH_SHORT).show();
                }else {
                    mainBinding.single.setChecked(false);
                    Toast.makeText(MainActivity.this,"Chưa có gia đình", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //sự kiện button đăng ký
       mainBinding.btnReg.setOnClickListener(new View.OnClickListener() {


           @Override
           public void onClick(View v) {
               String sg;
               if(mainBinding.single.isChecked()){
                   sg = "chưa có gia đình";

               }else{

                   sg = "có gia đình";
               }


               Toast.makeText(MainActivity.this,"Tên người dùng: " + mainBinding.edt1.getText() + "\r\n"
                       + "Ngày sinh: " + mainBinding.edt2.getText()+"\r\n"
                       + "Email: " + mainBinding.edt3.getText()+ "\r\n"
                       + "Single: " + sg + "\r\n"
                       + "Giới tính: " + mainBinding.toggleButton.getText() + "\r\n"
                       + "Mật khẩu: " + mainBinding.edt4.getText()+ "\r\n",Toast.LENGTH_SHORT).show();
           }
       });
    }
}
