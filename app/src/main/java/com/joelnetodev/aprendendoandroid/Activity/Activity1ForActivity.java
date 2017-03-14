package com.joelnetodev.aprendendoandroid.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.joelnetodev.aprendendoandroid.R;
import com.joelnetodev.aprendendoandroid.Util.UtilClass;

public class Activity1ForActivity extends AppCompatActivity
{
    //LinearLayout linearCreate;
    //LinearLayout linearRestart;

    final String mensagem = "Método chamado: ";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nova Activity");

        Bundle extras = getIntent().getExtras();
        String valorExtra = extras.getString("digitado");
        TextView txtView = (TextView) findViewById(R.id.txtValorDigitado);
        txtView.setText("Valor digitado: " + valorExtra);

        UtilClass.mostrarAlerta(this, mensagem + "onCreate()");

        //linearCreate = (LinearLayout) findViewById(R.id.layoutCreate);
        //linearRestart = (LinearLayout) findViewById(R.id.layoutRestart);

        //linearCreate.setVisibility(View.VISIBLE);
        //linearRestart.setVisibility(View.GONE);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        UtilClass.mostrarAlerta(this, mensagem + "onRestart()");

        //linearCreate.setVisibility(View.GONE);
        //linearRestart.setVisibility(View.VISIBLE);
    }
}
