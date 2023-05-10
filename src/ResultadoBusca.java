import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class ResultadoBusca extends JFrame {
	String d0;
	String d1;
	String d2;
	String d3;
	public ResultadoBusca(String banco, String nome) {
		super("Busca");
		 RandomAccessFile test;
		    String linha;
		    String lista[] = new String[4];		    
		    	int achado = 0;		        
		        try {
		            
		            test = new RandomAccessFile(banco, "rw");
		                        
		            linha = test.readLine();		            
		            
		            while(linha!=null)
		            {
		                
		                lista = linha.split(":");
		                if(nome.compareTo(lista[0])==0)
		                {		                	
		                	achado=1;
		                	break;
		                }
		                linha = test.readLine();
		            }
		                        
		        } catch (IOException ex) {
		            Logger.getLogger(BuscaSParametro.class.getName()).log(Level.SEVERE, null, ex);
		        }
		
		 JLabel titulo = new JLabel("Filme: ");
		 JLabel ano = new JLabel("Ano: ");
		 JLabel studio = new JLabel("Estudio: ");
		 JLabel genero = new JLabel("Genero: ");
		 
		 if(achado==1) 
		 {
			 	titulo.setText(titulo.getText()+lista[0]);
				ano.setText(ano.getText()+lista[3]);
				studio.setText(studio.getText()+lista[2]);
				genero.setText(genero.getText()+lista[1]);
				this.d0 = lista[0];
				this.d1 = lista[1];
				this.d2 = lista[2];
				this.d3 = lista[3];
		 }
		 else 
		 {
			 	titulo.setText(titulo.getText()+"Not Found");
				ano.setText(ano.getText()+"Not Found");
				studio.setText(studio.getText()+"Not Found");
				genero.setText(genero.getText()+"Not Found");
		 }
		 	
		
        JButton excluir = new JButton("Excluir");
        JButton editar = new JButton("Editar");
        
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JPanel painel4 = new JPanel();
        JPanel painel5 = new JPanel();
        JPanel painel6 = new JPanel();
		
        painel1.add(titulo,BorderLayout.CENTER);
        painel2.add(ano,BorderLayout.CENTER);
        painel3.add(genero,BorderLayout.CENTER);
        painel4.add(studio,BorderLayout.CENTER);
        painel5.add(excluir,BorderLayout.WEST);
        painel6.add(editar,BorderLayout.EAST);
        
        setLayout(new GridLayout(3,2));
        
        add(painel1);
        add(painel2);
        add(painel3);
        add(painel4);
        add(painel5);
        add(painel6);
        
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirDado jaera = new ExcluirDado(banco,nome);
				String atividade = "Excluido";
				Salvo novo1 = new Salvo(atividade);
				toBack();
			}
		});
        editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar add = new Adicionar(banco,d0,d2,d1,d3,0);
				toBack();
			}
		});
       
        pack();
        this.setLocationRelativeTo(null);
		setSize(400,200);
		setResizable(false);
		setVisible(true);
	}
}
