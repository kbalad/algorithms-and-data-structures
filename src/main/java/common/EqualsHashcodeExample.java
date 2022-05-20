package common;

import java.util.HashMap;
import java.util.Map;

public class EqualsHashcodeExample {

    public static class MyKey {
        private final int v;

        public MyKey(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "MyKey=" + v;
        }

        @Override
        public int hashCode() {
            return v;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            else {
                if (!(o instanceof MyKey)) {
                    return false;
                }
                MyKey o1 = (MyKey) o;
                return o1.v == this.v;
            }
        }
    }

    public static void main(String[] args) {
        Map<MyKey, String> map = new HashMap<>();
        map.put(create(1), "first");
        map.put(create(1), "second");
        System.out.println(map);
    }

    private static MyKey create(int v) {
        MyKey mk = new MyKey(v);
        System.out.println("hashcode: " + Integer.toHexString(mk.hashCode()));
        System.out.println(mk);
        System.out.println("----");
        return mk;
    }
}
