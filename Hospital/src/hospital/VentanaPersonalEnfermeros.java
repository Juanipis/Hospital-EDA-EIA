package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JTextField txtEnfermeros;
	
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

		txtEnfermeros = new JTextField();
		txtEnfermeros.setFont(new Font("Verdana", Font.BOLD, 34));
		txtEnfermeros.setBackground(SystemColor.menu);
		txtEnfermeros.setBorder(null);
		txtEnfermeros.setText("Enfermeros");
		txtEnfermeros.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnfermeros.setBounds(10, 11, 894, 58);
		getContentPane().add(txtEnfermeros);
		txtEnfermeros.setColumns(10);
		txtEnfermeros.setEditable(false);

		JTextField ins = new JTextField();
		ins.setBorder(null);
		ins.setBackground(SystemColor.menu);
		getContentPane().add(ins);
		ins.setBounds(415, 80, 400, 23);
		ins.setVisible(true);
		ins.setEditable(false);
		ins.setText("Porfavor ingrese los datos correctos y escoja que desea hacer con ellos");
		
		JTextArea listaEnfermeros = new JTextArea();
		listaEnfermeros.setBounds(10, 80, 400, 379);
		getContentPane().add(listaEnfermeros);
		listaEnfermeros.setEditable(false);
		listaEnfermeros.setText(Arrays.toString(Main.hp.getEnfermeros()));
		
		JTextArea datosEnfermero = new JTextArea();
		datosEnfermero.setBounds(415, 115, 400, 23);
		getContentPane().add(datosEnfermero);
		datosEnfermero.setEditable(true);
		
		JButton btnAnadirEnfermero = new JButton("A�adir");
		btnAnadirEnfermero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Main.hp.addMedico(datosMedico.getText());
				listaEnfermeros.setText(Arrays.toString(Main.hp.getEnfermeros()) + datosEnfermero.getText());
			}
		});
		btnAnadirEnfermero.setBounds(415, 150, 89, 30);
		getContentPane().add(btnAnadirEnfermero);
		
		JButton btnBorrarEnfermero = new JButton("Eliminar");
		btnBorrarEnfermero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.hp.eliminarEnfermero(datosEnfermero.getText());
				} catch (NoExistePersonal | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				datosEnfermero.getText();
				listaEnfermeros.setText(Arrays.toString(Main.hp.getEnfermeros()));
			}
		});
		btnBorrarEnfermero.setBounds(415, 180, 89, 30);
		getContentPane().add(btnBorrarEnfermero);
		
		
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
