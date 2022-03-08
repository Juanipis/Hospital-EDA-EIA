package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class VentanaInventarioSalas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;

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
//
//	public void ingresarMedicamentoASala() {
//		Sala [] s = Main.hp.getSalas();
//		
//			new SimpleDateFormat("dd-MM-yyyy").parse(textField_3.getText());
//		
//			
//		}
//		int i=0;
//		while(!(s[i].getTipo().equals(textField_17.getText()))){
//			i++;
//		}
//		if(i<s.length) {
//			//s[i].addMedicamento(textField_1, textField_2, null, null, textField_6, true);
//		}
//	}
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
		btnNewButton.setBounds(475, 341, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 50, 276, 164);
		contentPane.add(scrollPane);
		
		JTextArea txtSalas = new JTextArea();
		txtSalas.setEditable(false);
		scrollPane.setViewportView(txtSalas);
		txtSalas.setText(texto);
		
		JButton btnAgregarmedicamentoSala = new JButton("AgregarMedicamento");
		btnAgregarmedicamentoSala.setBounds(438, 293, 159, 23);
		contentPane.add(btnAgregarmedicamentoSala);
		
		
		//nombre
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.menu);
		textField_8.setColumns(10);
		textField_8.setBounds(87, 238, 132, 20);
		contentPane.add(textField_8);
		textField_8.setText("NOMBRE");
		textField_8.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 255, 132, 20);
		contentPane.add(textField_1);
		
		
		//Id
		textField_11 = new JTextField();
		textField_11.setBackground(SystemColor.menu);
		textField_11.setColumns(10);
		textField_11.setBounds(87, 294, 132, 20);
		contentPane.add(textField_11);
		textField_11.setText("ID");
		textField_11.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 313, 132, 20);
		contentPane.add(textField_2);
		
		//FechaCompra
		textField_12 = new JTextField();
		textField_12.setBackground(SystemColor.menu);
		textField_12.setColumns(10);
		textField_12.setBounds(251, 294, 121, 20);
		contentPane.add(textField_12);
		textField_12.setText("FECHACOMPRA");
		textField_12.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(251, 313, 121, 20);
		contentPane.add(textField_3);
		
		//FechaVencimiento
		textField_13 = new JTextField();
		textField_13.setBackground(SystemColor.menu);
		textField_13.setColumns(10);
		textField_13.setBounds(251, 238, 121, 20);
		contentPane.add(textField_13);
		textField_13.setText("FECHAVENCIMIENTO");
		textField_13.setEditable(false);
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 255, 121, 20);
		contentPane.add(textField_4);
		
		
		
		//Cantidad
		textField_14 = new JTextField();
		textField_14.setBackground(SystemColor.menu);
		textField_14.setColumns(10);
		textField_14.setBounds(87, 342, 132, 20);
		contentPane.add(textField_14);
		textField_14.setText("CANTIDAD");
		textField_14.setEditable(false);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(87, 361, 132, 20);
		contentPane.add(textField_6);
		
//		//Disponibilidad
//		textField_15 = new JTextField();
//		textField_15.setBackground(SystemColor.menu);
//		textField_15.setColumns(10);
//		textField_15.setBounds(251, 342, 121, 20);
//		contentPane.add(textField_15);
//		textField_15.setText("DISPONIBILIDAD");
//		textField_15.setEditable(false);
//		
//		textField_5 = new JTextField();
//		textField_5.setColumns(10);
//		textField_5.setBounds(251, 361, 121, 20);
//		contentPane.add(textField_5);
		
		//CodigoSala
		textField_16 = new JTextField();
		textField_16.setText("CODIGO SALA");
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBackground(SystemColor.menu);
		textField_16.setBounds(438, 66, 132, 20);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(438, 83, 132, 20);
		contentPane.add(textField_17);
	}
}
