package com.huffman.code;

public class HuffmanApp {
    public static void main(String[] args) {
        HuffmanService hs = new HuffmanService();
        String decodedString;
        String inputString = "pipppperrr pippppar piippppeer";

        System.out.println(inputString);
        String encodedString = hs.encode(inputString);
        System.out.println(encodedString);

        decodedString = hs.decode();
        System.out.println(decodedString);
        boolean stringsMatch = decodedString.equals(inputString);
        System.out.println(stringsMatch);

    }

}
