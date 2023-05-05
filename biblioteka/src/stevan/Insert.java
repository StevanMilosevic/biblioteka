package stevan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteka";
        String username = "root";
        String password = "";

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("Uspostavljena je konekcija...");

            String sqlInset = "INSERT INTO clanovi(ime, prezime, dat_rodj, ulica, broj, telefon) VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sqlInset);
            ps.setString(1, "Pera");
            ps.setString(2, "Peric");
            ps.setDate(3, java.sql.Date.valueOf("1977-04-11"));
            ps.setString(4, "Cara Dusana");
            ps.setInt(5, 103);
            ps.setString(6, "0631230051");

            int unetPodatak = ps.executeUpdate();

            if(unetPodatak > 0)
                System.out.println("Podatak je upisan!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
