package common;

public class TryCatchFinallyExample {
    public static void main(String[] args) throws IllegalAccessException {
        try {
            throw new IllegalAccessException();
        } finally {
            System.out.println("finally");
        }
    }
}
