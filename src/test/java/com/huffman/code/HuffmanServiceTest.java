package com.huffman.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HuffmanServiceTest {

    @Test
    public void test01() {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("heeeellooorrrrrr");

        int h_count = hs.frequencyCount.get('h');
        int e_count = hs.frequencyCount.get('e');
        int l_count = hs.frequencyCount.get('l');
        int o_count = hs.frequencyCount.get('o');
        int r_count = hs.frequencyCount.get('r');

        assertEquals(1, h_count);
        assertEquals(4, e_count);
        assertEquals(2, l_count);
        assertEquals(3, o_count);
        assertEquals(6, r_count);

        hs.countFrequencies("ll");
        l_count = hs.frequencyCount.get('l');
        assertEquals(4, l_count);
    }

    @Test
    public void test02() {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("94755534996");
        int num5 = hs.frequencyCount.get('5');
        int num4 = hs.frequencyCount.get('4');
        assertEquals(3, num5);
        assertEquals(2, num4);
    }

    @Test
    //Validate encoding hashmap
    public void test03() {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("aaabbbbbccccccccdddddddddddd");
        hs.addToHeap();
        hs.buildTree();
        hs.buildEncoder(); // this is hashmap
        String d = "0";
        String c = "10";
        String a = "110";
        String b = "111";

        assertEquals(hs.encodingMap.get('d'),d);
        assertEquals(hs.encodingMap.get('c'),c);
        assertEquals(hs.encodingMap.get('a'),a);
        assertEquals(hs.encodingMap.get('b'),b);

    }

    @Test
    //Validate encoding hashmap
    public void test04() {
        HuffmanService hs = new HuffmanService();
        hs.countFrequencies("jjjjtjryrgryrrrjrrryyrrrrrtrryyyyyykkkkkkkkkkkkkkkkkkkkkkk");
        hs.addToHeap();
        hs.buildTree();
        hs.buildEncoder(); // this is hashmap
        String r = "10";
        String t = "11001";
        String g = "11000";
        String y = "111";
        String j = "1101";
        String k = "0";

        assertEquals(hs.encodingMap.get('r'),r);
        assertEquals(hs.encodingMap.get('t'),t);
        assertEquals(hs.encodingMap.get('g'),g);
        assertEquals(hs.encodingMap.get('y'),y);
        assertEquals(hs.encodingMap.get('j'),j);
        assertEquals(hs.encodingMap.get('k'),k);

    }


}