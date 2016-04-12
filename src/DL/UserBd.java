package DL;

import Models.Angajat;

import java.sql.Connection;

public class UserBd {
	ConexiuneDAO c = new ConexiuneDAO();
	public Connection con;

	public void addUser(Angajat ang) {
		String sb = null;
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO angajat");
			sb = sb + ("(nume,user,parola,cnp) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + ang.getNume() + "'");
			sb = sb + (", '" + ang.getUser() + "' ");
			sb = sb + (", '" + ang.getParola() + "' ");
			sb = sb + (", '" + ang.getCnp() + "' ");
			sb = sb + (")");

			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Angajat getAngajat() {
		Angajat ang = null;

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM angajat");

			while (res.next()) {
				String nume = res.getString("nume");
				String user = res.getString("user");
				String parola = res.getString("parola");
				String cnp = res.getString("cnp");
				ang = new Angajat(nume, user, parola, cnp);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return ang;
	}

	public int VerificaUser(String n, String u, String p) {

		int verificare = -1;

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM angajat");

			while (res.next()) {
				String nume = res.getString("nume");
				String user = res.getString("user");
				String parola = res.getString("parola");
				int a1 = n.compareTo(nume);
				int b1 = u.compareTo(user);
				int c1 = p.compareTo(parola);
				if (((a1 == b1) && (a1 == 0)) == true) {
					if (c1 == 0)
						verificare = 1;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return verificare;
	}

	public int VerificaCnp(String n, String u, String cnp) {

		int verificare = -1;

		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();
			java.sql.ResultSet res = st.executeQuery("SELECT * FROM angajat");

			while (res.next()) {
				String nume = res.getString("nume");
				String user = res.getString("user");
				String cnpp = res.getString("cnp");
				int a1 = n.compareTo(nume);
				int b1 = u.compareTo(user);
				int c1 = cnp.compareTo(cnpp);
				if (((a1 == b1) && (a1 == 0)) == true) {
					if (c1 == 0)
						verificare = 1;

				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return verificare;
	}

	public void UpdateUser(String nume, String parola) {
		try {
			con = c.Conectare();
			java.sql.Statement st = con.createStatement();

			String sql = "UPDATE angajat SET parola= '" + parola + "'"
					+ " WHERE nume = '" + nume + "'";

			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
