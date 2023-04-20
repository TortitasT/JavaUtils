package utils.databases;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;

import org.junit.Test;

public class DatabaseSQLiteTest {
  @Test
  public void testFunctional() {
    DatabaseSQLite db = new DatabaseSQLite("test.sqlite");

    try {
      db.update("CREATE TABLE IF NOT EXISTS test (id INTEGER PRIMARY KEY, name TEXT)");
      db.update("INSERT INTO test (name) VALUES ('test')");

      ResultSet results = db.query("SELECT * FROM test");

      assertTrue(results.next());
      assertTrue(results.getInt("id") == 1);
      assertTrue(results.getString("name").equals("test"));
    } catch (Exception e) {
      e.printStackTrace();
    }

    db.destroy();
  }
}
