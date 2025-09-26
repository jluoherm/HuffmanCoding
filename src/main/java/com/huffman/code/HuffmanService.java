package com.huffman.code;

import java.util.HashMap;
import java.util.Stack;
import java.util.stream.IntStream;

public class HuffmanService {

    Heap<Node, Integer> huffHeap = new Heap<>();
    HashMap<Character, Integer> frequencyCount = new HashMap<>();
    HuffmanTree huffTree = new HuffmanTree();
    HashMap<Character,String> encodingMap = new HashMap<>();

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
                    int priority = frequencyCount.get(key);
                    Node n = new Node(key,priority);
                    huffHeap.add(n,n.freq);
                });
    }

    public void addNodeToHeap (Node n){
        huffHeap.add(n, n.freq);
    }

    public void printHeap(){
        while (huffHeap.size() > 0) {
            System.out.println(huffHeap.poll());
        }
    }

    public void buildTree(){
        while (huffHeap.size() > 1) {
            Node x = huffHeap.poll();
            Node y = huffHeap.poll();
            Node z = new Node(x.freq + y.freq);
            z.left = x;
            z.right = y;
            addNodeToHeap(z);
        }
        Node z = huffHeap.poll();
        huffTree.insert(z);
        huffTree.printTree();
    }


    public void dfs(Node n, StringBuilder sb){
        if (n.isLeaf(n)){
            String code = sb.toString();
            encodingMap.put(n.aChar,code);
            sb.delete(sb.length()-1,sb.length());
        } else {
            if (n.left != null){
                sb.append("0");
                dfs(n.left, sb);
            }
            if (n.right != null){
                sb.append("1");
                dfs(n.right,sb);
            }
        }

    }

    public void buildEncoder(){
        Node n = huffTree.getRoot();
        StringBuilder sb = new StringBuilder();
        dfs(n, sb);
    }
}

