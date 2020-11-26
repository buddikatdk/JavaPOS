import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import simple_pos.frmMain;

public class JDBCExample {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pos_db", "kasun", "12345")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                frmMain frm = new frmMain();
                frm.show();
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}