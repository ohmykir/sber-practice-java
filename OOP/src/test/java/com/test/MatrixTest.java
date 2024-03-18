package com.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void additionTest(){
        Matrix m1 = new Matrix(2,2);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                m1.setValue(i, j, (i+1)*(j+1));
            }
        }
        Matrix m2 = new Matrix(2,2);
        for (int i = 0; i < m2.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                m2.setValue(i, j, (i+1)*1.0/(j+1));
            }
        }
        double [][] res = {{2, 2.5}, {4, 5}};

        assertEquals(Arrays.deepToString(res), Arrays.deepToString(Matrix.addition(m1, m2).getTable()));

    }

    @Test
    public void multiplyTest(){
        Matrix m1 = new Matrix(2,2);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                m1.setValue(i, j, (i+1)*(j+1));
            }
        }

        double [][] res = {{5, 10}, {10, 20}};

        assertEquals(Arrays.deepToString(res), Arrays.deepToString(Matrix.multiply(m1, 5).getTable()));

    }

    @Test
    public void multiplicationTest(){
        Matrix m1 = new Matrix(2,2);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                m1.setValue(i, j, (i+1)*(j+1));
            }
        }

        Matrix m2 = new Matrix(2,2);
        for (int i = 0; i < m2.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                m2.setValue(i, j, (i+1)*1.0/(j+1));
            }
        }

        double [][] res = {{5, 2.5}, {10, 5}};

        assertEquals(Arrays.deepToString(res), Arrays.deepToString(Matrix.multiplication(m1, m2).getTable()));

    }
    @Test
    public void printTest(){
        Matrix m1 = new Matrix(2,2);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                m1.setValue(i, j, (i+1)*(j+1));
            }
        }

        Matrix.print(m1);

        assertEquals("1.0 2.0 \r\n2.0 4.0", outputStreamCaptor.toString().trim());

    }
    @AfterEach
    public void tearDown(){
        System.setOut(standardOut);
    }
}
