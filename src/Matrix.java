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

    public int getRow(){
        return this.rows;
    }

    public int getColumn(){
        if (this.rows == 0) {
            return 0;
        }
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
    public void printMatrix(){
        int i,j;
        int rows = this.rows;
        int columns = this.columns;
        for(i=0; i< rows; i++) {
            for(j = 0; j < columns; j++){
                if (this.matrix[i][j] == -0){
                    this.matrix[i][j] = 0;
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

    public Matrix OBE(Matrix M){
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
                            M.printMatrix();
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
                    M.printMatrix();
                }

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
                        else{
                            System.out.println();
                            System.out.print("Matriks : ");
                            System.out.print("(");
                        }
                        count++;
                        if (pengali>=0) {
                            System.out.print("R"+(i+1)+" dikurang dengan "+String.format("%.2f", pengali)+" kali R"+(now+1));   
                        }
                        else{
                            System.out.print("R"+(i+1)+" ditambah dengan "+String.format("%.2f", (-1)*pengali)+" kali R"+(now+1));
                        }
                    }
                }
                if (count!=0) {
                    System.out.println(")");
                    M.printMatrix();
                }
            }

            else{
                int leading=-1;
                for (int i = 0; i < M.columns; i++) {
                    if (M.getElmt(now, i)!=0) {
                        leading=i;
                        break;
                    }
                }
                if (leading!=-1) {
                    double pembagi=M.getElmt(now,leading);

                    if (pembagi!=1) {
                        for (int j = 0; j < M.columns; j++) {
                            if (M.getElmt(now,j)!=0) {
                                M.setELmt(now, j, (M.getElmt(now,j)/pembagi));   
                            }
                        }
                        System.out.println();
                        System.out.print("Matriks : ");
                        System.out.println("(R" + (now + 1) + " dibagi dengan " + String.format("%.2f", pembagi) + ")");
                        M.printMatrix();   
                    }
                }
                int count=0;
                for (int i = now+1; i < M.rows; i++) {
                    if (M.getElmt(i,leading)!=0) {
                        double pengali=M.getElmt(i,leading);
                        for (int j = 0; j < M.columns; j++) {
                            M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                        }
                        if (count!=0) {
                            System.out.print(", ");
                        }
                        else{
                            System.out.println();
                            System.out.print("Matriks : ");
                            System.out.print("(");
                        }
                        count++;
                        if (pengali>=0) {
                            System.out.print("R"+(i+1)+" dikurang dengan "+String.format("%.2f", pengali)+" kali R"+(now+1));
                        }
                        else{
                            System.out.print("R"+(i+1)+" ditambah dengan "+String.format("%.2f", (-1)*pengali)+" kali R"+(now+1));
                        }
                    }
                }
                if (count!=0) {
                    System.out.println(")");
                    M.printMatrix();
                }
            }

            now++;
        }
        return M;
    }

    public Matrix OBE_red(Matrix M){
        M.OBE(M);
        int now=M.rows-1;
        while (now>=0) {
            int leading=-1;
            for (int i = 0; i < M.columns; i++) {
                if (M.getElmt(now, i)==1) {
                    leading=i;
                    break;
                }
            }
            if (leading!=-1) {
                int count=0;
                for (int i = now-1; i >= 0; i--) {
                    if (M.getElmt(i,leading)!=0) {
                        double pengali=M.getElmt(i,leading);
                        for (int j = 0; j < M.columns; j++) {
                            M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                        }
                        if (count!=0) {
                            System.out.print(", ");
                        }
                        else{
                            System.out.println();
                            System.out.print("Matriks : ");                                
                            System.out.print("(");
                        }
                        count++;
                        if (pengali>=0) {
                            System.out.print("R"+(i+1)+" dikurang dengan "+String.format("%.2f", pengali)+" kali R"+(now+1));   
                        }
                        else{
                            System.out.print("R"+(i+1)+" ditambah dengan "+String.format("%.2f", (-1)*pengali)+" kali R"+(now+1));
                        }
                    }
                }
                if (count!=0) {
                    System.out.println(")");
                    M.printMatrix();
                }                    
            }
            now--;
        }
        return M;
    }


    public Matrix minor(int row,int col){
        int newRows = this.rows-1;
        int newCols = this.columns-1;
        int rowcounter = 0;
        int colcounter = 0;
        Matrix newmatrix = new Matrix(newRows,newCols);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                if(i!=row && j!=col){   
                    if(colcounter == newCols){
                        rowcounter+=1;
                        colcounter = 0;
                    }
                    double value = this.getElmt(i, j);
                    newmatrix.setELmt(rowcounter, colcounter, value);
                    colcounter+=1;
                }
                
            }
        }
        return newmatrix;
    }

    public double determinanCof() {
        int n = this.rows;
        int sign;
        double det = 0;
        double detMinor;

        if (n == 1) {
            det = this.getElmt(0, 0);
        } else {
            for (int i = 0; i < n; i++) {
                sign = ((i%2)==0) ? 1 : -1;
                Matrix minor = this.minor(0,i);
                detMinor = minor.determinanCof();
                det += sign * this.matrix[0][i] * detMinor;
            }
        }
        return det;
    }

    public Matrix transpose(){
        int rows = this.rows;
        int cols = this.columns;
        Matrix transposeMatrix = new Matrix(rows,cols);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                double elmt = this.getElmt(i,j);
                transposeMatrix.setELmt(j,i,elmt);
            }
        }
        return transposeMatrix;
    }

    public Matrix adjoin(){
        int sign=1;
        int rows = this.rows;
        int cols = this.columns;
        Matrix adjoin = new Matrix(rows,cols);
        Matrix minor = new Matrix(rows-1,cols-1);
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if((i+j)%2 == 0){
                    sign = 1;
                }  
                else{
                    sign = -1;
                }
                minor = this.minor(i,j);
                double det = minor.determinanCof();
                adjoin.setELmt(i,j,(det*sign));
                System.out.println(det);    
            }
        }
        adjoin = adjoin.transpose();
        return adjoin;
    }

    public Matrix inverseCofactor(){
        int rows = this.rows;
        int cols = this.columns;
        Matrix inverse = new Matrix(rows,cols);
        Matrix adjoin = this.adjoin();
        double det = this.determinanCof();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                inverse.setELmt(i,j,adjoin.getElmt(i,j)/det);
            }
        }
        return inverse;
    }
}
