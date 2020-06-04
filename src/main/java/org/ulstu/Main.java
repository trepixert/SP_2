package org.ulstu;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//5 LABA
public class Main {
    public static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    public static String getAlphaNumericString(int n) {
        return IntStream.range(0, n).map(i -> (int) (ALPHA_NUMERIC_STRING.length()
                * Math.random())).mapToObj(index -> String.valueOf(ALPHA_NUMERIC_STRING
                .charAt(index))).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int initialCapacity = 400;
        ArrayList<String> stringArrayList = IntStream.range(0, initialCapacity)
                .mapToObj(i -> getAlphaNumericString(32))
                .collect(Collectors.toCollection(() -> new ArrayList<>(initialCapacity)));

        int size = 400;

        Rehashing rehashing = new Rehashing(size);
        ChainingMethod chainingMethod = new ChainingMethod(size);

        System.out.println("Добавление - метод цепочки");
        long start = System.currentTimeMillis();
        stringArrayList.forEach(chainingMethod::add);
        long end = System.currentTimeMillis();

        System.out.println((end - start) + " мс");

        System.out.println("Добавление - рехэширование");
        start = System.currentTimeMillis();
        stringArrayList.forEach(rehashing::add);
        end = System.currentTimeMillis();

        System.out.println((end - start) + " мс");

    }
}
