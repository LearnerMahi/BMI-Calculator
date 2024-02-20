package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textResult, textResult2;
        EditText edtweight, edtheightFt, edtheightIn;
        Button btnCalculate;

        edtweight = findViewById(R.id.edtweight);
        edtheightFt = findViewById(R.id.edtheightFt);
        edtheightIn = findViewById(R.id.edtheightIn);
        textResult = findViewById(R.id.textResult);
        textResult2 = findViewById(R.id.textResult2); // Initialize textResult2
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheightFt.getText().toString());
                int in = Integer.parseInt(edtheightIn.getText().toString());
                int total = 12 * ft + in;
                double totalCm = total * 2.54;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                // Format the BMI value as a string
                String bmiString = String.format("%.2f", bmi);

                if (bmi > 25) {
                    textResult.setText("You have to reduce your weight");
                    textResult2.setText("BMI: " + bmiString); // Set BMI value
                } else if (bmi < 18) {
                    textResult.setText("You have to gain some weight");
                    textResult2.setText("BMI: " + bmiString); // Set BMI value
                } else {
                    textResult.setText("You are healthy. Congratulations!");
                    textResult2.setText("BMI: " + bmiString); // Set BMI value
                }
            }
        });
    }
}
