package bot.bindings;
import javax.swing.JTextField;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.AbstractValueModel;

@SuppressWarnings("serial")
public class BindingTextField extends JTextField {

	public BindingTextField(AbstractValueModel model, boolean commitOnFocusLost) {
		super();
		Bindings.bind(this, model, commitOnFocusLost);
	}
	
}
