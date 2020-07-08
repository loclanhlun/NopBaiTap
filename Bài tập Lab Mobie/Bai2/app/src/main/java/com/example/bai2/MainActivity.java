package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnChangImage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangImage = (Button) findViewById(R.id.btnChangImage);
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.kimetsunoyaiba);
        btnChangImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imageView.setBackgroundResource(R.drawable.onepunchman);
            }
        });
    }
}
