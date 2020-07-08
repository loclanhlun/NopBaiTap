package com.example.thitracnghiem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radiogr1,radiogr2,radiogr3;
    RadioButton radiobtna1, radiobtnb1,radiobtnc1,radiobtnd1;
    RadioButton radiobtna2, radiobtnb2,radiobtnc2,radiobtnd2;
    RadioButton radiobtna3, radiobtnb3,radiobtnc3,radiobtnd3;
    Button btnKQ, btnLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();

    }
    public void setWidget(){
        //cau1
        radiobtna1 = (RadioButton) findViewById(R.id.rab_a1);
        radiobtnb1 = (RadioButton) findViewById(R.id.rab_b1);
        radiobtnc1 = (RadioButton) findViewById(R.id.rab_c1);
        radiobtnd1 = (RadioButton) findViewById(R.id.rab_d1);
        //cau2
        radiobtna2 = (RadioButton) findViewById(R.id.rab_a2);
        radiobtnb2 = (RadioButton) findViewById(R.id.rab_b2);
        radiobtnc2 = (RadioButton) findViewById(R.id.rab_c2);
        radiobtnd2 = (RadioButton) findViewById(R.id.rab_d2);
        //cau3
        radiobtna3 = (RadioButton) findViewById(R.id.rab_a3);
        radiobtnb3 = (RadioButton) findViewById(R.id.rab_b3);
        radiobtnc3 = (RadioButton) findViewById(R.id.rab_c3);
        radiobtnd3 = (RadioButton) findViewById(R.id.rab_d3);

        radiogr1 = (RadioGroup) findViewById(R.id.radio_gr1);
        radiogr2 = (RadioGroup) findViewById(R.id.radio_gr2);
        radiogr3 = (RadioGroup) findViewById(R.id.radio_gr3);
         btnKQ = (Button) findViewById(R.id.btn_ketqua);
        btnLL = (Button) findViewById(R.id.btn_lamlai);

    }
    public void Ketqua (View view){
        if(view.getId() == R.id.btn_ketqua){
            int a = 0;
            if(radiobtnc1.isChecked() == true){

                a+= 3;
            }
            if(radiobtnc2.isChecked() == true){
                a+= 3;
            }
            if(radiobtnc3.isChecked() == true) {
                a += 4;

            }
            AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
            ab.setTitle("Kết quả điểm thi");
            ab.setMessage(a + "/10");
            ab.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this, "Chúc mừng bạn đã làm xong bài thi", Toast.LENGTH_SHORT).show();
                }
            });

            ab.show();

        }

    }
    public void lamlai(View view){
        if(view.getId() == R.id.btn_lamlai){
            AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
            ab.setTitle("Cảnh báo!");
            ab.setMessage("bạn có thật sự muốn làm lại?");
            ab.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    radiogr1.clearCheck();
                    radiogr2.clearCheck();
                    radiogr3.clearCheck();
                    Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
                }
            });
            ab.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Thất bại", Toast.LENGTH_SHORT).show();
                }
            });
            ab.show();

        }

    }







}


