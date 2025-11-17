package com.example.ap_pruebaapi_17_11_25;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRedireccionar = findViewById(R.id.btn_redireccionar);

        btnRedireccionar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, api_form.class);
            startActivity(intent);
        });
    }
}
