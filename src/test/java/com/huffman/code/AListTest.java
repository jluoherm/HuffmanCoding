package com.huffman.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(3)
class AListTest {

    @Test
    /* Test constructors, making sure they're sizing the array correctly.
     * */
    public void test00Constructors() {
        AList<Integer> al = new AList<Integer>();
        assertEquals(0, al.size());
        assertEquals(8, al.getCap());

        al = new AList<Integer>(18);
        assertEquals(18, al.getCap());
    }


    @Test
    /** Test resize, which indirectly tests growIfNeeded. */
    public void test10Resize() {
        AList<Integer> al = new AList<Integer>(16);
        al.resize(4);
        assertEquals(4, al.size());
        assertEquals(16, al.getCap()); // shouldn't have grown

        al.resize(18);
        assertEquals(18, al.size());
        assertEquals(32, al.getCap()); // should have grown

        al.resize(32);
        assertEquals(32, al.size());
        assertEquals(32, al.getCap());

        // Test for multiple doublings at once contributed by Chris Holt, Spring 23
        al.resize(100);
        assertEquals(100, al.size());
        assertEquals(128, al.getCap());
    }


    @Test
    /** Test put and get.  */
    public void test20PutGet() {
        AList<Integer> al = new AList<Integer>(16);
        al.resize(16);

        for (int i = 0; i < 16; i++) {
            al.put(i, i);
            assertEquals(Integer.valueOf(i), al.get(i));
        }

        // Additional checks contributed by Madisen Cordell,
        // Spring 2022
        al.put(8,20);

        for (int i = 0; i < 16; i++) {
            if (i != 8) {
                assertEquals(Integer.valueOf(i), al.get(i));
            } else {
                assertEquals(Integer.valueOf(20), al.get(8));
            }
        }
    }

    @Test
    /** Test that put and get throw the correct exceptions */
    public void test21PutGet() {
        AList<Integer> al = new AList<Integer>(16);

        try {
            al.get(32); fail("Didn't throw an exception");
        } catch (IndexOutOfBoundsException e) { // supposed to happen
        } catch (Throwable e){
            fail("Threw something other than IndexOutOfBoundsException: " + e);
        }

        try {
            al.get(-1); fail("Didn't throw an exception");
        } catch (IndexOutOfBoundsException e) { // supposed to happen
        } catch (Throwable e){
            fail("Threw something other than IndexOutOfBoundsException: " + e);
        }

        try {
            al.put(-1, 4); fail("Didn't throw an exception");
        } catch (IndexOutOfBoundsException e) { // supposed to happen
        } catch (Throwable e){
            fail("Threw something other than IndexOutOfBoundsException: " + e);
        }

        try {
            al.put(16, 4); fail("Didn't throw an exception");
        } catch (IndexOutOfBoundsException e) { // supposed to happen
        } catch (Throwable e){
            fail("Threw something other than IndexOutOfBoundsException: " + e);
        }
    }


    @Test
    /** Test append and pop, making sure it grows as needed */
    public void test30Append() {
        AList<Integer> al = new AList<Integer>(8);

        for (int i = 0; i < 16; i++) {
            al.append(i);
            assertEquals(Integer.valueOf(i), al.get(i));
            assertEquals(i+1, al.size());
        }
        assertEquals(16, al.getCap());

        for (int i = 15; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), al.pop());
            assertEquals(i, al.size());
            try {
                al.get(i);
                fail("AList didn't throw an exception on indexing removed element.");
            } catch (IndexOutOfBoundsException e) {
                // This is supposed to happen
            } catch (Throwable e){
                fail("Threw something other than IndexOutOfBoundsException: " + e);
            }
        }
        assertEquals(16, al.getCap());

        try {
            al.pop();
            fail("pop on an empty AList did not throw an exception");
        } catch (NoSuchElementException e) {
            // This is supposed to happen
        } catch (Throwable e){
            fail("Threw something other than NoSuchElementException: " + e);
        }
    }

}