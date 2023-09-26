import java.util.*;

public class Matrix {
    int rows;
    int columns;
    public double [][] matrix;

    public Matrix (int row, int col){
        this.rows = row;
        this.columns = col; 
        this.matrix = new double[row][col];
    }
    public double getElmt(int i,int j){
        return this.matrix[i][j];
    }

    public void setELmt(int row, int col, double val){
        if((row < this.rows) && (col< this.columns)){
            this.matrix[row][col] = val;
        }else{
            System.out.println("Invalid baris dan kolum");
        }
    }
    
    public int getRow(){
        return this.rows;
    }

    public int getColumn(){
        return this.columns;
    }

    public void printMatrix(){
        int i,j;
        for(i=0; i< this.rows; i++) {
            for(j = 0; j < this.columns; j++){
                if(j != (this.columns -1)){
                    System.out.printf("%.2f ",this.matrix[i][j]);
                }else{
                    System.out.printf("%.2f",this.matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void readMatrixFromTerminal(Scanner scanner){
        double elmt;
        int row, column,i,j;
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
}