package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;

public class VentanaPersonalMedicos extends JFrame {

	private JTextField txtMedicos;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		txtMedicos = new JTextField();
		txtMedicos.setFont(new Font("Verdana", Font.BOLD, 34));
		txtMedicos.setBackground(SystemColor.menu);
		txtMedicos.setBorder(null);
		txtMedicos.setText("Medicos");
		txtMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicos.setBounds(10, 11, 894, 58);
		getContentPane().add(txtMedicos);
		txtMedicos.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 80, 894, 696);
		getContentPane().add(textArea);
	}
}
