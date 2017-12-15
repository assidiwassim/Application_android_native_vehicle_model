package com.example.assid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
Spinner choix;
    Spinner fluide;
    double EchelleChoix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choix= (Spinner)findViewById(R.id.choix);
        fluide= (Spinner)findViewById(R.id.fluid);
        if(choix.getSelectedItem().toString().matches("Small car"))
            EchelleChoix=(double)1/43;
        else if(choix.getSelectedItem().toString().matches("Tractor"))
            EchelleChoix=(double) 1/50;
        else if(choix.getSelectedItem().toString().matches("Tank"))
            EchelleChoix=(double)1/35;
        else if(choix.getSelectedItem().toString().matches("Motobike"))
            EchelleChoix=(double)1/18;
        else
            return;

    }

    public void next(View view) {
        Intent i = new Intent(this,Form1.class);
        i.putExtra("EchelleChoix",choix.getSelectedItem().toString());
        i.putExtra("fluide",fluide.getSelectedItem().toString());
        startActivity(i);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.item2:
                Intent ii=new  Intent(getApplicationContext(),About.class);
                startActivity(ii);
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.men,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
