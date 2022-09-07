package bot.bindings;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.ValueModel;

@SuppressWarnings("serial")
public class BindingCheckBox extends JCheckBox {

	public BindingCheckBox(ValueModel model) {
		super();
		Bindings.bind(this, model);
	}
	
}
