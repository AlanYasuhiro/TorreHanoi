package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import game.TorreDeHanoi;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class Interface extends JFrame {
	int contT1 = 0, contT2 = 0, contT3 = 0, quantMov = 0, quant;
	int disc1 = 1, disc2 = 1, disc3 = 1, disc4 = 1, disc5 = 1, disc6 = 1, disc7 = 1, disc8 = 1;
    int minMov;
	int tam, tam1, tam2;
	boolean d1, d2, d3, d4, d5, d6, d7, d8;
	ArrayList<Integer> pesoT1 = new ArrayList<Integer>();
	ArrayList<Integer> pesoT2 = new ArrayList<Integer>();
	ArrayList<Integer> pesoT3 = new ArrayList<Integer>();	
	ArrayList<Integer> caminho1 = new ArrayList<Integer>(); ArrayList<Integer> caminho2 = new ArrayList<Integer>();
	
	private JPanel contentPane;
	private JLabel lblDisco1, lblDisco2, lblDisco3, lblDisco4, lblDisco5, lblDisco6, lblDisco7, lblDisco8;
	private JLabel lblTorre1, lblTorre2, lblTorre3;
	private JButton btnIniciar, btnSimular;
	private JSpinner spinner;
	private JLabel lblSeusMovimentos, lblQtd, lblNmeroMnimoDe, lblQuantidadeDeDiscos, lblMov;

	public Interface() {
		setTitle("Torre de Hanoi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new Torres();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		criaComponentes();
		criaAcoes();
	}

	public void criaComponentes() {

		lblQuantidadeDeDiscos = new JLabel("Quantidade de discos");
		lblQuantidadeDeDiscos.setBounds(751, 37, 143, 14);
		contentPane.add(lblQuantidadeDeDiscos);

		lblNmeroMnimoDe = new JLabel("M\u00EDnimo de movimentos");
		lblNmeroMnimoDe.setBounds(751, 91, 133, 14);
		contentPane.add(lblNmeroMnimoDe);

		lblQtd = new JLabel("");
		lblQtd.setBounds(853, 122, 31, 14);
		contentPane.add(lblQtd);
		
		btnSimular = new JButton("SIMULAR");
		btnSimular.setBackground(Color.WHITE);
		btnSimular.setBounds(795, 266, 89, 23);
		contentPane.add(btnSimular);
		
		lblDisco1 = new JLabel("");
		lblDisco1.setBackground(Color.MAGENTA);
		lblDisco1.setOpaque(true);
		lblDisco1.setBounds(83, 91, 35, 25);
		contentPane.add(lblDisco1);
		
		lblDisco2 = new JLabel("");
		lblDisco2.setBackground(Color.ORANGE);
		lblDisco2.setOpaque(true);
		lblDisco2.setBounds(73, 116, 55, 25);
		contentPane.add(lblDisco2);
		
		lblDisco3 = new JLabel("");
		lblDisco3.setBackground(Color.GRAY);
		lblDisco3.setOpaque(true);
		lblDisco3.setBounds(63, 141, 75, 25);
		contentPane.add(lblDisco3);

		lblDisco4 = new JLabel("");
		lblDisco4.setOpaque(true);
		lblDisco4.setBackground(Color.RED);
		lblDisco4.setBounds(53, 166, 95, 25);
		contentPane.add(lblDisco4);

		lblDisco5 = new JLabel("");
		lblDisco5.setOpaque(true);
		lblDisco5.setBackground(Color.YELLOW);
		lblDisco5.setBounds(43, 191, 115, 25);
		contentPane.add(lblDisco5);

		lblDisco6 = new JLabel("");
		lblDisco6.setOpaque(true);
		lblDisco6.setBackground(Color.BLUE);
		lblDisco6.setBounds(33, 216, 135, 25);
		contentPane.add(lblDisco6);
		
		lblDisco7 = new JLabel("");
		lblDisco7.setBackground(Color.CYAN);
		lblDisco7.setOpaque(true);
		lblDisco7.setBounds(23, 241, 155, 25);
		contentPane.add(lblDisco7);
		
		lblDisco8 = new JLabel("");
		lblDisco8.setBackground(Color.BLACK);
		lblDisco8.setOpaque(true);
		lblDisco8.setBounds(13, 266, 175, 25);
		contentPane.add(lblDisco8);
		
		lblTorre1 = new JLabel("");
		lblTorre1.setBounds(40, 27, 121, 283);
		contentPane.add(lblTorre1);
		
		lblTorre2 = new JLabel("");
		lblTorre2.setBounds(280, 27, 121, 283);
		contentPane.add(lblTorre2);
		
		lblTorre3 = new JLabel("");
		lblTorre3.setBounds(520, 27, 121, 283);
		contentPane.add(lblTorre3);
		
		spinner = new JSpinner();
		spinner.setBackground(Color.WHITE);
		spinner.setFont(new Font("Arial", Font.PLAIN, 12));
		spinner.setModel(new SpinnerNumberModel(3, 3, 8, 1));
		spinner.setBounds(832, 66, 52, 20);
		contentPane.add(spinner);
		
		btnIniciar = new JButton("INICIAR");
		btnIniciar.setBackground(Color.WHITE);
		btnIniciar.setBounds(795, 147, 89, 23);
		contentPane.add(btnIniciar);
		
		lblSeusMovimentos = new JLabel("Seus movimentos: ");
		lblSeusMovimentos.setBounds(751, 191, 115, 14);
		contentPane.add(lblSeusMovimentos);
		
		lblMov = new JLabel("");
		lblMov.setBounds(782, 216, 46, 14);
		contentPane.add(lblMov);
	}

	public void criaAcoes() {
		
		tam = pesoT1.size();
		tam1 = pesoT2.size();
		tam2 = pesoT3.size();
		
		lblDisco1.setVisible(false);
		lblDisco2.setVisible(false);
		lblDisco3.setVisible(false);
		lblDisco4.setVisible(false);
		lblDisco5.setVisible(false);
		lblDisco6.setVisible(false);
		lblDisco7.setVisible(false);
		lblDisco8.setVisible(false);
		
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Movimento().start();
			}
		});
		
		//Torre 1
		lblTorre1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((disc1 == 2 && d1) || (disc2 == 2 && d2) || (disc3 == 2 && d3) || (disc4 == 2 && d4) || (disc5 == 2 && d5) || (disc6 == 2 && d6) || (disc7 == 2 && d7) || (disc8 == 2 && d8)){
					if(!pesoT1.isEmpty() && pesoT2.get(tam1) < pesoT1.get(tam)){
						contT2 -= 25;
						pesoT2.remove(0);
						System.out.println("Torre 2 ficou: " + contT2);
					}else if(pesoT1.isEmpty()){
						contT2 -= 25;
						pesoT2.remove(0);
						System.out.println("Torre 2 ficou: " + contT2);
					}else{
						discoFalso();
					}
				}

				if((disc1 == 3 && d1) || (disc2 == 3 && d2) || (disc3 == 3 && d3) || (disc4 == 3 && d4) || (disc5 == 3 && d5) || (disc6 == 3 && d6) || (disc7 == 3 && d7) || (disc8 == 3 && d8)){
					if(!pesoT1.isEmpty() && pesoT3.get(tam2) < pesoT1.get(tam)){
						contT3 -= 25;
						pesoT3.remove(0);
						System.out.println("Torre 3 ficou: " + contT3);
					}else if(pesoT1.isEmpty()){
						contT3 -= 25;
						pesoT3.remove(0);
						System.out.println("Torre 3 ficou: " + contT3);
					}else{
						discoFalso();
					}
				}
				
				//disco 1
				if(d1){
					lblDisco1.setLocation(83, 266 - contT1);
					d1 = false;
					disc1 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 1);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 2
				if(d2 && (pesoT1.isEmpty() || pesoT1.get(tam) > 2)){
					lblDisco2.setLocation(73, 266 - contT1);
					d2 = false;
					disc2 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 2);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 3
				if(d3 && (pesoT1.isEmpty() || pesoT1.get(tam) > 3)){
					lblDisco3.setLocation(63, 266 - contT1);
					d3 = false;
					disc3 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 3);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 4
				if(d4 && (pesoT1.isEmpty() || pesoT1.get(tam) > 4)){
					lblDisco4.setLocation(53 , 266 - contT1);
					d4 = false;
					disc4 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 4);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 5
				if(d5 && (pesoT1.isEmpty() || pesoT1.get(tam) > 5)){
					lblDisco5.setLocation(43, 266 - contT1);
					d5 = false;
					disc5 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 5);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 6
				if(d6 && (pesoT1.isEmpty() || pesoT1.get(tam) > 6)){
					lblDisco6.setLocation(33, 266 - contT1);
					d6 = false;
					disc6 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 6);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 7
				if(d7 && (pesoT1.isEmpty() || pesoT1.get(tam) > 7)){
					lblDisco7.setLocation(23, 266 - contT1);
					d7 = false;
					disc7 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 7);
					System.out.println("Torre 1: " + contT1);
				}
				
				//disco 8
				if(d8 && pesoT1.isEmpty()){
					lblDisco8.setLocation(13, 266 - contT1);
					d8 = false;
					disc8 = 1;
					contT1 += 25;
					quantMov++;
					pesoT1.add(0, 8);
					System.out.println("Torre 1: " + contT1);
				}
				lblMov.setText((String.valueOf(quantMov)));
			}
		});
		
		//Torre 2
		lblTorre2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((disc1 == 1 && d1) || (disc2 == 1 && d2) || (disc3 == 1 && d3) || (disc4 == 1 && d4) || (disc5 == 1 && d5) || (disc6 == 1 && d6) || (disc7 == 1 && d7) || disc8 == 1 && d8){
					if(!pesoT2.isEmpty() && pesoT1.get(tam) < pesoT2.get(tam1)){
						contT1 -= 25;
						pesoT1.remove(0);
						System.out.println("Torre 1 ficou: " + contT1);
					}else if(pesoT2.isEmpty()){
						contT1 -= 25;
						pesoT1.remove(0);
						System.out.println("Torre 1 ficou: " + contT1);
					}else{
						discoFalso();
					}
				}
				
				if((disc1 == 3 && d1) || (disc2 == 3 && d2) || (disc3 == 3 && d3) || (disc4 == 3 && d4) || (disc5 == 3 && d5) || (disc6 == 3 && d6) || (disc7 == 3 && d7) || disc8 == 3 && d8){
					if(!pesoT2.isEmpty() && pesoT3.get(tam2) < pesoT2.get(tam1)){
						contT3 -= 25;
						pesoT3.remove(0);
						System.out.println("Torre 3 ficou: " + contT3);
					}else if(pesoT2.isEmpty()){
						contT3 -= 25;
						pesoT3.remove(0);
						System.out.println("Torre 3 ficou: " + contT3);
					}else{
						discoFalso();
					}
				}
				
				//disco 1
				if(d1){
					lblDisco1.setLocation(322, 266 - contT2);
					d1 = false;
					disc1 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 1);
					System.out.println("Torre 2: " + contT2);
				}
				
				//disco 2
				if(d2 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 2))){
					lblDisco2.setLocation(312, 266 - contT2);
					d2 = false;
					disc2 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 2);
					System.out.println("Torre 2: " + contT2);
				}
				
				//disco 3
				if(d3 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 3))){
					lblDisco3.setLocation(302, 266 - contT2);
					d3 = false;
					disc3 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0 ,3);
					System.out.println("Torre 2: " + contT2);
				}

				//disco 4
				if(d4 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 4))){
					lblDisco4.setLocation(292, 266 - contT2);
					d4 = false;
					disc4 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 4);
					System.out.println("Torre 2: " + contT2);
				}
				
				//disco 5
				if(d5 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 5))){
					lblDisco5.setLocation(282, 266 - contT2);
					d5 = false;
					disc5 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 5);
					System.out.println("Torre 2: " + contT2);
				}
				
				//disco 6
				if(d6 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 6))){
					lblDisco6.setLocation(272, 266 - contT2);
					d6 = false;
					disc6 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 6);
					System.out.println("Torre 2: " + contT2);
				}		
				
				//disco 7
				if(d7 && ((pesoT2.isEmpty()) || (pesoT2.get(tam1) > 7))){
					lblDisco7.setLocation(262, 266 - contT2);
					d7 = false;
					disc7 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0 ,7);
					System.out.println("Torre 2: " + contT2);
				}
				
				//disco 8
				if(d8 && pesoT2.isEmpty()){
					lblDisco8.setLocation(252, 266 - contT2);
					d8 = false;
					disc8 = 2;
					contT2 += 25;
					quantMov++;
					pesoT2.add(0, 8);
					System.out.println("Torre 2: " + contT2);
				}
				lblMov.setText((String.valueOf(quantMov)));
			}
		});
		
		//Torre 3
		lblTorre3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((disc1 == 2 && d1) || (disc2 == 2 && d2) || (disc3 == 2 && d3) || (disc4 == 2 && d4) || (disc5 == 2 && d5) || (disc6 == 2 && d6) || (disc7 == 2 && d7) || disc8 == 2 && d8){
					if(!pesoT3.isEmpty() && pesoT2.get(tam1) < pesoT3.get(tam2)){
						contT2 -= 25;
						pesoT2.remove(0);
						System.out.println("Torre 2 ficou: " + contT2);
					}else if(pesoT3.isEmpty()){
						contT2 -= 25;
						pesoT2.remove(0);
						System.out.println("Torre 2 ficou: " + contT2);
					}else{
						discoFalso();
					}
				}

				if((disc1 == 1 && d1) || (disc2 == 1 && d2) || (disc3 == 1 && d3) || (disc4 == 1 && d4) || (disc5 == 1 && d5) || (disc6 == 1 && d6) || (disc7 == 1 && d7) || disc8 == 1 && d8){
					if(!pesoT3.isEmpty() && pesoT1.get(tam) < pesoT3.get(tam2)){
						contT1 -= 25;
						pesoT1.remove(0);
						System.out.println("Torre 1 ficou: " + contT1);
					}else if(pesoT3.isEmpty()){
						contT1 -= 25;
						pesoT1.remove(0);
						System.out.println("Torre 1 ficou: " + contT1);
					}else{
						discoFalso();
					}
				}
				
				//disco 1
				if(d1){
					lblDisco1.setLocation(563, 266 - contT3);
					d1 = false;
					contT3 += 25;
					disc1 = 3;
					quantMov++;
					pesoT3.add(0, 1);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 2
				if(d2 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 2))){
					lblDisco2.setLocation(553, 266 - contT3);
					d2 = false;
					contT3 += 25;
					disc2 = 3;
					quantMov++;
					pesoT3.add(0, 2);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 3
				if(d3 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 3))){
					lblDisco3.setLocation(543, 266 - contT3);
					d3 = false;
					contT3 += 25;
					disc3 = 3;
					quantMov++;
					pesoT3.add(0, 3);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 4
				if(d4 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 4))){
					lblDisco4.setLocation(532, 266 - contT3);
					d4 = false;
					contT3 += 25;
					disc4 = 3;
					quantMov++;
					pesoT3.add(0, 4);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 5
				if(d5 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 5))){
					lblDisco5.setLocation(522, 266 - contT3);
					d5 = false;
					disc5 = 3;
					contT3 += 25;
					quantMov++;
					pesoT3.add(0, 5);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 6
				if(d6 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 6))){
					lblDisco6.setLocation(512, 266 - contT3);
					d6 = false;
					disc6 = 3;
					contT3 += 25;
					quantMov++;
					pesoT3.add(0, 6);
					if(minMov == quantMov && quant == pesoT3.size()){
						JOptionPane.showMessageDialog(null, "Fim de jogo!!! Parabéns você conseguiu em " + minMov + " movimentos");
					}
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 7
				if(d7 && ((pesoT3.isEmpty()) || (pesoT3.get(tam2) > 7))){
					lblDisco7.setLocation(502, 266 - contT3);
					d7 = false;
					disc7 = 3;
					contT3 += 25;
					quantMov++;
					pesoT3.add(0, 7);
					System.out.println("Torre 3: " + contT3);
				}
				
				//disco 8
				if(d8 && pesoT3.isEmpty()){
					lblDisco8.setLocation(492, 266 - contT3);
					d8 = false;
					disc8 = 3;
					contT3 += 25;
					quantMov++;
					pesoT3.add(0, 8);
					System.out.println("Torre 3: " + contT3);	
				}
				lblMov.setText((String.valueOf(quantMov)));
			}
		});
		
		lblDisco1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d1 = true;
			}
		});
		
		lblDisco2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 2){
					System.out.println("T1: " + pesoT1.get(tam));
					d2 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 2){
					System.out.println("T2: " + pesoT2.get(tam1));
					d2 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 2){
					System.out.println("T3: " + pesoT3.get(tam2));
					d2 = true;
				}
			}
		});
		
		lblDisco3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 3){
					System.out.println("T1: " + pesoT1.get(tam));
					d3 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 3){
					System.out.println("T2: " + pesoT2.get(tam1));
					d3 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 3){
					System.out.println("T3: " + pesoT3.get(tam2));
					d3 = true;
				}	
			}
		});
		
		lblDisco4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 4){
					System.out.println("T1: " + pesoT1.get(tam));
					d4 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 4){
					System.out.println("T2: " + pesoT2.get(tam1));
					d4 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 4){
					System.out.println("T3: " + pesoT3.get(tam2));
					d4 = true;
				}
			}
		});
		
		lblDisco5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 5){
					System.out.println("T1: " + pesoT1.get(tam));
					d5 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 5){
					System.out.println("T2: " + pesoT2.get(tam1));
					d5 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 5){
					System.out.println("T3: " + pesoT3.get(tam2));
					d5 = true;
				}
			}
		});
		
		lblDisco6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 6){
					System.out.println("T1: " + pesoT1.get(tam));
					d6 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 6){
					System.out.println("T2: " + pesoT2.get(tam1));
					d6 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 6){
					System.out.println("T3: " + pesoT3.get(tam2));
					d6 = true;
				}
			}
		});
		
		lblDisco7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 7){
					System.out.println("T1: " + pesoT1.get(tam));
					d7 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 7){
					System.out.println("T2: " + pesoT2.get(tam1));
					d7 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 7){
					System.out.println("T3: " + pesoT3.get(tam2));
					d7 = true;
				}
			}
		});
		
		lblDisco8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!pesoT1.isEmpty() && pesoT1.get(tam) == 8){
					System.out.println("T1: " + pesoT1.get(tam));
					d8 = true;
				}else if(!pesoT2.isEmpty() && pesoT2.get(tam1) == 8){
					System.out.println("T2: " + pesoT2.get(tam));
					d8 = true;
				}else if(!pesoT3.isEmpty() && pesoT3.get(tam2) == 8){
					System.out.println("T3: " + pesoT3.get(tam));
					d8 = true;
				}
			}
		});
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quant = (Integer) spinner.getValue();
				lblMov.setText("");
				quantMov = 0;
				pesoT1.clear(); pesoT2.clear(); pesoT3.clear();
				caminho1.clear(); caminho2.clear();
				contT1 = 0; contT2 = 0; contT3 = 0;
				disc1 = 1; disc2 = 1; disc3 = 1; disc4 = 1; disc5 = 1; disc6 = 1; disc7 = 1; disc8 = 1;
				discoFalso();
				
				if(quant == 3){
					lblDisco1.setVisible(false);
					lblDisco2.setVisible(false);
					lblDisco3.setVisible(false);
					lblDisco4.setVisible(false);
					lblDisco5.setVisible(false);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				
				if(quant == 4){
					lblDisco1.setVisible(false);
					lblDisco2.setVisible(false);
					lblDisco3.setVisible(false);
					lblDisco4.setVisible(false);
					lblDisco5.setVisible(true);
					lblDisco5.setLocation(43, 191);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(5);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				
				if(quant == 5){
					lblDisco1.setVisible(false);
					lblDisco2.setVisible(false);
					lblDisco3.setVisible(false);
					lblDisco4.setVisible(true);
					lblDisco4.setLocation(53, 166);
					lblDisco5.setVisible(true);
					lblDisco5.setLocation(43, 191);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(4);
					pesoT1.add(5);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				
				if(quant == 6){
					lblDisco1.setVisible(false);
					lblDisco2.setVisible(false);
					lblDisco3.setVisible(true);
					lblDisco3.setLocation(63, 141);
					lblDisco4.setVisible(true);
					lblDisco4.setLocation(53, 166);
					lblDisco5.setVisible(true);
					lblDisco5.setLocation(43, 191);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(3);
					pesoT1.add(4);
					pesoT1.add(5);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				
				if(quant == 7){
					lblDisco1.setVisible(false);
					lblDisco2.setVisible(true);
					lblDisco2.setLocation(73, 116);
					lblDisco3.setVisible(true);
					lblDisco3.setLocation(63, 141);
					lblDisco4.setVisible(true);
					lblDisco4.setLocation(53, 166);
					lblDisco5.setVisible(true);
					lblDisco5.setLocation(43, 191);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(2);
					pesoT1.add(3);
					pesoT1.add(4);
					pesoT1.add(5);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				
				if(quant == 8){
					lblDisco1.setVisible(true);
					lblDisco1.setLocation(83, 91);
					lblDisco2.setVisible(true);
					lblDisco2.setLocation(73, 116);
					lblDisco3.setVisible(true);
					lblDisco3.setLocation(63, 141);
					lblDisco4.setVisible(true);
					lblDisco4.setLocation(53, 166);
					lblDisco5.setVisible(true);
					lblDisco5.setLocation(43, 191);
					lblDisco6.setVisible(true);
					lblDisco6.setLocation(33, 216);
					lblDisco7.setVisible(true);
					lblDisco7.setLocation(23, 241);
					lblDisco8.setVisible(true);
					lblDisco8.setLocation(13, 266);
					pesoT1.add(1);
					pesoT1.add(2);
					pesoT1.add(3);
					pesoT1.add(4);
					pesoT1.add(5);
					pesoT1.add(6);
					pesoT1.add(7);
					pesoT1.add(8);
					contT1 = 25 * quant;
				}
				minMov = (int) Math.pow(2, quant) - 1;
				lblQtd.setText("" + minMov);

				hanoi(quant, 1, 3, 2);
			}
		});
	}
	
	public void discoFalso(){
		d1 = false;
		d2 = false;
		d3 = false;
		d4 = false;
		d5 = false;
		d6 = false;
		d7 = false;
		d8 = false;
	}
	
	public class Movimento extends Thread{
		public void run() {
			for(int i = 0; i < caminho1.size(); i++) {
				if(caminho1.get(i) == 1 && caminho2.get(i) == 2) {
					mov12();
					try{Thread.sleep(500);}catch(Exception e) {}
				}else if(caminho1.get(i) == 1 && caminho2.get(i) == 3){
					mov13();
					try{Thread.sleep(500);}catch(Exception e) {}
				}else if(caminho1.get(i) == 2 && caminho2.get(i) == 3){
					mov23();
					try{Thread.sleep(500);}catch(Exception e) {}
				}else if(caminho1.get(i) == 3 && caminho2.get(i) == 2){
					mov32();
					try{Thread.sleep(500);}catch(Exception e) {}
				}else if(caminho1.get(i) == 2 && caminho2.get(i) == 1){
					mov21();
					try{Thread.sleep(500);}catch(Exception e) {}
				}else if(caminho1.get(i) == 3 && caminho2.get(i) == 1){
					mov31();
					try{Thread.sleep(500);}catch(Exception e) {}
				}
			}
				contT1 = 0; contT2 = 0; contT3 = 0;
				pesoT1.clear(); pesoT2.clear(); pesoT3.clear();
				caminho1.clear(); caminho2.clear();
		}
	}
	
	public void mov12() {
		if(pesoT1.get(0) == 1) {
			lblDisco1.setLocation(322, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 1);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 2) {
			lblDisco2.setLocation(312, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 2);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 3) {
			lblDisco3.setLocation(302, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 3);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 4) {
			lblDisco4.setLocation(292, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 4);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 5) {
			lblDisco5.setLocation(282, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 5);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 6) {
			lblDisco6.setLocation(272, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 6);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 7) {
			lblDisco7.setLocation(262, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 7);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 8) {
			lblDisco8.setLocation(252, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 8);
			contT1 -= 25;
			pesoT1.remove(0);
		}
		
	}
	public void mov13() {
		if(pesoT1.get(0) == 1) {
			lblDisco1.setLocation(563, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 1);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 2) {
			lblDisco2.setLocation(553, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 2);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 3) {
			lblDisco3.setLocation(543, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 3);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 4) {
			lblDisco4.setLocation(532, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 4);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 5) {
			lblDisco5.setLocation(522, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 5);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 6) {
			lblDisco6.setLocation(512, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 6);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 7) {
			lblDisco7.setLocation(502, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 7);
			contT1 -= 25;
			pesoT1.remove(0);
		}else if(pesoT1.get(0) == 8) {
			lblDisco8.setLocation(492, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 8);
			contT1 -= 25;
			pesoT1.remove(0);
		}	
	}
	public void mov21() {
		if(pesoT2.get(0) == 1) {
			lblDisco1.setLocation(83, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 1);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 2) {
			lblDisco2.setLocation(73, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 2);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 3) {
			lblDisco3.setLocation(63, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 3);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 4) {
			lblDisco4.setLocation(53 , 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 4);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 5) {
			lblDisco5.setLocation(43, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 5);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 6) {
			lblDisco6.setLocation(33, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 6);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 7) {
			lblDisco7.setLocation(502, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 7);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 8) {
			lblDisco8.setLocation(492, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 8);
			contT2 -= 25;
			pesoT2.remove(0);
		}
	}
	public void mov31() {
		if(pesoT3.get(0) == 1) {
			lblDisco1.setLocation(83, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 1);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 2) {
			lblDisco2.setLocation(73, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 2);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 3) {
			lblDisco3.setLocation(63, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 3);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 4) {
			lblDisco4.setLocation(53 , 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 4);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 5) {
			lblDisco5.setLocation(43, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 5);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 6) {
			lblDisco6.setLocation(33, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 6);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 7) {
			lblDisco7.setLocation(23, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 7);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 8) {
			lblDisco8.setLocation(13, 266 - contT1);
			contT1 += 25;
			pesoT1.add(0, 8);
			contT3 -= 25;
			pesoT3.remove(0);
		}
	}
	public void mov23() {
		if(pesoT2.get(0) == 1) {
			lblDisco1.setLocation(563, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 1);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 2) {
			lblDisco2.setLocation(553, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 2);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 3) {
			lblDisco3.setLocation(543, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 3);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 4) {
			lblDisco4.setLocation(532, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 4);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 5) {
			lblDisco5.setLocation(522, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 5);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 6) {
			lblDisco6.setLocation(512, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 6);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 7) {
			lblDisco7.setLocation(502, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 7);
			contT2 -= 25;
			pesoT2.remove(0);
		}else if(pesoT2.get(0) == 8) {
			lblDisco8.setLocation(492, 266 - contT3);
			contT3 += 25;
			pesoT3.add(0, 8);
			contT2 -= 25;
			pesoT2.remove(0);
		}
	}
	public void mov32() {
		if(pesoT3.get(0) == 1) {
			lblDisco1.setLocation(322, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 1);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 2) {
			lblDisco2.setLocation(312, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 2);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 3) {
			lblDisco3.setLocation(302, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 3);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 4) {
			lblDisco4.setLocation(292, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 4);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 5) {
			lblDisco5.setLocation(282, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 5);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 6) {
			lblDisco6.setLocation(272, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 6);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT3.get(0) == 7) {
			lblDisco7.setLocation(262, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 7);
			contT3 -= 25;
			pesoT3.remove(0);
		}else if(pesoT2.get(0) == 8) {
			lblDisco8.setLocation(252, 266 - contT2);
			contT2 += 25;
			pesoT2.add(0, 8);
			contT3 -= 25;
			pesoT3.remove(0);
		}
	}
	
	// Método que realiza (imprime) o movimento
	// de um disco entre dois pinos
	public void mover(int O, int D) {
		System.out.println(O + "-" + D);
		caminho1.add(O);
		caminho2.add(D);
	}
	// Método que implementa a recursão
	// O = pino origem
	// D = pino destino
	// T = pino de trabalho
	public void hanoi(int n, int O, int D, int T) {
		if (n > 0) {
			hanoi(n - 1, O, T, D);
			mover(O, D);
			hanoi(n - 1, T, D, O);
		}
	}
}