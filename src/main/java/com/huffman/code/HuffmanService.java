package com.huffman.code;

import java.util.HashMap;
import java.util.stream.IntStream;

public class HuffmanService {

    Heap<Node, Integer> huffHeap = new Heap<>();
    HashMap<Character, Integer> frequencyCount = new HashMap<>();
    HuffmanTree huffTree = new HuffmanTree();
    HashMap<Character, String> encodingMap = new HashMap<>();
    String encodedString;
    String decodedString;

    public String getEncodedString(){return encodedString;}


    public void countFrequencies(String data) {
        int stringLength = data.length();

        IntStream.range(0, stringLength)
                .forEach(x -> {
                    char c = data.charAt(x);
                    frequencyCount.put(c,
                            frequencyCount.getOrDefault(c, 0) + 1);
                });
    }

    public void addToHeap() {
        frequencyCount.keySet()
                .forEach((key) -> {
                    int priority = frequencyCount.get(key);
                    Node n = new Node(key, priority);
                    huffHeap.add(n, n.freq);
                });
    }

    public void addNodeToHeap(Node n) {
        huffHeap.add(n, n.freq);
    }

    public void printHeap() {
        while (huffHeap.size() > 0) {
            System.out.println(huffHeap.poll());
        }
    }

    public void buildTree() {
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
        //huffTree.printTree();
    }

    public void dfs(Node n, StringBuilder sb) {

        if (n.isLeaf(n)) {
            String code = sb.toString();
            encodingMap.put(n.aChar, code);
        }
        if (n.left != null) {
            dfs(n.left, sb.append("0"));
            sb.delete(sb.length() - 1, sb.length());
        }
        if (n.right != null) {
            dfs(n.right, sb.append("1"));
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public void buildEncoder() {
        Node n = huffTree.getRoot();
        StringBuilder sb = new StringBuilder();
        dfs(n, sb);
    }

    public String encode(String rawString) {
        StringBuilder sb = new StringBuilder();
        countFrequencies(rawString);
        addToHeap();
        buildTree();
        buildEncoder();

        IntStream.range(0, rawString.length())
                .forEach(x -> {
                    char key = rawString.charAt(x);
                    String code = encodingMap.get(key);
                    sb.append(code);
                });
        encodedString = sb.toString();
        return encodedString;
    }

    public String decode() {

        StringBuilder sb = new StringBuilder();
        Node root = huffTree.getRoot();
        Node currentNode = root;

        for (int x = 0; x < encodedString.length(); x++ ){
            char code = encodedString.charAt(x);
            if (code == '0'){
                currentNode = currentNode.left;
            }else {
                currentNode = currentNode.right;
            }
            if (currentNode.isLeaf(currentNode)){
                sb.append(currentNode.aChar);
                currentNode = root;
            }
        }
        decodedString = sb.toString();
        return decodedString;
    }
}

