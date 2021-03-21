package practices.streamapi;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//2. Написать метод, который принимает два числа и генерирует последовательность чисел в
// заданном диапазоне, исключает из последовательности все чётные значения, умножает все значения на два,
// возвращает первые 5 наибольших чисел в виде строки (числа должны быть соединены символом "&").

public class StreamIpi {
    public String getSequence(int minRange, int maxRange) {
            StringBuilder stringBuilder = new StringBuilder();
         IntStream.range(minRange, maxRange).filter(x -> x % 2 != 0).map(x -> x * 2).sorted().forEach(x -> {
             stringBuilder.append(x).append('&');
         });
         return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StreamIpi streamIpi = new StreamIpi();

        System.out.println(streamIpi.getSequence(1,50));

    }

}
