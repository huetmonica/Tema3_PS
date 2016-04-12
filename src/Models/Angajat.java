package Models;

public class Angajat {
	private String nume;
	private String user;
	private String parola;
	private String cnp;

	public Angajat(String nume, String user, String parola, String cnp) {
		this.nume = nume;
		this.user = user;
		this.parola = parola;
		this.cnp = cnp;
	}

	public String getNume() {
		return this.nume;
	}

	public String getUser() {
		return this.user;
	}

	public String getCnp() {
		return this.cnp;
	}

	public String getParola() {
		return this.parola;
	}

	public void setParola(String parolan) {
		this.parola = parolan;
	}

	public void setCnp(String cnpp) {
		this.cnp = cnpp;
	}

	public String toString() {
		return ("Nume=" + this.nume + "\n User = " + this.user + "\n Parola= " + this.parola);
	}
}
