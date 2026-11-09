package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaSetFormula extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtIdcita;
	private JTextField txtEnfermedades;
	private JTextField txtOperaciones;
	private JTextField txtAlergias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSetFormula frame = new VentanaSetFormula();
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
	public VentanaSetFormula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseNuevosDatos = new JLabel("Ingrese nuevos datos al historial de un paciente");
		lblIngreseNuevosDatos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIngreseNuevosDatos.setBounds(35, 12, 359, 17);
		contentPane.add(lblIngreseNuevosDatos);
		
		JLabel lblCcMedico = new JLabel("CC Medico");
		lblCcMedico.setBounds(34, 49, 83, 17);
		contentPane.add(lblCcMedico);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(35, 73, 114, 21);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblIdCita = new JLabel("ID Cita");
		lblIdCita.setBounds(35, 106, 60, 17);
		contentPane.add(lblIdCita);
		
		txtIdcita = new JTextField();
		txtIdcita.setBounds(35, 124, 114, 21);
		contentPane.add(txtIdcita);
		txtIdcita.setColumns(10);
		
		JLabel lblEnfermedades = new JLabel("Enfermedades");
		lblEnfermedades.setBounds(35, 167, 93, 17);
		contentPane.add(lblEnfermedades);
		
		txtEnfermedades = new JTextField();
		txtEnfermedades.setBounds(35, 188, 114, 21);
		contentPane.add(txtEnfermedades);
		txtEnfermedades.setColumns(10);
		
		JLabel lblSeparadasPorComas = new JLabel("Separadas por comas \",\"");
		lblSeparadasPorComas.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblSeparadasPorComas.setBounds(35, 211, 93, 17);
		contentPane.add(lblSeparadasPorComas);
		
		JLabel lblOperaciones = new JLabel("Operaciones");
		lblOperaciones.setBounds(205, 49, 83, 17);
		contentPane.add(lblOperaciones);
		
		txtOperaciones = new JTextField();
		txtOperaciones.setBounds(205, 73, 114, 21);
		contentPane.add(txtOperaciones);
		txtOperaciones.setColumns(10);
		
		JLabel lblSeparadasPorComas_1 = new JLabel("Separadas por comas \",\"");
		lblSeparadasPorComas_1.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblSeparadasPorComas_1.setBounds(205, 94, 93, 17);
		contentPane.add(lblSeparadasPorComas_1);
		
		JLabel lblAlergias = new JLabel("Alergias");
		lblAlergias.setBounds(205, 126, 60, 17);
		contentPane.add(lblAlergias);
		
		txtAlergias = new JTextField();
		txtAlergias.setBounds(205, 151, 114, 21);
		contentPane.add(txtAlergias);
		txtAlergias.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(190, 204, 105, 27);
		contentPane.add(btnAadir);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.hp.addHistorialPaciente(txtCedula.getText(), txtIdcita.getText(), txtEnfermedades.getText().split(","), txtOperaciones.getText().split(";"), txtAlergias.getText().split(";"));
					JOptionPane.showMessageDialog(null,"Historial añadido con éxito");		
				} catch (MedicoNoCitas | IOException | CitaNoExiste e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(312, 204, 105, 27);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio inicio = new VentanaInicio();
				inicio.setVisible(true);
				dispose();
			}
		});
	}

}
