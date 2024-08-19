package com.mastercoding.planetapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    CustumAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView =  findViewById(R.id.planetList);
        planetArrayList = new ArrayList<Planet>();
        planetArrayList.add(new Planet("Earth","1 moon",R.drawable.earth));
        planetArrayList.add(new Planet("Mercury","0 moons",R.drawable.mercury));
        planetArrayList.add(new Planet("jupiter","79 moons",R.drawable.jupiter));
        planetArrayList.add(new Planet("mars","2 moons",R.drawable.mars));
        planetArrayList.add(new Planet("neptune","14 moons",R.drawable.neptune));
        planetArrayList.add(new Planet("pluto","5 moons",R.drawable.pluto));
        planetArrayList.add(new Planet("saturn","83 moons",R.drawable.saturn));
        planetArrayList.add(new Planet("uranus","27 moons",R.drawable.uranus));
        planetArrayList.add(new Planet("venus","0",R.drawable.venus));

        CustumAdapter listAdapter = new CustumAdapter(planetArrayList, getApplicationContext());
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Planet Name: "+ listAdapter.getItem(i).getPlanetName(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}