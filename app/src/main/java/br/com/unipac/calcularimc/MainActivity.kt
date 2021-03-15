package br.com.unipac.calcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesoEdt         = findViewById<EditText>(R.id.pesoEdt)
        val alturaEdt       = findViewById<EditText>(R.id.alturaEdt)
        val calcularBtn     = findViewById<Button>(R.id.calcularBtn)
        val resultadoTv     = findViewById<TextView>(R.id.resultadoTv)

        resultadoTv.setTextSize(28F)

        calcularBtn.setOnClickListener {
            val pesoTxt     = pesoEdt.text.toString().trim();
            val alturaTxt   = alturaEdt.text.toString().trim();

            if(pesoTxt.isNotEmpty() && alturaTxt.isNotEmpty()) {
                val peso    = pesoTxt.toDouble();
                val altura  = alturaTxt.toDouble();

                val imc     = peso / (altura * altura);

                var resp    = "";

                if(imc < 16) {
                    resp    = "Baixo peso muito grave";
                    resultadoTv.setTextColor(resources.getColor(R.color.red))
                } else if(imc > 16 && imc < 16.99) {
                    resp    = "Baixo peso grave";
                    resultadoTv.setTextColor(resources.getColor(R.color.orange))
                } else if(imc > 17 && imc < 18.49) {
                    resp    = "Baixo peso";
                    resultadoTv.setTextColor(resources.getColor(R.color.green_lime))
                } else if(imc > 18.50 && imc < 24.99) {
                    resp    = "Peso normal";
                    resultadoTv.setTextColor(resources.getColor(R.color.green))
                } else if(imc > 25 && imc < 29.99) {
                    resp    = "Sobrepeso";
                    resultadoTv.setTextColor(resources.getColor(R.color.green_lime))
                } else if(imc > 30 && imc < 34.99) {
                    resp    = "Obesidade grau I";
                    resultadoTv.setTextColor(resources.getColor(R.color.orange))
                } else if(imc > 35 && imc < 39.99) {
                    resp    = "Obesidade grau II";
                    resultadoTv.setTextColor(resources.getColor(R.color.red))
                } else if(imc > 40) {
                    resp    = "Obesidade grau III";
                    resultadoTv.setTextColor(resources.getColor(R.color.black))
                }

                resultadoTv.text = resp;

            }

        }

    }
}