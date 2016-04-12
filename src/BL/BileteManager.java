package BL;

import DL.BileteDAO;

import DL.SpectacolDAO;
import Models.Bilet;


import java.lang.*;
import java.util.ArrayList;

public class BileteManager {
	private String Spectacol;
	private String rand;
	private String numar;
	private int rd;
	private int nr;
	private int valid = -1;

	public BileteManager(String Spectacol, String rand, String numar) {
		this.Spectacol = Spectacol;
		this.rand = rand;
		this.numar = numar;
	}

	public void AdaugaBilete() {
		rd = Integer.parseInt(rand);
		nr = Integer.parseInt(numar);
		SpectacolDAO sp = new SpectacolDAO();
		valid = sp.VerificaSpectacol(Spectacol);
		if (valid == 1) {
			Bilet bl = new Bilet(Spectacol, rd, nr);
			BileteDAO bil = new BileteDAO();
		int	val= bil.VerificaBilet(bl);
		
		if (val==0)
			{
			bil.addBilet(bl);
			sp.UpdateSpectacol(Spectacol, 1);
			}
		}

	}

	public ArrayList<Bilet> getBilete() {
		ArrayList list = new ArrayList();
		BileteDAO bil = new BileteDAO();
		list = bil.getBilet();
		return list;
	}
	
}
