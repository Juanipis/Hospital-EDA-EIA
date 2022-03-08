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
	private JTextField textField;

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
		
		if( verificarSiSalaExiste() == true) {
			for(int i =0;i<p.length;i++) {
				if(txtCedulaInput.getText().equals(p[i].getCC())) {
					try {
						Main.hp.ingresarPacienteSala(txtCodigoSalaInput.getText(), txtCedulaInput.getText());
						JOptionPane.showMessageDialog(null, "El paciente se ingreso correctamente a la Sala");
					} catch (IOException | VectorNulo | PacienteEnSala | SalaLLena | NoExisteSala | NoExistePaciente e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					
					}
				}
			}
		}
	}
	public void salidaPacientesSala() {
		//Paciente [] p = Main.hp.getPacientes();
		//for(int i=0 ; i<p.length;i++) {
			try {
				Main.hp.salidaPacienteSala(txtCodigoSalaInput.getText(), txtCedulaInput.getText());
				JOptionPane.showMessageDialog(null, "El paciente se retiro correctamente de la Sala");
			} catch (VectorNulo | NoPacienteEnSala e) {
				JOptionPane.showMessageDialog(null,  e.getMessage());
				e.printStackTrace();
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
		setBounds(100, 100, 477, 324);
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
		btnNewButton.setBounds(324, 258, 89, 23);
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
		btnPacientesSinSala.setBounds(15, 172, 137, 23);
		contentPane.add(btnPacientesSinSala);
		
		JButton btnPacientesConSala = new JButton("Pacientes Con Sala");
		btnPacientesConSala.setBounds(15, 220, 137, 23);
		contentPane.add(btnPacientesConSala);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(169, 173, 96, 20);
		contentPane.add(txtCedula);
		txtCedula.setText("CEDULA");
		txtCedula.setEditable(false);
		txtCedula.setColumns(10);
		txtCedula.setBorder(null);
		
		txtCedulaInput = new JTextField();
		txtCedulaInput.setColumns(10);
		txtCedulaInput.setBounds(162, 190, 96, 20);
		contentPane.add(txtCedulaInput);
		
		JButton btnAgregarPacienteASala = new JButton("Agregar Paciente");
		btnAgregarPacienteASala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarPacienteASala();
			}
		});
		btnAgregarPacienteASala.setBounds(286, 165, 147, 23);
		contentPane.add(btnAgregarPacienteASala);
		
		JButton btnEliminarPacientedeSala = new JButton("Eliminar Paciente");
		btnEliminarPacientedeSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salidaPacientesSala();
			}
		});
		btnEliminarPacientedeSala.setBounds(286, 224, 147, 23);
		contentPane.add(btnEliminarPacientedeSala);
		
		//Codigo Sala
		txtCodigoSalaInput = new JTextField();
		txtCodigoSalaInput.setColumns(10);
		txtCodigoSalaInput.setBounds(162, 240, 96, 20);
		contentPane.add(txtCodigoSalaInput);
		
		textField = new JTextField();
		textField.setText("CODIGO");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(162, 221, 96, 20);
		contentPane.add(textField);

	}
}
