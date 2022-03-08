package hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaModificarMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtPorfavorIngreseLos;
	private JTextField textField_6;
	private JTextField txtCedula;
	private JButton btnBorrar;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnBuscar;
	private JButton btnAgregar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarMedico frame = new VentanaModificarMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaModificarMedico() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 545, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(26, 251, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		btnAgregar = new JButton("Modificar");
		btnAgregar.setBounds(183, 251, 131, 23);
		contentPane.add(btnAgregar);
		
		txtPorfavorIngreseLos = new JTextField();
		txtPorfavorIngreseLos.setEditable(false);
		txtPorfavorIngreseLos.setBackground(SystemColor.menu);
		txtPorfavorIngreseLos.setBorder(null);
		txtPorfavorIngreseLos.setHorizontalAlignment(SwingConstants.CENTER);
		txtPorfavorIngreseLos.setText("Porfavor ingrese los siguientes datos del medico");
		txtPorfavorIngreseLos.setBounds(0, 16, 541, 23);
		contentPane.add(txtPorfavorIngreseLos);
		txtPorfavorIngreseLos.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("Cedula");
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(SystemColor.menu);
		textField_6.setBounds(15, 52, 86, 20);
		contentPane.add(textField_6);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(136, 52, 142, 20);
		contentPane.add(txtCedula);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Main.hp.eliminarMedico(txtCedula.getText());
						JOptionPane.showMessageDialog(null, "El medico se borro con exito");
					} catch (NoExistePersonal | IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
		});
		btnBorrar.setBounds(377, 251, 131, 23);
		contentPane.add(btnBorrar);
		
		textField = new JTextField();
		textField.setText("Nombre");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(15, 88, 86, 20);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setText("Apellido");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(15, 125, 86, 20);
		contentPane.add(textField_2);

		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(136, 88, 142, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(136, 125, 142, 23);
		contentPane.add(txtApellido);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cc = txtCedula.getText();
				Medico p = Main.getHospital().getMedico(cc);
				if(p == null) {
					JOptionPane.showMessageDialog(null, "No existe la persona");
				}else {
					txtNombre.setText(p.getNombre());
					txtApellido.setText(p.getApellido());
					btnAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String nombre = txtNombre.getText();
							String apellido = txtApellido.getText();
							
							if(txtNombre.getText() != "" && txtNombre.getText() != p.getNombre()) {
								p.setNombre(nombre);
							}
							
							if(txtApellido.getText() != "" && txtApellido.getText() != p.getApellido()) {
								p.setApellido(apellido);
							}
		
						}
					});
				}
				
			}
		});
		btnBuscar.setBounds(330, 55, 131, 23);
		contentPane.add(btnBuscar);

	}
}