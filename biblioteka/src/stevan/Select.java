package stevan;

import java.sql.*;

public class Select {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("Uspesno je uspostavljena konekcija ka bazi!");

			String sqlSelect = "SELECT * FROM clanovi";

			// objekat za komunikaciju sa bazom
			Statement stmt = conn.createStatement();
			// izvrsavanje (namena)
			ResultSet result = stmt.executeQuery(sqlSelect);

			while (result.next()) {
				int brClanske = result.getInt(1);
				String ime = result.getString(2);
				String prezime = result.getString(3);
				String ulica = result.getString(5);
				String broj = result.getString(6);
				String telefon = result.getString(7);
				Date datum = result.getDate(4);

				StringBuilder builder = new StringBuilder();
				builder.append("Broj clanske karte: ").append(brClanske);
				builder.append("\nClan: ").append(ime).append(" " + prezime);
				builder.append("\nUlica: ").append(ulica).append(" " + broj);
				builder.append("\nTelefon: ").append(telefon);
				builder.append("\nDatum rodjenja: ").append(datum);

				System.out.println(builder.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
