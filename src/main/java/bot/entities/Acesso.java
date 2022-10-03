package bot.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Acesso implements Serializable{
	
	private String name;
	private String dispositivo;
	private String ip;
	private String dataAcesso;
	private String visto;
	private String tempoTotal;

	
	public Acesso(String name, String dispositivo, String ip, String dataAcesso, String visto, String tempoTotal) {
		this.name = name;
		this.dispositivo = dispositivo;
		this.ip = ip;
		this.dataAcesso = dataAcesso;
		this.visto = visto;
		this.tempoTotal = tempoTotal;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(String dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public String getVisto() {
		return visto;
	}

	public void setVisto(String visto) {
		this.visto = visto;
	}

	public String getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}


}
