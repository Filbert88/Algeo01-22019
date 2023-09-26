import java.util.*;
import java.io.*;

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

    public int getRow(double[][]matrix){
        return matrix.length;
    }

    public int getColumn(){
        if (matrix.length == 0) {
            return 0;
        }
        return matrix[0].length;
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
        if(isSquare(matrix)){
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
    
    public int Msize(double[][]matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        return (rows*columns);
    }

    public boolean isSquare(double[][]matrix){
        if (matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        return rows==columns;
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

    public static void OBE(Matrix M){
        if (M.columns==1) {
            System.out.println("Tidak ada penyelesaian");
        }
        else{
            int now=0;
            while (now<M.rows) {
                if (M.getElmt(now,now)==0) {
                    for (int i = now+1; i < M.rows; i++) {
                        if (M.getElmt(i, now)!=0) {
                            Matrix temp = new Matrix(1, M.columns);
                            for (int j = 0; j < M.columns; j++) {
                                temp.setELmt(0, j, M.getElmt(i,j));
                                M.setELmt(i, j, M.getElmt(now,j));
                                M.setELmt(now, j, temp.getElmt(0,j));
                            }
                            if (i!=M.rows) {
                                System.out.println();
                                System.out.print("Matriks : ");
                                System.out.println("(R"+(now+1)+" ditukar dengan R"+(i+1)+")");
                                M.printMatrix(M.matrix);
                            }
                            break;
                        }
                    }
                }

                if (M.getElmt(now,now)!=0) {
                    if (M.getElmt(now,now)!=1) {
                        double pembagi=M.getElmt(now,now);
                        for (int j = 0; j < M.columns; j++) {
                            if (M.getElmt(now,j)!=0) {
                                M.setELmt(now, j, (M.getElmt(now,j)/pembagi));   
                            }
                        }
                        System.out.println();
                        System.out.print("Matriks : ");
                        System.out.println("(R" + (now + 1) + " dibagi dengan " + String.format("%.2f", pembagi) + ")");
                        M.printMatrix(M.matrix);
                    }

                    System.out.println();
                    System.out.print("Matriks : (");
                    int count=0;
                    for (int i = now+1; i < M.rows; i++) {
                        if (M.getElmt(i,now)!=0) {
                            double pengali=M.getElmt(i,now);
                            for (int j = 0; j < M.columns; j++) {
                                M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                            }
                            if (count!=0) {
                                System.out.print(", ");
                            }
                            count++;
                            System.out.print("R"+(i+1)+" dikurang dengan "+String.format("%.2f", pengali)+" kali R"+(now+1));
                        }
                    }
                    if (count==0) {
                        System.out.println("Tidak ada perubahan)");
                        M.printMatrix(M.matrix);
                    }
                    else{
                        System.out.println(")");
                        M.printMatrix(M.matrix);
                    }
                }
                now++;
            }
        }

    }
}
