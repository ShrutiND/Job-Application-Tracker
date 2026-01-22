import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("✅ Connected to MySQL successfully!");
        } else {
            System.out.println("❌ Connection failed.");
        }
    }
}
