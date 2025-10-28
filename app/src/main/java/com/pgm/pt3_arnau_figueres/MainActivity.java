package com.pgm.pt3_arnau_figueres;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);

            // Inicializar SharedPreferences
            sharedPreferences = getSharedPreferences("LifecycleCounters", MODE_PRIVATE);

            // Contador para onCreate
            int onCreateCount = sharedPreferences.getInt("onCreate_count", 0);
            onCreateCount++;
            sharedPreferences.edit().putInt("onCreate_count", onCreateCount).apply();

            // Actualizar TextView
            TextView tvOnCreate = findViewById(R.id.tv_onCreate);
            String onCreateText = "onCreate() s'ha executat " + onCreateCount + " vegades";
            tvOnCreate.setText(onCreateText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onCreate: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            int onStartCount = sharedPreferences.getInt("onStart_count", 0);
            onStartCount++;
            sharedPreferences.edit().putInt("onStart_count", onStartCount).apply();

            TextView tvOnStart = findViewById(R.id.tv_onStart);
            String onStartText = "onStart() s'ha executat " + onStartCount + " vegades";
            tvOnStart.setText(onStartText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onStart: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
            int onRestartCount = sharedPreferences.getInt("onRestart_count", 0);
            onRestartCount++;
            sharedPreferences.edit().putInt("onRestart_count", onRestartCount).apply();

            TextView tvOnRestart = findViewById(R.id.tv_onRestart);
            String onRestartText = "onRestart() s'ha executat " + onRestartCount + " vegades";
            tvOnRestart.setText(onRestartText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onRestart: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            int onResumeCount = sharedPreferences.getInt("onResume_count", 0);
            onResumeCount++;
            sharedPreferences.edit().putInt("onResume_count", onResumeCount).apply();

            TextView tvOnResume = findViewById(R.id.tv_onResume);
            String onResumeText = "onResume() s'ha executat " + onResumeCount + " vegades";
            tvOnResume.setText(onResumeText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onResume: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            int onPauseCount = sharedPreferences.getInt("onPause_count", 0);
            onPauseCount++;
            sharedPreferences.edit().putInt("onPause_count", onPauseCount).apply();

            TextView tvOnPause = findViewById(R.id.tv_onPause);
            String onPauseText = "onPause() s'ha executat " + onPauseCount + " vegades";
            tvOnPause.setText(onPauseText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onPause: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            int onStopCount = sharedPreferences.getInt("onStop_count", 0);
            onStopCount++;
            sharedPreferences.edit().putInt("onStop_count", onStopCount).apply();

            TextView tvOnStop = findViewById(R.id.tv_onStop);
            String onStopText = "onStop() s'ha executat " + onStopCount + " vegades";
            tvOnStop.setText(onStopText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onStop: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            int onDestroyCount = sharedPreferences.getInt("onDestroy_count", 0);
            onDestroyCount++;
            sharedPreferences.edit().putInt("onDestroy_count", onDestroyCount).apply();

            TextView tvOnDestroy = findViewById(R.id.tv_onDestroy);
            String onDestroyText = "onDestroy() s'ha executat " + onDestroyCount + " vegades";
            tvOnDestroy.setText(onDestroyText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onDestroy: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
