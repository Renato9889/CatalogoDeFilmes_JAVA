import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Novo extends JFrame {
	public Novo() {
		super("Novo banco de Dados");
		JTextField texto = new JTextField(15);
		JLabel titulo = new JLabel("Nome:");
        JButton cancelar = new JButton("Cancelar");
        JButton ok = new JButton("Ok");
        
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
		
        painel1.add(titulo,BorderLayout.WEST);
        painel1.add(texto,BorderLayout.EAST);
        
        painel2.add(cancelar,BorderLayout.WEST);
        painel2.add(ok,BorderLayout.EAST);
        
        setLayout(new GridLayout(2,1));
        
        add(painel1);
        add(painel2);
        
        cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
			}
		});
        ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = texto.getText();
				if(!nome.equals("")) {
				CriarBancoDeDados banco = new CriarBancoDeDados(nome);
				String atividade = "Cadastrado";
				Salvo novo = new Salvo(atividade);
				toBack();
				}else{
					String atividade = "Espaço vazio!!!";
					Erro alerta = new Erro(atividade);
					toBack();
				}
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

