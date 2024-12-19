package spaa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Reservar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reservar dialog = new Reservar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the dialog.
	 */
	public Reservar() {
		setBounds(100, 100, 823, 678);
		setTitle("Reservar");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel = new JPanel(new BorderLayout());
		setContentPane(contentPanel);
		JPanel panelGrid = new JPanel(new GridBagLayout());
		contentPanel.add(panelGrid, BorderLayout.NORTH);
		// Se crea la constraints que es obligatorio para luego poder situar cada
		// casilla del gridbaglayout
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0, 40, 0, 40);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbc.gridy = 0;// Primera fila de la primera columna
		JLabel etiq1 = new JLabel("Reserva un día en el spa");
		etiq1.setFont(new Font("Dubai", Font.BOLD, 30));
		panelGrid.add(etiq1,gbc);
		
		GridBagConstraints gbc2 = new GridBagConstraints();

		gbc2.insets = new Insets(0, 40, 5, 40);
		gbc2.anchor = GridBagConstraints.CENTER;
		gbc2.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbc2.gridy = 1;// Primera fila de la primera columna
		JLabel etiq2 = new JLabel("Ingresa tu información a continuación para reservar un día en el spa");
		panelGrid.add(etiq2,gbc2);
		
		UIManager.put("TextField.inactiveForeground", Color.LIGHT_GRAY);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		contentPanel.add(panelForm, BorderLayout.CENTER);
		// Se crea la constraints que es obligatorio para luego poder situar cada
		// casilla del gridbaglayout
		GridBagConstraints gbclblnom = new GridBagConstraints();

		gbclblnom.insets = new Insets(0, 40, 0, 40);
		gbclblnom.anchor = GridBagConstraints.CENTER;
		gbclblnom.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblnom.gridy = 0;// Primera fila de la primera columna
		JLabel etiqnom = new JLabel("Nombre completo");
		etiqnom.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqnom,gbclblnom);
		
		GridBagConstraints gbctxNom = new GridBagConstraints();

		gbctxNom.insets = new Insets(0, 40, 5, 40);
		gbctxNom.anchor = GridBagConstraints.CENTER;
		gbctxNom.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxNom.gridy = 1;// Primera fila de la primera columna
		JTextField txnom = new JTextField();
		String placeholder="Ingresa tu nombre completo";
		txnom.setText(placeholder);
		txnom.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txnom.getText().equals(placeholder)) {
					txnom.setText("");
					txnom.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txnom.getText().isEmpty()) {
					txnom.setText(placeholder);
					txnom.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txnom.setPreferredSize(new Dimension(300, 40)); // Tamaño específico
		panelForm.add(txnom,gbctxNom);
		
		GridBagConstraints gbclblemail = new GridBagConstraints();

		gbclblemail.insets = new Insets(10, 40, 0, 40);
		gbclblemail.anchor = GridBagConstraints.CENTER;
		gbclblemail.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblemail.gridy = 2;// Primera fila de la primera columna
		JLabel etiqemail = new JLabel("Correo electrónico");
		etiqemail.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqemail,gbclblemail);
		
		GridBagConstraints gbctxEmail = new GridBagConstraints();

		gbctxEmail.insets = new Insets(0, 40, 5, 40);
		gbctxEmail.anchor = GridBagConstraints.CENTER;
		gbctxEmail.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxEmail.gridy = 3;// Primera fila de la primera columna
		JTextField txEmail = new JTextField();
		String placeholderEmail="Ingresa tu correo electrónico";
		txEmail.setText(placeholderEmail);
		txEmail.setForeground(Color.GRAY);
		txEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txEmail.getText().equals(placeholderEmail)) {
					txEmail.setText("");
					txEmail.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txEmail.getText().isEmpty()) {
					txEmail.setText(placeholderEmail);
					txEmail.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txEmail.setPreferredSize(new Dimension(300, 40));
		panelForm.add(txEmail,gbctxEmail);
		
		GridBagConstraints gbclblnum = new GridBagConstraints();

		gbclblnum.insets = new Insets(10, 40, 0, 40);
		gbclblnum.anchor = GridBagConstraints.CENTER;
		gbclblnum.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblnum.gridy = 4;// Primera fila de la primera columna
		JLabel etiqnum = new JLabel("Número de teléfono");
		etiqnum.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqnum,gbclblnum);
		
		GridBagConstraints gbctxNum = new GridBagConstraints();

		gbctxNum.insets = new Insets(0, 40, 5, 40);
		gbctxNum.anchor = GridBagConstraints.CENTER;
		gbctxNum.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxNum.gridy = 5;// Primera fila de la primera columna
		JTextField txNum = new JTextField();
		String placeholderNum="Ingresa tu número de teléfono";
		txNum.setText(placeholderNum);
		txNum.setForeground(Color.GRAY);
		txNum.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txNum.getText().equals(placeholderNum)) {
					txNum.setText("");
					txNum.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txNum.getText().isEmpty()) {
					txNum.setText(placeholderNum);
					txNum.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txNum.setPreferredSize(new Dimension(300, 40));
		panelForm.add(txNum,gbctxNum);
		
		GridBagConstraints gbclblFech = new GridBagConstraints();

		gbclblFech.insets = new Insets(10, 40, 0, 40);
		gbclblFech.anchor = GridBagConstraints.CENTER;
		gbclblFech.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblFech.gridy = 6;// Primera fila de la primera columna
		JLabel etiqFech = new JLabel("Fecha preferida");
		etiqFech.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqFech,gbclblFech);
		
		GridBagConstraints gbctFech = new GridBagConstraints();

		gbctFech.insets = new Insets(0, 40, 5, 40);
		gbctFech.anchor = GridBagConstraints.CENTER;
		gbctFech.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctFech.gridy = 7;// Primera fila de la primera columna
		JTextField txFecha = new JTextField();
		String placeholderFecha="Ingresa la fecha en este formato aaaa/mm/dd";
		txFecha.setText(placeholderFecha);
		txFecha.setForeground(Color.GRAY);
		txFecha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txFecha.getText().equals(placeholderFecha)) {
					txFecha.setText("");
					txFecha.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txFecha.getText().isEmpty()) {
					txFecha.setText(placeholderFecha);
					txFecha.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txFecha.setPreferredSize(new Dimension(300, 40));
		panelForm.add(txFecha,gbctFech);
		
		GridBagConstraints gbclblHora = new GridBagConstraints();

		gbclblHora.insets = new Insets(10, 40, 0, 40);
		gbclblHora.anchor = GridBagConstraints.CENTER;
		gbclblHora.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblHora.gridy = 8;// Primera fila de la primera columna
		JLabel etiqHora = new JLabel("Hora preferida");
		etiqHora.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqHora,gbclblHora);
		
		GridBagConstraints gbctHora = new GridBagConstraints();

		gbctHora.insets = new Insets(0, 40, 5, 40);
		gbctHora.anchor = GridBagConstraints.CENTER;
		gbctHora.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctHora.gridy = 9;// Primera fila de la primera columna
		JTextField txHora = new JTextField();
		String placeholderHora="Ingresa la hora preferida en HH:MM:SS";
		txHora.setText(placeholderHora);
		txHora.setForeground(Color.GRAY);
		txHora.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txHora.getText().equals(placeholderHora)) {
					txHora.setText("");
					txHora.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txHora.getText().isEmpty()) {
					txHora.setText(placeholderHora);
					txHora.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txHora.setPreferredSize(new Dimension(300, 40));
		panelForm.add(txHora,gbctHora);
		
		GridBagConstraints gbclblInvit = new GridBagConstraints();

		gbclblInvit.insets = new Insets(10, 40, 0, 40);
		gbclblInvit.anchor = GridBagConstraints.CENTER;
		gbclblInvit.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbclblInvit.gridy = 10;// Primera fila de la primera columna
		JLabel etiqInvit = new JLabel("Número de invitados");
		etiqInvit.setFont(new Font("Dubai", Font.BOLD, 18));
		panelForm.add(etiqInvit,gbclblInvit);
		
		GridBagConstraints gbctInvit = new GridBagConstraints();

		gbctInvit.insets = new Insets(0, 40, 5, 40);
		gbctInvit.anchor = GridBagConstraints.CENTER;
		gbctInvit.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctInvit.gridy = 11;// Primera fila de la primera columna
		JTextField txInvit = new JTextField();
		String placeholderInvit="Ingresa el número de personas";
		txInvit.setText(placeholderInvit);
		txInvit.setForeground(Color.GRAY);
		txInvit.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(txInvit.getText().equals(placeholderInvit)) {
					txInvit.setText("");
					txInvit.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txInvit.getText().isEmpty()) {
					txInvit.setText(placeholderInvit);
					txInvit.setForeground(Color.GRAY);
				}
				
			}
			
		});
		txInvit.setPreferredSize(new Dimension(300, 40));
		panelForm.add(txInvit,gbctInvit);
		
		JPanel panelbtn = new JPanel(new GridBagLayout());
		contentPanel.add(panelbtn, BorderLayout.SOUTH);
		
		GridBagConstraints gbcbtnEnv = new GridBagConstraints();

		gbcbtnEnv.insets = new Insets(10, 10, 5, 10);
		gbcbtnEnv.anchor = GridBagConstraints.CENTER;
		gbcbtnEnv.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcbtnEnv.gridy = 0;// Primera fila de la primera columna
		gbcbtnEnv.fill = GridBagConstraints.BOTH;
		JButton btnEnv = new JButton("Enviar");
		btnEnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String nombre = txnom.getText();
	             String correo = txEmail.getText();
	             int num_telefono = Integer.parseInt(txNum.getText());
	             String fecha_cita = txFecha.getText();
	             String hora = txHora.getText();
	             int num_invitados = Integer.parseInt(txInvit.getText());
	             ClienteModel cliente = new ClienteModel(nombre, correo, num_telefono, fecha_cita, hora, num_invitados);
	             
	             Conexion conexion = new Conexion();
	                try {
						conexion.insertar(cliente);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	          
	                JOptionPane.showMessageDialog(null, "Operación completada con exito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	                dispose();
			}
		});
		panelbtn.add(btnEnv,gbcbtnEnv);
		
		GridBagConstraints gbcbtnCanc = new GridBagConstraints();

		gbcbtnCanc.insets = new Insets(10,10, 5,10);
		gbcbtnCanc.anchor = GridBagConstraints.CENTER;
		gbcbtnCanc.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcbtnCanc.gridy = 0;// Primera fila de la primera columna
		gbcbtnCanc.fill = GridBagConstraints.BOTH;
		JButton btnCanc = new JButton("Cancelar");
		btnCanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txnom.setText("");
	             txEmail.setText("");
	             txNum.setText("");
	             txFecha.setText("");
	             txHora.setText("");
	             txInvit.setText("");
			}
		});
		panelbtn.add(btnCanc,gbcbtnCanc);


		
	}
}
