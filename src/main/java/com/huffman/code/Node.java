package com.huffman.code;

public class Node {
    public String key;
    public Node parent;
    public Node left;
    public Node right;
    public int code;
    public int freq = 0;

    public String toString() {
        return key + ":" + freq + "|" + code;
    }

    public Node() {}

    public Node(String k) {
        key = k;
    }

    public Node(String k, int f) {
        key = k;
        freq = f;

    }

    public Node(Node p, String k, int f, int c) {
        parent = p;
        key = k;
        freq = f;
        code = c;
    }
}
