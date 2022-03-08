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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaInicio extends JFrame {

	private JTextField txtBienvenidosAlHospital;
	private JTextField txtSeleccionaUnaDe;
	private JTextField txtSeleccionaSegunLo;
	private JTextField txtTodoDatoDe;
	private JTextField txtTodoDatoDe_1;
	private JTextField txtTodoDatoDe_2;
	private JTextField txtTodoDatoDe_3;
	private JTextField txtBuenosDiasComo;
	private JTextField txtUtiliceEsteBoton;
	private JTextField txtEnCasoDe;
	private JTextField txtSiCambioDe;
	private JTextField textField;
	private JTextField txtEstadoCantidadY;
	private JTextField txtEstadoCantidadY_1;
	private JTextField txtId;
	private JTextField txtEstadoIncapacidadY;
	private JTextField txtBuenasSiEstas;
	public  Hospital a ;
	private JTextField txtCCPaciente;
	private JTextField txtCCVisitante;
	private JButton btnBuscar;
	private JTextField txtParaVerLas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public VentanaInicio() {

		setAlwaysOnTop(false);
		setResizable(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param a2 
	 */
	private void initialize() {

		getContentPane().setForeground(SystemColor.desktop);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 789, 361);
		getContentPane().add(tabbedPane);

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

		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.getHospital().guardarFicheros();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExistePersonal e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnNewButton.setBounds(314, 260, 89, 23);
		panel.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Pacientes", null, panel_2, null);
		panel_2.setLayout(null);

		txtBuenosDiasComo = new JTextField();
		txtBuenosDiasComo.setEditable(false);
		txtBuenosDiasComo.setBackground(SystemColor.menu);
		txtBuenosDiasComo.setBorder(null);
		txtBuenosDiasComo.setText("Buenos dias, como podemos servirle");
		txtBuenosDiasComo.setBounds(10, 11, 764, 20);
		panel_2.add(txtBuenosDiasComo);
		txtBuenosDiasComo.setColumns(10);

		JButton btnAgendarCita = new JButton("Agendar Cita");
		btnAgendarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPacientesAgendar a = new VentanaPacientesAgendar();
				a.setVisible(true);
				dispose();

			}
		});
		btnAgendarCita.setBounds(10, 42, 123, 23);
		panel_2.add(btnAgendarCita);

		JButton btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPacientesCancelar a = new VentanaPacientesCancelar();
				a.setVisible(true);
				dispose();
			}
		});
		btnCancelarCita.setBounds(10, 287, 123, 23);
		panel_2.add(btnCancelarCita);



		JButton btnModificarCita = new JButton("Modificar Cita");
		btnModificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPacientesModificar a = new VentanaPacientesModificar();
				a.setVisible(true);
				dispose();
			}
		});
		btnModificarCita.setBounds(10, 166, 123, 23);
		panel_2.add(btnModificarCita);

		txtUtiliceEsteBoton = new JTextField();
		txtUtiliceEsteBoton.setEditable(false);
		txtUtiliceEsteBoton.setBorder(null);
		txtUtiliceEsteBoton.setBackground(SystemColor.menu);
		txtUtiliceEsteBoton.setText("Utilice este boton para agendar una cita si necesita de ayuda.");
		txtUtiliceEsteBoton.setBounds(143, 43, 631, 20);
		panel_2.add(txtUtiliceEsteBoton);
		txtUtiliceEsteBoton.setColumns(10);

		txtEnCasoDe = new JTextField();
		txtEnCasoDe.setEditable(false);
		txtEnCasoDe.setBorder(null);
		txtEnCasoDe.setBackground(SystemColor.menu);
		txtEnCasoDe.setText("En caso de que necesite cambiar o modificar una cita utilice este boton.");
		txtEnCasoDe.setColumns(10);
		txtEnCasoDe.setBounds(143, 169, 631, 20);
		panel_2.add(txtEnCasoDe);

		txtSiCambioDe = new JTextField();
		txtSiCambioDe.setEditable(false);
		txtSiCambioDe.setBorder(null);
		txtSiCambioDe.setBackground(SystemColor.menu);
		txtSiCambioDe.setText(
				"Si cambio de opinion o no cree necesario tener una cita puede cancelarla utilizando este boton.");
		txtSiCambioDe.setColumns(10);
		txtSiCambioDe.setBounds(143, 288, 631, 20);
		panel_2.add(txtSiCambioDe);
		
		JButton btnNewButton_1 = new JButton("Ver Citas");
		btnNewButton_1.setBounds(10, 97, 123, 20);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerCitasPaciente window = new VerCitasPaciente();
				window.setVisible(true);
				dispose();

			}
		});
		
		txtParaVerLas = new JTextField();
		txtParaVerLas.setText("Para ver las citas de un paciente");
		txtParaVerLas.setEditable(false);
		txtParaVerLas.setBounds(143, 97, 358, 21);
		panel_2.add(txtParaVerLas);
		txtParaVerLas.setColumns(10);

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

				VentanaPersonalMedicos medico = new VentanaPersonalMedicos();
				medico.setVisible(true);
				dispose();
			}
		});
		btnMedicos.setBounds(20, 42, 89, 23);
		panel_1.add(btnMedicos);

		JButton btnEnfermeros = new JButton("Enfermeros");
		btnEnfermeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaPersonalEnfermeros window = new VentanaPersonalEnfermeros();
				window.setVisible(true);
				dispose();

			}
		});
		btnEnfermeros.setBounds(20, 126, 116, 23);
		panel_1.add(btnEnfermeros);

		JButton btnLimpieza = new JButton("Limpieza");
		btnLimpieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaPersonalLimpieza window = new VentanaPersonalLimpieza();
				window.setVisible(true);
				dispose();
			}
		});
		btnLimpieza.setBounds(20, 213, 89, 23);
		panel_1.add(btnLimpieza);

		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaPersonalPacientes window = new VentanaPersonalPacientes();
				window.setVisible(true);
				dispose();
			}
		});
		btnPacientes.setBounds(20, 299, 99, 23);
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
		txtTodoDatoDe_1.setBounds(146, 127, 166, 20);
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
		txtTodoDatoDe_3.setBounds(129, 300, 152, 20);
		panel_1.add(txtTodoDatoDe_3);
		txtTodoDatoDe_3.setColumns(10);
		
		JButton btnA1 = new JButton("Agregar");
		btnA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarMedico window = new VentanaAgregarMedico();
				window.setVisible(true);
				dispose();
				
			}
		});
		btnA1.setBounds(325, 42, 89, 23);
		panel_1.add(btnA1);
		
		JButton btnA2 = new JButton("Agregar");
		btnA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarEnfermero window = new VentanaAgregarEnfermero();
				window.setVisible(true);
				dispose();
			}
		});
		btnA2.setBounds(325, 126, 89, 23);
		panel_1.add(btnA2);
		
		JButton btnA3 = new JButton("Agregar");
		btnA3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarLimpieza window = new VentanaAgregarLimpieza();
				window.setVisible(true);
				dispose();
			}
		});
		btnA3.setBounds(325, 215, 89, 23);
		panel_1.add(btnA3);
		
		JButton btnA4 = new JButton("Agregar");
		btnA4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregarPaciente window = new VentanaAgregarPaciente();
				window.setVisible(true);
				dispose();
			}
		});
		btnA4.setBounds(325, 299, 89, 23);
		panel_1.add(btnA4);
		
		JButton btnM1 = new JButton("Modificar");
		btnM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificarMedico window = new VentanaModificarMedico();
				window.setVisible(true);
				dispose();
			}
		});
		btnM1.setBounds(463, 42, 99, 23);
		panel_1.add(btnM1);
		
		JButton btnM2 = new JButton("Modificar");
		btnM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificarEnfermero window = new VentanaModificarEnfermero();
				window.setVisible(true);
				dispose();
			}
		});
		btnM2.setBounds(463, 126, 99, 23);
		panel_1.add(btnM2);
		
		JButton btnM3 = new JButton("Modificar");
		btnM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificarLimpieza window = new VentanaModificarLimpieza();
				window.setVisible(true);
				dispose();
			}
		});
		btnM3.setBounds(463, 215, 99, 23);
		panel_1.add(btnM3);
		
		JButton btnM4 = new JButton("Modificar");
		btnM4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaModificarPaciente window = new VentanaModificarPaciente();
				window.setVisible(true);
				dispose();
			}
		});
		btnM4.setBounds(463, 299, 99, 23);
		panel_1.add(btnM4);
		
		JButton btnNewButton_2 = new JButton("Ver citas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerCitasMedico window = new VerCitasMedico();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(598, 42, 99, 20);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ingresar formula a cita medica");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSetFormula window = new VentanaSetFormula();
				window.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(324, 77, 238, 27);
		panel_1.add(btnNewButton_3);

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
		btnEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInventarioEquipos a = new VentanaInventarioEquipos();
				a.setVisible(true);
				dispose();
			}
		});
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
		btnSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInventarioSalas a = new VentanaInventarioSalas();
				a.setVisible(true);
				dispose();
			}
		});
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
		btnFormula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInventarioFormula a = new VentanaInventarioFormula();
				a.setVisible(true);
				dispose();
			}
		});
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
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInventarioHistorial a = new VentanaInventarioHistorial();
				a.setVisible(true);
				dispose();
			}
		});
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
		txtBuenasSiEstas.setEditable(false);
		txtBuenasSiEstas.setBorder(null);
		txtBuenasSiEstas.setBackground(SystemColor.menu);
		txtBuenasSiEstas.setText("Buenas, si estas buscando a algun paciente porfavor ingresa los siguientes datos.");
		txtBuenasSiEstas.setBounds(10, 11, 491, 20);
		panel_4.add(txtBuenasSiEstas);
		txtBuenasSiEstas.setColumns(10);
		
		JLabel lblCcPaciente = new JLabel("CC Paciente");
		lblCcPaciente.setBounds(20, 47, 103, 20);
		panel_4.add(lblCcPaciente);
		
		txtCCPaciente = new JTextField();
		txtCCPaciente.setBounds(146, 44, 166, 26);
		panel_4.add(txtCCPaciente);
		txtCCPaciente.setColumns(10);
		
		JLabel lblCcVisitante = new JLabel("CC Visitante");
		lblCcVisitante.setBounds(20, 83, 103, 20);
		panel_4.add(lblCcVisitante);
		
		txtCCVisitante = new JTextField();
		txtCCVisitante.setColumns(10);
		txtCCVisitante.setBounds(146, 86, 166, 26);
		panel_4.add(txtCCVisitante);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar = new JButton("Agregar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccPaciente = txtCCPaciente.getText();
				String ccVisitante = txtCCVisitante.getText();
				Paciente p = Main.hp.getPaciente(ccPaciente);
				if(p == null) {
					JOptionPane.showMessageDialog(null, "No existe el paciente");
				}else {
					try {
						String[] acompanantes = p.getAcompanantes();
						int x = 0;
						if(ccVisitante != null && ccVisitante.equals("") == false) {
							while(x < acompanantes.length && acompanantes[x].equals(ccVisitante) == false) {
								x++;
							}
							if(x < acompanantes.length) {
								JOptionPane.showMessageDialog(null, "El documento ya esta registrado");
							}else {
								Main.hp.ingresoVisitantePaciente(ccPaciente, ccVisitante);
								JOptionPane.showMessageDialog(null, "Visitante con la cc: " + ccVisitante + " ha sido admitido");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Ingrese un documento del visitante");
						}
					}catch(CampoLleno e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnBuscar.setBounds(363, 85, 115, 29);
		btnBuscar.setBounds(362, 43, 115, 29);
		panel_4.add(btnBuscar);
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ccPaciente = txtCCPaciente.getText();
				String ccVisitante = txtCCVisitante.getText();
				Paciente p = Main.hp.getPaciente(ccPaciente);
				if(p == null) {
					JOptionPane.showMessageDialog(null, "No existe el paciente");
				}else {
					if(ccVisitante != null && ccVisitante.equals("") == false) {
						try {
							Main.hp.salidaVisitantePaciente(ccPaciente, ccVisitante);
							JOptionPane.showMessageDialog(null, "El visitante ha salido con exito");
						} catch (NoAcompanantesPaciente e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnEliminar.setBounds(362, 85, 115, 29);
		panel_4.add(btnEliminar);
		setBounds(100, 100, 805, 400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSetFormula window = new VentanaSetFormula();
				window.setVisible(true);
				dispose();
			}
		});

	}
}