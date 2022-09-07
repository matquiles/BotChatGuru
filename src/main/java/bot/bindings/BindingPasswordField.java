package bot.bindings;

import javax.swing.JPasswordField;

import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.value.AbstractValueModel;

@SuppressWarnings("serial")
public class BindingPasswordField extends JPasswordField{
	
	public BindingPasswordField(AbstractValueModel model, boolean commitOnFocusLost) {
		super();
		Bindings.bind(this, model, commitOnFocusLost);
	}

}
