package bot.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Form extends JFrame {

	
	JFrame frame = new JFrame();
	
	private JPanel panel;
	private JMenuBar menuBar;
	private String title;
	private String identifier;
	
	public Logger logger = Logger.getLogger(this.getClass().getName());

	public Form() {
	}
	
	public Form(String title, int x, int y) {
		setTitle(title);
		setParameters(x, y);
		setBarraMenu();
		setIcone();
	}

	
	public JFrame getFrame() {
		if(frame == null) {
			frame = new JFrame();
		}
		return frame;
	}
	
	public JPanel getPanel() {
		if(panel == null) {
			panel = new JPanel();
		}
		return panel;
	}
	
	
	public void setParameters(int x, int y) {
		frame.setTitle(getTitle());
		frame.setSize(x, y);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		frame.setVisible(true);
	}
	
	
	public void setBarraMenu() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Criado por MM Softwares \n Versao 1.0"));
		menuArquivo.add(menuSobre);

		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(evt -> frame.dispose());
		menuArquivo.add(menuSair);
		
	}
	
	public void setIcone() {
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\img\\robo.png"));
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public JMenuBar getBarraMenu() {
		return menuBar;
	}



}
