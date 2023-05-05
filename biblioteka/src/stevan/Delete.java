package stevan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteka";
        String username = "root";
        String password = "";

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("Konektovani smo na bazu");

            String sqlDelete = "DELETE FROM clanovi WHERE clan_karta_id = ?";

            PreparedStatement ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, 3);

            int obrisanPodatak = ps.executeUpdate();

            if(obrisanPodatak > 0)
                System.out.println("Podatak je uspesno izbrisan!");
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

}
