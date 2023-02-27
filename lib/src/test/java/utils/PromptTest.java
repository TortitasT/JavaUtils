package utils;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PromptTest {
  // MOCK SCANNER
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }
  // END MOCK SCANNER

  @Test
  public void testGetBoolean() {
    setInputStream("y");

    String message = "Get boolean test";

    boolean response = Prompt.getBoolean(message);

    assertTrue("The message should be printed",
        outContent.toString().contains(message));

    assertTrue("The prompt should be printed", outContent.toString().contains(Prompt.PROMPT));

    assertTrue("The response should be true", response);
  }

  @Test
  public void testGetDouble() {
    String message = String.valueOf(Double.MAX_VALUE);

    setInputStream(message);

    Double response = Prompt.getDouble(message);

    assertTrue("The message should be printed",
        outContent.toString().contains(message));

    assertTrue("The prompt should be printed", outContent.toString().contains(Prompt.PROMPT));

    assertTrue("The response should equal the message", response == Double.MAX_VALUE);
  }

  @Test
  public void testGetFloat() {
    String message = String.valueOf(Float.MAX_VALUE);

    setInputStream(message);

    float response = Prompt.getFloat(message);

    assertTrue("The message should be printed",
        outContent.toString().contains(message));

    assertTrue("The prompt should be printed", outContent.toString().contains(Prompt.PROMPT));

    assertTrue("The response should equal 1", response == Float.MAX_VALUE);
  }

  @Test
  public void testGetInt() {
    String message = "1";

    setInputStream(message);

    int response = Prompt.getInt(message);

    assertTrue("The message should be printed",
        outContent.toString().contains(message));

    assertTrue("The prompt should be printed", outContent.toString().contains(Prompt.PROMPT));

    assertTrue("The response should equal 1", response == 1);
  }

  @Test
  public void testGetString() {
    String message = "Get string test";

    setInputStream(message);

    String response = Prompt.getString(message);

    assertTrue("The message should be printed",
        outContent.toString().contains(message));

    assertTrue("The prompt should be printed", outContent.toString().contains(Prompt.PROMPT));

    assertTrue("The response should equal the message", response.equals(message));
  }

  private void setInputStream(String input) {
    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
  }
}
