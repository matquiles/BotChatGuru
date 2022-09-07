package bot.bindings;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JTextField;

import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

@SuppressWarnings("serial")
public abstract class BindingNumberField extends BindingTextField{

	protected ValueHolder valueHolder;
	protected ValueModel valueModel;
	
	protected boolean listening;
	
	protected NumberFormat numberFormat;
	
	public BindingNumberField(ValueModel model) {
		this(model, new ValueHolder());
	}
	
	private BindingNumberField(ValueModel model, ValueHolder valueHolder) {
		super(valueHolder, true);
		this.valueModel = model;
		this.valueHolder = valueHolder;
		
		setHorizontalAlignment(JTextField.RIGHT);
		
		initListeners();
		
		listening = true;
	}

	private void initListeners() {
		valueHolder.addValueChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (!listening) return;
				listening = false;
				String value = (String) valueHolder.getValue();
				try {
					Number result = (value == null || value.length() == 0) ? null : convertStringToNumber(value);
					valueModel.setValue(result);
				} catch (Exception e) {
					final String result = valueModel.getValue() == null ? null : getNumberFormat().format(valueModel.getValue());
					valueHolder.setValue(result);
				}
				listening = true;
			}

		});
		
		valueModel.addValueChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (!listening) return;
				listening = false;
				
				final String result = valueModel.getValue() == null ? null : getNumberFormat().format(valueModel.getValue());
				
				valueHolder.setValue(result);
				
				listening = true;
			}
		});
	}
	
	protected abstract Number convertStringToNumber(String value) throws ParseException;
	
	public void setNumberFormat(NumberFormat numberFormat) {
		this.numberFormat = numberFormat;
	}
	
	public NumberFormat getNumberFormat() {
		if (numberFormat == null){
			numberFormat = new DecimalFormat("#,##0");
		}
		return numberFormat;
	}
	
	public Number getModelValue(){
		return (Number) valueModel.getValue();
	}
	
	public void refreshView(){
		Number number = getModelValue();
		if (number == null){
			valueHolder.setValue(null);
		}else{
			valueHolder.setValue(getNumberFormat().format(number));
		}
	}

}
