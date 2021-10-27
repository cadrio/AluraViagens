package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacotes;
import br.com.alura.aluraviagens.ui.adapters.ListaPacotesAdapter;

public class ListaPacotes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);


        ListView listaPacotes = findViewById(R.id.listapacotes_listView);

        List<Pacotes> pacotes = new PacoteDAO().lista();

        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes,ListaPacotes.this));


    }
}