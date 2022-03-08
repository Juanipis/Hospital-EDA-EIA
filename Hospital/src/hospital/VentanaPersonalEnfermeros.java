package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class VentanaPersonalEnfermeros extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtCedulaInput;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalEnfermeros frame = new VentanaPersonalEnfermeros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public VentanaPersonalEnfermeros() {
	
		String texto = "";
		
		Enfermero[] enfermeros = Main.getHospital().getEnfermeros();
		for(int x = 0; x < enfermeros.length; x++) {
			texto = texto + enfermeros[x].toString() + "\n";
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
		
		JButton btnEnfermerosEnSala = new JButton("Enfermeros con Sala");
		btnEnfermerosEnSala.setBounds(15, 181, 142, 23);
		contentPane.add(btnEnfermerosEnSala);
		
		JButton btnEnfermerosSinSala = new JButton("Enfermeros sin Sala");
		btnEnfermerosSinSala.setBounds(15, 215, 142, 23);
		contentPane.add(btnEnfermerosSinSala);
		
		JButton btnAgregarEnfermeroaSala = new JButton("Agregar Enfermero");
		btnAgregarEnfermeroaSala.setBounds(289, 181, 130, 23);
		contentPane.add(btnAgregarEnfermeroaSala);
		
		JButton btnEliminarEnfermeroSala = new JButton("Eliminar Enfermero");
		btnEliminarEnfermeroSala.setBounds(289, 215, 130, 23);
		contentPane.add(btnEliminarEnfermeroSala);
		
		txtCedula = new JTextField();
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setBounds(177, 191, 96, 20);
		contentPane.add(txtCedula);
		txtCedula.setText("CEDULA");
		txtCedula.setColumns(10);
		txtCedula.setBorder(null);
		txtCedula.setEditable(false);
		
		txtCedulaInput = new JTextField();
		txtCedulaInput.setColumns(10);
		txtCedulaInput.setBounds(177, 218, 96, 20);
		contentPane.add(txtCedulaInput);

	}
}
