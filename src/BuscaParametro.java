import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BuscaParametro extends JFrame {
	public BuscaParametro(String bd) {
		super("Busca por Parâmetro");
		JTextField texto = new JTextField(15);
		JLabel titulo = new JLabel("Digite:");
		JLabel especifico = new JLabel("Parâmetro:");
		JComboBox<String> tipo = new JComboBox<String>();
        JButton cancelar = new JButton("Cancelar");
        JButton pesquisar = new JButton("Pesquisar");
        
        tipo.setPreferredSize(new Dimension(180, 20));
        
        tipo.addItem("Genêro");
        tipo.addItem("Estudio");
        tipo.addItem("Ano");

        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        
        painel1.add(especifico,BorderLayout.WEST);
        painel1.add(tipo,BorderLayout.EAST);
        
        painel2.add(titulo,BorderLayout.WEST);
        painel2.add(texto,BorderLayout.EAST);
        
        painel3.add(cancelar,BorderLayout.WEST);
        painel3.add(pesquisar,BorderLayout.EAST);
        
        
        setLayout(new GridLayout(3,1));
        
        add(painel1);
        add(painel2);
        add(painel3);
        
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
        pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tipo.getSelectedIndex();
				String inf = texto.getText();
				ListarBusca novo = new ListarBusca(bd, inf, i);
			}
		});
        
        pack();
        this.setLocationRelativeTo(null);
		setSize(300,200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
