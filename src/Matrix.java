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
        System.out.print("Masukkan Jumlah Ukuran Matriks yang diinginkan: ");
        row = scanner.nextInt();
        column = row;
        this.rows = row;
        this.columns = column;
        this.matrix = new double[row][column];
        if(isSquare(matrix)){
            System.out.println();
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
        String fileName = scanner.next();
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
        while (now<M.rows && now<M.columns) {
            if (M.getElmt(now,now)==0) {

                int tukar=-1;
                int leading=Integer.MAX_VALUE;
                for (int i = 0; i < M.columns; i++) {
                    if (M.getElmt(now,i)!=0) {
                        leading=i;
                        break;
                    }
                }

                for (int i = now+1; i < M.rows; i++) {
                    int leading_temp=Integer.MAX_VALUE;
                    for (int j = 0; j < M.columns; j++) {
                        if (M.getElmt(i, j)!=0) {
                            leading_temp=j;
                            break;
                        }
                    }
                    if (leading_temp<leading) {
                        leading=leading_temp;
                        tukar=i;
                    }
                }

                if (tukar!=-1) {
                    Matrix temp = new Matrix(1, M.columns);
                    for (int j = 0; j < M.columns; j++) {
                        temp.setELmt(0, j, M.getElmt(tukar,j));
                        M.setELmt(tukar, j, M.getElmt(now,j));
                        M.setELmt(now, j, temp.getElmt(0,j));
                    }
                    if (tukar!=M.rows) {
                        System.out.println();
                        System.out.print("Matriks : ");
                        System.out.println("(R"+(now+1)+" ditukar dengan R"+(tukar+1)+")");
                        M.printMatrix();
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
                if (M.getElmt(now, i)==1 ) {
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

    public Matrix cofactor(){
        int sign=1;
        int rows = this.rows;
        int cols = this.columns;
        Matrix cofacMatrix = new Matrix(rows,cols);
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
                cofacMatrix.setELmt(i,j,(det*sign));    
            }
        }
        return cofacMatrix;
    }
    
    // untuk menampilkan cara menentukan determinan dengan menggunakan ekspansi kofaktor
    public void determinanCofExp(){
        int i;
        int n = this.rows;
        double det;
        Matrix cofactorMat = this.cofactor();

        System.out.println();
        System.out.println("Matriks : ");
        printMatrix();
        System.out.println();
        System.out.println("Matriks Kofaktor : ");
        cofactorMat.printMatrix();

        System.out.println();
        System.out.println("Cara : ");
        System.out.println("1. Lakukan perhitungan dengan menggunakan baris pertama.");
        System.out.println("2. Kalikan elemen baris pertama dari Matriks dengan elemen baris pertama dari Matriks Kofaktor.");
        System.out.println("3. Lalu, tambahkan semua elemennya.");
        
        if (this.rows == 1){
            det = this.getElmt(0, 0);
            System.out.println(String.format("Determinant Matriks adalah %.2f", det));
        }
        System.out.println();
        System.out.print("Determinan : ");
        System.out.print(String.format( "(%.2f x %.2f)", this.getElmt(0,0) , cofactorMat.getElmt(0,0)));
        det = this.getElmt(0,0) * cofactorMat.getElmt(0,0);
        for(i=1;i<n;i++){
            System.out.print(String.format( " + (%.2f x %.2f)", this.getElmt(0, i), cofactorMat.getElmt(0, i)));
            det += this.matrix[0][i] * cofactorMat.matrix[0][i];
        }
        System.out.print(String.format(" = %.2f", det));
        System.out.println();
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

    public void swapRows(int i,int j) {
    double[] temp = this.matrix[i];
    this.matrix[i] = this.matrix[j];
    this.matrix[j] = temp;
    }

    public static double round(double number,int decimal){
        double factor = Math.pow(10, decimal);
        return Math.round(number * factor) / factor;
    }

    public double determinanOBE(){
        int n = this.rows;
        int i,j,k,l,changeRow = 0;
        int count = 1;
        double det = 1.0;

        System.out.println();
        System.out.println("Matriks : ");
        printMatrix();
        System.out.println();
        for(i=0;i<n;i++){
            if(this.getElmt(i,i) == 0){
                for(j=i+1;j<n;j++){
                    if (this.getElmt(j,i) != 0){
                        changeRow += 1;
                        this.swapRows(i,j);
                        System.out.println("Matriks " + count + " : (Tukar R" + (i + 1) + " dengan R" + (j + 1) + ")");
                        count ++;
                        printMatrix();
                        System.out.println();
                        break;
                    }
                }
            }
            for(k=i+1;k<n;k++){
                double pembuatnol = this.getElmt(k, i)/this.getElmt(i,i);
                for(l=0;l<n;l++){
                    this.setELmt(k, l, this.getElmt(k,l) - (pembuatnol*(this.getElmt(i,l))));
                }
                if (pembuatnol != 0){
                    System.out.println("Matriks " + count + " : (R" + (k + 1) + " dikurang dengan " + String.format("%.2f", pembuatnol) + " kali R" + (i + 1) + ")");
                    printMatrix();
                    System.out.println();
                    count ++;
                }
            }
        }

        double minus = Math.pow(-1, changeRow);
        for(i=0;i<n;i++){
            det *= this.getElmt(i,i);
        }
        double hasil = det*minus;
        double hasillast = round(hasil,8);

        System.out.println("Lalu,Kalikan Peubah (Berapa kali jumlah baris yang ditukar) dengan semua elemen diagonal dari Matriks tersebut.");
        System.out.println();

        System.out.print("Determinan : ");
        System.out.print(String.format("((%.2f)^%d)", minus, changeRow)); // Display the minus factor and changeRow
        System.out.print(" * ");
        for (int m = 0; m < n; m++) {
            double diagonalElement = this.getElmt(m, m);
            det *= diagonalElement;
            System.out.print(String.format("%.2f", diagonalElement));
    
            if (m < n - 1) {
                System.out.print(" * ");
            }
        }
    
        System.out.println(" = " + String.format("%.2f", hasillast));

        return hasillast;
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
            }
        }
        System.out.println("Matrix hasil ekspansi kofaktor:");
        adjoin.printMatrix();
        System.out.println();
        System.out.println("Dari kofaktor di transpose untuk diubah menjadi adjoin.");
        adjoin = adjoin.transpose();
        System.out.println("Adjoin:");
        adjoin.printMatrix();
        System.out.println();
        return adjoin;
    }

    public Matrix inverseAdjoinFunc(){
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
        System.out.println("Di cari Matriks Balikan dengan membagi setiap elemen dengan determinan.");
        System.out.println("Determinan:"+det);
        return inverse;
    }
}
