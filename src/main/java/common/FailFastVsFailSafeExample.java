package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafeExample {
    public static void main(String[] args) {
        failFast();
        failSafe();
    }

    private static void failFast() {
        List<String> list = new ArrayList<>();
        list.add("a");

        Iterator<String> it = list.iterator();
        list.add("d");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void failSafe() {
        List<String> l = new CopyOnWriteArrayList<>();
        l.add("a");

        Iterator<String> it = l.iterator();
        l.add("b");
        // prints only "a" because iterates over the copied list
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
