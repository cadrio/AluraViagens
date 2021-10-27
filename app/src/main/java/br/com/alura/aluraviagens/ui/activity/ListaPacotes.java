package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacotes;
import br.com.alura.aluraviagens.ui.adapters.ListaPacotesAdapter;

public class ListaPacotes extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Pacotes";

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
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes,ListaPacotes.this));
    }
}