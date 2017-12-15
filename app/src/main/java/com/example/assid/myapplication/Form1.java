package com.example.assid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Form1 extends AppCompatActivity {
String Fluid;
    Double EchelleChoix;
    String choix;
    EditText Length;
    EditText Width;
    EditText Height;
    EditText Speed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);
        Intent intent =getIntent();
        Fluid=intent.getStringExtra("fluide");

        choix= intent.getStringExtra("EchelleChoix");
//get value

        Length = (EditText) findViewById(R.id.Length);
        Width = (EditText) findViewById(R.id.Width);
        Height = (EditText) findViewById(R.id.Height);
        Speed = (EditText) findViewById(R.id.Speed);

        if(choix.matches("Small car"))
            EchelleChoix=(double)1/43;
        else if(choix.matches("Tractor"))
            EchelleChoix=(double) 1/50;
        else if(choix.matches("Tank"))
            EchelleChoix=(double)1/35;
        else if(choix.matches("Motobike"))
            EchelleChoix=(double)1/18;
        else
            return;

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    public void nextz(View view) {
        Intent i = new Intent(this,Form2.class);
        if (Length.getText().toString().matches("")||Width.getText().toString().matches("")||Height.getText().toString().matches("")||Speed.getText().toString().matches(""))
            Toast.makeText(this,"Please check all field  ",Toast.LENGTH_SHORT).show();
        else {
            i.putExtra("Length",Length.getText().toString());
            i.putExtra("Width",Width.getText().toString());
            i.putExtra("Height",Height.getText().toString());
            i.putExtra("Speed",Speed.getText().toString());
            i.putExtra("EchelleChoix",String.valueOf(EchelleChoix));
            i.putExtra("Fluid",Fluid);
            startActivity(i);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
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
