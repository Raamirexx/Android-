package com.example.consumodecalorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // Declarando os componentes que estão na interface
    Spinner sexo, nivel, obj;
    EditText idade,peso,alt,ind;
    Button Calcular;
    //Declarando e definindo os itens que serão apresentados nos spinners
    private String[] Sitems = new String[]{"M","F"};
    private String[] Nitems = new String[]{"Sedentário","Exercícios leves","Exercícios moderados","Exercícios pesados","Atleta"};
    private String[] Oitems = new String[]{"Emagrecer","Manter","Engordar"};
    private String texto = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> Sexo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, Sitems);
        ArrayAdapter<String> Nivel = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, Nitems);
        ArrayAdapter<String> Objetivo = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, Oitems);
        Sexo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);Nivel.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Objetivo.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sexo = (Spinner) findViewById(R.id.sp_SEXO);nivel = (Spinner) findViewById(R.id.sp_NIVEL);obj = (Spinner) findViewById(R.id.sp_OBJ);
        idade = (EditText) findViewById(R.id.ET_age);peso = (EditText) findViewById(R.id.ET_alt);alt= (EditText) findViewById(R.id.ET_alt);
        ind = (EditText) findViewById(R.id.ET_igc);
        Calcular = (Button) findViewById(R.id.BTNcalcular);
        sexo.setAdapter(Sexo);nivel.setAdapter(Nivel);obj.setAdapter(Objetivo);
    }

    public void Calcular(View view)
    {

        if(idade.getText().toString().equals("") || peso.getText().toString().equals("") || alt.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double parcial = 0;
            int varidade = Integer.parseInt(idade.getText().toString());
            double varpeso = Double.parseDouble(peso.getText().toString());
            int varaltura = Integer.parseInt(alt.getText().toString());
            int varsexo = 0;
            if(sexo.getSelectedItem().toString().equals("M"))
            {
                varsexo = 5;
            }
            else
            {
                varsexo = -161;
            }
            if(ind.getText().toString().equals(""))
            {
                parcial = Math.floor((10 * varpeso + 6.25 * varaltura - 5 * varidade) + varsexo);
                this.Envia(parcial);
            }
            else
            {
                double IDG = Double.parseDouble(ind.getText().toString());
                double LBM = (varpeso - (varpeso * IDG/100));
                 parcial = Math.floor(370 + (21.6 * LBM)) ;
                this.Envia(parcial);
            }

        }
    }
    private int func_OBJ()
    {
        int res = 0;
        if(obj.getSelectedItem().toString() == "Emagrecer")
        {
            res = -500;
            texto = "emagrecer";
        }
        else if(obj.getSelectedItem().toString() == "Engordar")
        {
            res = 500;
            texto = "ganhar massa";
        }
        else if(obj.getSelectedItem().toString() == "Manter")
        {

            texto = "manter";
        }
        return res;
    }
    private void Envia(double parcial)
    {
        double result = 0;
        if(nivel.getSelectedItem().toString().equals("Sedentário"))
        {
            result = parcial * 1.2;
        }
        else if (nivel.getSelectedItem().toString().equals("Exercícios leves"))
        {
            result = parcial * 1.375;
        }
        else if (nivel.getSelectedItem().toString().equals("Exercícios moderados"))
        {
            result = parcial * 1.55;
        }
        else if (nivel.getSelectedItem().toString().equals("Exercícios pesados"))
        {
            result = parcial * 1.725;
        }
        else if (nivel.getSelectedItem().toString().equals("Atleta"))
        {
            result = parcial * 1.9;
        }
        Intent tela2 = new Intent(MainActivity.this, Resultado.class); //Declarando Uma nova Intent
        Bundle dados2 = new Bundle(); // Criando um conjunto de dados
        double result2 = this.func_OBJ() + result;
        dados2.putDouble("Kcals",result);
        dados2.putDouble("Kcals2",result2);
        dados2.putString("OBJ",texto);
        tela2.putExtras(dados2);
        startActivity(tela2);
    }
}
