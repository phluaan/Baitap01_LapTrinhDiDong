package com.example.baitap01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau4Activity extends AppCompatActivity {

    private EditText editTextNumbers;
    private Button buttonCheckPrime;
    private TextView textViewResult;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);

        editTextNumbers = findViewById(R.id.editTextNumbers);
        buttonCheckPrime = findViewById(R.id.buttonCheckPrime);
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        buttonCheckPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumbers.getText().toString();

                if (!input.isEmpty()) {
                    String[] numbersStr = input.split(",");
                    ArrayList<Integer> numbers = new ArrayList<>();
                    for (String numStr : numbersStr) {
                        numbers.add(Integer.parseInt(numStr.trim()));
                    }

                    StringBuilder primeNumbers = new StringBuilder("Các số nguyên tố: ");
                    for (int num : numbers) {
                        if (isPrime(num)) {
                            primeNumbers.append(num).append(" ");
                        }
                    }

                    textViewResult.setText(primeNumbers.toString());
                }
            }
        });
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
