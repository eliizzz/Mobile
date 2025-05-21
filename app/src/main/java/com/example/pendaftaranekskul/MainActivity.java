package com.example.pendaftaranekskul;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNIS, etHariJam;
    Spinner spinnerKelas;
    Button btnTanggalLahir, btnSimpan, btnBatal;
    RadioGroup rgGender;
    CheckBox cbPramuka, cbPMR, cbBasket;
    String selectedTanggal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNama = findViewById(R.id.etNama);
        etNIS = findViewById(R.id.etNIS);
        spinnerKelas = findViewById(R.id.spinnerKelas);
        btnTanggalLahir = findViewById(R.id.btnTanggalLahir);
        rgGender = findViewById(R.id.rgGender);
        cbPramuka = findViewById(R.id.cbPramuka);
        cbPMR = findViewById(R.id.cbPMR);
        cbBasket = findViewById(R.id.cbBasket);
        etHariJam = findViewById(R.id.etHariJam);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnBatal = findViewById(R.id.btnBatal);


        String[] kelas = {"X IPA", "X IPS", "XI IPA", "XI IPS", "XII IPA", "XII IPS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, kelas);
        spinnerKelas.setAdapter(adapter);


        btnTanggalLahir.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                selectedTanggal = dayOfMonth + "/" + (month + 1) + "/" + year;
                btnTanggalLahir.setText(selectedTanggal);
            }, y, m, d).show();
        });


        btnSimpan.setOnClickListener(v -> {
            String nama = etNama.getText().toString();
            String nis = etNIS.getText().toString();
            String kelasDipilih = spinnerKelas.getSelectedItem().toString();
            String hariJam = etHariJam.getText().toString();

            int selectedGenderId = rgGender.getCheckedRadioButtonId();
            RadioButton rbGender = findViewById(selectedGenderId);
            String gender = rbGender.getText().toString();

            StringBuilder ekstra = new StringBuilder();
            if (cbPramuka.isChecked()) ekstra.append("Pramuka ");
            if (cbPMR.isChecked()) ekstra.append("PMR ");
            if (cbBasket.isChecked()) ekstra.append("Basket ");


            Intent intent = new Intent(this, HasilActivity.class);
            intent.putExtra("data", "Nama: " + nama + "\nNIS: " + nis + "\nKelas: " + kelasDipilih +
                    "\nTanggal Lahir: " + selectedTanggal + "\nGender: " + gender +
                    "\nEkskul: " + ekstra.toString() + "\nHari & Jam: " + hariJam);
            startActivity(intent);
        });

        btnBatal.setOnClickListener(v -> finish());
    }
}
