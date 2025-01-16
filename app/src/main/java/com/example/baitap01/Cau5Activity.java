package com.example.baitap01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau5Activity extends AppCompatActivity {

    private EditText editTextNumbers;
    private Button buttonCheckPerfectSquare;
    private TextView textViewResult;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5);

        editTextNumbers = findViewById(R.id.editTextNumbers);
        buttonCheckPerfectSquare = findViewById(R.id.buttonCheckPerfectSquare);
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonCheckPerfectSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumbers.getText().toString();
                if (!input.isEmpty()) {
                    String[] numbersStr = input.split(",");
                    ArrayList<Integer> numbers = new ArrayList<>();
                    for (String numStr : numbersStr) {
                        numbers.add(Integer.parseInt(numStr.trim()));
                    }

                    StringBuilder perfectSquares = new StringBuilder("Các số chính phương: ");
                    for (int num : numbers) {
                        if (isPerfectSquare(num)) {
                            perfectSquares.append(num).append(" ");
                        }
                    }

                    textViewResult.setText(perfectSquares.toString());
                }
            }
        });
    }

    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return num == sqrt * sqrt;
    }
}
