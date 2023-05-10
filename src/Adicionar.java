import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Adicionar extends JFrame {
	public Adicionar(String c0, String c1, String c2, String c3, String c4, int tipo) {
		super("Adicionar Filme");
		
		JTextField texto = new JTextField(10);
		texto.setText(c1);
		String original = c1;
		
		JLabel titulo = new JLabel("Nome:");
		JLabel ano = new JLabel("Ano: ");
		JTextField lanca = new JTextField(10);
		lanca.setText(c4);
		
		
		JLabel banco = new JLabel("Gênero: ");
		JComboBox<String> genero = new JComboBox<String>();
		
		JLabel studio = new JLabel("Estudio: ");
		JTextField est = new JTextField(10);
		est.setText(c2);
		
		
        JButton cancelar = new JButton("Cancelar");
        JButton ok = new JButton("Ok");
        
        genero.setPreferredSize(new Dimension(130, 20));
        
        genero.addItem("Ação");
        genero.addItem("Animação");
        genero.addItem("Aventura");
        genero.addItem("Comédia");
        genero.addItem("Drama");
        genero.addItem("Erótico");
        genero.addItem("Ficção Científica");
        genero.addItem("Musicais");
        genero.addItem("Erótico");
        genero.addItem("Terror");
     
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JPanel painel4 = new JPanel();
        JPanel painel5 = new JPanel();
        JPanel painel6 = new JPanel();
		
        painel1.add(titulo,BorderLayout.WEST);
        painel1.add(texto,BorderLayout.EAST);
        
        
        painel2.add(banco,BorderLayout.WEST);
        painel2.add(genero,BorderLayout.EAST);
        
        painel3.add(ano,BorderLayout.WEST);
        painel3.add(lanca,BorderLayout.EAST);
        
        painel4.add(studio,BorderLayout.WEST);
        painel4.add(est,BorderLayout.EAST);
        
        painel5.add(ok,BorderLayout.CENTER);
        
        painel6.add(cancelar,BorderLayout.CENTER);
        
        
        setLayout(new GridLayout(3,2));
        
        add(painel1);
        add(painel2);
        add(painel3);
        add(painel4);
        add(painel6);
        add(painel5);
        
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
        ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d1 = texto.getText();
				String d2 = lanca.getText();
				String d3 = genero.getSelectedItem().toString();
				String d4 = est.getText();	
				if(tipo==1) {			
				InserirDado bd = new InserirDado(c0,d1, d3, d4, d2);
				}else{
					AlteracaoDeDado ola = new AlteracaoDeDado(c0,original,d1, d3, d4, d2);
				}
				String atividade = "Filme adicionado";
				Salvo novo = new Salvo(atividade);
				toBack();
			}
		});
  
        pack();
        this.setLocationRelativeTo(null);
		setSize(400,200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
