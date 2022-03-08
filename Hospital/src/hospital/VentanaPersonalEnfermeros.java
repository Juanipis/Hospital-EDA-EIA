package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private JTextField txtCodigo;
	private JTextField txtCodigoInput;
	
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
	public String enfermerosSinSalas() {
		String texto = "";
		Enfermero [] e = Main.hp.getEnfermerosSinSala();
		for(int i =0;i<e.length;i++) {
			texto = texto + e[i].toString() + "\n";
		}
		return texto;
	}
	public boolean verificarSiSalaExiste() {
		Sala[] s = Main.hp.getSalas();
		for(int i = 0 ; i< s.length;i++) {
			if(s[i].getTipo().equals(txtCodigoInput.getText())) {
				return true;
			}
		} 
		return false;
	}
	
	public void salidaEnfermeroSala() {
		Sala [] s = Main.hp.getSalas();
		int i = 0;
			try {
				while(s[i].verificarEnfermero(txtCedulaInput.getText()) == -1 && verificarSiSalaExiste() ==true) {
						i++;
					}
				try {
					s[i].eliminarEnfermero(txtCedulaInput.getText());
					JOptionPane.showMessageDialog(null, "El enfermero se elimino correctamente de la Sala");
				} catch (NoEnfermeroEnSala e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			} catch (VectorNulo e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
			
		
		
	}
	public void agregarEnfermeroASala() {
		Enfermero [] e = Main.hp.getEnfermeros();
		
		if(verificarSiSalaExiste() == true) {
			for(int i =0;i<e.length;i++) {
				if(txtCedulaInput.getText().equals(e[i].getCC())) {
					try {
						Main.hp.addEnfermeroASala(txtCodigoInput.getText(), txtCedulaInput.getText());
						JOptionPane.showMessageDialog(null, "El enfermero ingreso se correctamente a la Sala");
					} catch (IOException | VectorNulo | EnfermeroEnSala e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
				}
			}
		}	
	}

public VentanaPersonalEnfermeros() {
	
		String texto = "";
		
		Enfermero[] enfermeros = Main.getHospital().getEnfermeros();
		for(int x = 0; x < enfermeros.length; x++) {
			texto = texto + enfermeros[x].toString() + "\n";
		}
		System.out.print(texto);
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 498, 318);
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
		btnNewButton.setBounds(330, 250, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 398, 138);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setText(texto);
		
//		JButton btnEnfermerosEnSala = new JButton("Enfermeros con Sala");
//		btnEnfermerosEnSala.setBounds(15, 181, 142, 23);
//		contentPane.add(btnEnfermerosEnSala);
		
		JButton btnEnfermerosSinSala = new JButton("Enfermeros sin Sala");
		btnEnfermerosSinSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(enfermerosSinSalas());
			}
		});
		btnEnfermerosSinSala.setBounds(15, 215, 142, 23);
		contentPane.add(btnEnfermerosSinSala);
		
		JButton btnAgregarEnfermeroaSala = new JButton("Agregar Enfermero");
		btnAgregarEnfermeroaSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEnfermeroASala();
			}
		});
		btnAgregarEnfermeroaSala.setBounds(289, 181, 130, 23);
		contentPane.add(btnAgregarEnfermeroaSala);
		
		JButton btnEliminarEnfermeroSala = new JButton("Eliminar Enfermero");
		btnEliminarEnfermeroSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salidaEnfermeroSala();
			}
		});
		btnEliminarEnfermeroSala.setBounds(289, 215, 130, 23);
		contentPane.add(btnEliminarEnfermeroSala);
		
		txtCedula = new JTextField();
		txtCedula.setBackground(SystemColor.menu);
		txtCedula.setBounds(183, 182, 96, 20);
		contentPane.add(txtCedula);
		txtCedula.setText("CEDULA");
		txtCedula.setColumns(10);
		txtCedula.setBorder(null);
		txtCedula.setEditable(false);
		
		txtCedulaInput = new JTextField();
		txtCedulaInput.setColumns(10);
		txtCedulaInput.setBounds(183, 201, 96, 20);
		contentPane.add(txtCedulaInput);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("CODIGO");
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(null);
		txtCodigo.setBackground(SystemColor.menu);
		txtCodigo.setBounds(183, 232, 96, 20);
		contentPane.add(txtCodigo);
		
		txtCodigoInput = new JTextField();
		txtCodigoInput.setColumns(10);
		txtCodigoInput.setBounds(183, 251, 96, 20);
		contentPane.add(txtCodigoInput);

	}
}
