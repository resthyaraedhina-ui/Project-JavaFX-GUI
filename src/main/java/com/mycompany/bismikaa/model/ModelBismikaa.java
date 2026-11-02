package com.mycompany.bismikaa.model;

public class ModelBismikaa {
    private double berat;  // dalam Kilogram (kg)
    private double tinggi; // dalam Meter (m)

    // Constructor Kosong
    public ModelBismikaa() {
    }

    // Constructor Utama
    public ModelBismikaa(double berat, double tinggi) {
        this.berat = berat;
        this.tinggi = tinggi;
    }

    // Getter dan Setter
    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    // Method Rumus Hitung BMI: berat / (tinggi dalam meter)^2
    public double hitungBMI() {
        if (tinggi <= 0) return 0;
        return berat / (tinggi * tinggi);
    }

    // Method Penentu Kategori Hasil
    public String getKategori() {
        double bmi = hitungBMI();
        if (bmi < 18.5) {
            return "Kurus (Kekurangan berat badan)";
        } else if (bmi < 25.0) {
            return "Normal (Ideal)";
        } else if (bmi < 30.0) {
            return "Kelebihan Berat Badan";
        } else {
            return "Obesitas";
        }
    }
}