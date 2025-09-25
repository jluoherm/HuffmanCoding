package com.huffman.code;

public class HuffmanApp {
    public static void main(String[] args) {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("aaabbbbbccccccccdddddddddddd");

        System.out.println(hs.frequencyCount.keySet());
        System.out.println("---Print Frequency Count HashMap----");
        hs.frequencyCount.entrySet().forEach(System.out::println);
        System.out.println("---Add to and print Heap----");

        hs.addToHeap();
        //Node n = new Node("5",5);
        //hs.addNodeToHeap(n);
        //hs.printHeap();
        System.out.println("---Build Tree----");
        hs.buildTree();
        hs.buildEncoder();
        //System.out.println(hs.encodingMap.keySet());
        hs.encodingMap.entrySet().forEach(System.out::println);
        //hs.printHeap();

    }

}
