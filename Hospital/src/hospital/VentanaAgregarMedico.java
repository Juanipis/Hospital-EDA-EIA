package hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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

public class VentanaAgregarMedico extends JFrame {

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarMedico frame = new VentanaAgregarMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaAgregarMedico() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(300, 119, 89, 23);
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
				JOptionPane.showMessageDialog(null, "El medico se agrego con exito");
					try {
						Main.hp.addMedico(textField.getText(), textField_1.getText(), textField_2.getText(), true, textField_4.getText(), true);
					} catch (IOException | ExistePersonal e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
		});
		btnAgregar.setBounds(58, 119, 89, 23);
		contentPane.add(btnAgregar);
		
		textField = new JTextField();
		textField.setBounds(61, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 77, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(253, 77, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(349, 77, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(445, 77, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(541, 77, 86, 20);
		contentPane.add(textField_5);
		
		txtPorfavorIngreseLos = new JTextField();
		txtPorfavorIngreseLos.setEditable(false);
		txtPorfavorIngreseLos.setBackground(SystemColor.menu);
		txtPorfavorIngreseLos.setBorder(null);
		txtPorfavorIngreseLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorfavorIngreseLos.setText("Porfavor ingrese los siguientes datos del medico");
		txtPorfavorIngreseLos.setBounds(15, 11, 662, 20);
		contentPane.add(txtPorfavorIngreseLos);
		txtPorfavorIngreseLos.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBorder(null);
		txtNombre.setBackground(SystemColor.menu);
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(61, 52, 86, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBorder(null);
		txtApellido.setBackground(SystemColor.menu);
		txtApellido.setText("Apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(157, 52, 86, 20);
		contentPane.add(txtApellido);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBorder(null);
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setText("Cedula");
		txtCedula.setColumns(10);
		txtCedula.setBounds(253, 52, 86, 20);
		contentPane.add(txtCedula);
		
		txtDisponibilidad = new JTextField();
		txtDisponibilidad.setEditable(false);
		txtDisponibilidad.setBorder(null);
		txtDisponibilidad.setBackground(SystemColor.menu);
		txtDisponibilidad.setText("Disponibilidad");
		txtDisponibilidad.setColumns(10);
		txtDisponibilidad.setBounds(349, 52, 86, 20);
		contentPane.add(txtDisponibilidad);
		
		txtEspecializacion = new JTextField();
		txtEspecializacion.setEditable(false);
		txtEspecializacion.setBorder(null);
		txtEspecializacion.setBackground(SystemColor.menu);
		txtEspecializacion.setText("Especializacion");
		txtEspecializacion.setColumns(10);
		txtEspecializacion.setBounds(445, 52, 94, 20);
		contentPane.add(txtEspecializacion);
		
		txtPrescripciones = new JTextField();
		txtPrescripciones.setEditable(false);
		txtPrescripciones.setBorder(null);
		txtPrescripciones.setBackground(SystemColor.menu);
		txtPrescripciones.setText("Prescripciones");
		txtPrescripciones.setColumns(10);
		txtPrescripciones.setBounds(541, 52, 86, 20);
		contentPane.add(txtPrescripciones);

	}
}