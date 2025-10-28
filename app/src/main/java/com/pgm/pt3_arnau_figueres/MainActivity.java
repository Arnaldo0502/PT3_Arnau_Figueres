package com.pgm.pt3_arnau_figueres;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvOnCreate;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_main);

            // Inicializar SharedPreferences
            sharedPreferences = getSharedPreferences("LifecycleCounters", MODE_PRIVATE);

            // Conectar con el TextView
            tvOnCreate = findViewById(R.id.tv_onCreate);

            // Obtener y actualizar contador
            int count = sharedPreferences.getInt("onCreate_count", 0);
            count++;
            sharedPreferences.edit().putInt("onCreate_count", count).apply();

            // Mostrar resultado
            String text = "onCreate() s’ha executat " + count + " veces";
            tvOnCreate.setText(text);
        } catch (Exception e) {
            Toast.makeText(this, "Error en onCreate: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}