package com.example.probandomenucontextual_22_23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
String[] graficas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        graficas = new String[] {"RTX 4090","RTX 4060", "Radeon 6500 XT", "TI 1070"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,graficas);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
      menu.setHeaderTitle("¿Qué hacemos con la gráfica?");
      menu.add(0,v.getId(),0, "Comprar");
      menu.add(0,v.getId(),0, "Ver");
      menu.add(0,v.getId(),0, "Borrar");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int posicionLista = info.position;
        if(item.getTitle()=="Comprar"){
            Toast.makeText(this, "Compramos: "+graficas[posicionLista], Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}