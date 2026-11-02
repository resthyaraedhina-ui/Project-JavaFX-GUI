package com.mycompany.bismikaa;

import com.mycompany.bismikaa.model.ModelBismikaa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    // 1. Deklarasi elemen UI sesuai fx:id dari Scene Builder
    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtTinggi;

    @FXML
    private Label lblNilaiBMI;

    @FXML
    private Label lblKategori;

    // 2. Inisialisasi objek Model
    private final ModelBismikaa model = new ModelBismikaa();

    // 3. Method saat tombol "Hitung BMI" diklik
    @FXML
    private void handleHitung(ActionEvent event) {
        try {
            // Ambil input teks dari TextField
            String inputBerat = txtBerat.getText().trim();
            String inputTinggi = txtTinggi.getText().trim();

            // Validasi jika kolom kosong
            if (inputBerat.isEmpty() || inputTinggi.isEmpty()) {
                lblNilaiBMI.setText("Error");
                lblKategori.setText("Isi semua kolom!");
                return;
            }

            // Konversi string input menjadi angka double
            double berat = Double.parseDouble(inputBerat);
            double tinggiCm = Double.parseDouble(inputTinggi);

            // Konversi cm ke meter (karena ModelBismikaa menghitung dalam satuan meter)
            double tinggiMeter = tinggiCm / 100.0;

            // Masukkan data ke dalam instance model
            model.setBerat(berat);
            model.setTinggi(tinggiMeter);

            // Panggil method dari ModelBismikaa
            double bmi = model.hitungBMI();
            String kategori = model.getKategori();

            // Tampilkan hasil ke Label di layar
            lblNilaiBMI.setText(String.format("%.2f", bmi));
            lblKategori.setText(kategori);

        } catch (NumberFormatException e) {
            // Penanganan jika user memasukkan selain angka
            lblNilaiBMI.setText("Error");
            lblKategori.setText("Masukkan angka yang valid!");
        }
    }

    // 4. Method saat tombol "Reset" diklik
    @FXML
    private void handleReset(ActionEvent event) {
        txtBerat.clear();
        txtTinggi.clear();
        lblNilaiBMI.setText("-");
        lblKategori.setText("-");
        
        // Mengembalikan kursor ketikan langsung ke kolom berat badan
        txtBerat.requestFocus();
    }
}