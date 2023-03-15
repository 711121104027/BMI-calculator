package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText) findViewById(R.id.height);
        weight=(EditText) findViewById(R.id.weight);
        result=(TextView) findViewById(R.id.result);
    }

    public void calculatebmi(View view) {
        String h=height.getText().toString();
        String w=weight.getText().toString();
        if(h!=null && !"".equals(h) && w!=null && !"".equals(w)){
            float hf=Float.parseFloat(h);
            float wf=Float.parseFloat(w);
            float bmi=(wf/(hf*hf)*10000);
            String lab="";
            if(bmi<=18.55){
                lab=getString(R.string.under);
            } else if (bmi>18.55 && bmi<=24.55) {
                lab=getString(R.string.normal);
            } else if (bmi>24.55 && bmi<=29.99) {
                lab=getString(R.string.over);
            }
            else {
                lab=getString(R.string.obesity);
            }
            result.setText(bmi+"\n\n"+lab);
        }
    }
}