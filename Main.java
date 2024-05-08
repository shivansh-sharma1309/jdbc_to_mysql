import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Main {
        public static void main(String[] args) {
                String url = "jdbc:mysql://4d275b38-2eee-4b4d-8a88-cb022388e975.blijti4d0v0nkr55oei0.databases.appdomain.cloud:32661/TM_IBM_POWER_DB_1";
                String user = "Your username";
                String password = "Your password";

                try (Connection conn = DriverManager.getConnection(url,user,password)) {
                        System.out.println("Connected to the database!");
                        DatabaseMetaData metaData = conn.getMetaData();
                        String catalog = null ;
                        String schemaPattern = null;

                        ResultSet resultSet = metaData.getTables(catalog, schemaPattern, null, new String[] {"TABLE"});
                        while(resultSet.next()){
                                String tableName = resultSet.getString("TABLE_NAME");
                                System.out.println(tableName);
                        }
                } catch (SQLException e) {
                        System.err.println("Failed to connect to the database!");
                        e.printStackTrace();
                }
        }
}