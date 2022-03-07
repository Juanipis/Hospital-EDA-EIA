package hospital;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VentanaAgregarEnfermero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtPorfavorIngreseLos;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDisponibilidad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarEnfermero frame = new VentanaAgregarEnfermero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaAgregarEnfermero() {
	
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
				try {
					Main.hp.addEnfermeros(textField.getText(), textField_1.getText(), textField_2.getText(), true);
				} catch (IOException | ExistePersonal e1) {
					// TODO Auto-generated catch block
					
				}
			}
		});
		btnAgregar.setBounds(61, 119, 89, 23);
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
		
		txtPorfavorIngreseLos = new JTextField();
		txtPorfavorIngreseLos.setEditable(false);
		txtPorfavorIngreseLos.setBackground(SystemColor.menu);
		txtPorfavorIngreseLos.setBorder(null);
		txtPorfavorIngreseLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorfavorIngreseLos.setText("Porfavor ingrese los siguientes datos del enfermero");
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

	}
}
