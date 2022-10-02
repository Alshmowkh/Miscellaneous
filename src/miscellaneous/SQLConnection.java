package miscellaneous;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

    void connection() throws SQLException, ClassNotFoundException {
        Connection conn;
        String db = "./Shom_lib/data2.mdf";
        pl(new File(db).exists());
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://ALshmowkh_Lab\\Alshmowkh_SQL;databaseName=data2;username='root';passowrd=''";
        String url2 = "jdbc:sqlserver://ALSHMOWKH-LAP\\ALSHMOWKH_SQL;databaseName=data2;";
        String url3 = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=data2";
//String DB_URL = "jdbc:mysql://localhost/EMP";
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(url);
        pl("connected");
    }

    void connection2() throws ClassNotFoundException, SQLException {
        String db = "./Shom_lib/data2.mdf";
        pl(new File(db).exists());
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String dbURL = "jdbc:sqlserver://ALSHMOWKH-LAP\\ALSHMOWKH_SQL;databaseName=" + db + ";user=bakee;passowrd='958575'";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
            System.out.println("Connected");
        }
    }

    void createSQLDB() throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/EMP";
        DB_URL = "jdbc:sqlserver://ALSHMOWKH-LAP//data2";

//        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection conn = null;
        Statement stmt = null;
        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SQLConnection cls = new SQLConnection();
//        cls.connection2();
        cls.createSQLDB();
    }

    static void pl(Object o) {
        System.out.println(o);
    }
}
