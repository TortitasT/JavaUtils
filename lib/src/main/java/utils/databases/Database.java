package utils.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {
  ResultSet query(String query) throws SQLException;

  void update(String query) throws SQLException;

  Connection connection();

  void connect(String url);

  void disconnect();
}
