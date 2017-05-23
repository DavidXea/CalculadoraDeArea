package com.company.david.calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculaActivity extends AppCompatActivity {

    private TextView tvArea;

    private ImageView ivTriangulo;
    private ImageView ivCirculo;
    private ImageView ivQuadrado;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula);

        tvArea = (TextView) findViewById(R.id.tvArea);

        calculaArea();
    }

    public void calculaArea(){
        Intent intent = getIntent();

        if(intent.getStringExtra("formato").equals("Triangulo")){
            tvArea.setText(tvArea.getText()+" "+intent.getStringExtra("area"));
            ivTriangulo = (ImageView)findViewById(R.id.ivTriangulo);
            ivTriangulo.setVisibility(View.VISIBLE);

        }else if(intent.getStringExtra("formato").equals("Quadrado")){
            String area = intent.getStringExtra("area");
            tvArea.setText(tvArea.getText()+" "+area);
            ivQuadrado = (ImageView)findViewById(R.id.ivQuadrado);
            ivQuadrado.setVisibility(View.VISIBLE);

        }else if(intent.getStringExtra("formato").equals("Circulo")){
            tvArea.setText(tvArea.getText()+" "+intent.getStringExtra("area"));
            ivCirculo = (ImageView)findViewById(R.id.ivCirculo);
            ivCirculo.setVisibility(View.VISIBLE);
        }
    }

    public void voltarTelaPrincipal(View v){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}
