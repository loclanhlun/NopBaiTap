package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnDangKy, btnThoat;
    EditText editEmail, editPass;
    FirebaseAuth mAuthencation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthencation = FirebaseAuth.getInstance();
        Anhxa();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dangky();
            }
        });


    }
    private  void Dangky(){
        String email = editEmail.getText().toString();
        String pass = editPass.getText().toString();
        mAuthencation.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();

                }
            }
            });

    }
    private void Anhxa(){
        btnDangKy = (Button) findViewById(R.id.button);
        btnThoat = (Button) findViewById(R.id.button2);
        editEmail = (EditText) findViewById(R.id.editText);
        editPass = (EditText)findViewById(R.id.editText2);

    }
}
