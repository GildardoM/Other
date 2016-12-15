/**
 * Created by Gildardo on 25/07/2016.
 */
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

    }

    public static void printMatrix(Matrix m) {
        for (int row = 0; row < m.getRowsNumber(); row++) {
            for (int column = 0; column < m.getColumnsNumber(); column++) {
                System.out.print(m.elementAt(row,column) + ",\t");
            }
            System.out.println();
        }
    }
    public static Matrix scanMatrix(int rows, int columns) {
        float[] rowEntries = new float[columns];
        Scanner read = new Scanner(System.in);
        for(int current = 0; current < columns; current++) {
            System.out.print("(" + current + ",0) = ");
            rowEntries[current] = read.nextFloat();
        }
        Matrix m = new Matrix(rowEntries);
        for(int currentRow = 1; currentRow < rows; currentRow++) {
            for(int currentCol = 0; currentCol < columns; currentCol++) {
                System.out.print("(" + currentRow + "," + currentCol + ") = ");
                rowEntries[currentCol] = read.nextFloat();
            }
            m.addRow(rowEntries);
        }
        return m;
    }
    public static Matrix scanRow(Matrix m) {
        float[] rowEntries = new float[m.getColumnsNumber()];
        Scanner read = new Scanner(System.in);
        for(int i = 0; i < m.getColumnsNumber(); i++) {
            rowEntries[i] = read.nextFloat();
        }
        m.addRow(rowEntries);
        return m;
    }
    public static Matrix scanColumn(Matrix m) {
        float[] columnEntries = new float[m.getRowsNumber()];
        Scanner read = new Scanner(System.in);
        for(int i = 0; i < m.getRowsNumber(); i++) {
            columnEntries[i] = read.nextFloat();
        }
        m.addColumn(columnEntries);
        return m;
    }
}
