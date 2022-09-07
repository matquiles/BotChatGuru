package bot.enuns;

public enum OperationlSystem {
	
	WINDOWS(1, "Windows"),
	LINUX(2, "Linux");
	
	private final int value;
	private final String meaning;

	OperationlSystem(int i, String string) {
		this.value = i;
		this.meaning = string;
	}
	
	public int getValue() {
		return value;
	}

	public String getMeaning() {
		return meaning;
	}

	public String toString() {
		return meaning;
	}
	
}
