package com.example.jinal.bmicalculator;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends ListActivity {

    List<PersonHistory> results = new ArrayList<PersonHistory>();
    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userid = bundle.getString("userid");
        }

        InClassDatabaseHelper helper = new InClassDatabaseHelper(HistoryActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Log.d("login activity","userid :"+userid);
        Cursor resultSet = db.rawQuery("Select BMI,DATE from "+InClassDatabaseHelper.HISTORY_TABLE_NAME+" where ID='" + userid+"'",null);

//        DecimalFormat df2 = new DecimalFormat(".##");
        while(resultSet.moveToNext()) {
            PersonHistory pbmi = new PersonHistory();
            String bmiValue = resultSet.getString(0);
            pbmi.setBmi(bmiValue);
            pbmi.setUserid(userid);
            pbmi.setDate(resultSet.getString(1));
            results.add(pbmi);
        }

        ListView listPersonHistory = getListView();
        ArrayAdapter<PersonHistory> listAdapter = new ArrayAdapter<PersonHistory>(
                this,
                android.R.layout.simple_list_item_1,
                results);

        listPersonHistory.setAdapter(listAdapter);
    }

    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        //System.out.println("CLicked on" +results[position].toString());
    }
}

