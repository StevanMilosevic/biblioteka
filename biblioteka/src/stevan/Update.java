package stevan;

import java.sql.*;

public class Update {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String username = "root";
		String password = "";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			if (conn != null)
				System.out.println("Uspostavljena je konekcija ka bazi!");
			else
				System.out.println("Nije uspostavljena konekcija sa bazom");

			String sqlUpdate = "UPDATE clanovi SET ime = ?, prezime = ?, dat_rodj = ?, ulica = ?, broj = ?, telefon = ? WHERE clan_karta_id = ?";

			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, "Mika");
			ps.setString(2, "Mikic");
			ps.setDate(3, java.sql.Date.valueOf("1986-09-04"));
			ps.setString(4, "Cvijiceva");
			ps.setInt(5, 3);
			ps.setString(6, "0656513214");
			ps.setInt(7, 1);
			

			int numRows = ps.executeUpdate();

			if (numRows > 0)
				System.out.println("Uspesno je izvrsen UPDATE korisnika");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
