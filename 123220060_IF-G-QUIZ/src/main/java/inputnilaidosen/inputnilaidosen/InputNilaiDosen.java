/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package inputnilaidosen.inputnilaidosen;

/**
 *
 * @author AJENG
 */
import javax.swing.*;

public class InputNilaiDosen extends JDialog {
    private Interface tampilanSekarang;

    public InputNilaiDosen() {
        setTitle("Aplikasi Input Nilai Mahasiswa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        tampilanSekarang = new Login(this);
        tampilanSekarang.tampilkan();
    }

    public void ubahTampilan(Interface tampilanBaru) {
        tampilanSekarang = tampilanBaru;
        tampilanSekarang.tampilkan();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputNilaiDosen());
    }
}

