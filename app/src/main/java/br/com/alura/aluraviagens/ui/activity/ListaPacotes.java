package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacotes;
import br.com.alura.aluraviagens.ui.adapters.ListaPacotesAdapter;

public class ListaPacotes extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Pacotes";
    public ListaPacotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraListView();


    }


    private void configuraListView() {
        ListView listaPacotes = findViewById(R.id.listapacotes_listView);
        List<Pacotes> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, ListaPacotes.this));

        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {

                Intent intent = new Intent(ListaPacotes.this, ResumoPacoteActivity.class);
                Pacotes pacoteEnviado = pacotes.get(posicao);
                intent.putExtra("pacoteEnviado",pacoteEnviado);
                startActivity(intent);
        }
        });
    }
}