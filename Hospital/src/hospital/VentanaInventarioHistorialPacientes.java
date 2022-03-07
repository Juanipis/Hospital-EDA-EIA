package hospital;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class VentanaInventarioHistorialPacientes extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtHistorial;
	private JTextField txtNombrePaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInventarioHistorialPacientes window = new VentanaInventarioHistorialPacientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInventarioHistorialPacientes() {
		
		
		
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
		btnNewButton.setBounds(297, 169, 89, 23);
		contentPane.add(btnNewButton);
		
		txtHistorial = new JTextField();
		txtHistorial.setBounds(35, 26, 231, 215);
		txtHistorial.setEditable(false);
		contentPane.add(txtHistorial);
		txtHistorial.setColumns(10);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setBounds(290, 48, 96, 43);
		contentPane.add(txtNombrePaciente);
		txtNombrePaciente.setEditable(false);
		txtNombrePaciente.setColumns(10);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	

}
