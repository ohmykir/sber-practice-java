package com.test;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] table;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[][] getTable() {
        return table;
    }
    public double getValue(int i, int j){
        return this.table[i][j];
    }

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.table = new double[rows][columns];
    }

    public void setValue(int i, int j, double value) {
        this.table[i][j] = value;
    }

    public static Matrix addition(Matrix m1, Matrix m2){
        Matrix res = new Matrix(m1.getRows(), m2.getColumns());

        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                res.setValue(i, j,m1.getValue(i, j) + m2.getValue(i,j));
            }
        }
        return res;
    }

    public static Matrix multiply(Matrix matrix, double value){
        Matrix res = new Matrix(matrix.getRows(), matrix.getColumns());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                res.setValue(i, j, matrix.getValue(i, j)*value);
            }
        }
        return res;
    }

    public static void print(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(matrix.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static Matrix multiplication(Matrix m1, Matrix m2) {
        Matrix res = new Matrix(m1.getRows(), m2.getColumns());

        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                double num = 0;
                for (int k = 0; k < m1.getColumns(); k++) {
                    num += m1.getValue(i, k)* m2.getValue(k, j);
                }
                res.setValue(i, j, num);
            }
        }

        return  res;
    }
}