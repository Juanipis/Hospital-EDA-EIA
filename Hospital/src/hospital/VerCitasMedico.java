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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VerCitasMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerCitasPaciente frame = new VerCitasPaciente();
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
	public VerCitasMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerCitasDe = new JLabel("Ver citas de un médico");
		lblVerCitasDe.setFont(new Font("Dialog", Font.BOLD, 19));
		lblVerCitasDe.setBounds(107, 12, 239, 17);
		contentPane.add(lblVerCitasDe);
		
		JLabel lblNewLabel = new JLabel("Ingrese la cedula");
		lblNewLabel.setBounds(12, 42, 114, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 64, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(172, 66, 444, 250);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(12, 97, 105, 17);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StringBuilder bld = new StringBuilder();
					for(Cita ct :Main.hp.getCitasMedico(textField.getText())) {
						bld.append(ct + "\n");
					}
					textArea.setText(bld.toString());
				} catch (MedicoNoCitas e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());		
				}

			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(12, 191, 105, 27);
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
