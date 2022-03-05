package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;

public class InformacionMedicos {

	public JFrame medicosFrame;
	private JTextField txtMedicos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionMedicos window = new InformacionMedicos();
					window.medicosFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InformacionMedicos() {
		initialize();
	}

	/**
	 * Initialize the contents of the medicosFrame.
	 */
	private void initialize() {
		medicosFrame = new JFrame();
		medicosFrame.setBounds(100, 100, 930, 826);
		medicosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		medicosFrame.getContentPane().setLayout(null);
		
		txtMedicos = new JTextField();
		txtMedicos.setFont(new Font("Verdana", Font.BOLD, 34));
		txtMedicos.setBackground(SystemColor.menu);
		txtMedicos.setBorder(null);
		txtMedicos.setText("Medicos");
		txtMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicos.setBounds(10, 11, 894, 58);
		medicosFrame.getContentPane().add(txtMedicos);
		txtMedicos.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 80, 894, 696);
		medicosFrame.getContentPane().add(textArea);
	}
}
