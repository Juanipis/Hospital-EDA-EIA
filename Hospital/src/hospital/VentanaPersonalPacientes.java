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
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class VentanaPersonalPacientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtCedulaInput;
	private JTextField txtCodigoSalaInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalPacientes frame = new VentanaPersonalPacientes();
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
	public String pacientesEnSalas() {
		String texto = "";
		Paciente [] p = Main.hp.getPacienteSinSala();
		for(int i =0;i<p.length;i++) {
			texto = texto + p[i].toString() + "\n";
		}
		return texto;
	}
	public String pacientesSinSalas() {
		String texto = "";
		Paciente [] p = Main.hp.getPacienteSinSala();
		for(int i =0;i<p.length;i++) {
			texto = texto + p[i].toString() + "\n";
		}
		return texto;
	}
	public boolean verificarSiSalaExiste() {
		Sala[] s = Main.hp.getSalas();
		for(int i = 0 ; i< s.length;i++) {
			if(s[i].getTipo().equals(txtCodigoSalaInput.getText())) {
				return true;
			}
		} 
		return false;
	}
	public void agregarPacienteASala() {
		Paciente [] p = Main.hp.getPacienteSinSala();
		
		
			for(int i =0;i<p.length;i++) {
				if(txtCedulaInput.getText().equals(p[i].getCC()) && verificarSiSalaExiste() == true) {
					try {
						Main.hp.ingresarPacienteSala(txtCodigoSalaInput.getText(), txtCedulaInput.getText());
					} catch (IOException | VectorNulo | PacienteEnSala | SalaLLena | NoExisteSala | NoExistePaciente e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
			}
		}
	}
	
	public VentanaPersonalPacientes() {
		String texto = "";
		
		Paciente[] pacientes = Main.getHospital().getPacientes();
		for(int x = 0; x < pacientes.length; x++) {
			texto = texto + pacientes[x].toString() + "\n";
		}
		System.out.print(texto);
	
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
		btnNewButton.setBounds(167, 157, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 398, 138);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setText(texto);
		
		JButton btnPacientesSinSala = new JButton("Pacientes Sin Sala");
		btnPacientesSinSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(pacientesSinSalas());
			}
		});
		btnPacientesSinSala.setBounds(32, 188, 127, 23);
		contentPane.add(btnPacientesSinSala);
		
		JButton btnPacientesConSala = new JButton("Pacientes Con Sala");
		btnPacientesConSala.setBounds(32, 220, 127, 23);
		contentPane.add(btnPacientesConSala);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(177, 191, 96, 20);
		contentPane.add(txtCedula);
		txtCedula.setText("CEDULA");
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBorder(null);
		
		txtCedulaInput = new JTextField();
		txtCedulaInput.setColumns(10);
		txtCedulaInput.setBounds(177, 221, 96, 20);
		contentPane.add(txtCedulaInput);
		
		JButton btnAgregarPacienteASala = new JButton("Agregar Paciente");
		btnAgregarPacienteASala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPacienteASala();
			}
		});
		btnAgregarPacienteASala.setBounds(283, 188, 127, 23);
		contentPane.add(btnAgregarPacienteASala);
		
		JButton btnEliminarPacientedeSala = new JButton("Eliminar Paciente");
		btnEliminarPacientedeSala.setBounds(283, 220, 127, 23);
		contentPane.add(btnEliminarPacientedeSala);
		
		//Codigo Sala
		txtCodigoSalaInput = new JTextField();
		txtCodigoSalaInput.setColumns(10);
		txtCodigoSalaInput.setBounds(177, 235, 96, 20);
		contentPane.add(txtCodigoSalaInput);

	}
}
