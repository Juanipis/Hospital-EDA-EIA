package hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaInicio {

	private JFrame frame;
	private JTextField txtBienvenidosAlHospital;
	private JTextField txtSeleccionaUnaDe;
	private JTextField txtSeleccionaSegunLo;
	private JTextField txtTodoDatoDe;
	private JTextField txtTodoDatoDe_1;
	private JTextField txtTodoDatoDe_2;
	private JTextField txtTodoDatoDe_3;
	private JTextField txtBuenosDiasComo;
	private JTextField txtUtiliceEsteBoton;
	private JTextField txtUtiliceEsteBoton_1;
	private JTextField txtEnCasoDe;
	private JTextField txtSiPerdioUna;
	private JTextField txtSiCambioDe;
	private JTextField textField;
	private JTextField txtEstadoCantidadY;
	private JTextField txtEstadoCantidadY_1;
	private JTextField txtId;
	private JTextField txtEstadoIncapacidadY;
	private JTextField txtBuenasSiEstas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio ventanaInicio = new VentanaInicio();
					ventanaInicio.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 789, 361);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Inicio", null, panel, null);
		panel.setLayout(null);
		
		txtBienvenidosAlHospital = new JTextField();
		txtBienvenidosAlHospital.setEditable(false);
		txtBienvenidosAlHospital.setBackground(SystemColor.menu);
		txtBienvenidosAlHospital.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenidosAlHospital.setFont(new Font("Sitka Text", Font.BOLD, 35));
		txtBienvenidosAlHospital.setBorder(null);
		txtBienvenidosAlHospital.setText("Bienvenidos al hospital virtual");
		txtBienvenidosAlHospital.setBounds(10, 11, 764, 49);
		panel.add(txtBienvenidosAlHospital);
		txtBienvenidosAlHospital.setColumns(10);
		
		txtSeleccionaUnaDe = new JTextField();
		txtSeleccionaUnaDe.setEditable(false);
		txtSeleccionaUnaDe.setBackground(SystemColor.menu);
		txtSeleccionaUnaDe.setBorder(null);
		txtSeleccionaUnaDe.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtSeleccionaUnaDe.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeleccionaUnaDe.setText("Selecciona una de las siguientes opciones acuerdo a tu necesidad.");
		txtSeleccionaUnaDe.setBounds(173, 71, 434, 20);
		panel.add(txtSeleccionaUnaDe);
		txtSeleccionaUnaDe.setColumns(10);
		
		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(tabbedPane).setSelectedIndex(1);
			}
		});
		
		btnPaciente.setBounds(92, 141, 142, 62);
		panel.add(btnPaciente);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(tabbedPane).setSelectedIndex(2);
			}
		});
		btnPersonal.setBounds(244, 141, 142, 62);
		panel.add(btnPersonal);
		
		JButton btnInventario = new JButton("Inventario");
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(tabbedPane).setSelectedIndex(3);
			}
		});
		btnInventario.setBounds(395, 141, 142, 62);
		panel.add(btnInventario);
		
		JButton btnVisitas = new JButton("Visitas");
		btnVisitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(tabbedPane).setSelectedIndex(4);
			}
		});
		btnVisitas.setBounds(547, 141, 142, 62);
		panel.add(btnVisitas);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pacientes", null, panel_2, null);
		panel_2.setLayout(null);
		
		txtBuenosDiasComo = new JTextField();
		txtBuenosDiasComo.setBackground(SystemColor.menu);
		txtBuenosDiasComo.setBorder(null);
		txtBuenosDiasComo.setText("Buenos dias, como podemos servirle");
		txtBuenosDiasComo.setBounds(10, 11, 764, 20);
		panel_2.add(txtBuenosDiasComo);
		txtBuenosDiasComo.setColumns(10);
		
		JButton btnAgendarCita = new JButton("Agendar Cita");
		btnAgendarCita.setBounds(10, 42, 123, 23);
		panel_2.add(btnAgendarCita);
		
		JButton btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.setBounds(10, 287, 123, 23);
		panel_2.add(btnCancelarCita);
		
		JButton btnRecuperarCita = new JButton("Recuperar Cita");
		btnRecuperarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecuperarCita.setBounds(10, 229, 123, 23);
		panel_2.add(btnRecuperarCita);
		
		JButton btnGenerarCita = new JButton("Generar Cita");
		btnGenerarCita.setBounds(10, 103, 123, 23);
		panel_2.add(btnGenerarCita);
		
		JButton btnModificarCita = new JButton("Modificar Cita");
		btnModificarCita.setBounds(10, 166, 123, 23);
		panel_2.add(btnModificarCita);
		
		txtUtiliceEsteBoton = new JTextField();
		txtUtiliceEsteBoton.setBorder(null);
		txtUtiliceEsteBoton.setBackground(SystemColor.menu);
		txtUtiliceEsteBoton.setText("Utilice este boton para agendar una cita si necesita de ayuda.");
		txtUtiliceEsteBoton.setBounds(143, 43, 631, 20);
		panel_2.add(txtUtiliceEsteBoton);
		txtUtiliceEsteBoton.setColumns(10);
		
		txtUtiliceEsteBoton_1 = new JTextField();
		txtUtiliceEsteBoton_1.setBorder(null);
		txtUtiliceEsteBoton_1.setBackground(SystemColor.menu);
		txtUtiliceEsteBoton_1.setText("Utilice este boton si necesita generar una cita.");
		txtUtiliceEsteBoton_1.setColumns(10);
		txtUtiliceEsteBoton_1.setBounds(143, 104, 631, 20);
		panel_2.add(txtUtiliceEsteBoton_1);
		
		txtEnCasoDe = new JTextField();
		txtEnCasoDe.setBorder(null);
		txtEnCasoDe.setBackground(SystemColor.menu);
		txtEnCasoDe.setText("En caso de que necesite cambiar o modificar una cita utilice este boton.");
		txtEnCasoDe.setColumns(10);
		txtEnCasoDe.setBounds(143, 169, 631, 20);
		panel_2.add(txtEnCasoDe);
		
		txtSiPerdioUna = new JTextField();
		txtSiPerdioUna.setBorder(null);
		txtSiPerdioUna.setBackground(SystemColor.menu);
		txtSiPerdioUna.setText("Si perdio una cita y necesita recuperarla y saber las especificaciones utilice este boton.");
		txtSiPerdioUna.setColumns(10);
		txtSiPerdioUna.setBounds(143, 230, 631, 20);
		panel_2.add(txtSiPerdioUna);
		
		txtSiCambioDe = new JTextField();
		txtSiCambioDe.setBorder(null);
		txtSiCambioDe.setBackground(SystemColor.menu);
		txtSiCambioDe.setText("Si cambio de opinion o no cree necesario tener una cita puede cancelarla utilizando este boton.");
		txtSiCambioDe.setColumns(10);
		txtSiCambioDe.setBounds(143, 288, 631, 20);
		panel_2.add(txtSiCambioDe);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personal", null, panel_1, null);
		panel_1.setLayout(null);
		
		txtSeleccionaSegunLo = new JTextField();
		txtSeleccionaSegunLo.setBackground(SystemColor.menu);
		txtSeleccionaSegunLo.setBorder(null);
		txtSeleccionaSegunLo.setEditable(false);
		txtSeleccionaSegunLo.setText("Selecciona segun lo que buscas");
		txtSeleccionaSegunLo.setBounds(10, 11, 305, 20);
		panel_1.add(txtSeleccionaSegunLo);
		txtSeleccionaSegunLo.setColumns(10);
		
		JButton btnMedicos = new JButton("Medicos");
		btnMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacionMedicos window = new InformacionMedicos();
				window.medicosFrame.setVisible(true);
				frame.dispose();
			}
		});
		btnMedicos.setBounds(20, 42, 89, 23);
		panel_1.add(btnMedicos);
		
		JButton btnEnfermeros = new JButton("Enfermeros");
		btnEnfermeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnfermeros.setBounds(20, 126, 89, 23);
		panel_1.add(btnEnfermeros);
		
		JButton btnLimpieza = new JButton("Limpieza");
		btnLimpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpieza.setBounds(20, 213, 89, 23);
		panel_1.add(btnLimpieza);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBounds(20, 299, 89, 23);
		panel_1.add(btnPacientes);
		
		txtTodoDatoDe = new JTextField();
		txtTodoDatoDe.setBackground(SystemColor.menu);
		txtTodoDatoDe.setBorder(null);
		txtTodoDatoDe.setEditable(false);
		txtTodoDatoDe.setText("Todo dato de los medicos");
		txtTodoDatoDe.setBounds(119, 43, 152, 20);
		panel_1.add(txtTodoDatoDe);
		txtTodoDatoDe.setColumns(10);
		
		txtTodoDatoDe_1 = new JTextField();
		txtTodoDatoDe_1.setBorder(null);
		txtTodoDatoDe_1.setBackground(SystemColor.menu);
		txtTodoDatoDe_1.setEditable(false);
		txtTodoDatoDe_1.setText("Todo dato de los enfermeros");
		txtTodoDatoDe_1.setBounds(119, 127, 196, 20);
		panel_1.add(txtTodoDatoDe_1);
		txtTodoDatoDe_1.setColumns(10);
		
		txtTodoDatoDe_2 = new JTextField();
		txtTodoDatoDe_2.setBackground(SystemColor.menu);
		txtTodoDatoDe_2.setBorder(null);
		txtTodoDatoDe_2.setEditable(false);
		txtTodoDatoDe_2.setText("Todo dato de los conserjes");
		txtTodoDatoDe_2.setBounds(119, 214, 152, 20);
		panel_1.add(txtTodoDatoDe_2);
		txtTodoDatoDe_2.setColumns(10);
		
		txtTodoDatoDe_3 = new JTextField();
		txtTodoDatoDe_3.setBorder(null);
		txtTodoDatoDe_3.setBackground(SystemColor.menu);
		txtTodoDatoDe_3.setEditable(false);
		txtTodoDatoDe_3.setText("Todo dato de los pacientes");
		txtTodoDatoDe_3.setBounds(119, 300, 152, 20);
		panel_1.add(txtTodoDatoDe_3);
		txtTodoDatoDe_3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Inventario", null, panel_3, null);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Selecciona segun lo que buscas");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(10, 11, 305, 20);
		panel_3.add(textField);
		
		JButton btnEquipos = new JButton("Equipos");
		btnEquipos.setBounds(20, 42, 89, 23);
		panel_3.add(btnEquipos);
		
		txtEstadoCantidadY = new JTextField();
		txtEstadoCantidadY.setText("Estado, cantidad y todo otro dato acerca de los equipos del hospital.");
		txtEstadoCantidadY.setEditable(false);
		txtEstadoCantidadY.setColumns(10);
		txtEstadoCantidadY.setBorder(null);
		txtEstadoCantidadY.setBackground(SystemColor.menu);
		txtEstadoCantidadY.setBounds(119, 43, 597, 20);
		panel_3.add(txtEstadoCantidadY);
		
		JButton btnSalas = new JButton("Salas");
		btnSalas.setBounds(20, 126, 89, 23);
		panel_3.add(btnSalas);
		
		txtEstadoCantidadY_1 = new JTextField();
		txtEstadoCantidadY_1.setText("Estado, cantidad y todo otro dato acerca de las salas del hospital.");
		txtEstadoCantidadY_1.setEditable(false);
		txtEstadoCantidadY_1.setColumns(10);
		txtEstadoCantidadY_1.setBorder(null);
		txtEstadoCantidadY_1.setBackground(SystemColor.menu);
		txtEstadoCantidadY_1.setBounds(119, 127, 452, 20);
		panel_3.add(txtEstadoCantidadY_1);
		
		JButton btnFormula = new JButton("Formula");
		btnFormula.setBounds(20, 213, 89, 23);
		panel_3.add(btnFormula);
		
		txtId = new JTextField();
		txtId.setText("Id, medicamentos y otros datos sobre las formulas del hospital.");
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBorder(null);
		txtId.setBackground(SystemColor.menu);
		txtId.setBounds(119, 214, 398, 20);
		panel_3.add(txtId);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setBounds(20, 299, 89, 23);
		panel_3.add(btnHistorial);
		
		txtEstadoIncapacidadY = new JTextField();
		txtEstadoIncapacidadY.setText("Estado, incapacidad y todo dato acerca de los pacientes dentro del hospital.");
		txtEstadoIncapacidadY.setEditable(false);
		txtEstadoIncapacidadY.setColumns(10);
		txtEstadoIncapacidadY.setBorder(null);
		txtEstadoIncapacidadY.setBackground(SystemColor.menu);
		txtEstadoIncapacidadY.setBounds(119, 300, 389, 20);
		panel_3.add(txtEstadoIncapacidadY);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Visitas", null, panel_4, null);
		panel_4.setLayout(null);
		
		txtBuenasSiEstas = new JTextField();
		txtBuenasSiEstas.setBorder(null);
		txtBuenasSiEstas.setBackground(SystemColor.menu);
		txtBuenasSiEstas.setText("Buenas, si estas buscando a algun paciente porfavor ingresa los siguientes datos.");
		txtBuenasSiEstas.setBounds(10, 11, 491, 20);
		panel_4.add(txtBuenasSiEstas);
		txtBuenasSiEstas.setColumns(10);
		frame.setBounds(100, 100, 805, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}