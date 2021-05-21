package com.example.consumodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class Resultado extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent Rec = getIntent();
        Bundle params = Rec.getExtras();
        Double kcal1 = params.getDouble("Kcals");
        Double kcal2 = params.getDouble("Kcals2");
        String kcal3 = params.getString("OBJ");
        TextView opa = (TextView) findViewById(R.id.R1);
        TextView opa2 = (TextView) findViewById(R.id.R2);
        TextView opa3 = (TextView) findViewById(R.id.R3);
        NumberFormat DF1 = NumberFormat.getInstance();
        DF1.setMaximumFractionDigits(2);
        opa.setText("* " + DF1.format(kcal1 ) + " kcal"  );
        opa2.setText("* consumir " + DF1.format(kcal2) + " kcal/dia"  );
        opa3.setText("Para "+ kcal3 +", você deve: ");
    }

    public void Voltar(View view)
    {
        Intent intent2 = new Intent(Resultado.this, MainActivity.class);
        startActivity(intent2);
    }
}
