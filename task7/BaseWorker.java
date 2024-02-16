package task7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseWorker {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "password";

    public static Connection makeConnection() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            return null;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return null;
        }

        System.out.println("You successfully connected to database now");
        return connection;

    }

    public static void select(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departmentEmployee LIMIT 10;");

        while (rs.next()) {
            // String str =
            for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {

                System.out.printf("%-20s", rs.getString(i));
            }
        }
        rs.close();
        stmt.close();
    }

    public static void main(String[] argv) {

        Connection connection = makeConnection();
        if (connection == null) {
            return;
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
        }
        try {
            BaseWorker.select(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Success!!");
    }

}
