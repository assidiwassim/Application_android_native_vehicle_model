package com.example.assid.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Form2 extends AppCompatActivity {
    String Length;
    String Width;
    String Height;
    String Speed;
    Double EchelleChoix;
    String Fluid;

    EditText Wieght;
    EditText Driven;
    EditText Bearing;
    EditText Trail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        Intent intent =getIntent();
        Length=intent.getStringExtra("Length");
        Width=intent.getStringExtra("Width");
        Height=intent.getStringExtra("Height");
        Speed=intent.getStringExtra("Speed");
        Fluid=intent.getStringExtra("Fluid");
        EchelleChoix=Double.parseDouble(intent.getStringExtra("EchelleChoix"));

        Wieght = (EditText) findViewById(R.id.Wieght);
        Driven = (EditText) findViewById(R.id.Driven);
        Bearing = (EditText) findViewById(R.id.Bearing);
        Trail = (EditText) findViewById(R.id.Trail);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void Result(View view) {
        Intent i = new Intent(this,Result.class);


        if (Wieght.getText().toString().matches("")||Driven.getText().toString().matches("")||Bearing.getText().toString().matches("")||Trail.getText().toString().matches(""))
            Toast.makeText(this,"Please check all field  ",Toast.LENGTH_SHORT).show();
        else {
            i.putExtra("Length", Length);
            i.putExtra("Width", Width);
            i.putExtra("Height", Height);
            i.putExtra("Speed", Speed);
            i.putExtra("EchelleChoix", String.valueOf(EchelleChoix));
            i.putExtra("Fluid", Fluid);
            i.putExtra("Wieght", Wieght.getText().toString());
            i.putExtra("Driven", Driven.getText().toString());
            i.putExtra("Bearing", Bearing.getText().toString());
            i.putExtra("Trail", Trail.getText().toString());


            startActivity(i);
        }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.men,menu);
        return super.onCreateOptionsMenu(menu);
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
}
