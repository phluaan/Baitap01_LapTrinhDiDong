package com.example.baitap01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonOpenCau4;
    private Button buttonOpenCau5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOpenCau4 = findViewById(R.id.buttonOpenCau4);
        buttonOpenCau5 = findViewById(R.id.buttonOpenCau5);

        // Mở màn hình câu 4
        buttonOpenCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cau4Activity.class);
                startActivity(intent);
            }
        });

        buttonOpenCau5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cau5Activity.class);
                startActivity(intent);
            }
        });
    }
}