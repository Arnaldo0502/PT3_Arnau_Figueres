package com.pgm.pt3_arnau_figueres;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargar idioma antes de setContentView
        SharedPreferences prefs = getSharedPreferences("LifecycleCounters", MODE_PRIVATE);
        String languageCode = prefs.getString("app_language", "en");
        setAppLanguage(languageCode);

        try {
            setContentView(R.layout.activity_main);

            // Inicializar SharedPreferences
            sharedPreferences = getSharedPreferences("LifecycleCounters", MODE_PRIVATE);

            // Configurar RadioGroup
            radioGroup = findViewById(R.id.radioGroup);

            // Establecer selección según idioma actual
            String currentLang = sharedPreferences.getString("app_language", "en");
            switch (currentLang) {
                case "ca":
                    radioGroup.check(R.id.radioCatalan);
                    break;
                case "es":
                    radioGroup.check(R.id.radioSpanish);
                    break;
                default:
                    radioGroup.check(R.id.radioEnglish);
                    break;
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String newLanguage = "en";

                    if (checkedId == R.id.radioCatalan) {
                        newLanguage = "ca";
                    } else if (checkedId == R.id.radioSpanish) {
                        newLanguage = "es";
                    }

                    // Guardar nuevo idioma
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("app_language", newLanguage);
                    editor.apply();

                    // Recargar actividad para aplicar cambios
                    recreate();
                }
            });

            // Contador para onCreate
            int onCreateCount = sharedPreferences.getInt("onCreate_count", 0);
            onCreateCount++;
            sharedPreferences.edit().putInt("onCreate_count", onCreateCount).apply();

            // Actualizar TextView individualmente
            TextView tvOnCreate = findViewById(R.id.tv_onCreate);
            String onCreateText = getString(R.string.onCreate_text, onCreateCount);
            tvOnCreate.setText(onCreateText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onCreate: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void setAppLanguage(String languageCode) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            int onStartCount = sharedPreferences.getInt("onStart_count", 0);
            onStartCount++;
            sharedPreferences.edit().putInt("onStart_count", onStartCount).apply();

            TextView tvOnStart = findViewById(R.id.tv_onStart);
            String onStartText = getString(R.string.onStart_text, onStartCount);
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
            String onRestartText = getString(R.string.onRestart_text, onRestartCount);
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
            String onResumeText = getString(R.string.onResume_text, onResumeCount);
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
            String onPauseText = getString(R.string.onPause_text, onPauseCount);
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
            String onStopText = getString(R.string.onStop_text, onStopCount);
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
            String onDestroyText = getString(R.string.onDestroy_text, onDestroyCount);
            tvOnDestroy.setText(onDestroyText);

        } catch (Exception e) {
            Toast.makeText(this, "Error en onDestroy: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}