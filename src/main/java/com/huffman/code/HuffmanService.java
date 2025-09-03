package com.huffman.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

    public void addToHeap() {

        Heap<Character, Integer> huffHeap = new Heap<>();
        frequencyCount.forEach(huffHeap::add);



    }

/*        while (huffHeap.size() > 0){
        char c = huffHeap.peek();
        int priority = frequencyCount.get(c);
        System.out.println(huffHeap.poll() + " " + priority);
    }*/


}
