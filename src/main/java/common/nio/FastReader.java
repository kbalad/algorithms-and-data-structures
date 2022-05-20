package common.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * User defined class for ease AND speed of read operations.
 *
 * It is not faster than BufferedReader, but easier to use.
 * It is faster than Scanner.
 * It is slower than SuperFastReader.
 */
public class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            createNewStringTokenizer();
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private void createNewStringTokenizer() {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
