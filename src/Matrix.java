import java.util.*;
import java.io.*;
import java.io.BufferedReader;

public class Matrix {
    int rows;
    int columns;
    public double[][] matrix;

    public Matrix (int row, int col){
        this.rows = row;
        this.columns = col; 
        this.matrix = new double[row][col];
    }
    public double getElmt(int i,int j){
        return this.matrix[i][j];
    }

    public int getRow(){
        return this.rows;
    }

    public int getColumn(){
        return this.columns;
    }

    public void setELmt(int row, int col, double val){
        if((row < this.rows) && (col< this.columns)){
            this.matrix[row][col] = val;
        }else{
            System.out.println("Invalid baris dan kolum");
        }
    }

    // print all matrix
    public void printMatrix(double [][] matrix){
        int i,j;
        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println("Matriks: ");
        for(i=0; i< rows; i++) {
            for(j = 0; j < columns; j++){
                if (matrix[i][j] == -0){
                    matrix[i][j] = 0;
                }
                if(j != (columns -1)){
                    System.out.printf("%.2f ",matrix[i][j]);
                }else{
                    System.out.printf("%.2f",matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void readMatrixFromTerminal(Scanner scanner){
        double elmt;
        int row,column,i,j;
        System.out.print("Masukkan Jumlah Baris: ");
        row = scanner.nextInt();
        System.out.print("Masukkan Jumlah Kolom: ");
        column = scanner.nextInt();

        this.rows = row;
        this.columns = column;
        this.matrix = new double[row][column];
    
        System.out.println("Masukkan Matriks: ");
        for(i=0;i<row;i++){
            for(j=0;j<column;j++){
                elmt = scanner.nextDouble();
                this.matrix[i][j] = elmt;
            }
        }
    }

    public void readSquareMatrix(Scanner scanner){
        double elmt;
        int row,column,i,j;
        System.out.print("Masukkan Jumlah Ukuran Matriz yang diinginkan: ");
        row = scanner.nextInt();
        this.rows = row;
        column = row;
        this.columns = column;
        this.matrix = new double[row][column];
        if(isSquare()){
            System.out.println("Masukkan Matriks: ");
            for(i=0;i<row;i++){
                for(j=0;j<column;j++){
                    elmt = scanner.nextDouble();
                    this.matrix[i][j] = elmt;
                }
            }
        }else{
            System.out.println("Bukan Matriks persegi");
        }
    }

    public Matrix copyMatrix(){   
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        int i,j;
        newMatrix.rows = this.rows;
        newMatrix.columns = this.columns;
        for(i=0;i<this.rows;i++){
            for(j=0;j<this.columns;j++){
                newMatrix.matrix[i][j] = this.matrix[i][j];
            }
        }
        return newMatrix;
    }
    
    public int Msize(){
        return (this.rows * this.columns);
    }

    public boolean isSquare(){
        return this.rows == this.columns;
    }

    public void readMatrixFromFile(Scanner scanner) {
        int row=0;
        int col=0;
        int counter=0;
        String fileName = scanner.nextLine();
        if(isTxtFile(fileName)){
            String filePath = "../test/"+fileName;
            try (BufferedReader rowcolReader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = rowcolReader.readLine()) != null) {
                    row +=1;
                    String[] temparray = line.split(" ");
                    col = temparray.length;
                }
                rowcolReader.close();
                BufferedReader matrixReader = new BufferedReader(new FileReader(filePath));
                this.rows = row;
                this.columns = col;
                this.matrix = new double[row][col];
                while ((line = matrixReader.readLine()) != null) {
                    String[] temparray = line.split(" ");
                    for (int i = 0; i < col; i++) {
                    double value = Double.parseDouble(temparray[i]);
                    this.setELmt(counter,i,value);
                    }
                    counter +=1;
                }
            } catch (IOException e) {
                System.out.println("Please make sure the file exist and readable.");
            }
        }
        else{
            System.out.println("The file is not a txt file.");
        }
    }

    public static boolean isTxtFile(String fileName){
        if (fileName.endsWith(".txt")){
            return true;
        }
        else{
            return false;
        }
    }
    }
