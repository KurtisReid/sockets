package com.example.kreid.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.kreid.myapplication.R;
//import com.example.sairamkrishna.myapplication.R;
//import com.example.sairamkrishna.myapplication.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//com.example.sairamkrishna.myapplication

public class MainActivity extends ActionBarActivity {
    EditText ed1,ed2,ed3,ed4,ed5;

    private String url1 = "http://kurtisreid.github.io/";
    private String url2 = "LFST.xml";
    private HandleXml obj;
    Button b1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = ed1.getText().toString();
                String finalUrl = url1 + url2;
                ed2.setText(finalUrl);

                obj = new HandleXml(finalUrl);
                obj.fetchXML();

                while(obj.parsingComplete);
                ed2.setText(obj.getCountry());
                ed3.setText(obj.getTemperature());
                ed4.setText(obj.getHumidity());
                ed5.setText(obj.getPressure());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.textView2) {
            return true;
        }
        Log.i("MainActivity", "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }
}