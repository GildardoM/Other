import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gildardo on 25/07/2016.
 */
public class Matrix {
    public Matrix(float[]... rowEntries) {
        for(float[] r : rowEntries) {
            this.addRow(r);
        }
        this.rows = this.matrixEntries.size();
        this.columns = this.matrixEntries.get(firstIndex).size();
    }
    private final int firstIndex = 0;
    private final int clear = 0;
    private int rows, columns;
    private ArrayList<ArrayList<Float>> matrixEntries = new ArrayList<>();
    public int getRowsNumber() {
        return this.rows;
    }
    public int getColumnsNumber() {
        return this.columns;
    }
    public void addRow(float... entries) {
        if(this.columns == entries.length || this.columns == clear) {
            this.matrixEntries.add(new ArrayList<>());
            for (float entry : entries) {
                this.matrixEntries.get(this.matrixEntries.size() - 1).add(entry);
            }
            this.rows = this.matrixEntries.size();
        } else {
            System.out.println("Error! Columns number != entries number");
        }
    }
    public void addColumn(float... entries) {
        if(this.rows == entries.length) {
            int current = 0;
            for (float entry : entries) {
                this.matrixEntries.get(current).add(entry);
                current++;
            }
            this.columns = this.matrixEntries.get(firstIndex).size();
        } else {
            System.out.println("Error! Rows number != entries number");
        }
    }
    public float elementAt(int row, int column) {
        return this.matrixEntries.get(row).get(column);
    }
    public float[] getRow(int rowIndex) {
        float[] matRow = new float[this.columns];
        for(int current = 0; current < this.columns; current++) {
            matRow[current] = this.elementAt(rowIndex,current);
        }
        return matRow;
    }
    public float[] getColumn(int columnIndex) {
        float[] matColumn = new float[this.rows];
        for(int current = 0; current < this.rows; current++) {
            matColumn[current] = this.elementAt(current,columnIndex);
        }
        return matColumn;
    }
    public static Matrix transpose(Matrix m) {
        Matrix transMatrix = new Matrix(m.getColumn(m.firstIndex));
        for(int currentColumn = 1; currentColumn < m.columns; currentColumn++) {
            transMatrix.addRow(m.getColumn(currentColumn));
        }
        return transMatrix;
    }
    public static Matrix[] decompositionLU(Matrix m) {
        float[] u = new float[m.getColumnsNumber()];
        float[] l = new float[m.getRowsNumber()];
        l[0] = 1;
        Matrix U = new Matrix(m.getRow(m.firstIndex));
        for(int i = 1; i < m.getColumnsNumber(); i++) {
            l[i] = 0;
        }
        Matrix L = new Matrix(l);
        for (int row = 1; row < m.getRowsNumber(); row++) {
            for (int column = 0; column < m.getColumnsNumber(); column++) {
                if (row == column) {
                    l[column] = 1;
                }
                else if (row < column) {
                    l[column] = 0;
                }
                else if (row > column) {
                    u[column] = 0;
                }


            }
            L.addRow(l);
            U.addRow(u);

        }
        Matrix[] LU = {L,U};
        return LU;
    }
}
