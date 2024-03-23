/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputnilaidosen.inputnilaidosen;

/**
 *
 * @author AJENG
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tampilan implements Interface {
    private final JDialog dialog;
    private JTextField kolomNama, kolomNIM, kolomNilaiTugas, kolomNilaiQuiz;
    private JComboBox<String> pilihanKelas, pilihanMataKuliah;
    private JButton tombolSubmit, tombolKeluar;

    public Tampilan(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void tampilkan() {
        dialog.getContentPane().removeAll();
        dialog.setTitle("Aplikasi Input Nilai Mahasiswa");
        dialog.setLayout(new GridLayout(7, 2, 10, 10));

        kolomNama = new JTextField();
        kolomNIM = new JTextField();
        kolomNilaiTugas = new JTextField();
        kolomNilaiQuiz = new JTextField();
        pilihanKelas = new JComboBox<>(new String[]{"Kelas Praktikum", "Kelas Teori"});
        pilihanMataKuliah = new JComboBox<>(new String[]{"PBO", "SCPK", "Algo Lanjut"});
        tombolSubmit = new JButton("Submit");
        tombolKeluar = new JButton("Keluar");

        dialog.add(new JLabel("Nama Mahasiswa:"));
        dialog.add(kolomNama);
        dialog.add(new JLabel("NIM Mahasiswa:"));
        dialog.add(kolomNIM);
        dialog.add(new JLabel("Nilai Tugas:"));
        dialog.add(kolomNilaiTugas);
        dialog.add(new JLabel("Nilai Quiz:"));
        dialog.add(kolomNilaiQuiz);
        dialog.add(new JLabel("Kelas:"));
        dialog.add(pilihanKelas);
        dialog.add(new JLabel("Mata Kuliah:"));
        dialog.add(pilihanMataKuliah);
        dialog.add(tombolSubmit);
        dialog.add(tombolKeluar);

        tombolSubmit.addActionListener(e -> hitungDanTampilkanNilai());
        tombolKeluar.addActionListener(e -> dialog.dispose());

        dialog.revalidate();
        dialog.repaint();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void hitungDanTampilkanNilai() {
        String nama = kolomNama.getText();
        String nim = kolomNIM.getText();
        double nilaiTugas = Double.parseDouble(kolomNilaiTugas.getText());
        double nilaiQuiz = Double.parseDouble(kolomNilaiQuiz.getText());
        String kelas = (String) pilihanKelas.getSelectedItem();
        String mataKuliah = (String) pilihanMataKuliah.getSelectedItem();

        double totalNilai;
        if (kelas.equals("Kelas Praktikum")) {
            totalNilai = nilaiTugas * 0.3 + nilaiQuiz * 0.7;
        } else {
            totalNilai = nilaiTugas * 0.7 + nilaiQuiz * 0.3;
        }

        String hasil = totalNilai >= 85 ? "Lulus" : "Tidak Lulus";

        JOptionPane.showMessageDialog(dialog, String.format("Nama: %s\nNIM: %s\nMata Kuliah: %s\nHasil: %s\nTotal Nilai: %.2f", nama, nim, mataKuliah, hasil, totalNilai), "Hasil Nilai", JOptionPane.INFORMATION_MESSAGE);
    }
}


