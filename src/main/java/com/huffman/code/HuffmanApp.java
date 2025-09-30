package com.huffman.code;

public class HuffmanApp {
    public static void main(String[] args) {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("pipppperrr pippppar piippppeer");
        //hs.countFrequencies("aaabbbbbccccccccdddddddddddd");

        System.out.println(hs.frequencyCount.keySet());
        System.out.println("---Print Frequency Count HashMap----");
        hs.frequencyCount.entrySet().forEach(System.out::println);
        System.out.println("---Add to and print Heap----");

        hs.addToHeap();

        System.out.println("---Build Tree----");
        hs.buildTree();
        hs.buildEncoder();
        hs.encodingMap.entrySet().forEach(System.out::println);
        System.out.println(hs.encode("pipppperrr pippppar piippppeer"));
        System.out.println(hs.decode());

    }

}
