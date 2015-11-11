
public class Codes {
	private Code[] codes;
	
	/**
	 * This gives back an object with a maximum of 10 codes
	 */
	public Codes() {
		this.codes = new Code[10];
		for (int i = 0; i < codes.length; i++) {
			codes[i] = new Code();
		}
	}
	
	public void setACode(int numCode, byte[] code) {
		codes[numCode-1].setCode(code);
	}
	
	public byte[] getACode(int numCode) {
		return codes[numCode-1].getCode();
	}

}
