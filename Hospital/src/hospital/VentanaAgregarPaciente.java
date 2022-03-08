package hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaAgregarPaciente  extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtPorfavorIngreseLos;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDisponibilidad;
	private JTextField txtEspecializacion;
	private JTextField txtPrescripciones;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtEdad;
	private JTextField txtEdad_1;
	private JTextField txtSexo;
	private JTextField textField_9;
	private JTextField txtTipoDeSangre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarPaciente frame = new VentanaAgregarPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaAgregarPaciente() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1033, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(465, 119, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.hp.addPaciente(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), null, Integer.valueOf(textField_5.getText()), null, Integer.valueOf(textField_7.getText()), textField_8.getText(), textField_9.getText());
					JOptionPane.showMessageDialog(null, "El paciente se agrego correctamente");
				} catch (IOException | ExistePersonal e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAgregar.setBounds(12, 119, 89, 23);
		contentPane.add(btnAgregar);
		
		textField = new JTextField();
		textField.setBounds(15, 67, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 67, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(207, 67, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 67, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(399, 67, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(495, 67, 86, 20);
		contentPane.add(textField_5);
		
		txtPorfavorIngreseLos = new JTextField();
		txtPorfavorIngreseLos.setEditable(false);
		txtPorfavorIngreseLos.setBackground(SystemColor.menu);
		txtPorfavorIngreseLos.setBorder(null);
		txtPorfavorIngreseLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorfavorIngreseLos.setText("Porfavor ingrese los siguientes datos del paciente");
		txtPorfavorIngreseLos.setBounds(15, 11, 992, 20);
		contentPane.add(txtPorfavorIngreseLos);
		txtPorfavorIngreseLos.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBorder(null);
		txtNombre.setBackground(SystemColor.menu);
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(15, 42, 86, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBorder(null);
		txtApellido.setBackground(SystemColor.menu);
		txtApellido.setText("Apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(111, 42, 86, 20);
		contentPane.add(txtApellido);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBorder(null);
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setText("Cedula");
		txtCedula.setColumns(10);
		txtCedula.setBounds(207, 42, 86, 20);
		contentPane.add(txtCedula);
		
		txtDisponibilidad = new JTextField();
		txtDisponibilidad.setEditable(false);
		txtDisponibilidad.setBorder(null);
		txtDisponibilidad.setBackground(SystemColor.menu);
		txtDisponibilidad.setText("Poliza");
		txtDisponibilidad.setColumns(10);
		txtDisponibilidad.setBounds(303, 42, 86, 20);
		contentPane.add(txtDisponibilidad);
		
		txtEspecializacion = new JTextField();
		txtEspecializacion.setEditable(false);
		txtEspecializacion.setBorder(null);
		txtEspecializacion.setBackground(SystemColor.menu);
		txtEspecializacion.setText("Sintomas");
		txtEspecializacion.setColumns(10);
		txtEspecializacion.setBounds(399, 42, 94, 20);
		contentPane.add(txtEspecializacion);
		
		txtPrescripciones = new JTextField();
		txtPrescripciones.setEditable(false);
		txtPrescripciones.setBorder(null);
		txtPrescripciones.setBackground(SystemColor.menu);
		txtPrescripciones.setText("Triaje");
		txtPrescripciones.setColumns(10);
		txtPrescripciones.setBounds(495, 42, 86, 20);
		contentPane.add(txtPrescripciones);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(591, 67, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(687, 67, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(783, 67, 86, 20);
		contentPane.add(textField_8);
		
		txtEdad = new JTextField();
		txtEdad.setText("Conocidos");
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBorder(null);
		txtEdad.setBackground(SystemColor.menu);
		txtEdad.setBounds(591, 42, 86, 20);
		contentPane.add(txtEdad);
		
		txtEdad_1 = new JTextField();
		txtEdad_1.setText("Edad");
		txtEdad_1.setEditable(false);
		txtEdad_1.setColumns(10);
		txtEdad_1.setBorder(null);
		txtEdad_1.setBackground(SystemColor.menu);
		txtEdad_1.setBounds(687, 42, 94, 20);
		contentPane.add(txtEdad_1);
		
		txtSexo = new JTextField();
		txtSexo.setText("Sexo");
		txtSexo.setEditable(false);
		txtSexo.setColumns(10);
		txtSexo.setBorder(null);
		txtSexo.setBackground(SystemColor.menu);
		txtSexo.setBounds(783, 42, 86, 20);
		contentPane.add(txtSexo);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(879, 67, 86, 20);
		contentPane.add(textField_9);
		
		txtTipoDeSangre = new JTextField();
		txtTipoDeSangre.setText("Tipo de Sangre");
		txtTipoDeSangre.setEditable(false);
		txtTipoDeSangre.setColumns(10);
		txtTipoDeSangre.setBorder(null);
		txtTipoDeSangre.setBackground(SystemColor.menu);
		txtTipoDeSangre.setBounds(879, 42, 86, 20);
		contentPane.add(txtTipoDeSangre);

	}
}

