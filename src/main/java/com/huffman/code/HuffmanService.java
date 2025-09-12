package com.huffman.code;

import java.util.HashMap;
import java.util.stream.IntStream;

public class HuffmanService {

    Heap<Node, Integer> huffHeap = new Heap<>();
    HashMap<Character, Integer> frequencyCount = new HashMap<>();
    HuffmanTree huffTree = new HuffmanTree();

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
        frequencyCount.keySet()
                .forEach((key) -> {
                    String nodeKey = key.toString();
                    int priority = frequencyCount.get(key);
                    Node n = new Node(nodeKey,priority);
                    huffHeap.add(n,n.freq);
                });
    }

    public void addNodeToHeap (Node n){
        huffHeap.add(n, n.freq);
    }

    public void printHeap(){
        while (huffHeap.size() > 0) {
            Node n = huffHeap.peek();
            System.out.println(huffHeap.poll());
        }
    }

    public void buildTree(){
        while (huffHeap.size() > 1) {
            Node x = huffHeap.poll();
            Node y = huffHeap.poll();
            x.code = 0;
            y.code = 1;
            int zFreq = x.freq + y.freq;
            Node z = new Node(String.valueOf(zFreq),zFreq);
            z.left = x;
            z.right = y;
            addNodeToHeap(z);
        }
        Node z = huffHeap.poll();
        huffTree.insert(z);
        huffTree.printTree();
    }
}

