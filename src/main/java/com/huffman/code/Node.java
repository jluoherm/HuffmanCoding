package com.huffman.code;

public class Node {
    public char aChar;
    public Node parent;
    public Node left;
    public Node right;
    public int code;
    public int freq = 0;

    public String toString() {
        return aChar + ":" + freq + "|" + code;
    }

    public Node() {}

    public Node(int f) {freq = f;}

    public Node(char ac, int f) {
        aChar = ac;
        freq = f;
    }

    public Node(Node p, char ac, int f, int c) {
        parent = p;
        aChar = ac;
        freq = f;
        code = c;
    }
}
