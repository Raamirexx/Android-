package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnviarCirc(View view)
    {
      this.AbrirNova("Área do cículo","#7B1FA2",4);
    }
    public void EnviarQuad(View view)
    {
        this.AbrirNova("Área do Quadrado","#F57C00",1);
    }
    public void EnviarRet(View view)
    {
        this.AbrirNova("Área do Retângulo","#00796B",2);
    }
    public void EnviarTri(View view)
    {
        this.AbrirNova("Área do Triângulo","#1976D2",3);
    }
    public void AbrirNova(String texto,String cor, int tipo)
    {
        Intent TelaCalculo = new Intent(MainActivity.this, Calculo.class);
        Bundle parametros = new Bundle();
        parametros.putInt("Tipo",tipo);
        parametros.putString("TipoTexto",texto);
        parametros.putString("TipoCor",cor);
        TelaCalculo.putExtras(parametros);
        startActivity(TelaCalculo);
    }
}
