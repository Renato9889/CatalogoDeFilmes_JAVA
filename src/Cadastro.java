import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Cadastro extends JFrame {
	public Cadastro() {
		super("Catalogo de filmes");
        JButton cadastrar = new JButton("Cadastrar um banco de dados");
        JButton adicionar = new JButton("Adicionar filme em um banco de dados");
        JButton buscar = new JButton("Buscar");
        JButton excluir = new JButton("Excluir um banco de dados");
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JPanel painel4 = new JPanel();
       
       
        
        painel1.add(cadastrar, BorderLayout.CENTER);
        painel2.add(adicionar,BorderLayout.CENTER);
        
        painel4.add(buscar,BorderLayout.CENTER);
        painel3.add(excluir,BorderLayout.CENTER);
        
        setLayout(new GridLayout(4,1));
        
        add(painel1);
        add(painel3);
        add(painel2);
        add(painel4);
        
        cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Novo novo = new Novo();
			}
		});
        adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectBanco novo = new SelectBanco();
			}
		});
        buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectBancoPesquisa novo = new SelectBancoPesquisa();
			}
		});
        excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excluir novo = new Excluir();
			}
		});
        
        pack();
        this.setLocationRelativeTo(null);
		setSize(400,200);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Cadastro janela = new Cadastro();		
	}
}
