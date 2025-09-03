package com.huffman.code;

public class HuffmanApp {
    public static void main(String[] args) {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("heeeellllllllllllooorrrrrr");

        System.out.println(hs.frequencyCount.keySet());
        System.out.println("---Print Frequency Count HashMap----");
        hs.frequencyCount.entrySet().forEach(System.out::println);
        System.out.println("---Add to and print Heap----");
        hs.addToHeap();
    }

}
