package bot.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	private String driverPath;
	private Integer daysBefore;
	
	public Login() {
	}

	public Login(String user, String password, String driverPath) {
		super();
		this.user = user;
		this.password = password;
		this.driverPath = driverPath;
	}
	
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener l) {
		changeSupport.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changeSupport.removePropertyChangeListener(l);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		Object oldValue = this.user;
		this.user = user;
		changeSupport.firePropertyChange("user", oldValue, user);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Object oldValue = this.password;
		this.password = password;
		changeSupport.firePropertyChange("password", oldValue, password);

	}

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		Object oldValue = this.driverPath;
		this.driverPath = driverPath;
		changeSupport.firePropertyChange("driverPath", oldValue, driverPath);

	}

	public PropertyChangeSupport getChangeSupport() {
		return changeSupport;
	}
	
	public String toFormatedString() {
		return getUser() + "," + getPassword() + "," + getDriverPath();
	}

	public Integer getDaysBefore() {
		return daysBefore;
	}

	public void setDaysBefore(Integer daysBefore) {
		Object oldValue = this.daysBefore;
		this.daysBefore = daysBefore;
		changeSupport.firePropertyChange("daysBefore", oldValue, daysBefore);

	}


}
