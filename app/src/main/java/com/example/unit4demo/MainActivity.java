package com.example.unit4demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unit4demo.models.Movie;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    //My own instances of widgets:
    EditText etInput;
    Button btnGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.) Connect MY widgets to talk to the widgets in activity_main.xml:
        etInput = findViewById(R.id.etInput);
        btnGo = findViewById(R.id.btnGo);


        //2.) When btnGo is clicked --> Go to SecondActivity!
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //1.) Get the input from the user:
                String input = etInput.getText().toString();
                etInput.setText("");    //clear the EditText

                try {
                    int value = Integer.parseInt(input);

                    //TODO: Make intent here to pass data to SecondActivity
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("value",value);

                    startActivityForResult(i, 123456789);

                } catch(NumberFormatException error){
                    Toast.makeText(getApplicationContext(), "You did not enter a number!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_logout:
                LogOutAction(item);
            case R.id.item_settings:
                SettingsAction(item);
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123456789 && resultCode == RESULT_OK){
            Toast.makeText(this, "Result received: " + data.getIntExtra("result", -1), Toast.LENGTH_SHORT).show();
        }
    }

    public void LogOutAction(MenuItem item){
        Toast.makeText(this, "Logout button was clicked!", Toast.LENGTH_SHORT).show();
    }
    public void SettingsAction(MenuItem item){
        Toast.makeText(this, "Settings button was clicked!", Toast.LENGTH_SHORT).show();
    }
}



















/*

   //ODO: Make intent here to pass data to SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("value", value);
                    startActivityForResult(intent, 123456789);




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123456789 && resultCode == RESULT_OK){
            Toast.makeText(this, "Received Result:  " + data.getIntExtra("result", -1), Toast.LENGTH_SHORT).show();
        }
    }
 */



/*


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_logout:
                LogoutAction(item);
                return true;

            case R.id.item_settings:
                SettingsAction(item);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void LogoutAction(MenuItem item){
        Toast.makeText(this, "Logout button clicked!", Toast.LENGTH_SHORT).show();
    }
    public void SettingsAction(MenuItem item){
        Toast.makeText(this, "Settings button clicked!", Toast.LENGTH_SHORT).show();
    }
 */