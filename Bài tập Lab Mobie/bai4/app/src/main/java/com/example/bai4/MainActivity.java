package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView Name;
    TextView Year;
    TextView Notices;
    Button btnCal;
    int age;
    Activity age_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (TextView) findViewById(R.id.inputName);
        Year = (TextView) findViewById(R.id.inputYear);
        Notices = (TextView) findViewById(R.id.txtNotices);
        btnCal = (Button) findViewById(R.id.btnCal);
        Notices.setTextColor(Color.BLUE);
        Notices.setTextSize(24);
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(Year.getText().toString());
                Notices.setText("Bạn "+Name.getText()+ ' ' +age+" Tuổi");
            }
        });

    }
}
