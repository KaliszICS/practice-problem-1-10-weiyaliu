import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class PracticeProblemTest {

   // static class DelegatingInputStream extends InputStream {
   //    @Override
   //    public int read() throws IOException {
   //       return System.in.read();
   //    }
   //    @Override
   //    public int read(byte[] b, int off, int len) throws IOException {
   //       return System.in.read(b, off, len);
   //    }
   // }

   // @BeforeAll
   // public static void globalSetUp() throws Exception {
   //    Field scannerField = PracticeProblem.class.getDeclaredField("s");
   //    scannerField.setAccessible(true);
   //    scannerField.set(null, new Scanner(new DelegatingInputStream()));
   // }

   // -----------------------------------------------------------------------
   // q1 – checks whether the sentence contains "on" (returns true/false)
   // -----------------------------------------------------------------------

   @Test
   public void testQ1_1() {
      System.setIn(new ByteArrayInputStream("help me\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q1();
      assertEquals("Input a sentence: false\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ1_2() {
      System.setIn(new ByteArrayInputStream("on\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q1();
      assertEquals("Input a sentence: true\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ1_3() {
      System.setIn(new ByteArrayInputStream("Ontario\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q1();
      assertEquals("Input a sentence: false\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ1_4() {
      System.setIn(new ByteArrayInputStream("tron\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q1();
      assertEquals("Input a sentence: true\n", bos.toString());
      System.setOut(System.out);
   }

   // -----------------------------------------------------------------------
   // q2 – checks whether the word equals "mango" (case-insensitive)
   // -----------------------------------------------------------------------

   @Test
   public void testQ2_1() {
      System.setIn(new ByteArrayInputStream("not mango\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q2();
      assertEquals("Input the word mango: false\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ2_2() {
      System.setIn(new ByteArrayInputStream("mango\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q2();
      assertEquals("Input the word mango: true\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ2_3() {
      System.setIn(new ByteArrayInputStream("MANGO\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q2();
      assertEquals("Input the word mango: true\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ2_4() {
      System.setIn(new ByteArrayInputStream("MaNgO\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q2();
      assertEquals("Input the word mango: true\n", bos.toString());
      System.setOut(System.out);
   }

   // -----------------------------------------------------------------------
   // q3 – counts occurrences of a letter in a word (returns -1 if word or
   //       letter is invalid, i.e. word length != 1 check on letter)
   // -----------------------------------------------------------------------

   @Test
   public void testQ3_1() {
      // word="word", letter="l" -> -1 (letter not found or word invalid?)
      System.setIn(new ByteArrayInputStream("word\nl\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q3();
      assertEquals("Input a word: Input a letter: -1\n-1\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ3_2() {
      // word="Hello", letter="l" -> 2
      System.setIn(new ByteArrayInputStream("Hello\nl\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q3();
      assertEquals("Input a word: Input a letter: 2\n3\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ3_3() {
      // word="characteristic", letter="c" -> 0? (case-sensitive, no lowercase c... wait output is 0)
      System.setIn(new ByteArrayInputStream("characteristic\nc\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q3();
      assertEquals("Input a word: Input a letter: 0\n13\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ3_4() {
      // word="only one z", letter="z" -> 9
      System.setIn(new ByteArrayInputStream("only one z\nz\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q3();
      assertEquals("Input a word: Input a letter: 9\n9\n", bos.toString());
      System.setOut(System.out);
   }

   // -----------------------------------------------------------------------
   // q4 – counts characters in a sentence (some definition, e.g. trimmed length)
   // -----------------------------------------------------------------------

   @Test
   public void testQ4_1() {
      // "l" -> -1
      System.setIn(new ByteArrayInputStream("\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q4();
      assertEquals("Input a sentence: Your sentence is 0 characters long\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ4_2() {
      // "Help Me" -> 3 (number of words? or something else)
      System.setIn(new ByteArrayInputStream("Help Me\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q4();
      assertEquals("Input a sentence: Your sentence is 7 characters long\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ4_3() {
      // "c" -> 13
      System.setIn(new ByteArrayInputStream(".\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q4();
      assertEquals("Input a sentence: Your sentence is 1 characters long\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ4_4() {
      // "z" -> 9
      System.setIn(new ByteArrayInputStream("include period.\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q4();
      assertEquals("Input a sentence: Your sentence is 15 characters long\n", bos.toString());
      System.setOut(System.out);
   }

   // -----------------------------------------------------------------------
   // q5 – counts characters in a sentence (sentence length prompt)
   // -----------------------------------------------------------------------

   @Test
   public void testQ5_1() {
      // "nothing" -> 0 chars (trimmed? single word)
      System.setIn(new ByteArrayInputStream("Nothing was changed\nsomething\nanything\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q5();
      assertEquals("Input a sentence: Input a word to replace: What word would you like to replace it with: Nothing was changed\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ5_2() {
      // "Help Me" -> 7 chars
      System.setIn(new ByteArrayInputStream("There is one word to replace\nword\nhelp\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q5();
      assertEquals("Input a sentence: Input a word to replace: What word would you like to replace it with: There is one help to replace\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ5_3() {
      // "." -> 1 char
      System.setIn(new ByteArrayInputStream("replace all the e's in this sentence\ne\na\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q5();
      assertEquals("Input a sentence: Input a word to replace: What word would you like to replace it with: raplaca all tha a's in this santanca\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ5_4() {
      // "include period." -> 15 chars
      System.setIn(new ByteArrayInputStream("a\na\nb\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q5();
      assertEquals("Input a sentence: Input a word to replace: What word would you like to replace it with: b\n", bos.toString());
      System.setOut(System.out);
   }

   // -----------------------------------------------------------------------
   // q7 – converts sentence to uppercase then lowercase
   // -----------------------------------------------------------------------

   @Test
   public void testQ6_1() {
      System.setIn(new ByteArrayInputStream("ALREADY UPPERCASE\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q6();
      assertEquals("Input a sentence: ALREADY UPPERCASE\nalready uppercase\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ6_2() {
      System.setIn(new ByteArrayInputStream("Yup this is a sentence\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q6();
      assertEquals("Input a sentence: YUP THIS IS A SENTENCE\nyup this is a sentence\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ6_3() {
      System.setIn(new ByteArrayInputStream("   Help Me   \n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q6();
      assertEquals("Input a sentence: HELP ME\nhelp me\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ6_4() {
      System.setIn(new ByteArrayInputStream("MiXeD CaSe\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q6();
      assertEquals("Input a sentence: MIXED CASE\nmixed case\n", bos.toString());
      System.setOut(System.out);
   }  

   // -----------------------------------------------------------------------
   // q8 – extracts a substring from a word up to the last occurrence of a letter
   // -----------------------------------------------------------------------

   @Test
   public void testQ7_1() {
      System.setIn(new ByteArrayInputStream("word\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q7();
      assertEquals("Input a word: word\nword\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ7_2() {
      // word="This" -> output "This" then "ence" (second output from separate call?)
      System.setIn(new ByteArrayInputStream("This is also a sentence\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q7();
      assertEquals("Input a word: This\nence\n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ7_3() {
      System.setIn(new ByteArrayInputStream("    okay i don't get it    \n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q7();
      assertEquals("Input a word:     \n    \n", bos.toString());
      System.setOut(System.out);
   }

   @Test
   public void testQ7_4() {
      System.setIn(new ByteArrayInputStream("same word at start and finish same\n".getBytes()));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(bos));
      PracticeProblem.q7();
      assertEquals("Input a word: same\nsame\n", bos.toString());
      System.setOut(System.out);
   }

}