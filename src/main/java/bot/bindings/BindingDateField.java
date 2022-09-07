package bot.bindings;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;

@SuppressWarnings("serial")
public abstract class BindingDateField extends BindingTextField{

	protected ValueHolder valueHolder;
	protected ValueModel valueModel;
	
	protected boolean listening;
	
	protected SimpleDateFormat dateFormat;
	
	public BindingDateField(ValueModel model) {
		this(model, new ValueHolder());
	}
	
	private BindingDateField(ValueModel model, ValueHolder valueHolder) {
		super(valueHolder, true);
		this.valueModel = model;
		this.valueHolder = valueHolder;
		
		setHorizontalAlignment(JTextField.RIGHT);
		
		listening = true;
		
		valueModel.addValueChangeListener(evt -> refreshView());
	}


	protected abstract Date convertStringToDate(String value) throws ParseException;
	
	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = (SimpleDateFormat) dateFormat;
	}
	
	public DateFormat getNumberFormat() {
		if (dateFormat == null){
			dateFormat = new SimpleDateFormat("dd/MM/yyy");
		}
		return dateFormat;
	}
	
	public Date getModelValue(){
		return (Date) valueModel.getValue();
	}
	
	public void refreshView(){
		Date data = getModelValue();
		if (data == null){
			valueHolder.setValue(null);
		}else{
			valueHolder.setValue(getNumberFormat().format(data));
		}
	}


}
