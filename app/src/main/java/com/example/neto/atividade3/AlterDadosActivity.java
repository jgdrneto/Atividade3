package com.example.neto.atividade3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AlterDadosActivity extends Activity {

    TextView tipo;
    EditText valor;

    String medida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_dados);

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        this.tipo =  findViewById(R.id.textView_tipo);
        this.valor = findViewById(R.id.editText_valor);

        this.medida = param.getString("TIPO");

        this.tipo.setText(medida+" :");

    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, PrimeiraActivity.class);
        intent.putExtra("TIPO","CANCELAR");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void alterarValor(View view) {
        Intent intent = new Intent(this, PrimeiraActivity.class);

        int valor_medida=0;

        if(!valor.getText().toString().isEmpty()){
            valor_medida = Integer.parseInt(valor.getText().toString());
        }

        intent.putExtra("TIPO",this.medida);
        intent.putExtra("VALOR",valor_medida);

        setResult(RESULT_OK,intent);
        finish();
    }
}
