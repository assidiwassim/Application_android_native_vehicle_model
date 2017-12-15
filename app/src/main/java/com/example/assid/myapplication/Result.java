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
import android.widget.TextView;

public class Result extends AppCompatActivity {
    double Length;
    double Width;
    double Height;
    double Speed;


    double Wieght;
    double Driven;
    double Bearing;
    double Trail;
    double EchelleChoix;
    String Fluid;

    TextView TLength;
    TextView TWidth;
    TextView THeight;
    TextView TSpeed;


    TextView TWieght;
    TextView TDriven;
    TextView TBearing;
    TextView TTrail;

    double Nu_Aiar=0.0000175;
    double Ro_Air=1.3;
    double Nu_Eau=0.000891;
    double Ro_Eau=1000;
    double ResultSpeed;
    double ResultWieght;
    double ResultDriven;
    double ResultBearing;
    double ResultTrail;
ProgressBar B;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        B= (ProgressBar) findViewById(R.id.progressBarSpin);
        TLength= (TextView) findViewById(R.id.Length);
        TWidth= (TextView) findViewById(R.id.Width);
        THeight= (TextView) findViewById(R.id.Height);
        TSpeed= (TextView) findViewById(R.id.Speed);

        TWieght= (TextView) findViewById(R.id.Wieght);
        TDriven= (TextView) findViewById(R.id.Driven);
        TBearing= (TextView) findViewById(R.id.Bearing);
        TTrail= (TextView) findViewById(R.id.Trail);
        TLength.setVisibility(View.INVISIBLE);
        TWidth.setVisibility(View.INVISIBLE);
        THeight.setVisibility(View.INVISIBLE);
        TSpeed.setVisibility(View.INVISIBLE);

        TWieght.setVisibility(View.INVISIBLE);
        TDriven.setVisibility(View.INVISIBLE);
        TBearing.setVisibility(View.INVISIBLE);
        TTrail.setVisibility(View.INVISIBLE);


        new Handler().postDelayed(new Runnable()
                                  {
                                      public void run()
                                      {



                                          TLength.setVisibility(View.VISIBLE);
                                          TWidth.setVisibility(View.VISIBLE);
                                          THeight.setVisibility(View.VISIBLE);
                                          TSpeed.setVisibility(View.VISIBLE);

                                          TWieght.setVisibility(View.VISIBLE);
                                          TDriven.setVisibility(View.VISIBLE);
                                          TBearing.setVisibility(View.VISIBLE);
                                          TTrail.setVisibility(View.VISIBLE);
                                          B.setVisibility(View.INVISIBLE);


                                      }
                                  }
                , 2000L);



        Intent intent =getIntent();
        Length=Double.parseDouble(intent.getStringExtra("Length"));
        Width=Double.parseDouble(intent.getStringExtra("Width"));
        Height=Double.parseDouble(intent.getStringExtra("Height"));
        Speed=Double.parseDouble(intent.getStringExtra("Speed"));



        Wieght=Double.parseDouble(intent.getStringExtra("Wieght"));
        Driven=Double.parseDouble(intent.getStringExtra("Driven"));
        Bearing=Double.parseDouble(intent.getStringExtra("Bearing"));
        Trail=Double.parseDouble(intent.getStringExtra("Trail"));

        Fluid=intent.getStringExtra("Fluid");
        EchelleChoix=Double.parseDouble(intent.getStringExtra("EchelleChoix"));




        TLength.setText(String.valueOf(Length*EchelleChoix*100));
        TWidth.setText(String.valueOf(Width*EchelleChoix*100));
        THeight.setText(String.valueOf(Height*EchelleChoix*100));

        if(Fluid.matches("Air")) {
            ResultSpeed = (Speed * (double) (1 / EchelleChoix));
            ResultWieght=Wieght*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
            ResultDriven=Driven*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
            ResultBearing =Bearing*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
            ResultTrail=Trail*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
        }
        else {
            ResultSpeed = (Speed * ((double) (Ro_Eau / Ro_Air) * (double) (Nu_Aiar / Nu_Eau) * (double) (1 / EchelleChoix)));
            ResultWieght=Wieght*(double) (Ro_Eau/Ro_Air)*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
            ResultDriven=Driven*(double) (Ro_Eau/Ro_Air)*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));

            ResultBearing=Bearing*(double) (Ro_Eau/Ro_Air)*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
            ResultTrail=Trail*(double) (Ro_Eau/Ro_Air)*( (double)((ResultSpeed*ResultSpeed)/(Speed*Speed))*(EchelleChoix*EchelleChoix));
        }

        TSpeed.setText(String.valueOf(ResultSpeed));




        TWieght.setText(String.valueOf(ResultWieght));
        TDriven.setText(String.valueOf(ResultDriven));
        TBearing.setText(String.valueOf(ResultBearing));
        TTrail.setText(String.valueOf(ResultTrail));

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void cancel(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
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
        }    }
}
