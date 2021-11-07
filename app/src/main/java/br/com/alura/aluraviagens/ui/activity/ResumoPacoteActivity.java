package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacotes;
import br.com.alura.aluraviagens.util.ConversoresUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    private Pacotes pacoteRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo Pacote");
        carregaPacote();
        configuraBotaoPagamento();

    }

    private void configuraBotaoPagamento() {
        Button botaoPagamento = findViewById(R.id.resumopacote_botao_pagamento);
        botaoPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaPagamento();
            }
        });
    }

    private void vaiParaPagamento() {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra("pacoteEnviado", pacoteRecebido);
        startActivity(intent);
    }

    private void carregaPacote() {

        Intent intentRecebido = getIntent();
        pacoteRecebido = (Pacotes) intentRecebido.getSerializableExtra("pacoteEnviado");

        mostraLocalRes(pacoteRecebido);
        mostraPrecoRes(pacoteRecebido);
        mostraImagemRes(pacoteRecebido);
        mostraDiasRes(pacoteRecebido);
        mostraDataRes(pacoteRecebido);
    }

    private void mostraDataRes(Pacotes pacote) {
        TextView txtData = findViewById(R.id.resumopacote_textView_data);
        txtData.setText(ConversoresUtil.periodoEmTexto(pacote.getDias()));

    }

    private void mostraDiasRes(Pacotes pacote) {
        TextView txtDias = findViewById(R.id.resumopacote_textView_dias);
        txtDias.setText(ConversoresUtil.corrigeDias(pacote.getDias()));
    }

    private void mostraImagemRes(Pacotes pacote) {
        ImageView imgBanner = findViewById(R.id.resumopacote_imageView_banner);
        imgBanner.setImageDrawable(ConversoresUtil.devolveDrawable(ResumoPacoteActivity.this, pacote.getImagem()));
    }

    private void mostraPrecoRes(Pacotes pacote) {
        TextView txtPreco = findViewById(R.id.resumopacote_textView_preco);
        NumberFormat formatoBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        txtPreco.setText(formatoBrasileiro.format(pacote.getPreco()));
    }

    private void mostraLocalRes(Pacotes pacote) {
        TextView txtLocal = findViewById(R.id.resumopacote_textView_local);
        txtLocal.setText(pacote.getLocal());
    }
}