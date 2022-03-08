package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class VentanaPacientesModificar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblFechaInicial;
	private JLabel lblFechaFinal;
	private JLabel lblCcMedico;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField textField_7;
	private JLabel lblNewLabel_1_2;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPacientesModificar frame = new VentanaPacientesModificar();
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
	public VentanaPacientesModificar() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 670, 303);
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
		btnNewButton.setBounds(153, 227, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(106, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(106, 120, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 167, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(289, 61, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(289, 92, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(289, 148, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(289, 175, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		lblNewLabel = new JLabel("CC");
		lblNewLabel.setBounds(29, 64, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Fecha inicial");
		lblNewLabel_1.setBounds(10, 123, 65, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Fecha final");
		lblNewLabel_2.setBounds(10, 170, 65, 14);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("CC");
		lblNewLabel_3.setBounds(202, 64, 46, 14);
		contentPane.add(lblNewLabel_3);

		lblFechaInicial = new JLabel("Fecha inicial");
		lblFechaInicial.setBounds(202, 151, 80, 14);
		contentPane.add(lblFechaInicial);

		lblFechaFinal = new JLabel("Fecha final");
		lblFechaFinal.setBounds(202, 181, 80, 14);
		contentPane.add(lblFechaFinal);

		lblCcMedico = new JLabel("CC medico");
		lblCcMedico.setBounds(202, 95, 77, 14);
		contentPane.add(lblCcMedico);

		btnNewButton_2 = new JButton("Mismo doctor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setEnabled(true);
				textField_1.setEnabled(true);
				textField_7.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(false);
				textField_4.setEnabled(false);
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				textField_8.setEnabled(false);
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_8.setText("");

			}
		});
		btnNewButton_2.setBounds(63, 11, 108, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Diferente Doctor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setEnabled(false);
				textField_1.setEnabled(false);
				textField_2.setEnabled(false);
				textField_7.setEnabled(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_7.setText("");

				textField_3.setEnabled(true);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
				textField_8.setEnabled(true);
			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("Fecha original");
		lblNewLabel_1_1.setBounds(10, 95, 89, 14);
		contentPane.add(lblNewLabel_1_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(106, 92, 86, 20);
		contentPane.add(textField_7);
		btnNewButton_3.setBounds(286, 11, 122, 23);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() != 0 && textField_1.getText().length() != 0
						&& textField_3.getText().length() != 0) {

					String inicial = textField_7.getText();
					String[] h = inicial.split(",");

					int[] y = new int[h.length];
					for (int i = 0; i < h.length; i++) {
						y[i] = Integer.parseInt(h[i]);

					}

					String ini = textField_1.getText();
					String[] a = ini.split(",");

					int[] x = new int[a.length];
					for (int i = 0; i < a.length; i++) {
						x[i] = Integer.parseInt(a[i]);

					}

					String fin = textField_2.getText();
					String[] b = fin.split(",");

					int[] c = new int[a.length];
					for (int i = 0; i < a.length; i++) {
						c[i] = Integer.parseInt(b[i]);

					}

					try {

						try {

							Main.getHospital().modificarCita(
									Main.getHospital().getIdCitaPacienteFecha(textField.getText(), y), x, c);
							textField.setText("");
							textField_7.setText("");
							textField_1.setText("");
							textField_2.setText("");
						} catch (FechaInvalida e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} catch (FormatoFechaInvalida e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (CitaNoExiste e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (PersonaNoCitas e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NoHayDisponibilidadCita e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (MedicoNoCitas e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}

				} else if (textField_5.getText().length() != 0) {

					String inicial = textField_8.getText();
					String[] h = inicial.split(",");

					int[] y = new int[h.length];
					for (int i = 0; i < h.length; i++) {
						y[i] = Integer.parseInt(h[i]);

					}

					String ini = textField_5.getText();
					String[] a = ini.split(",");

					int[] x = new int[a.length];
					for (int i = 0; i < a.length; i++) {
						x[i] = Integer.parseInt(a[i]);

					}

					String fin = textField_6.getText();
					String[] b = fin.split(",");

					int[] c = new int[a.length];
					for (int i = 0; i < a.length; i++) {
						c[i] = Integer.parseInt(b[i]);

					}

					try {

						try {
							String g = "";
							g = Main.getHospital().getIdCitaPacienteFecha(textField_3.getText(), y);
							Main.getHospital().modificarCita(g, textField_4.getText(), x, c);
						} catch (FormatoFechaInvalida e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (NoHayDisponibilidadCita e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					} catch (PersonaNoCitas e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e2.getMessage());
					} catch (FechaInvalida e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e2.getMessage());
					} catch (CitaNoExiste e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}

				}

			}
		});
		btnNewButton_1.setBounds(153, 198, 89, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_1_2 = new JLabel("Fecha original");
		lblNewLabel_1_2.setBounds(202, 123, 80, 14);
		contentPane.add(lblNewLabel_1_2);

		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(289, 120, 86, 20);
		contentPane.add(textField_8);
		
		JTextArea txtrFormatoFecha = new JTextArea();
		txtrFormatoFecha.setText("Formato fecha: 2022,6,6,11,30\r\na\u00F1o,mes,dia,hora,minuto");
		txtrFormatoFecha.setEditable(false);
		txtrFormatoFecha.setBounds(400, 118, 244, 40);
		contentPane.add(txtrFormatoFecha);

	}
}
