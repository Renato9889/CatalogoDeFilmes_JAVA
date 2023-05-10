import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TipoBusca extends JFrame {
	public TipoBusca(String banco) {
		super("Tipo de Busca");
        JButton parametro = new JButton("Busca por Parâmetro");
        JButton busca = new JButton("Buscar Filme Especifico");
     
        JPanel painel1 = new JPanel();
        
        painel1.add(parametro,BorderLayout.WEST);
        painel1.add(busca,BorderLayout.EAST);
       
        setLayout(new GridLayout(1,1));
        
        add(painel1);
      
        busca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar novo = new Buscar(banco);
				toBack();
			}
		});
        parametro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaParametro novo = new BuscaParametro(banco);
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
}
