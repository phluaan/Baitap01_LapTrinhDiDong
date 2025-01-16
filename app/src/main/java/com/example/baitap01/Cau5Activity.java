package com.example.baitap01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Cau5Activity extends AppCompatActivity {

    private EditText editTextNumberOfElements;
    private Button buttonGenerateAndCheck;
    private TextView textViewResult;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5);

        editTextNumberOfElements = findViewById(R.id.editTextNumberOfElements);
        buttonGenerateAndCheck = findViewById(R.id.buttonGenerateAndCheck);
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonGenerateAndCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumberOfElements.getText().toString();

                if (!input.isEmpty()) {
                    int numberOfElements = Integer.parseInt(input);

                    ArrayList<Integer> randomNumbers = generateRandomNumbers(numberOfElements);
                    ArrayList<Integer> perfectSquares = getPerfectSquares(randomNumbers);

                    StringBuilder result = new StringBuilder("Các số chính phương: ");
                    for (int num : perfectSquares) {
                        result.append(num).append(" ");
                    }

                    textViewResult.setText(result.toString());

                    Toast.makeText(Cau5Activity.this, result.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Cau5Activity.this, "Vui lòng nhập số phần tử", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private ArrayList<Integer> generateRandomNumbers(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
        return numbers;
    }

    private ArrayList<Integer> getPerfectSquares(ArrayList<Integer> numbers) {
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        for (int num : numbers) {
            if (isPerfectSquare(num)) {
                perfectSquares.add(num);
            }
        }
        return perfectSquares;
    }

    private boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt == (int) sqrt;
    }
}
