package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Calculo extends AppCompatActivity {

    TextView T1,T2,T3,T4,T5,T6;
    EditText TXT,TXT2;
    Button B1,B2;
    Integer tipo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        Intent Rec = getIntent();
        Bundle params = Rec.getExtras();
        String texto = params.getString("TipoTexto");
        String cor = params.getString("TipoCor");
        tipo = params.getInt("Tipo");
        T1 = findViewById(R.id.TVtexto);T2 = findViewById(R.id.TVcampo1);
        T3 = findViewById(R.id.TVcampo2);T4 = findViewById(R.id.TVresultado);// NUMERO
        T6 = findViewById(R.id.cm2);
        T5 = findViewById(R.id.ETresult);/* TEXTO */ TXT = findViewById(R.id.ET1);
        TXT2 = findViewById(R.id.ET2);B1 = findViewById(R.id.BTNvoltar);
        B2 = findViewById(R.id.BTNcalcular);
        T1.setText(texto);
        T1.setTextColor(Integer.parseInt(cor));T2.setTextColor(Integer.parseInt(cor));
        T3.setTextColor(Integer.parseInt(cor));T5.setTextColor(Integer.parseInt(cor));
        B1.setBackgroundColor(Integer.parseInt(cor));B2.setBackgroundColor(Integer.parseInt(cor));
        switch (tipo)
        {
            case 1:
                this.TwoFields();
                T3.setText("Lado Maior");T2.setText("Lado menor");
                break;
            case 2:
                this.TwoFields();
                T3.setText("Altura");T2.setText("Base");
                break;
            case 3:
                T2.setText("Lado");
                break;
            case 4:
                T2.setText("Raio");
                break;
        }
    }
    public void Voltar(View view)
    {
        Intent intent2 = new Intent(Calculo.this, MainActivity.class);
        startActivity(intent2);
    }
    public void Calcular(View view)
    {
        double r = 0;
        double n1 = Double.parseDouble(TXT.getText().toString());
        double n2 = Double.parseDouble(TXT.getText().toString());
        switch (tipo)
        {
            case 1:
                r = new MetodosCalculo().AreaQuadrado(n1);
                break;
            case 2:
                r = new MetodosCalculo().AreaRetangulo(n1,n2);
                break;
            case 3:
                r = new MetodosCalculo().AreaTriangulo(n1,n2);
                break;
            case 4:
                r = new MetodosCalculo().AreaCirculo(n1);
                break;
                default:
                    break;
        }
        T4.setVisibility(View.VISIBLE);T5.setVisibility(View.VISIBLE);
        NumberFormat DF1 = NumberFormat.getInstance();
        DF1.setMaximumFractionDigits(2);
        T4.setText(DF1.format(r)+ "cm");
        B1.setVisibility(View.VISIBLE);
    }
    public void TwoFields()
    {
        T3.setVisibility(View.VISIBLE);TXT.setVisibility(View.VISIBLE);
        T6.setVisibility(View.VISIBLE);
    }
}
