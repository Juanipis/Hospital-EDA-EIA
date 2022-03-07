package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaInventarioSalas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInventarioSalas frame = new VentanaInventarioSalas();
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
	public VentanaInventarioSalas() {
		
		String texto = "";
		
		Sala[] salas = Main.getHospital().getSalas();
		for(int x = 0; x < salas.length; x++) {
			texto = texto + salas[x].getTipo().toString() + "\n";
		}
		System.out.print(texto);
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 657, 426);
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
		btnNewButton.setBounds(452, 300, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 50, 276, 164);
		contentPane.add(scrollPane);
		
		JTextArea txtSalas = new JTextArea();
		txtSalas.setEditable(false);
		scrollPane.setViewportView(txtSalas);
		txtSalas.setText(texto);
	}
}
