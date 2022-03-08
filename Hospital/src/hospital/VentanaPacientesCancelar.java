package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VentanaPacientesCancelar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPacientesCancelar frame = new VentanaPacientesCancelar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPacientesCancelar() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnNewButton.setBounds(156, 206, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(223, 32, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(223, 91, 111, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("CC");
		lblNewLabel.setBounds(35, 35, 106, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setBounds(35, 94, 106, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					try {

						if (textField.getText() == "" || textField_1.getText() == "") {
							JOptionPane.showMessageDialog(null, "Ingrese los datos");
						} else {

							String ini = textField_1.getText();
							String[] a = ini.split(",");

							int[] x = new int[a.length];
							for (int i = 0; i < a.length; i++) {
								x[i] = Integer.parseInt(a[i]);

							}
							Main.getHospital()
									.cancelarCita(Main.getHospital().getIdCitaPacienteFecha(textField.getText(), x));
							textField.setText("");
							textField_1.setText("");
						}

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				} catch (PersonaNoCitas e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (FechaInvalida e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (CitaNoExiste e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(156, 163, 89, 23);
		contentPane.add(btnNewButton_1);

		JTextArea txtrFormatoFecha = new JTextArea();
		txtrFormatoFecha.setText("Formato fecha: 2022,6,6,11,30\r\na\u00F1o,mes,dia,hora,minuto");
		txtrFormatoFecha.setEditable(false);
		txtrFormatoFecha.setBounds(115, 119, 244, 40);
		contentPane.add(txtrFormatoFecha);
	}
}
