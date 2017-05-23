package com.company.david.calculadoraarea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgFormato;
    private RadioButton rbCirculo;
    private RadioButton rbQuadrado;
    private RadioButton rbTriangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgFormato = (RadioGroup) findViewById(R.id.rgFormato);
        rbCirculo = (RadioButton) findViewById(R.id.rbCirculo);
        rbQuadrado = (RadioButton) findViewById(R.id.rbQuadrado);
        rbTriangulo = (RadioButton) findViewById(R.id.rbTriangulo);
    }

    public void avancar(View v){
        if(((RadioButton) findViewById(rgFormato.getCheckedRadioButtonId())).getText().toString() ==
                rbQuadrado.getText().toString())
        {
            Intent intent = new Intent(this, InformarDadosActivity.class);
            intent.putExtra("formato", rbQuadrado.getText().toString());
            startActivity(intent);
        }else if (((RadioButton) findViewById(rgFormato.getCheckedRadioButtonId())).getText().toString() == rbTriangulo.getText().toString())
        {
            Intent intent = new Intent(this, InformarDadosActivity.class);
            intent.putExtra("formato", rbTriangulo.getText().toString());
            startActivity(intent);
        }else if(((RadioButton) findViewById(rgFormato.getCheckedRadioButtonId())).getText().toString() == rbCirculo.getText().toString())
        {
            Intent intent = new Intent(this, InformarDadosActivity.class);
            intent.putExtra("formato", rbCirculo.getText().toString());
            startActivity(intent);
        }
    }
}
