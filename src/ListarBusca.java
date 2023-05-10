import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListarBusca extends JFrame {
	public ListarBusca(String banco, String busca, int tipo) {
		super("Tabela");
		JFrame janela = new JFrame();
		JPanel painel = new JPanel();
		painel.setPreferredSize(new Dimension(500,400));
		painel.setLayout(null);
		add(painel);

		String filme = new String();
		String ano = new String();
		String estudio = new String();
		String genero = new String();
		tipo = tipo+1;
		
		
		JTable tabela = new JTable() {
			public boolean isCellEditable(int row, int column) { 
	            return false;  
	        }
		};
		
		DefaultTableModel modelo = new DefaultTableModel();
		tabela.setModel(modelo);
		modelo.addColumn("Filme");
		modelo.addColumn("Ano");
		modelo.addColumn("Gênero");
		modelo.addColumn("Estudio");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(200);  
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);  
		tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		 
	    RandomAccessFile test;
	    String linha;
	    String lista[] = new String[4];
	    char procura[],achado[];
	        procura = new char[busca.length()];
	        procura = busca.toCharArray();
	        try {
	            test = new RandomAccessFile(banco, "rw");
	                      
	            
	                    linha=test.readLine();
	                    while(linha!=null)
	                    {                                              
	                        lista = linha.split(":");
	                        achado = new char[lista[tipo].length()];
	                        achado = lista[tipo].toCharArray();
	                        int j = 0;
	                        for (int i = 0; i < achado.length; i++) {
	                            
	                            if(procura[j]==achado[i])
	                            {
	                                j++;
	                            }
	                            else
	                            {
	                                j=0;
	                            }
	                            if(j==(procura.length))
	                            {
	                            	filme = lista[0]; 
			                    	ano = lista[3];
			           		     	genero = lista[1];
			           		     	estudio = lista[2];
			           		     	modelo.addRow(new Object[]{filme,ano,genero,estudio});
			                        break;
	                            }
	                        }
	                        linha=test.readLine();
	                    }
	              
	        } catch (IOException ex) {
	            Logger.getLogger(BuscaCParametro.class.getName()).log(Level.SEVERE, null, ex);
	        }
	
	        					
		
		tabela.getTableHeader().setReorderingAllowed(false);
		JScrollPane n = new JScrollPane(tabela);
		n.setBounds(0, 0, 490, 300);
		painel.add(n);
		pack();
        this.setLocationRelativeTo(null);
		setSize(500,300);
		setResizable(false);
		setVisible(true);
		}
		 
}

