
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Excluir extends JFrame {
	String bd;
	public Excluir() {
		super("Excluir Banco de Dados");
		JComboBox<String> texto = new JComboBox<String>();
		JLabel titulo = new JLabel("Nome:");
        JButton cancelar = new JButton("Cancelar");
        JButton ok = new JButton("Ok");
        RandomAccessFile test;
        String linha;        
        char inf[];
        
        try {                
            test = new RandomAccessFile("Registro.txt","rw");                           
            linha = test.readLine();                            
            while(linha!=null)
            {            	            	                       
                inf = new char[linha.length()];
                inf = linha.toCharArray();                               
                linha = "";
                
                for (int i = 0; i < 40; i++) 
                {
					  if(inf[i]==' ')
					  {
						  if((i+1)<40)
						  {
							  if(inf[(i+1)]==' ')
							  {
								  break;
							  }
							  else
							  {
								  linha=linha+inf[i];
							  }
						  }
						  else
						  {
							  break;
						  }
					  }
					  else
					  {
						  linha = linha+inf[i];
					  }
				}                                
                
                if(linha.length()!=0)
                {
                	texto.addItem(linha);
                } 
                
                linha = test.readLine();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(LerRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        texto.setPreferredSize(new Dimension(130, 20));
        
        
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
		
        painel1.add(titulo,BorderLayout.WEST);
        painel1.add(texto,BorderLayout.EAST);
        
        painel2.add(cancelar,BorderLayout.WEST);
        painel2.add(ok,BorderLayout.EAST);
        
        setLayout(new GridLayout(2,1));
        
        add(painel1);
        add(painel2);
        
        
         ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd = texto.getSelectedItem().toString();
				ExcluirBancoDeDados apagar = new ExcluirBancoDeDados(bd);
				String atividade = "Excluido";
				Salvo novo = new Salvo(atividade);
				toBack();
			}
		});
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
       
     
        pack();
        this.setLocationRelativeTo(null);
		setSize(300,100);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	public static void main(String[] args) {
		Excluir janela = new Excluir();
	}
}