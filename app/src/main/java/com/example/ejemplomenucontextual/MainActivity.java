package com.example.ejemplomenucontextual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textoMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoMostrar = (EditText) findViewById(R.id.editText1);
        registerForContextMenu(textoMostrar);  //asociamos el menu contextual a la caja de texto.

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Convertir texto a:");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemMay:
                textoMostrar.setText(textoMostrar.getText().toString().toUpperCase());
                break;
            case R.id.itemMin:
                textoMostrar.setText(textoMostrar.getText().toString().toLowerCase());
                break;

        }
        return true;

    }
}