package bot.bindings;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.text.ParseException;

import com.jgoodies.binding.value.ValueModel;

@SuppressWarnings("serial")
public class BindingDoubleField extends BindingNumberField{
	
	public BindingDoubleField(ValueModel model, NumberFormat numberFormat) {
		super(model);
		
		setNumberFormat(numberFormat);
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				refreshView();
			}
		});
	}
	
	@Override
	protected Number convertStringToNumber(String value) throws ParseException {
		return getNumberFormat().parse(value).doubleValue();
	}

}
