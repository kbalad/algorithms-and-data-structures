package nio;

import static org.testng.Assert.*;

import lombok.SneakyThrows;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class FastReaderTest {

    FastReader fr;

    @BeforeTest
    public void setup() {
        reloadFr("ok");
    }

    @Test
    public void testNextOk() {
        String s = fr.next();
        assertEquals(s, "5");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNextFail() {
        reloadFr("emptyFile");
        fr.next();
    }

    @Test
    public void testNextIntOk() {
        int i = fr.nextInt();
        assertEquals(i, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNextIntFail() {
        fr.next();
        fr.nextInt();
    }

    @Test
    public void testNextLongOk() {
        long l = fr.nextLong();
        assertEquals(l, 5);
        fr.next();
        l = fr.nextLong();
        assertEquals(l, 10000000000L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNextLongFail() {
        long l = fr.nextLong();
        assertEquals(l, 5);
        fr.nextLong();
    }

    @Test
    public void testNextDoubleOk() {
        double d = fr.nextDouble();
        assertEquals(d, 5.0);
        fr.next();
        fr.next();
        d = fr.nextDouble();
        assertEquals(d, 23.13);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNextDoubleFail() {
        double d = fr.nextDouble();
        assertEquals(d, 5.0);
        fr.nextDouble();
    }

    @Test
    public void testNextLine() {
        for (int i = 0; i < 4; i++) {
            fr.nextLine();
        }
        String s = fr.nextLine();
        assertEquals(s, "1 2 4 hello");
    }

    @SneakyThrows
    private void reloadFr(String filename) {
        File f = new File("src/test/resources/nio/" + filename);
        fr = new FastReader(new FileInputStream(f));
    }
}
