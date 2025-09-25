package com.huffman.code;

public class Node {
    public char aChar;
    public Node parent;
    public Node left;
    public Node right;
    public int freq = 0;

    public boolean isLeaf (Node n){
        return n != null && n.left == null && n.right == null;
    }

    public String toString() {
        return aChar + ":" + freq;
    }


    public Node(int f) {freq = f;}

    public Node(char ac, int f) {
        aChar = ac;
        freq = f;
    }

    public Node(Node p, char ac, int f) {
        parent = p;
        aChar = ac;
        freq = f;
    }
}
