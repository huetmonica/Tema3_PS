package Models;

public class Bilet {
	private String spectacol;
	private int rand;
	private int numar;

	public Bilet(String spectacol, int rand, int numar) {
		this.rand = rand;
		this.spectacol = spectacol;
		this.numar = numar;
	}

	public String getSpectacol() {
		return this.spectacol;
	}

	public int getNumar() {
		return this.numar;
	}

	public int getRand() {
		return this.rand;
	}

	public String toString() {
		return ("Spectacol:" + this.spectacol + "; Rand: " + this.rand
				+ "; Numar: " + this.numar);
	}
}
