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


}