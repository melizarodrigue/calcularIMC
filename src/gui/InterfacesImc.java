package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Logica;
import Clases.PersonaVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class InterfacesImc extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtTalla;
	JButton btnRegistrar,btnConsultar, btnPromedio;
	JTextArea txtArea;

	Logica miLogica;

	public InterfacesImc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 565);
		miLogica= new Logica();
		IniciarComponentes();
	}
		
	public void IniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Datos Basicos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo.setBounds(33, 69, 108, 16);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("CALCULAR IMC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(261, 23, 146, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDoc = new JLabel("Documento:");
		lblDoc.setBounds(33, 101, 95, 16);
		contentPane.add(lblDoc);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(112, 96, 130, 26);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setBounds(261, 101, 95, 16);
		contentPane.add(lblNom);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(320, 96, 236, 26);
		contentPane.add(txtNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(569, 101, 42, 16);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(610, 96, 95, 26);
		contentPane.add(txtEdad);
		
		JLabel lblTitulo2 = new JLabel("Datos IMC");
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo2.setBounds(33, 143, 108, 16);
		contentPane.add(lblTitulo2);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(33, 176, 95, 16);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(112, 171, 130, 26);
		contentPane.add(txtPeso);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(261, 176, 95, 16);
		contentPane.add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(320, 171, 130, 26);
		contentPane.add(txtTalla);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResultado.setBounds(33, 228, 95, 16);
		contentPane.add(lblResultado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(199, 484, 117, 29);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnConsultar = new JButton("Consultar Lista");
		btnConsultar.setBounds(328, 484, 167, 29);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		
		
		btnPromedio = new JButton("Consultar Promedio IMC");
		btnPromedio.setBounds(507, 484, 184, 29);
		btnPromedio.addActionListener(this);
		contentPane.add(btnPromedio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 255, 648, 198);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setLineWrap(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnRegistrar == e.getSource()) {
			PersonaVO miPersona = new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			
			
			String res = miLogica.RegistarPersona(miPersona);
			txtArea.setText(res);
		}
		if (btnConsultar == e.getSource()) {
			String res = miLogica.consultarListaPersona();
			txtArea.setText(res);
		}
		
		if (btnPromedio == e.getSource()) {
			String res = miLogica.consultarPromedio();
			txtArea.setText(res);
		}
	}
}