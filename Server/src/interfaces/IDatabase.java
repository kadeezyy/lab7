package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabase {
    void connect();

    ResultSet executeQuery(String query) throws SQLException;

    default ResultSet executeQuery(String query, Object... arg) throws SQLException {
        for (int i = 0; i < arg.length; i++) {
            if (!(arg[i] instanceof String)) {
                continue;
            }
            arg[i] = arg[i].toString().replace("'", "''");
        }
        return executeQuery(String.format(query, arg));
    }

    ResultSet executeQueryStatement() throws SQLException;

    void setStatement(String sql);

    PreparedStatement getStatement();

    void disconnect();
}
