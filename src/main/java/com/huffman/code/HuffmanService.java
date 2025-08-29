package com.huffman.code;

import java.util.HashMap;
import java.util.stream.IntStream;

public class HuffmanService {


    HashMap<Character, Integer> frequencyCount = new HashMap<>();

    public void countFrequencies(String dataToEncode) {
        int stringLength = dataToEncode.length();

        IntStream.range(0, stringLength)
                .forEach(x -> {
                    char c = dataToEncode.charAt(x);
                    frequencyCount.put(c,
                            frequencyCount.getOrDefault(c, 0) + 1);
                });
    }


}
