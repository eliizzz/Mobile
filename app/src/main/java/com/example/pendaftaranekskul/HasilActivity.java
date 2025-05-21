package com.example.pendaftaranekskul;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HasilActivity extends AppCompatActivity {

    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        tvHasil = findViewById(R.id.tvHasil);
        String data = getIntent().getStringExtra("data");
        tvHasil.setText(data);
    }
}
