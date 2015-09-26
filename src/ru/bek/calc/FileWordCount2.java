package ru.bek.calc;

import java.io.*;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Bek on 26.09.2015.
 */
public class FileWordCount2 {
    public static void main(String[] args) throws IOException {
        AtomicInteger total = new AtomicInteger(0);
        Pattern pattrn = Pattern.compile("\\W");
        try (BufferedReader r = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(args[0]))))) {
            Comparator<Map.Entry<String, Integer>> entryComparator = (a, b) -> {
                int res = a.getValue().compareTo(b.getValue());
                if (res == 0){
                    res = a.getKey().compareTo(b.getKey());
                }
                return res;
            };

            r.lines()
                    //.parallel()
                    .map((input) -> pattrn.split(input))
                    .flatMap((array) -> Arrays.stream(array))
                    .filter(word -> !word.isEmpty())
                    .map(word -> new AbstractMap.SimpleEntry<>(word,1))
                    .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                            Collectors.summingInt(AbstractMap.SimpleEntry::getValue)))
                    .entrySet()
                    .stream().sorted(entryComparator)
                    .forEach(s -> System.out.printf("$s\t%s\t%s\n", s.getKey(), s.getValue(), 100 * s.getValue()/total.get()));
        }
    }
}
