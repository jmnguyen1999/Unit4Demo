package com.example.unit4demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.unit4demo.models.Movie;

import org.parceler.Parcels;

public class SecondActivity extends AppCompatActivity {

    //My own instance of widgets:
    TextView tvValueGiven;
    TextView tvValueLabel;
    Button btnGoBack;
    Button btnIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //1.) Connect MY widgets to talk to the widgets in activity_second.xml:
        tvValueLabel = findViewById(R.id.tvValueLabel);
        tvValueGiven = findViewById(R.id.tvValueGiven);
        btnGoBack = findViewById(R.id.btnGoBack);
        btnIncrement = findViewById(R.id.btnIncrement);

        //2.) TODO: Receive intent, do something to the value, and pass it back:
        int receivedData = getIntent().getIntExtra("value", -1);

        //TODO: print out received value here:
        tvValueGiven.setText(String.valueOf(receivedData));


        //3.) Make buttons do things:
        //2a.) btnGoBack --> go back to MainActivity:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(tvValueGiven.getText().toString());

                //TODO: Set result to pass back data to MainActivity:
                Intent goBack = new Intent();
                goBack.putExtra("result", result);
                setResult(RESULT_OK, goBack);

                finish();
            }
        });

        //2b.) btnIncrement --> add 1 to the current value:
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currValue = Integer.parseInt(tvValueGiven.getText().toString());
                currValue++;
                tvValueGiven.setText(String.valueOf(currValue));
            }
        });

    }
}















/*
       //2.) ODO: Receive intent, do something to the value, and pass it back:
        int value = getIntent().getIntExtra("value", -1);



 tvValueGiven.setText(String.valueOf(value));

//ODO: Set result to pass back data to MainActivity:
                int result = Integer.parseInt(tvValueGiven.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("result", result);
                setResult(RESULT_OK, intent);
                finish();
 */