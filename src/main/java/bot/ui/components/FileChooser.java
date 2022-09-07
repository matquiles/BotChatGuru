package bot.ui.components;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileChooser {
	
	
	public FileChooser() {
	}
	
	public String selectFile(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		
		int retorno = fileChooser.showOpenDialog(frame);

		if(retorno == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().getAbsolutePath();

		} else {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(frame, "Selecione um chromedriver", "Selecione um Chromedriver",
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			null, options, options[0]);
			return "";
		}

	}
	
}
