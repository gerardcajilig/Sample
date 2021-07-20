package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ComputeWageTest {

    ComputeWage obj = new ComputeWage();

    @BeforeEach
    public void initEach(){
        ByteArrayInputStream in = new ByteArrayInputStream("John\n35".getBytes());
        System.setIn(in);
    }
//checks the input
    @org.junit.jupiter.api.Test
    void acceptData() {
        obj.acceptData();

        assertEquals("John", obj.getName());
        assertEquals(35, obj.getHours());
    }
//check the tests with regular hours
    @org.junit.jupiter.api.Test
    void computeWage() {
        //calls the computation
                obj.acceptData();
                obj.computeWage();

                assertEquals( 525, obj.getGtotal());
    }

    @org.junit.jupiter.api.Test
    void computeWageWithOT() {
//need to put new input
        ByteArrayInputStream in = new ByteArrayInputStream("John\n45".getBytes());
        System.setIn(in);

        obj.acceptData();
        obj.computeWage();

        assertEquals( 682.5, obj.getGtotal());

    }

    @Test
    void TestExcemption(){
        ByteArrayInputStream in = new ByteArrayInputStream("John\nxx\n35".getBytes());
        System.setIn(in);

        PrintStream standartout = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.acceptData();

        assertTrue(new String(captor.toByteArray()).contains("You Didn't Put a correct integer"));


    }



    @org.junit.jupiter.api.Test
    void display() {
        obj.acceptData();
        obj.computeWage();

        PrintStream standartout = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.display();
        assertEquals("The total wage of John is 525.0",captor.toString().trim());

        System.setOut(standartout);
    }






}