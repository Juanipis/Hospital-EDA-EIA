package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class VentanaPacientesModificar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblFechaInicial;
	private JLabel lblFechaFinal;
	private JLabel lblCcMedico;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPacientesModificar frame = new VentanaPacientesModificar();
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
	public VentanaPacientesModificar() {
	
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
		btnNewButton.setBounds(152, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(85, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 103, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 150, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(289, 61, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(289, 92, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(289, 123, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(289, 150, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel = new JLabel("CC");
		lblNewLabel.setBounds(29, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fecha inicial");
		lblNewLabel_1.setBounds(10, 106, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fecha final");
		lblNewLabel_2.setBounds(10, 153, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CC");
		lblNewLabel_3.setBounds(202, 64, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblFechaInicial = new JLabel("Fecha inicial");
		lblFechaInicial.setBounds(202, 126, 80, 14);
		contentPane.add(lblFechaInicial);
		
		lblFechaFinal = new JLabel("Fecha final");
		lblFechaFinal.setBounds(202, 156, 80, 14);
		contentPane.add(lblFechaFinal);
		
		lblCcMedico = new JLabel("CC medico");
		lblCcMedico.setBounds(202, 95, 77, 14);
		contentPane.add(lblCcMedico);
		
		btnNewButton_2 = new JButton("Mismo doctor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					
					textField_2.setEnabled(true);
					textField_3.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					
				
			}
		});
		btnNewButton_2.setBounds(63, 11, 108, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Diferente Doctor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setEnabled(false);
				textField_1.setEnabled(false);
				
				textField_2.setEnabled(false);
				textField_3.setEnabled(true);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
			}
		});
		btnNewButton_3.setBounds(286, 11, 122, 23);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!=null||textField.getText()!="") {
					
					String ini=  textField_1.getText();
					String[] a= ini.split(",");
				
					int [] x=new int [a.length];
					for (int i = 0; i < a.length; i++) {
						x[i]= Integer.parseInt(a[i]);
					
					}
					
					String fin=  textField_2.getText();
					String[] b= fin.split(",");
				
					int [] c=new int [a.length];
					for (int i = 0; i < a.length; i++) {
						c[i]= Integer.parseInt(b[i]);
					
					}
					
					
					try {
						String g = "";
						try {
							g = Main.getHospital().getIdCitaPacienteFecha(textField.getText(), x);
						} catch (FechaInvalida e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Main.getHospital().modificarCita(g, x, c);
					} catch (FormatoFechaInvalida e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CitaNoExiste e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PersonaNoCitas e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoHayDisponibilidadCita e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MedicoNoCitas e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if (textField_5.getText()!=""||textField_3.getText()!=null){
					String ini=  textField_1.getText();
					String[] a= ini.split(",");
				
					int [] x=new int [a.length];
					for (int i = 0; i < a.length; i++) {
						x[i]= Integer.parseInt(a[i]);
					
					}
					
					String fin=  textField_6.getText();
					String[] b= fin.split(",");
				
					int [] c=new int [a.length];
					for (int i = 0; i < a.length; i++) {
						c[i]= Integer.parseInt(b[i]);
					
					}
					
					
					String g ="";
					try {
						g= Main.getHospital().getIdCitaPacienteFecha(textField_3.getText(), c);
					} catch (PersonaNoCitas e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (FechaInvalida e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (CitaNoExiste e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						Main.getHospital().modificarCita(g, textField_4.getText(), x, c);
					} catch (FormatoFechaInvalida e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CitaNoExiste e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PersonaNoCitas e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoHayDisponibilidadCita e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(152, 181, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
