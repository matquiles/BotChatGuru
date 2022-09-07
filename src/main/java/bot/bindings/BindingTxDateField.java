package bot.bindings;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jgoodies.binding.value.ValueModel;

@SuppressWarnings("serial")
public class BindingTxDateField extends BindingDateField{
	
	public BindingTxDateField(ValueModel model) {
		super(model);
		setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
	}	

	@Override
	protected Date convertStringToDate(String value) throws ParseException  {
		return dateFormat.parse(value);
	}

}
