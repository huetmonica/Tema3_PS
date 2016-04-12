package DL;

import java.sql.Connection;
import java.sql.DriverManager;

import Models.Angajat;

public class ConexiuneDAO {
	public Connection con;

	public Connection Conectare() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "tema";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();

			con = DriverManager.getConnection(url + dbName, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// deconecteaza de la baza de date
	public void DisConect() {

		try {
			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void addUser(Angajat ang) {
		String sb = null;
		try {
			// c.Conectare();
			java.sql.Statement st = con.createStatement();
			sb = ("INSERT INTO angajat");
			sb = sb + ("(nume,user,parola) ");
			sb = sb + ("VALUES ( ");
			sb = sb + ("  '" + ang.getNume() + "'");
			sb = sb + (", '" + ang.getUser() + "' ");
			sb = sb + (", '" + ang.getParola() + "' ");
			sb = sb + (")");

			st.executeUpdate(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
