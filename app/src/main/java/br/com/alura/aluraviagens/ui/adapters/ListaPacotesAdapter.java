package br.com.alura.aluraviagens.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacotes;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacotes> pacotes;
    private final Context contexto;


    public ListaPacotesAdapter(List<Pacotes> pacotesListados, Context contexto) {
        this.contexto = contexto;
        this.pacotes = pacotesListados;
    }


    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacotes getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(contexto).inflate(R.layout.item_layout, parent, false);

        mostraLocal(posicao, viewCriada);
        mostraImagem(posicao, viewCriada);
        mostraDias(posicao, viewCriada);
        mostraPreco(posicao, viewCriada);

        return viewCriada;
    }

    private void mostraPreco(int posicao, View viewCriada) {
        TextView preco = viewCriada.findViewById(R.id.itempacote_textView_precos);
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String precoFormatado = formatoBrasileiro.format(pacotes.get(posicao).getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(int posicao, View viewCriada) {
        TextView dia = viewCriada.findViewById(R.id.itempacote_textView_dias);
        int quantidadeDias = pacotes.get(posicao).getDias();
        if (quantidadeDias <= 1) {
            dia.setText(quantidadeDias + " dia");
        } else {
            dia.setText(quantidadeDias + " dias");
        }
    }

    private void mostraImagem(int posicao, View viewCriada) {
        ImageView imagem = viewCriada.findViewById(R.id.itempacote_imageView_fotoCidade);

        Resources recurso = contexto.getResources();
        int identificadorDraw = recurso.getIdentifier(pacotes.get(posicao).getImagem(),
                "drawable", contexto.getPackageName());
        imagem.setImageResource(identificadorDraw);
    }

    private void mostraLocal(int posicao, View viewCriada) {
        TextView local = viewCriada.findViewById(R.id.itempacote_textView_local);
        local.setText(pacotes.get(posicao).getLocal());
    }
}
