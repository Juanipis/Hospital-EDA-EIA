package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VentanaPacientesAgendar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param a
	 */
	public VentanaPacientesAgendar() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(161, 301, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("CcPaciente");
		lblNewLabel.setBounds(31, 11, 136, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CcMedico");
		lblNewLabel_1.setBounds(31, 76, 114, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha Inicio");
		lblNewLabel_2.setBounds(31, 141, 89, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha final");
		lblNewLabel_3.setBounds(31, 206, 114, 14);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(223, 11, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(223, 77, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(223, 143, 156, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(223, 209, 156, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");

		JButton btnNewButton_1 = new JButton("Agendar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textField.getText().length() == 0 || textField_1.getText().length() == 0 || textField_2.getText().length() == 0
							|| textField_3.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Ingrese los datos");
					} else {
						String ini = textField_2.getText();
						String[] a = ini.split(",");

						int[] x = new int[a.length];
						for (int i = 0; i < a.length; i++) {
							x[i] = Integer.parseInt(a[i]);

						}

						String fin = textField_3.getText();
						String[] b = fin.split(",");

						int[] c = new int[a.length];
						for (int i = 0; i < a.length; i++) {
							c[i] = Integer.parseInt(b[i]);

						}
						// fechas x, c
						String cc1 = textField.getText();
						String cc2 = textField_1.getText();
						Main.getHospital().generarCita(cc1, cc2, x, c);
						JOptionPane.showMessageDialog(null, "Se genero la cita");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
					}

				} catch (FormatoFechaInvalida e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (NoHayDisponibilidadCita e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				} catch (NoSeEncuetraMedico e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnNewButton_1.setBounds(161, 267, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea txtrFormatoFecha = new JTextArea();
		txtrFormatoFecha.setText("Formato fecha: 2022,6,6,11,30\r\na\u00F1o,mes,dia,hora,minuto");
		txtrFormatoFecha.setEditable(false);
		txtrFormatoFecha.setBounds(167, 166, 244, 40);
		contentPane.add(txtrFormatoFecha);
	}
}
