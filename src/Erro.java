import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Erro extends JFrame {
	public Erro(String atividade) {
		super("Ação!!!");
		JLabel titulo = new JLabel(atividade+" ERRO!!!");
        JButton ok = new JButton("Ok");
        
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
		
        painel1.add(titulo,BorderLayout.CENTER);
        painel2.add(ok,BorderLayout.CENTER);
        
        setLayout(new GridLayout(2,1));
        
        add(painel1);
        add(painel2);
  
        ok.addActionListener(new ActionListener() {
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
}

