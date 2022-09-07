package bot.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable{
	
	private String name;
	private Integer qtMessages;

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}
	
	public Person() {
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Object oldValue = this.name;
		this.name = name;
		changeSupport.firePropertyChange("name", oldValue, name);
	}

	public Integer getQtMessages() {
		return qtMessages;
	}

	public void setQtMessages(Integer qtMessages) {
		Object oldValue = this.qtMessages;
		this.qtMessages = qtMessages;
		changeSupport.firePropertyChange("qtMessages", oldValue, qtMessages);
	}
}
