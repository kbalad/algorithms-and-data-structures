package nio;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ScannerVsBufferedReaderTest {

    @Test
    public void testScanner() throws FileNotFoundException {
        File input = new File("src/test/resources/nio/someText");
        Scanner sc = new Scanner(input);

        System.out.println("Enter an integer");
        int a = sc.nextInt();

        System.out.println("Enter a String");
        String s = sc.nextLine();

        String out = "You've entered: " + a + " " + s;
        // we've got nothing in "s" because sc.nextLine() reads till '\n'
        // the next sc.nextLine will show the next word as expected
        System.out.println(out);
        System.out.println(Arrays.toString(out.getBytes()));
    }

    @Test
    public void testBufferedReader() throws IOException {
        File input = new File("src/test/resources/nio/someText");
        BufferedReader br = new BufferedReader(new FileReader(input));

        System.out.println("Enter an integer");
        int a = Integer.parseInt(br.readLine());

        System.out.println("Enter a String");
        String s = br.readLine();

        String out = "You've entered: " + a + " " + s;
        System.out.println(out);
    }

}
