package bot.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Person implements Serializable{
	
	private String name;
	private List<String> acessos;
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
		this.name = name;
		this.acessos = new ArrayList<>();
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

	public List<String> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<String> acessos) {
		Object oldValue = this.acessos;
		this.acessos = acessos;
		changeSupport.firePropertyChange("acessos", oldValue, acessos);
	}
	
	
}
