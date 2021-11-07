package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacotes;
import br.com.alura.aluraviagens.util.ConversoresUtil;

public class ConclusaoCompraActivity extends AppCompatActivity {
    
    private Pacotes pacoteRecebido; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusao_compra);
        setTitle("Resumo da Compra");
        carregaPacote();
    }

    private void carregaPacote() {
        pacoteRecebido = (Pacotes) getIntent().getSerializableExtra("pacoteEnviado");
        mostraImagemCon(pacoteRecebido);
        mostraLocalCon(pacoteRecebido);
        mostraDataCon(pacoteRecebido);
        mostraPrecoCon(pacoteRecebido);
    }

    private void mostraPrecoCon(Pacotes pacote) {
        TextView precoCon = findViewById(R.id.conclusao_textView_preco);
        NumberFormat formatoBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt","br"));
        precoCon.setText(formatoBrasileiro.format(pacote.getPreco()));
    }

    private void mostraDataCon(Pacotes pacote) {
        TextView dataCon = findViewById(R.id.conclusao_textView_data);
        dataCon.setText(ConversoresUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraLocalCon(Pacotes pacote) {
        TextView localCon = findViewById(R.id.conclusao_textView_local);
        localCon.setText(pacote.getLocal());
    }

    private void mostraImagemCon(Pacotes pacote) {
        ImageView imagemCon = findViewById(R.id.conclusao_imageview_banner);
        imagemCon.setImageDrawable(ConversoresUtil.devolveDrawable(this, pacote.getImagem()));
    }
}