package com.example.neto.atividade3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeiraActivity extends Activity {

    CalculadoraIMC calcIMC;
    TextView peso,altura,resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

        this.calcIMC = new CalculadoraIMC();

        this.peso = findViewById(R.id.textView_peso);
        this.altura = findViewById(R.id.textView_altura);
        this.resultado = findViewById(R.id.textView_resultado);

    }

    public void zerarValores(){
        this.peso.setText("0.0 kg");
        this.altura.setText("0.0 cm");
        this.resultado.setText("Aperte o botão calcular!");
    }

    public void alterarPeso(View view) {
        Intent intent = new Intent(this, AlterDadosActivity.class);
        intent.putExtra("TIPO","PESO");
        startActivityForResult(intent, 5);
    }

    public void alterarAltura(View view) {
        Intent intent = new Intent(this, AlterDadosActivity.class);
        intent.putExtra("TIPO","ALTURA");
        startActivityForResult(intent,5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 5){

            String tipo = data.getStringExtra("TIPO");
            int valor = data.getIntExtra("VALOR",0);

            switch(tipo){
                case "ALTURA":
                    calcIMC.setAltura(valor);
                    this.altura.setText(String.valueOf(valor)+".0 cm");
                break;
                case "PESO":
                    calcIMC.setPeso(valor);
                    this.peso.setText(String.valueOf(valor)+".0 kg");
                break;
                default:

            }

        }

    }

    public void calcularIMC(View view) {

        Toast janela_mensagem = null;

        if(this.calcIMC.getPeso()<=0){
            janela_mensagem = Toast.makeText(getApplicationContext(), "Peso menor ou igual a zero", Toast.LENGTH_LONG);
        }else{
            if(this.calcIMC.getAltura()<=0){
                janela_mensagem = Toast.makeText(getApplicationContext(), "Altura menor ou igual a zero", Toast.LENGTH_LONG);
            }
        }

        if(janela_mensagem!=null){
            janela_mensagem.show();
        }else{
            double imc = calcIMC.calcularIMC();

            String classificacao = "IMC : "+ String.valueOf(imc) + " Classificação : ";

            if(imc<16){
                classificacao += "Magreza grave";
            }else{
                if(imc>=16 && imc<17){
                    classificacao += "Magreza moderada";
                }else{
                    if(imc>=17 && imc<18.5){
                        classificacao += "Magreza leve";
                    }else{
                        if(imc>=18.5 && imc<25){
                            classificacao += "Saudável";
                        }else{
                            if(imc>=25 && imc<30){
                                classificacao += "Sobrepeso";
                            }else{
                                if(imc>=30 && imc<35){
                                    classificacao += "Obesidade Grau I";
                                }else{
                                    if(imc>=35 && imc<40){
                                        classificacao += "Obesidade Grau II (Severa)";
                                    }else{
                                        classificacao += "Obesidade Grau III (mórbida)";
                                    }
                                }
                            }
                        }
                    }
                }
            }

            this.resultado.setText(classificacao);

        }

    }
}

