package DL;

import java.util.ArrayList;

import Models.Spectacol;
import java.sql.Connection;

public class SpectacolDAO {
	ConexiuneDAO c = new ConexiuneDAO();
	private Connection con;

	public void addSpectacol(Spectacol spec) {
		String sb = null;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO spectacol");
			sb = sb + ("(titlu,regia,distributia, data, nrbilete) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + spec.getTitlu() + "'");
			sb = sb + (", '" + spec.getRegia() + "' ");
			sb = sb + (", '" + spec.getDistributia() + "' ");
			sb = sb + (", '" + spec.getData() + "' ");
			sb = sb + (", '" + spec.getNrbilete() + "'");
			sb = sb + (")");
			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Spectacol> getSpectacol() {
		Spectacol spec = null;
		ArrayList<Spectacol> list = new ArrayList<Spectacol>();
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM spectacol");

			while (res.next()) {
				String titlu = res.getString("titlu");
				String regia = res.getString("regia");
				String distributia = res.getString("distributia");
				String data = res.getString("data");
				int nrbilete = res.getInt("nrbilete");
				spec = new Spectacol(titlu, regia, distributia, data, nrbilete);
				list.add(spec);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void UpdateSpectacol(String spec, int nrb) {
		try {
			con = c.Conectare();
			int aux = -1;
			java.sql.Statement st = con.createStatement();

			java.sql.ResultSet res = st.executeQuery("SELECT * FROM spectacol");
			// int nb=spec.setNrbilete(nrb);
			while (res.next()) {
				String titlu = res.getString("titlu");
				int nrbilete = res.getInt("nrbilete");
				if (spec.compareTo(titlu) == 0) {
					aux = nrbilete - 1;
				}
			}
			String sql = "UPDATE spectacol SET nrbilete=" + aux
					+ " WHERE titlu = '" + spec + "'";
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int VerificaSpectacol(String spec) {

		int valid = -1;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM spectacol");

			while (res.next()) {
				String titlu = res.getString("titlu");
				int nrbilete = res.getInt("nrbilete");
				if (spec.compareTo(titlu) == 0) {
					if (nrbilete >= 1) {
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
