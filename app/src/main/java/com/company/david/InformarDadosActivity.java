package com.company.david.calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.company.david.calculadoraarea.R.string.base;

public class InformarDadosActivity extends AppCompatActivity {

    private EditText etBase;
    private EditText etAltura;
    private TextView tvAltura;
    private TextView tvBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informardados_quadrado);

        etBase = (EditText) findViewById(R.id.etBase);
        etAltura = (EditText) findViewById(R.id.etAltura);
        tvAltura = (TextView) findViewById(R.id.tvAltura);
        tvBase = (TextView) findViewById(R.id.tvBase);
        verificaFormato();
        }

    public void verificaFormato(){
        Intent intentRecepitor = getIntent();
        String formato = intentRecepitor.getStringExtra("formato");

        if(formato.toString().equals("Quadrado") || formato.toString().equals("Triangulo")) {
            tvAltura.setVisibility(View.VISIBLE);
            etAltura.setVisibility(View.VISIBLE);
        }else if(formato.toString().equals("Circulo")){
            tvBase.setText("Raio : ");
        }
    }

    public void avancarCalcular(View v){

        Intent intentRecepitor = getIntent();
        String formato = intentRecepitor.getStringExtra("formato");
        double altura;
        double base;
        Intent intent = new Intent(this, CalculaActivity.class);

        if(formato.toString().equals("Quadrado") || formato.toString().equals("Triangulo")){
            if(etBase.getText().toString().equals("")){
                etBase.setError("É preciso preencher este campo");
                return;
            }else{
                base = Double.parseDouble(etBase.getText().toString());
            }
            if(etAltura.getText().toString().equals("")){
                etAltura.setError("É preciso preencher este campo");
                return;
            }else{
                altura = Double.parseDouble(etAltura.getText().toString());
            }

            if(formato.toString().equals("Triangulo")){
                double area = (base * altura)/2;
                intent.putExtra("formato", formato);
                intent.putExtra("area", String.valueOf(area));
                startActivity(intent);
            }else if(formato.toString().equals("Quadrado")){
                double area = base * altura;
                intent.putExtra("formato", formato);
                intent.putExtra("area", String.valueOf(area));
                startActivity(intent);
            }

        }else if(formato.toString().equals("Circulo")){
            if(etBase.getText().toString().equals("")){
                etBase.setError("É preciso preencher este campo");
                return;
            }else{
                double raio = Double.parseDouble(etBase.getText().toString());
                double area = 3.14*(raio*raio);
                intent.putExtra("area", String.valueOf(area));
                intent.putExtra("formato", formato);
                startActivity(intent);
            }
        }
    }
}
