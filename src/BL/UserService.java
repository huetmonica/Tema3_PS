package BL;

import DL.UserBd;
import Models.Angajat;
import java.util.Random;
public class UserService {

	public String user;
	public String name;
	public String pass;
    public String cnp;
	public UserService(String name, String user, String pass, String cnp) {
		this.user = user;
		this.name = name;
		this.pass = pass;
		this.cnp= cnp;
	}

	public int Verific() throws Exception {
		int valid = -1;
		int tip = 2;
		UserBd us = new UserBd();
		String parola = "";
		MD5Digest md = new MD5Digest();
		parola = md.Criptare(pass);

		valid = us.VerificaUser(name, user, parola);
		// daca e o exista in baza de date
		if (valid == 1) {
			if (user.compareTo("angajat") == 0) {
				tip = 1;
			}
			if (user.compareTo("admin") == 0) {
				tip = 0;
			}
		}
		return tip;
	}

	public void Ceeaza() throws Exception {
		String parola = "";
		UserBd ubd = new UserBd();
		MD5Digest md = new MD5Digest();
		parola = md.Criptare(pass);
		Angajat ang = new Angajat(name, user, parola,cnp);
		ubd.addUser(ang);
	}
	
  public String Reseteaza() throws Exception{
	  String parola = "";
	  String parol="";
	  int valid=-1;
		UserBd ubd = new UserBd();
		MD5Digest md = new MD5Digest();
		Random rand = new Random();
		valid=ubd.VerificaCnp(name, user, cnp);
		if (valid==1)
		{
        int  n = rand.nextInt(10000) + 1;
	    parola= String.valueOf(n);
	    parol = md.Criptare("parola");
	 //   Angajat ang=new Angajat (name,user,parol,cnp);
	    ubd.UpdateUser(name, parol);
	    }
	  return parola;
  }
}
