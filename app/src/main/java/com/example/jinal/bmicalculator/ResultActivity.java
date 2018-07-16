package com.example.jinal.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    EditText height ;
    EditText weight ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public  void calculate(){
        height = findViewById(R.id.height_input);
        Double heightValue = Double.parseDouble( height.getText().toString());
        weight = findViewById(R.id.weight_input);

        Double weightValue = Double.parseDouble( weight.getText().toString());



    }
}
