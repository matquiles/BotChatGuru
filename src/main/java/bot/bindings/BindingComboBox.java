package bot.bindings;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import com.jgoodies.binding.adapter.Bindings;

@SuppressWarnings("serial")
public class BindingComboBox extends JComboBox<Integer> {

	public BindingComboBox(JComboBox<Integer> comboBox, ComboBoxModel<Integer> model) {
		super();
		Bindings.bind(comboBox, model);
	}
	
}
