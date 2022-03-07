package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class VentanaPersonalMedicos extends JFrame {

	private JTextField txtMedicos;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonalMedicos window = new VentanaPersonalMedicos();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPersonalMedicos() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the medicosFrame.
	 */
	private void initialize() {

		setBounds(100, 100, 930, 826);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);

		txtMedicos = new JTextField();
		txtMedicos.setFont(new Font("Verdana", Font.BOLD, 34));
		txtMedicos.setBackground(SystemColor.menu);
		txtMedicos.setBorder(null);
		txtMedicos.setText("Medicos");
		txtMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicos.setBounds(10, 11, 894, 58);
		getContentPane().add(txtMedicos);
		txtMedicos.setColumns(10);
		txtMedicos.setEditable(false);

		JTextField ins = new JTextField();
		ins.setBorder(null);
		ins.setBackground(SystemColor.menu);
		getContentPane().add(ins);
		ins.setBounds(415, 80, 400, 23);
		ins.setVisible(true);
		ins.setEditable(false);
		ins.setText("Porfavor ingrese los datos correctos y escoja que desea hacer con ellos");
		
		JTextArea listaMedicos = new JTextArea();
		listaMedicos.setBounds(10, 80, 400, 379);
		getContentPane().add(listaMedicos);
		listaMedicos.setEditable(false);
		listaMedicos.setText(Arrays.toString(Main.hp.getMedicos()));
		
		JTextArea datosMedico = new JTextArea();
		datosMedico.setBounds(415, 115, 400, 23);
		getContentPane().add(datosMedico);
		datosMedico.setEditable(true);
		
		JButton btnAñadirMedico = new JButton("Añadir");
		btnAñadirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.hp.addMedico(datosMedico.getText());
				listaMedicos.setText(Arrays.toString(Main.hp.getMedicos()) + datosMedico.getText());
			}
		});
		btnAñadirMedico.setBounds(415, 150, 89, 30);
		getContentPane().add(btnAñadirMedico);
		
		JButton btnBorrarMedico = new JButton("Eliminar");
		btnBorrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.hp.eliminarMedico(datosMedico.getText());
				} catch (NoExistePersonal | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				datosMedico.getText();
				listaMedicos.setText(Arrays.toString(Main.hp.getMedicos()));
			}
		});
		btnBorrarMedico.setBounds(415, 180, 89, 30);
		getContentPane().add(btnBorrarMedico);
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(446, 600, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
