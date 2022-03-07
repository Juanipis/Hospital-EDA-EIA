package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class VentanaInventarioHistorial extends JFrame {

	private JPanel contentPane;
	private JTextField txtPacientes;
	private JScrollPane scrollPane;
	private JTextField txtCedula;
	private JTextField txtCedulaInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInventarioHistorial frame = new VentanaInventarioHistorial();
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
	public VentanaInventarioHistorial() {
		
		String texto = "";
		
		Paciente[] pacientes = Main.getHospital().getPacientes();
		for(int x = 0; x < pacientes.length; x++) {
			texto = texto + pacientes[x].getNombre() +" CC: "+pacientes[x].getCC() + " "+"\n";
		}
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
		btnNewButton.setBounds(153, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 33, 277, 171);
		contentPane.add(scrollPane);
		
		txtPacientes = new JTextField();
		txtPacientes.setEditable(false);
		scrollPane.setViewportView(txtPacientes);
		
		txtPacientes.setText(texto);
		
		txtCedulaInput = new JTextField();
		txtCedulaInput.setBounds(332, 99, 96, 20);
		contentPane.add(txtCedulaInput);
		txtCedulaInput.setColumns(10);
		txtCedulaInput.setEditable(true);
		
		
		txtCedula = new JTextField();
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setBounds(332, 68, 96, 20);
		contentPane.add(txtCedula);
		txtCedula.setText("Ingrese Cedula");
		txtCedula.setColumns(10);
		txtCedula.setEditable(false);
		txtCedula.setBorder(null);
		
		JButton btnConsultarHistorial = new JButton("Consultar Historial");
		btnConsultarHistorial.setBounds(332, 139, 89, 23);
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInventarioHistorialPacientes historialPaciente = new VentanaInventarioHistorialPacientes();
				dispose();
			}
		});
		contentPane.add(btnConsultarHistorial);
		
	}
}
