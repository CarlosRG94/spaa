package spaa;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class PrincipalSpa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalSpa frame = new PrincipalSpa();
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
	public PrincipalSpa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 759);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Panel del menú (izquierda)
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(150, 0));

		// Botones del menú
		JButton botonInicio = createCustomButton("Inicio");
		JButton botonProm = createCustomButton("Promociones");
		JButton botonExp = createCustomButton("Experiencias");
		JButton botonReser = createCustomButton("Reservar");
		JButton botonContact = createCustomButton("Contacto");

		panel.add(Box.createVerticalStrut(10)); // margen entre botones
		panel.add(botonInicio);
		panel.add(Box.createVerticalStrut(10)); // margen entre botones
		panel.add(botonProm);
		panel.add(Box.createVerticalStrut(10));
		panel.add(botonExp);
		panel.add(Box.createVerticalStrut(10));
		panel.add(botonReser);
		panel.add(Box.createVerticalStrut(10));
		panel.add(botonContact);

		// Panel principal (Centro) con CardLayout
		JPanel panelPrincipal = new JPanel(new CardLayout());
		contentPane.add(panelPrincipal, BorderLayout.CENTER);

		// Panel inicial (contenido original)
		JPanel panelInicio = new JPanel();
		panelInicio.setLayout(new BorderLayout());
		panelInicio.setBackground(new Color(128, 255, 255));

		// Etiqueta de bienvenida (Norte)
		JLabel etiquetaBienvenida = new JLabel("       Bienvenido a SpaStar");
		etiquetaBienvenida.setBackground(Color.WHITE);
		etiquetaBienvenida.setVerticalAlignment(SwingConstants.BOTTOM);
		etiquetaBienvenida.setOpaque(true);
		etiquetaBienvenida.setFont(new Font("Dubai", Font.BOLD, 40));
		etiquetaBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(etiquetaBienvenida, BorderLayout.NORTH);

		// Imagen escalada
		ImageIcon originalIcon = new ImageIcon("src/imagenes/oasis_termal.jpg");
		Image scaledImage = originalIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);

		JLabel lblNewLabel = new JLabel(new ImageIcon(scaledImage));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panelInicio.add(lblNewLabel, BorderLayout.CENTER);

		// Texto debajo de la imagen
		JLabel etiquetaInferior = new JLabel(
				"Tu destino único para promociones increíbles y experiencias inolvidables");
		etiquetaInferior.setBackground(Color.WHITE);
		etiquetaInferior.setOpaque(true);
		etiquetaInferior.setVerticalAlignment(SwingConstants.TOP);
		etiquetaInferior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaInferior.setHorizontalAlignment(SwingConstants.CENTER);
		panelInicio.add(etiquetaInferior, BorderLayout.SOUTH);

		// Panel para "Promociones"
		JPanel panelPromoPrinc = new JPanel();
		panelPromoPrinc.setLayout(new BorderLayout());
		JLabel bienPromo = new JLabel("NUESTRAS PROMOCIONES");
		bienPromo.setFont(new Font("Dubai", Font.BOLD, 40));
		bienPromo.setHorizontalAlignment(SwingConstants.CENTER);
		bienPromo.setVerticalAlignment(SwingConstants.BOTTOM);
		panelPromoPrinc.add(bienPromo, BorderLayout.NORTH);

		// Panel para "Promociones"
		JPanel panelPromociones = new JPanel();
		panelPromoPrinc.add(panelPromociones, BorderLayout.CENTER);
		panelPromociones.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbc.insets = new Insets(5, 20, 5, 20);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;// Comenzamos con la columna izquierda posicion 0 del eje x
		gbc.gridy = 0;// Primera fila de la primera columna

		JLabel lblPrimerImg = new JLabel();
		lblPrimerImg.setIcon(new ImageIcon("src/imagenes/masaje.png"));
		panelPromociones.add(lblPrimerImg, gbc);

		GridBagConstraints gbcEtiq1 = new GridBagConstraints();
		gbcEtiq1.insets = new Insets(5, 20, 5, 20);
		gbcEtiq1.anchor = GridBagConstraints.CENTER;
		gbcEtiq1.gridx = 0;
		gbcEtiq1.gridy = 1;// Segunda fila de la primera columna
		JLabel etiq1 = new JLabel("Primera Promoción");
		etiq1.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(etiq1, gbcEtiq1);

		GridBagConstraints gbcDescr1 = new GridBagConstraints();
		gbcDescr1.insets = new Insets(5, 20, 5, 20);
		gbcDescr1.anchor = GridBagConstraints.CENTER;
		gbcDescr1.gridx = 0;
		gbcDescr1.gridy = 2;// Segunda fila de la primera columna
		JLabel descr1 = new JLabel("Oferta de spa + masaje durante 45 minutos en Málaga centro");
		descr1.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		panelPromociones.add(descr1, gbcDescr1);

		GridBagConstraints gbcPrec1 = new GridBagConstraints();
		gbcPrec1.insets = new Insets(5, 20, 5, 20);
		gbcPrec1.anchor = GridBagConstraints.CENTER;
		gbcPrec1.gridx = 0;
		gbcPrec1.gridy = 3;// Segunda fila de la primera columna
		JLabel prec1 = new JLabel("40€");
		prec1.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(prec1, gbcPrec1);

		GridBagConstraints gbcBtn = new GridBagConstraints();
		gbcBtn.insets = new Insets(3, 20, 3, 20);
		gbcBtn.anchor = GridBagConstraints.CENTER;
		gbcBtn.gridx = 0;
		gbcBtn.gridy = 4;// Segunda fila de la primera columna
		JButton btn1 = new JButton("Reservar");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservar In = new Reservar();
				In.setVisible(true);
			}
		});
		panelPromociones.add(btn1, gbcBtn);

		GridBagConstraints gbcimg2 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbcimg2.insets = new Insets(5, 20, 5, 20);
		gbcimg2.anchor = GridBagConstraints.CENTER;
		gbcimg2.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x

		gbcimg2.gridy = 0;// Primera fila de la primera columna

		JLabel lblImg2 = new JLabel();
		lblImg2.setIcon(new ImageIcon("src/imagenes/spapeque.jpg"));
		panelPromociones.add(lblImg2, gbcimg2);

		GridBagConstraints gbcEtiq2 = new GridBagConstraints();
		gbcEtiq2.insets = new Insets(5, 20, 5, 20);
		gbcEtiq2.anchor = GridBagConstraints.CENTER;
		gbcEtiq2.gridx = 1;
		gbcEtiq2.gridy = 1;// Segunda fila de la primera columna
		JLabel etiq2 = new JLabel("Segunda Promoción");
		etiq2.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(etiq2, gbcEtiq2);

		GridBagConstraints gbcDescr2 = new GridBagConstraints();
		gbcDescr2.insets = new Insets(5, 20, 5, 20);
		gbcDescr2.anchor = GridBagConstraints.CENTER;
		gbcDescr2.gridx = 1;
		gbcDescr2.gridy = 2;// Segunda fila de la primera columna
		JLabel descr2 = new JLabel("Oferta de spa durante 30 minutos en una sala de luces, para una mejor experiencia");
		descr2.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		panelPromociones.add(descr2, gbcDescr2);

		GridBagConstraints gbcPrec2 = new GridBagConstraints();
		gbcPrec2.insets = new Insets(5, 20, 5, 20);
		gbcPrec2.anchor = GridBagConstraints.CENTER;
		gbcPrec2.gridx = 1;
		gbcPrec2.gridy = 3;// Segunda fila de la primera columna
		JLabel prec2 = new JLabel("30€");
		prec2.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(prec2, gbcPrec2);

		GridBagConstraints gbcBtn2 = new GridBagConstraints();
		gbcBtn2.insets = new Insets(3, 20, 3, 20);
		gbcBtn2.anchor = GridBagConstraints.CENTER;
		gbcBtn2.gridx = 1;
		gbcBtn2.gridy = 4;// Segunda fila de la primera columna
		JButton btn2 = new JButton("Reservar");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservar In = new Reservar();
				In.setVisible(true);
			}
		});
		panelPromociones.add(btn2, gbcBtn2);

		GridBagConstraints gbcimg3 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbcimg3.insets = new Insets(5, 20, 5, 20);
		gbcimg3.anchor = GridBagConstraints.CENTER;
		gbcimg3.gridx = 2; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcimg3.gridy = 0;// Primera fila de la primera columna

		JLabel lblImg3 = new JLabel();
		lblImg3.setIcon(new ImageIcon("src/imagenes/velas.jpg"));
		panelPromociones.add(lblImg3, gbcimg3);

		GridBagConstraints gbcEtiq3 = new GridBagConstraints();
		gbcEtiq3.insets = new Insets(5, 20, 5, 20);
		gbcEtiq3.anchor = GridBagConstraints.CENTER;
		gbcEtiq3.gridx = 2;
		gbcEtiq3.gridy = 1;// Segunda fila de la primera columna
		JLabel etiq3 = new JLabel("Tercera Promoción");
		etiq3.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(etiq3, gbcEtiq3);

		GridBagConstraints gbcDescr3 = new GridBagConstraints();
		gbcDescr3.insets = new Insets(5, 20, 5, 20);
		gbcDescr3.anchor = GridBagConstraints.CENTER;
		gbcDescr3.gridx = 2;
		gbcDescr3.gridy = 2;// Segunda fila de la primera columna
		JLabel descr3 = new JLabel("Oferta de spa y aromaterapia durante una hora");
		descr3.setFont(new Font("TAHOMA", Font.PLAIN, 13));
		panelPromociones.add(descr3, gbcDescr3);

		GridBagConstraints gbcPrec3 = new GridBagConstraints();
		gbcPrec3.insets = new Insets(5, 20, 5, 20);
		gbcPrec3.anchor = GridBagConstraints.CENTER;
		gbcPrec3.gridx = 2;
		gbcPrec3.gridy = 3;// Segunda fila de la primera columna
		JLabel prec3 = new JLabel("50€");
		prec3.setFont(new Font("Dubai", Font.BOLD, 20));
		panelPromociones.add(prec3, gbcPrec3);

		GridBagConstraints gbcBtn3 = new GridBagConstraints();
		gbcBtn3.insets = new Insets(3, 20, 3, 20);
		gbcBtn3.anchor = GridBagConstraints.CENTER;
		gbcBtn3.gridx = 2;
		gbcBtn3.gridy = 4;// Segunda fila de la primera columna
		JButton btn3 = new JButton("Reservar");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservar In = new Reservar();
				In.setVisible(true);
			}
		});
		panelPromociones.add(btn3, gbcBtn3);

		// EXPERIENCIAS
		JPanel panelExpPrinc = new JPanel();
		panelExpPrinc.setLayout(new BorderLayout());
		JLabel bienExp = new JLabel("EXPERIENCIAS");
		bienExp.setFont(new Font("Dubai", Font.BOLD, 40));
		bienExp.setHorizontalAlignment(SwingConstants.CENTER);
		bienExp.setVerticalAlignment(SwingConstants.BOTTOM);
		panelExpPrinc.add(bienExp, BorderLayout.NORTH);

		// Panel para "Experiencias"
		JPanel panelExperiencias = new JPanel();
		panelExperiencias.setBackground(Color.WHITE);
		panelExpPrinc.add(panelExperiencias, BorderLayout.CENTER);
		panelExperiencias.setLayout(new GridBagLayout());
		GridBagConstraints gbcExp1 = new GridBagConstraints();
		gbcExp1.insets = new Insets(5, 10, 5, 10);
		gbcExp1.anchor = GridBagConstraints.WEST;
		gbcExp1.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcExp1.gridy = 0;
		gbcExp1.weighty = 1.0;

		// Panel para "Experiencias"
		JPanel panelExperiencia1 = new JPanel();
		panelExperiencia1.setBorder(new LineBorder(new Color(180, 180, 180), 2, true));
		panelExperiencia1.setBackground(SystemColor.controlHighlight);
		panelExperiencia1.setLayout(new GridBagLayout());
		GridBagConstraints gbcimgexp1 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbcimgexp1.insets = new Insets(5, 10, 5, 10);
		gbcimgexp1.anchor = GridBagConstraints.WEST;
		gbcimgexp1.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcimgexp1.gridy = 0;// Primera fila de la primera columna

		JLabel lblImgExp1 = new JLabel();
		lblImgExp1.setIcon(new ImageIcon("src/imagenes/aguatermal.jfif"));
		panelExperiencia1.add(lblImgExp1, gbcimgexp1);

		GridBagConstraints gbctxtexp1 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbctxtexp1.insets = new Insets(5, 10, 5, 10);
		gbctxtexp1.anchor = GridBagConstraints.WEST;
		gbctxtexp1.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxtexp1.gridy = 0;// Primera fila de la primera columna

		JLabel lbltxtExp1 = new JLabel(
				"Experiencia de aguas termales, para relajarse en agua caliente en los dias más fríos                                                ");
		panelExperiencia1.add(lbltxtExp1, gbctxtexp1);

		panelExperiencias.add(panelExperiencia1, gbcExp1);

		GridBagConstraints gbcExp2 = new GridBagConstraints();
		gbcExp2.insets = new Insets(5, 10, 5, 10);
		gbcExp2.anchor = GridBagConstraints.WEST;
		gbcExp2.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcExp2.gridy = 1;
		gbcExp2.weighty = 1.0;

		// Panel para "Experiencias2"
		JPanel panelExperiencia2 = new JPanel();
		panelExperiencia2.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 2, true));
		panelExperiencia2.setBackground(SystemColor.controlHighlight);
		panelExperiencia2.setLayout(new GridBagLayout());
		GridBagConstraints gbcimgexp2 = new GridBagConstraints();

		gbcimgexp2.insets = new Insets(5, 10, 5, 10);
		gbcimgexp2.anchor = GridBagConstraints.WEST;
		gbcimgexp2.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcimgexp2.gridy = 0;// Primera fila de la primera columna

		JLabel lblImgExp2 = new JLabel();
		lblImgExp2.setIcon(new ImageIcon("src/imagenes/saunajpeg.jfif"));
		panelExperiencia2.add(lblImgExp2, gbcimgexp2);

		GridBagConstraints gbctxtexp2 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbctxtexp2.insets = new Insets(5, 10, 5, 10);
		gbctxtexp2.anchor = GridBagConstraints.WEST;
		gbctxtexp2.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxtexp2.gridy = 0;// Primera fila de la primera columna

		JLabel lbltxtExp2 = new JLabel(
				"Experiencia en una sauna turca para poder sudar todas las impurezas de nuestro cuerpo y relajarse");
		panelExperiencia2.add(lbltxtExp2, gbctxtexp2);

		panelExperiencias.add(panelExperiencia2, gbcExp2);

		GridBagConstraints gbcExp3 = new GridBagConstraints();
		gbcExp3.insets = new Insets(5, 10, 5, 10);
		gbcExp3.anchor = GridBagConstraints.WEST;
		gbcExp3.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcExp3.gridy = 2;
		gbcExp3.weighty = 1.0;

		// Panel para "Experiencias2"
		JPanel panelExperiencia3 = new JPanel();
		panelExperiencia3.setBorder(new LineBorder(new Color(180, 180, 180), 2, true));
		panelExperiencia3.setBackground(SystemColor.controlHighlight);
		panelExperiencia3.setLayout(new GridBagLayout());
		GridBagConstraints gbcimgexp3 = new GridBagConstraints();

		gbcimgexp3.insets = new Insets(5, 10, 5, 10);
		gbcimgexp3.anchor = GridBagConstraints.WEST;
		gbcimgexp3.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcimgexp3.gridy = 0;// Primera fila de la primera columna

		JLabel lblImgExp3 = new JLabel();
		lblImgExp3.setIcon(new ImageIcon("src/imagenes/masage.jpg"));
		panelExperiencia3.add(lblImgExp3, gbcimgexp3);

		GridBagConstraints gbctxtexp3 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbctxtexp3.insets = new Insets(5, 10, 5, 10);
		gbctxtexp3.anchor = GridBagConstraints.WEST;
		gbctxtexp3.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxtexp3.gridy = 0;// Primera fila de la primera columna

		JLabel lbltxtExp3 = new JLabel(
				"Un masaje relajante con aceites esenciales del himalaya                                                                                                             ");
		panelExperiencia3.add(lbltxtExp3, gbctxtexp3);

		panelExperiencias.add(panelExperiencia3, gbcExp3);

		GridBagConstraints gbcExp4 = new GridBagConstraints();
		gbcExp4.insets = new Insets(5, 10, 5, 10);
		gbcExp4.anchor = GridBagConstraints.WEST;
		gbcExp4.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcExp4.gridy = 3;
		gbcExp4.weighty = 1.0;

		// Panel para "Experiencias2"
		JPanel panelExperiencia4 = new JPanel();
		panelExperiencia4.setBorder(new LineBorder(new Color(180, 180, 180), 2, true));
		panelExperiencia4.setBackground(SystemColor.controlHighlight);
		panelExperiencia4.setLayout(new GridBagLayout());
		GridBagConstraints gbcimgexp4 = new GridBagConstraints();

		gbcimgexp4.insets = new Insets(5, 10, 5, 10);
		gbcimgexp4.anchor = GridBagConstraints.WEST;
		gbcimgexp4.gridx = 0; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbcimgexp4.gridy = 0;// Primera fila de la primera columna

		JLabel lblImgExp4 = new JLabel();
		lblImgExp4.setIcon(new ImageIcon("src/imagenes/velass.jpg"));
		panelExperiencia4.add(lblImgExp4, gbcimgexp4);

		GridBagConstraints gbctxtexp4 = new GridBagConstraints();

		// Añadimos unos margenes a cada celda con insets y con anchor podemos mover el
		// contenido de la celda a norte sur este y oeste
		gbctxtexp4.insets = new Insets(5, 10, 5, 10);
		gbctxtexp4.anchor = GridBagConstraints.WEST;
		gbctxtexp4.gridx = 1; // Comenzamos con la columna izquierda posicion 0 del eje x
		gbctxtexp4.gridy = 0;// Primera fila de la primera columna

		JLabel lbltxtExp4 = new JLabel(
				"Sesiones de aromaterapia, para experimentar nuevas sensaciones                                                                                         ");
		panelExperiencia4.add(lbltxtExp4, gbctxtexp4);

		panelExperiencias.add(panelExperiencia4, gbcExp4);

		// Panel para "Contacto"
		JPanel panelContacto = new JPanel();
		panelContacto.setLayout(new BorderLayout());
		JLabel bienContact = new JLabel("CONTACTO");
		bienContact.setFont(new Font("Dubai", Font.BOLD, 40));
		bienContact.setHorizontalAlignment(SwingConstants.CENTER);
		bienContact.setVerticalAlignment(SwingConstants.BOTTOM);
		panelContacto.add(bienContact, BorderLayout.NORTH);

		// Panel para "Promociones"
		JPanel panelContacto2 = new JPanel();
		panelContacto.add(panelContacto2, BorderLayout.CENTER);
		panelContacto2.setLayout(new BoxLayout(panelContacto2, BoxLayout.Y_AXIS));
		
		JLabel numeroContacto = new JLabel("TELEFONO DE EMPRESA: 653456789");
		numeroContacto.setFont(new Font("Dubai", Font.BOLD, 20));
		numeroContacto.setHorizontalAlignment(SwingConstants.CENTER);
		numeroContacto.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel direccionContacto = new JLabel("DIRECCIÓN: Calle tortola, número 23, GRANADA");
		direccionContacto.setFont(new Font("Dubai", Font.BOLD, 20));
		direccionContacto.setHorizontalAlignment(SwingConstants.CENTER);
		direccionContacto.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel correoContacto = new JLabel("CORREO ELECTRÓNICO: spa23@gmail.com");
		correoContacto.setFont(new Font("Dubai",Font.BOLD, 20));
		correoContacto.setHorizontalAlignment(SwingConstants.CENTER);
		correoContacto.setVerticalAlignment(SwingConstants.BOTTOM);
		panelContacto2.add(numeroContacto);
		panelContacto2.add(direccionContacto);
		panelContacto2.add(correoContacto);
		

		// Añadir los paneles al CardLayout
		panelPrincipal.add(panelInicio, "Inicio");
		panelPrincipal.add(panelPromoPrinc, "Promociones");
		panelPrincipal.add(panelExpPrinc, "Experiencias");
		panelPrincipal.add(panelContacto, "Contacto");

		// Controlador de tarjetas
		CardLayout cl = (CardLayout) panelPrincipal.getLayout();

		// Añadir acciones a los botones
		botonInicio.addActionListener(e -> cl.show(panelPrincipal, "Inicio"));
		botonProm.addActionListener(e -> cl.show(panelPrincipal, "Promociones"));
		botonExp.addActionListener(e -> cl.show(panelPrincipal, "Experiencias"));
		botonReser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservar In = new Reservar();
				In.setVisible(true);
			}
		});
		
		botonContact.addActionListener(e -> cl.show(panelPrincipal, "Contacto"));

		// Panel superior vacío (Norte)
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(30, 144, 255));
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setPreferredSize(new Dimension(300, 50));

	}

	// Botones personalizados

	private JButton createCustomButton(String text) {
		JButton button = new JButton(text);

		// Estilo básico
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setOpaque(true);
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setBackground(Color.LIGHT_GRAY); // Fondo azul
		button.setForeground(Color.BLACK); // Texto blanco
		button.setFont(new Font("SansSerif", Font.BOLD, 16)); // Fuente personalizada
		button.setHorizontalAlignment(SwingConstants.LEFT); // Alinear texto a la izquierda
		button.setPreferredSize(new Dimension(150, 50)); // Tamaño preferido

		// Efecto "hover" con MouseAdapter
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(0, 153, 255)); // Fondo más claro al pasar el mouse
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(211, 211, 211)); // Fondo original al salir
			}
		});

		return button;
	}
}
