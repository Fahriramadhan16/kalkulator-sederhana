import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kalkulator extends JFrame implements ActionListener {
    private JTextField input1, input2;
    private JComboBox<String> operatorBox;
    private JButton tombolHitung;
    private JLabel hasilLabel;

    public Kalkulator() {
        setTitle("Kalkulator");
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Angka Pertama:"));
        input1 = new JTextField();
        add(input1);

        add(new JLabel("Operator (+, -, *, /):"));
        operatorBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        add(operatorBox);

        add(new JLabel("Angka Kedua:"));
        input2 = new JTextField();
        add(input2);

        tombolHitung = new JButton("Hitung");
        tombolHitung.addActionListener(this);
        add(tombolHitung);

        hasilLabel = new JLabel("Hasil: ");
        add(hasilLabel);

        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double angka1 = Double.parseDouble(input1.getText());
            double angka2 = Double.parseDouble(input2.getText());
            String operator = (String) operatorBox.getSelectedItem();
            double hasil = 0;

            switch (operator) {
                case "+": hasil = angka1 + angka2; break;
                case "-": hasil = angka1 - angka2; break;
                case "*": hasil = angka1 * angka2; break;
                case "/":
                    if (angka2 == 0) {
                        JOptionPane.showMessageDialog(this, "Tidak bisa dibagi dengan nol.");
                        return;
                    }
                    hasil = angka1 / angka2; break;
            }

            // Tampilkan hasil tanpa ".0" jika hasil adalah bilangan bulat
            if (hasil % 1 == 0) {
                hasilLabel.setText("Hasil: " + (int) hasil);
            } else {
                hasilLabel.setText("Hasil: " + hasil);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid.");
        }
    }

    public static void main(String[] args) {
        new Kalkulator();
    }
}
