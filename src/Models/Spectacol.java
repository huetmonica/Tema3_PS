package Models;

public class Spectacol {
	private String titlu;
	private String regia;
	private String distributia;
	private String data;
	private int nrbilete;

	public Spectacol(String titlu, String regia, String distributia,
			String data, int nrbilete) {
		this.titlu = titlu;
		this.regia = regia;
		this.distributia = distributia;
		this.data = data;
		this.nrbilete = nrbilete;
	}

	public String getTitlu() {
		return this.titlu;
	}

	public String getRegia() {
		return this.regia;

	}

	public String getDistributia() {
		return this.distributia;

	}

	public String getData() {
		return this.data;
	}

	public int getNrbilete() {
		return this.nrbilete;
	}

	public int setNrbilete(int nr) {
		return this.nrbilete = this.nrbilete - nr;
	}

	public String toString() {
		return ("Titlu:" + this.titlu + "; Regia: " + this.regia
				+ "; Distributia: " + this.distributia + "; Data:" + this.data
				+ "; Nrbilete: " + this.nrbilete);
	}
}
