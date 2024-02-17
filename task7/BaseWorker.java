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
    
    public static void printData(ResultSet data){
        try{
        DBTablePrinter.printResultSet(data);
        } catch (Exception e){
            System.out.println(false);
        }
    }

    public static void executeQuiery(Connection con, String quiery) throws SQLException {
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(quiery);
        printData(rs);
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
        
        final String firstQuiery = """
            SELECT * FROM 
                public.employeesAge
            WHERE 
                employeesAge.age > 20 
            LIMIT 10;
                """;

        final String secondQuiery = """
            SELECT departmentname, round(AVG(salary), 2)::real as "Average salary" FROM 
                public.departmentsalary
            GROUP BY departmentname;
                """;

        final String thirdQuiery = """
            SELECT public.departmentemployee.employeename, 
                    public.departmentlocation.departmentname, 
                    public.departmentlocation.location
            FROM 
                public.departmentemployee
            INNER JOIN
                public.departmentlocation
            ON 
                public.departmentemployee.departmentid = public.departmentlocation.id
            LIMIT 100;
                """;

        try {
            BaseWorker.executeQuiery(connection, firstQuiery);
            BaseWorker.executeQuiery(connection, secondQuiery);
            BaseWorker.executeQuiery(connection, thirdQuiery);
            connection.close();
        } catch (SQLException e) {
        }
        
    }

}
