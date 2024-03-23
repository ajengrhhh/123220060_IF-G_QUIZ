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

public class Login implements Interface {
    private final JDialog dialog;

    public Login(JDialog dialog) {
        this.dialog = dialog;
    }

    public void tampilkan() {
        dialog.getContentPane().removeAll();
        dialog.setTitle("Login");
        JPanel panelLogin = new JPanel(new GridLayout(3, 2));

        JTextField kolomNIM = new JTextField();
        JPasswordField kolomSandi = new JPasswordField();
        JButton tombolMasuk = new JButton("Masuk");
        JButton tombolBatal = new JButton("Batal");

        panelLogin.add(new JLabel("NIM:"));
        panelLogin.add(kolomNIM);
        panelLogin.add(new JLabel("Sandi:"));
        panelLogin.add(kolomSandi);
        panelLogin.add(tombolMasuk);
        panelLogin.add(tombolBatal);

        tombolMasuk.addActionListener(e -> {
            String nim = kolomNIM.getText();
            String sandi = new String(kolomSandi.getPassword());
            if (nim.equals("060") && sandi.equals("123123")) {
                new Tampilan(dialog).tampilkan();
            } else {
                JOptionPane.showMessageDialog(dialog, "NIM atau Sandi salah.", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        });

        tombolBatal.addActionListener(e -> System.exit(0));

        dialog.setContentPane(panelLogin);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

