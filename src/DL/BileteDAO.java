package DL;

import java.util.*;
import java.sql.Connection;

import Models.Bilet;

public class BileteDAO {
	ConexiuneDAO c = new ConexiuneDAO();
	private Connection con;

	public void addBilet(Bilet biletul) {
		String sb = null;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO bilet");
			sb = sb + ("(spectacol,rand,numar) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + biletul.getSpectacol() + "'");
			sb = sb + (", '" + biletul.getRand() + "' ");
			sb = sb + (", '" + biletul.getNumar() + "' ");
			sb = sb + (")");
			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Bilet> getBilet() {
		Bilet bil = null;
		ArrayList<Bilet> list = new ArrayList<Bilet>();
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st
					.executeQuery("SELECT spectacol,rand,numar FROM bilet");

			while (res.next()) {
				String spec = res.getString("spectacol");
				int rand = res.getInt("rand");
				int numar = res.getInt("numar");
				bil = new Bilet(spec, rand, numar);
				list.add(bil);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public int VerificaBilet(Bilet bil) {

		int valid = 0;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM bilet");

			while (res.next()) {
				String spec = res.getString("spectacol");
				int rand = res.getInt("rand");
				int numar = res.getInt("numar");
				if (bil.getSpectacol().compareTo(spec) == 0) {
					if ((rand == bil.getRand() && numar == bil.getNumar()) == true) {
						valid = 1;
					
					}
				}
			
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;

	}

}
