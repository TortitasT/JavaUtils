package utils.databases;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This class is used to connect to a SQLite database.
 */
public class DatabaseSQLite implements Database {
  private Connection connection;

  public DatabaseSQLite(String path) {
    connect(path);
  }

  public ResultSet query(String query) throws SQLException {
    return this.connection.createStatement().executeQuery(query);
  }

  public void update(String query) throws SQLException {
    this.connection.createStatement().executeUpdate(query);
  }

  public Connection connection() {
    return connection;
  }

  public void connect(String url) {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection connection = null;

    try {
      connection = DriverManager.getConnection("jdbc:sqlite:" + url);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    if (connection == null) {
      throw new RuntimeException("Failed to connect to database.");
    }

    this.connection = connection;
  }

  public void disconnect() {
    try {
      this.connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void destroy() {
    try {
      String url = this.connection.getMetaData().getURL();

      String filename = url.substring(url.lastIndexOf(':') + 1);

      disconnect();

      new File(filename).delete();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
