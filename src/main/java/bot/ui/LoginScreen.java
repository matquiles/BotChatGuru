package bot.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import bot.bindings.BindingPasswordField;
import bot.bindings.BindingTextField;
import bot.connection.Connection;
import bot.entities.Login;
import bot.ui.components.ExportLoginData;
import bot.ui.components.FileChooser;

public class LoginScreen extends Form implements DefaultForm{

	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame();
	PresentationModel<Login> model;

	private BindingTextField txLogin;
	private BindingPasswordField txPassword;
	private JButton btnOk;

	private BindingTextField txDriverPath;
	private JButton btSelectPath;
	
	private ExportLoginData savedLoginCheck;

	public LoginScreen(String title, int x, int y) {
		super(title, x, y);
		frame = super.getFrame();
		
		initModels();
		initComponents();
		initLayout();
		
		model.setBean(savedLoginCheck.checkSavedFile());
		
	}

	public void initModels() {
		model = new PresentationModel<Login>();
		model.setBean(new Login());
		
		savedLoginCheck = new ExportLoginData();

	}

	public void initComponents() {
		txLogin = new BindingTextField(model.getModel("user"), true);
		txPassword = new BindingPasswordField(model.getModel("password"), true);
		
		txDriverPath = new BindingTextField(model.getModel("driverPath"), true);
		txDriverPath.setEditable(false);
		btSelectPath = new JButton("Buscar");
		btSelectPath.addActionListener(act -> {
			FileChooser fileChooser = new FileChooser();
			String filePath = fileChooser.selectFile(frame);
			model.getBean().setDriverPath(filePath);
		});
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(act -> {
			Connection connection = new Connection();
			try {
				savedLoginCheck.saveLoginData(model.getBean());
				connection.connect(model.getBean());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}

	public void initLayout() {
		FormLayout layout = new FormLayout("pref, 5px, 60dlu, 5px, 70dlu, 5px, 50dlu");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.border(new EmptyBorder(5, 5, 5, 5));

		builder.appendRow("18dlu");
		builder.append("Login: ", txLogin, builder.getColumnCount()-2);
		builder.append("Password: ", txPassword, builder.getColumnCount()-2);
		builder.nextLine();
		builder.append("Caminho Driver", txDriverPath, builder.getColumnCount()-4);
		builder.append(btSelectPath);
		//gambiarra
		builder.append("");
		builder.append("");
		builder.append("");
		builder.append("");
		builder.append("");
		builder.append("");
		builder.append(btnOk);

		frame.add(builder.getPanel(),  BorderLayout.CENTER);
		frame.validate();
	}
}
