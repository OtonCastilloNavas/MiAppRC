package com.cam.miapprc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Foto> fotos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvLista= (RecyclerView) findViewById(R.id.rvLista);
        rvLista.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        rvLista.setLayoutManager(llm);

        fotos.add(new Foto("Ciudad de Granada","fecha: 18/09/2017",R.drawable.granada,1));
        fotos.add(new Foto("Ciudad de León","fecha: 01/02/2017",R.drawable.leon,2));
        fotos.add(new Foto("Corn Island","fecha: 08/06/2017",R.drawable.cornisland,3));
        fotos.add(new Foto("Laguna de Apoyo","fecha: 11/08/2017",R.drawable.apoyo,4));
        fotos.add(new Foto("Isla de Ometepe","fecha: 27/01/2017",R.drawable.ometepe,5));

        FotoAdapter adapter =  new FotoAdapter(fotos);
        rvLista.setAdapter(adapter);
    }
}
