package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractClassesExample {

    abstract static class Client {

        Client() {
            System.out.println(fun());
        }

        abstract int fun();
    }

    static class SberClient extends Client {
        private int x;

        SberClient() {
            this.x = -1;
        }

        @Override
        int fun() {
            return this.x;
        }
    }

    public static void main(String[] args) {
        SberClient sc = new SberClient();
        System.out.println("out: " + sc.fun());


        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);


        Integer[] a = new Integer[100];
        l.toArray(a);
        System.out.println(Arrays.toString(a));
    }
}
