package com.cam.miapprc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvLista= (RecyclerView) findViewById(R.id.rvLista);
        rvLista.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        rvLista.setLayoutManager(llm);

        personas.add(new Persona("Oton","Castillo",R.drawable.oton));
        personas.add(new Persona("Orlando","Cuadra",R.drawable.landy));
        personas.add(new Persona("Erick","Ruiz",R.drawable.gato));
        personas.add(new Persona("Mario","Cisnero",R.drawable.mario));
        personas.add(new Persona("Mario","Cisnero",R.drawable.landy));

        PersonaAdapter adapter =  new PersonaAdapter(personas);
        rvLista.setAdapter(adapter);
    }
}
