package DAO;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class C extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i,n;
	float j=0;
	JLabel N1,N;
	JButton augmenter;
	JButton diminuer;
	JTextField nombre;
	JPanel ci1;
	JPanel cprincipale;
	
	
	public  C() throws HeadlessException {
		System.out.println("donner nombre ");
		try (Scanner clavier = new Scanner (System.in)) {
			n=clavier.nextInt();
		}
		this.setTitle("Bouton");
		    this.setSize(300, 300);   
		   
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setLayout(new BorderLayout());
		    nombre=new JTextField();
		    ci1=new JPanel();
			ci1.setLayout(new GridLayout(1,2));
			ci1.add(nombre);
			cprincipale=new JPanel();
			augmenter=new JButton("N++");
			diminuer=new JButton("N--");
			cprincipale.setLayout(new GridLayout(3,1));
			cprincipale.add(augmenter);
			cprincipale.add(diminuer);
			this.getContentPane().add(cprincipale);
			this.setSize(420,150);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
		
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			augmenter.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Augmentation();
					
				}
				
			});
		    
	}
	public void Augmentation() {
		for(i=1,j=0;i<=n;i++) {
			j= (j+(float)1/i);
			
		}
		System.out.println(j);
		n++;
		
	
	}
	public static void main(String Args[]) {
		C fenetre =new C();
		fenetre.setVisible(true);
	}

}

