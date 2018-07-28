package com.example.jinal.bmicalculator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    EditText height ;
    EditText weight ;
    TextView bmiresult;
    String userid;
    String hvalue;
    String wvalue;
    Double calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        userid = i.getStringExtra("_id");

    }

    public  void calculate(View view){
        InClassDatabaseHelper helper = new InClassDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        // gets the height
        height = (EditText) findViewById(R.id.height_input);
        hvalue =  height.getText().toString();
        weight = (EditText) findViewById(R.id.weight_input);
        wvalue =  weight.getText().toString();
        if(!hvalue.equals("") && !wvalue.equals("")) {
            Double heightVal= Double.parseDouble(hvalue);
            Double weightVal= Double.parseDouble(wvalue);

            calc= (weightVal/ (heightVal* heightVal));
            TextView result = (TextView) findViewById(R.id.bmiresult);

            result.setText("BMI Index: "+ String.format("%.2f", calc));
            PersonHistory personHistory = new PersonHistory(userid,hvalue,wvalue,String.format("%.2f", calc),"");
            helper.createHistory(personHistory);
        }

    }
    public void viewHistory(View v){

        InClassDatabaseHelper helper = new InClassDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();


        Intent bmiListIntent = new Intent(getApplicationContext(),HistoryActivity.class);
        Bundle b = new Bundle();
        b.putString("userid",userid);
        bmiListIntent.putExtras(b);
        startActivity(bmiListIntent);
    }
}
