package com.android.curso.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private  TextView tvhora;
    private  TextView tvFecha;
    private  EditText edtNombre;
    private RadioGroup bgOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tvhora=(TextView)findViewById(R.id.tvHora);
         tvFecha=(TextView)findViewById(R.id.tvFecha);
        edtNombre=(EditText) findViewById(R.id.edtNombre);

        bgOpciones=(RadioGroup)findViewById(R.id.bgOpciones);

    }


    public void fecha(View v){
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mothOfYear, int day) {

                tvFecha.setText(day+"-"+(mothOfYear+1)+"-"+""+year);

            }
        },2016,3,20).show();
    }
    public void hora(View v){
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hora, int minuto) {

                tvhora.setText(hora+"-"+minuto);
            }
        },10,20,true).show();




    }
    public void citar(View v){

        Intent intent=new Intent(this,ConfirmacionActivity.class);
        intent.putExtra("nombre",edtNombre.getText().toString());
        intent.putExtra("fecha",tvFecha.getText().toString());
        intent.putExtra("hora",tvhora.getText().toString());

        int res=bgOpciones.getCheckedRadioButtonId();
        switch (res){
            case R.id.rbtnMedicinaGeneral:
                intent.putExtra("tipo",getResources().getString(R.string.medicinageneral));
                break;
            case R.id.rbtnPediatria:
                intent.putExtra("tipo",getResources().getString(R.string.pediatria));
                break;


        }

     startActivity(intent);


    }
}
