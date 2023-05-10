import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buscar extends JFrame {
	public Buscar(String bd) {
		super("Pesquisar Filme");
		JTextField texto = new JTextField(15);
		JLabel titulo = new JLabel("Filme:");
        JButton cancelar = new JButton("Cancelar");
        JButton pesquisar = new JButton("Pesquisar");
        
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
		
        painel1.add(titulo,BorderLayout.WEST);
        painel1.add(texto,BorderLayout.EAST);
        
        painel2.add(cancelar,BorderLayout.WEST);
        painel2.add(pesquisar,BorderLayout.EAST);
        
        setLayout(new GridLayout(2,1));
        
        add(painel1);
        add(painel2);
        
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
        pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filme = texto.getText();
				ResultadoBusca novo = new ResultadoBusca(bd,filme);
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