package hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaModificarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPorfavorIngreseLos;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnAgregar_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarPaciente frame = new VentanaModificarPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaModificarPaciente() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1005, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(890, 227, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("Modificar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//mofificarPaciente
			}
		});
		btnAgregar.setBounds(15, 108, 89, 23);
		contentPane.add(btnAgregar);
		
		txtPorfavorIngreseLos = new JTextField();
		txtPorfavorIngreseLos.setEditable(false);
		txtPorfavorIngreseLos.setBackground(SystemColor.menu);
		txtPorfavorIngreseLos.setBorder(null);
		txtPorfavorIngreseLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorfavorIngreseLos.setText("Porfavor ingrese los siguientes datos del paciente");
		txtPorfavorIngreseLos.setBounds(15, 11, 964, 20);
		contentPane.add(txtPorfavorIngreseLos);
		txtPorfavorIngreseLos.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("Cedula");
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(SystemColor.menu);
		textField_6.setBounds(15, 171, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(15, 196, 86, 20);
		contentPane.add(textField_7);
		
		btnAgregar_1 = new JButton("Borrar");
		btnAgregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//borrarPaciente
			}
		});
		btnAgregar_1.setBounds(15, 227, 89, 23);
		contentPane.add(btnAgregar_1);
		
		textField = new JTextField();
		textField.setText("Nombre");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(15, 52, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(15, 77, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Apellido");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(111, 52, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 77, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Cedula");
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(SystemColor.menu);
		textField_4.setBounds(207, 52, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(207, 77, 86, 20);
		contentPane.add(textField_5);
		
		textField_8 = new JTextField();
		textField_8.setText("Poliza");
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(SystemColor.menu);
		textField_8.setBounds(303, 52, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(303, 77, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("Sintomas");
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(SystemColor.menu);
		textField_10.setBounds(399, 52, 94, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(399, 77, 86, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("Triaje");
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBorder(null);
		textField_12.setBackground(SystemColor.menu);
		textField_12.setBounds(495, 52, 86, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(495, 77, 86, 20);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("Conocidos");
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBorder(null);
		textField_14.setBackground(SystemColor.menu);
		textField_14.setBounds(591, 52, 86, 20);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(591, 77, 86, 20);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("Edad");
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBorder(null);
		textField_16.setBackground(SystemColor.menu);
		textField_16.setBounds(687, 52, 94, 20);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(687, 77, 86, 20);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("Sexo");
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBorder(null);
		textField_18.setBackground(SystemColor.menu);
		textField_18.setBounds(783, 52, 86, 20);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(783, 77, 86, 20);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("Tipo de Sangre");
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBorder(null);
		textField_20.setBackground(SystemColor.menu);
		textField_20.setBounds(879, 52, 86, 20);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(879, 77, 86, 20);
		contentPane.add(textField_21);

	}
}
