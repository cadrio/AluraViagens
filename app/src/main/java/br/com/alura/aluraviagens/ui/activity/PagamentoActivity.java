package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacotes;

public class PagamentoActivity extends AppCompatActivity {

    private Pacotes pacoteRecebido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento");
        carregaPacote();
        configuraBotaoFinaliza();
    }

    private void configuraBotaoFinaliza() {
        Button botaoFinaliza = findViewById(R.id.pagamento_botaofinaliza);
        botaoFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(PagamentoActivity.this)
                        .setTitle("Confirmação de transação")
                        .setMessage("Deseja realizar o pagamento para o pacote selecionado?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                vaiParaConclusao();
                            }
                        }).setNegativeButton("Não",null).show();
            }
        });
    }

    private void vaiParaConclusao() {
        Intent intent = new Intent(PagamentoActivity.this, ConclusaoCompraActivity.class);
        intent.putExtra("pacoteEnviado",pacoteRecebido);
        startActivity(intent);
    }

    private void carregaPacote() {
        Intent intent = getIntent();
        pacoteRecebido = (Pacotes) intent.getSerializableExtra("pacoteEnviado");
        mostraPrecoPag(pacoteRecebido);
    }
    private void mostraPrecoPag(Pacotes pacote) {
        TextView precoPag = findViewById(R.id.pagamento_textView_preco);
        NumberFormat formatobrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt","br"));
        precoPag.setText(formatobrasileiro.format(pacote.getPreco()));
    }
}