import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Matrix {
    int rows;
    int columns;
    public double[][] matrix;

    public Matrix (int row, int col){
        this.rows = row;
        this.columns = col; 
        this.matrix = new double[row][col];
    }

    public Matrix ErrorMatrix (){
        Matrix Error = new Matrix(2,2);
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                this.setELmt(i,j,-9999999);
            }
        }
        return Error;
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

    int ValidateIntInput(String message,Scanner scanner) {
        while (true) {
            try {
                System.out.print(message);
                int input =  scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Input. Tolong masukin input sesuai format.");
                scanner.nextLine(); 
                System.out.println();
            }
        }
    }

    public boolean areStringsInside(String[] array) {
        for (String element : array) {
            try {
                Double.parseDouble(element); 
            } catch (NumberFormatException e) {
                try {
                    Integer.parseInt(element); 
                } catch (NumberFormatException ex) {
                    return true; 
                }
            }
        }
    return false; 
    }

    double getValidDoubleInput(String message, Scanner scanner) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Input. Tolong masukin input sesuai format.");
                scanner.nextLine();
            }
        }
    }

    public void readMatrixFromTerminal(Scanner scanner) {
        int row, column, i, j;
        boolean validMatrix;
        row = ValidateIntInput("Masukkan Jumlah Baris: ", scanner);
        column = ValidateIntInput("Masukkan Jumlah Kolom: ", scanner);
        this.rows = row;
        this.columns = column;
        this.matrix = new double[row][column];

        while (true) {
            validMatrix = true;
            System.out.println();
            System.out.println("Masukkan Matriks: ");

            for (i=0;i<row;i++) {
                String[] temp = scanner.nextLine().split(" ");
                if (temp.length != column) {
                    validMatrix = false;
                    System.out.println();
                    System.out.println(String.format("Data dalam tiap baris hanya boleh sebanyak %d.", column));
                    System.out.println("Tolong input Matriks ulang dari awal!\n");
                    break;
                }
                for (j=0;j<column;j++) {
                    try {
                        this.matrix[i][j] = Double.parseDouble(temp[j]);
                    } catch (NumberFormatException e) {
                        validMatrix = false;
                        System.out.println();
                        System.out.println("Masukan matriks tidak boleh selain bilangan riil.");
                        System.out.println("Tolong input Matriks ulang dari awal!\n");
                        break;
                    }
                }
                if (validMatrix == false) {
                    break;
                }
            }
            if (validMatrix) {
                return;
            }
        }
    }
    

    public void readMatrixFromTerminalRegresi(int rows,int cols,Scanner scanner){
        double elmt;
        int row,column,i,j;

        this.rows = rows;
        this.columns = cols+1;
        this.matrix = new double[rows][cols+1];
    
        System.out.println("Masukkan Matriks: ");
        for(i=0;i<rows;i++){
            for(j=0;j<cols+1;j++){
                elmt = scanner.nextDouble();
                this.matrix[i][j] = elmt;
            }
        }
    }

    public void readSquareMatrix(Scanner scanner){
        int row,column,i,j;
        boolean validMatrix;
        row = ValidateIntInput("Masukkan Jumlah Ukuran Matriks yang diinginkan: ",scanner);
        column = row;
        this.rows = row;
        this.columns = column;
        this.matrix = new double[row][column];

        while (true){
            validMatrix = true;
            System.out.println();
            System.out.println("Masukkan Matriks: ");

            for(i=0;i<row;i++){
                String[] temp = scanner.nextLine().split(" ");
                if (temp.length != column) {
                    validMatrix = false;
                    System.out.println();
                    System.out.println(String.format("Data dalam tiap baris hanya boleh sebanyak %d.", column));
                    System.out.println("Tolong input Matriks ulang dari awal!\n");
                    break;
                }
                for (j=0; j<column; j++) {
                    try {
                        this.matrix[i][j] = Double.parseDouble(temp[j]);
                    } catch (NumberFormatException e) {
                        validMatrix = false;
                        System.out.println();
                        System.out.println("Masukan matriks tidak boleh selain bilangan ril.");
                        System.out.println("Tolong input Matriks ulang dari awal!\n");
                        break;
                    }
                }
                if (validMatrix  == false) {
                    break;
                }
            }
            if (validMatrix) {
                return;
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
        while (true) {
            int row = 0;
            boolean valid=true;
            int col = 0;
            int counter = 0;
            System.out.print("Enter the file name:");
            String fileName = scanner.next();
            if (isTxtFile(fileName)) {
                String filePath = "../test/" + fileName;
                try (BufferedReader rowcolReader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = rowcolReader.readLine()) != null) {
                        row += 1;
                        String[] temparray = line.split(" ");
                        if (this.areStringsInside(temparray)) {
                            valid = false;
                        }
                        col = temparray.length;
                    }
                    rowcolReader.close();
                    if (valid){
                        BufferedReader matrixReader = new BufferedReader(new FileReader(filePath));
                        this.rows = row;
                        this.columns = col;
                        this.matrix = new double[row][col];
                        while ((line = matrixReader.readLine()) != null) {
                            String[] temparray = line.split(" ");
                            for (int i = 0; i < col; i++) {
                                double value = Double.parseDouble(temparray[i]);
                                this.setELmt(counter, i, value);
                            }
                            counter += 1;
                        }
                        return;
                    }
                    else{
                        System.out.println("There are strings inside the matrix, please enter another file name to progress.");
                    }
                } catch (IOException e) {
                    System.out.println("Please make sure the file exists and is readable.");
                    System.out.println("Please enter a valid file name.");
                }
            } else {
                System.out.println("The file is not a txt file.");
                System.out.println("Please enter a valid file name.");
            }
        }
}

    public Matrix readMatrixFromFileForBicubic(Scanner scanner) {
        while (true) {
            int row = 0;
            int a=0;
            boolean XYvalidation = true;
            int maxcol =0;
            boolean valid=true;
            int col = 0;
            int rowcounter = 0;
            int counter = 0;
            System.out.print("Enter the file name:");
            String fileName = scanner.next();
            if (isTxtFile(fileName)) {
                String filePath = "../test/" + fileName;
                try (BufferedReader rowcolReader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = rowcolReader.readLine()) != null) {
                        row += 1;
                        String[] temparray = line.split(" ");
                        if (this.areStringsInside(temparray)) {
                            valid = false;
                        }
                        col = temparray.length;
                        maxcol = Math.max(col,maxcol);
                        System.out.println("row"+row);
                    }
                        if(row !=5 || maxcol != 4){
                            XYvalidation = false;
                        }
                    rowcolReader.close();
                    if (valid && XYvalidation){
                        BufferedReader matrixReader = new BufferedReader(new FileReader(filePath));
                        this.rows = row-1;
                        this.columns = 4;
                        this.matrix = new double[4][4]; //col selalu 4 dan row selalu 4    
                        while ((line = matrixReader.readLine()) != null) {
                            rowcounter +=1;
                            String[] temparray = line.split(" ");
                            if (rowcounter <=row-1){ //belum di row terakhir
                                for (int i = 0; i < 4; i++) { //Hanya 4 kolom dan sudah pasti
                                    double value = Double.parseDouble(temparray[i]);
                                    this.setELmt(counter, i, value);
                                    }   
                                    counter += 1;
                                }
                            else{
                                if (temparray.length !=2){
                                    System.out.println("Row terakhir harap berisi titik X dan Y yang akan ditaksir!");
                                }
                                else{
                                    Matrix taksiran = new Matrix(1,2);
                                    for (int i = 0; i < 2; i++) {
                                        double value = Double.parseDouble(temparray[i]);                                        taksiran.setELmt(0, a, value);
                                        a+=1;
                                    }
                                    return taksiran;
                                }
                        }
                    }
                    }
                    else if (!XYvalidation){
                        System.out.println("Hanya menerima input matrix 4 baris dan 4 kolom");
                    }
                    else{
                        System.out.println("Terdapat input string di dalam matrix, harap input matrix dengan element double.");
                    }
                } catch (IOException e) {
                    System.out.println("Pastikan File ada dan dapat dibaca.");
                    System.out.println("Harap masukkan nama file yang valid");
                }
            } else {
                System.out.println("File tidak dalam bentuk .txt !");
                System.out.println("Harap masukkan nama file yang valid");
            }
        }
    }
    
    public double readMatrixFromFileforInterpolation(Scanner scanner) {
        while (true) {
            int row = 0;
            boolean XYvalidation = true;
            boolean valid=true;
            int col = 0;
            int rowcounter = 0;
            int counter = 0;
            System.out.print("Enter the file name : ");
            String fileName = scanner.next();
            if (isTxtFile(fileName)) {
                String filePath = "../test/" + fileName;
                try (BufferedReader rowcolReader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = rowcolReader.readLine()) != null) {
                        row += 1;
                        String[] temparray = line.split(" ");
                        if (this.areStringsInside(temparray)) {
                            valid = false;
                        }
                        col = temparray.length;
                        if(col >2){
                            XYvalidation = false;
                        }
                    }
                    rowcolReader.close();
                    if (valid && XYvalidation){
                        BufferedReader matrixReader = new BufferedReader(new FileReader(filePath));
                        this.rows = row-1;
                        this.columns = 2;
                        this.matrix = new double[row-1][2]; //col selalu 2 yakni x0 dan y0    
                        while ((line = matrixReader.readLine()) != null) {
                            rowcounter +=1;
                            String[] temparray = line.split(" ");
                            if (rowcounter <=row-1){
                                if (temparray.length <2){
                                    System.out.print("");
                                }
                                else{
                                    for (int i = 0; i < 2; i++) { //Hanya 2 kolom dan sudah pasti
                                        double value = Double.parseDouble(temparray[i]);
                                        this.setELmt(counter, i, value);
                                    }   
                                    counter += 1;
                                }
                            }
                            else{
                                if (temparray.length > 1){
                                    System.out.println("Row terakhir harap berisi nilai X yang akan ditaksir!");
                                }
                                else{
                                return Double.parseDouble(temparray[0]);
                                }
                        }
                    }
                    }
                    else if (!XYvalidation){
                        System.out.println("Hanya menerima input matrix 2 kolom yaitu Xn dan Yn");
                    }
                    else{
                        System.out.println("Terdapat input string di dalam matrix, harap input matrix dengan element double.");
                    }
                } catch (IOException e) {
                    System.out.println("Pastikan File ada dan dapat dibaca.");
                    System.out.println("Harap masukkan nama file yang valid");
                }
            } else {
                System.out.println("File tidak dalam bentu .txt !");
                System.out.println("Harap masukkan nama file yang valid");
            }
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

    public void determinanCofExp(Scanner scanner){
        // untuk menampilkan cara menentukan determinan dengan menggunakan ekspansi kofaktor
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

        try {
            String output = String.format("%.2f", det);
            Matrix.OutputToFile(scanner,output);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public double determinanCof() {
        // mengembalikan nilai determinan
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
        // menentukan determinan dengan menggunakan reduksi baris
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
                if (this.getElmt(i, i) != 0){
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
        }

        double minus = Math.pow(-1, changeRow);
        for(i=0;i<n;i++){
            det *= this.getElmt(i,i);
        }
        double hasil = det*minus;
        double hasillast = round(hasil,8);

        System.out.println("Lalu,Kalikan Peubah (Berapa kali jumlah baris yang ditukar) dengan semua elemen diagonal dari Matriks tersebut.");
        System.out.println();

        System.out.format("Total Pertukaran Baris Yang terjadi : %d", changeRow);
        System.out.println();
        System.out.print("Determinan : ");
        System.out.print(String.format("((%d)^%d)", -1,changeRow)); 
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

    public double determinanOBEtanpaPrint(){
        int n = this.rows;
        Matrix mOut = this.copyMatrix();
        int i,j,k,l,changeRow = 0;
        double det = 1.0;

        for(i=0;i<n;i++){
            if(mOut.getElmt(i,i) == 0){
                for(j=i+1;j<n;j++){
                    if (mOut.getElmt(j,i) != 0){
                        changeRow += 1;
                        mOut.swapRows(i,j);
                        break;
                    }
                }
            }
            for(k=i+1;k<n;k++){
                double pembuatnol = mOut.getElmt(k, i)/mOut.getElmt(i,i);
                if (mOut.getElmt(i, i) != 0){
                    for(l=0;l<n;l++){
                        mOut.setELmt(k, l, mOut.getElmt(k,l) - (pembuatnol*(mOut.getElmt(i,l))));
                    }
                }
            }
        }

        double minus = Math.pow(-1, changeRow);
        for(i=0;i<n;i++){
            det *= mOut.getElmt(i,i);
        }
        double hasil = det*minus;
        double hasillast = round(hasil,8);

        return hasillast;
    }

    public Matrix transpose(){
        int rows = this.rows;
        int cols = this.columns;
        Matrix transposeMatrix = new Matrix(cols,rows);
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
                double det = minor.determinanOBE();
                adjoin.setELmt(i,j,(det*sign));    
            }
        }
        System.out.println("Matriks hasil ekspansi kofaktor :");
        adjoin.printMatrix();
        System.out.println();
        System.out.println("Dari kofaktor di transpose untuk diubah menjadi adjoin.");
        adjoin = adjoin.transpose();
        System.out.println();
        System.out.println("Adjoin :");
        adjoin.printMatrix();
        System.out.println();
        return adjoin;
    }

    public Matrix inverseAdjoinFunc(){
        int rows = this.rows;
        int cols = this.columns;
        Matrix inverse = new Matrix(rows,cols);
        Matrix adjoin = this.adjoin();
        double det = this.determinanOBE();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                inverse.setELmt(i,j,adjoin.getElmt(i,j)/det);
            }
        }
        System.out.println("Di cari Matriks Balikan dengan membagi setiap elemen dengan determinan.");
        System.out.println();
        System.out.println("Determinan : "+det);
        return inverse;
    }

    public static void interPolim(Scanner scanner){
        int n;
        String output = "";
        DecimalFormat df = new DecimalFormat("#.####");
        do {
            System.out.print("Masukin berapa titik yang Anda mau Interpolasikan : ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Titik harus lebih dari harus lebih dari 0 untuk melakukan Interpolasi.");
            }
        } while (n <= 0);
        Matrix m = new Matrix(n,n+1);
        Matrix hasilspl = new Matrix(n,0);
        int count = 0;
        int ocurrence = 0;

        for(int i=0;i<n;i++){
            double x = m.getValidDoubleInput(String.format("Masukkan x%d : ", i), scanner);

            int j = 0;
            while (j< m.getColumn() - 1){
                m.matrix[i][j] = Math.pow(x,j);
                j++;
            }
            double y = m.getValidDoubleInput(String.format("Masukkan y%d : ", i), scanner);
            m.matrix[i][j] = y;
        }

        System.out.println();
        double soal = m.getValidDoubleInput(String.format("Masukkan nilai x%d yang mau ditaksir y nya : ", n), scanner);

        System.out.println();
        System.out.println("Matriks Augmented : ");
        m.printMatrix();

        double firstValue = m.matrix[0][1];
        for(int i=1;i<n;i++){
            if(m.matrix[i][1] == firstValue){
                ocurrence++;
            }
        }
        hasilspl = m.hasilOBEGauss();

        for(int i=0;i<n;i++){
            if(hasilspl.matrix[i][0]!=0){
                count ++;
            }
        }

        if (count != 0 && n>1 && ocurrence != n-1){
            System.out.println();
            System.out.print("Polynomial Function : ");
            System.out.println();
            output += "f(x) = ";
            System.out.print(output);
            boolean isZero = true;
            boolean isZero2 = true;

            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                if (Math.abs(coefficient) < 1e-4) {
                    continue;
                }
                if (!isZero) {
                    System.out.print(coefficient > 0 ? " + " : " - ");
                    if (coefficient > 0) {
                        output += " + ";
                    } else {
                        output += " - ";
                    }
                    
                } else {
                    isZero = false;
                    if (coefficient < 0) {
                        System.out.print("-");
                        output += "-";
                    }
                }
                if (i == 0) {
                    System.out.print(String.format(df.format(Math.abs(coefficient))));
                    output += String.format(df.format(Math.abs(coefficient)));
                } else if (i == 1) {
                    System.out.print(String.format(df.format(Math.abs(coefficient)))+" x");
                    output += String.format(df.format(Math.abs(coefficient)))+" x";
                } else {
                    System.out.print(String.format(df.format(Math.abs(coefficient))) + " x^" + i);
                    output += String.format(df.format(Math.abs(coefficient))) + " x^" + i;
                }
            }

            double result = 0.0;
            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                result += coefficient * Math.pow(soal, i);
            }

            System.out.println();
            System.out.print(String.format("f(" + df.format(soal) + ") = "));
            output += String.format("\nf(" + df.format(soal) + ") = ");
            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                if (Math.abs(coefficient) < 1e-4) {
                    continue;
                }

                if (!isZero2) {
                    System.out.print(coefficient > 0 ? " + " : " - ");
                    if (coefficient > 0) {
                        output += " + ";
                    } else {
                        output += " - ";
                    }
                } else {
                    isZero2 = false;
                    if (coefficient < 0) {
                        System.out.print("-");
                        output += "-";
                    }
                }

                if (i == 0) {
                    System.out.print(String.format(df.format(Math.abs(coefficient))));
                    output += String.format(df.format(Math.abs(coefficient)));
                } else if (i == 1) {
                    System.out.print(String.format(df.format(Math.abs(coefficient)))+ " * (" + df.format(Math.abs(soal)) + ")");
                    output += String.format(df.format(Math.abs(coefficient)))+ " * (" + df.format(Math.abs(soal)) + ")";
                } else {
                    System.out.print(String.format(df.format(Math.abs(coefficient))) + " * (" + df.format(Math.abs(soal)) + "^" + i + ")");
                    output += String.format(df.format(Math.abs(coefficient))) + " * (" + df.format(Math.abs(soal)) + "^" + i + ")"; 
                }
            }
            System.out.println(String.format(" = " + df.format(result)));
            output += String.format(" = " + df.format(result));
        } else{
            System.out.println();
            System.out.println("Tidak ada fungsi Polynomial");
            output += " Tidak ada fungsi Polynomial";
        } 

        try {
            OutputToFile(scanner,output);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public static void InterPolimFromFile(Scanner scanner){
        int n;
        String output = "";
        DecimalFormat df = new DecimalFormat("#.####");
        Matrix m = new Matrix(0, 0);
        double soal = m.readMatrixFromFileforInterpolation(scanner);
        Matrix matrixSoal = m.copyMatrix();
        n = matrixSoal.getRow();

        Matrix newMatrix = new Matrix(n,n+1);
        int column = newMatrix.getColumn();

        Matrix hasilspl = new Matrix(n, 0);
        int count = 0;
        int ocurrence = 0;

        for(int i=0;i<n;i++){
            double x = matrixSoal.matrix[i][0];
            int j = 0;
            while (j< column - 1){
                newMatrix.matrix[i][j] = Math.pow(x,j);
                j++;
            }
            double y = matrixSoal.matrix[i][1] ;
            newMatrix.matrix[i][j] = y;
        }

        System.out.println();
        System.out.println("Matriks Augmented : ");
        newMatrix.printMatrix();

        double firstValue = newMatrix.matrix[0][1];
        for(int i=1;i<n;i++){
            if(newMatrix.matrix[i][1] == firstValue){
                ocurrence++;
            }
        }
        hasilspl = newMatrix.hasilOBEGauss();

        for(int i=0;i<n;i++){
            if(hasilspl.matrix[i][0]!=0){
                count ++;
            }
        }

        if (count != 0 && n>1 && ocurrence != n-1){
            System.out.println();
            System.out.print("Polynomial Function : ");
            System.out.println();
            output += "f(x) = ";
            System.out.print(output);
            boolean isZero = true;
            boolean isZero2 = true;

            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                if (Math.abs(coefficient) < 1e-4) {
                    continue;
                }
                if (!isZero) {
                    System.out.print(coefficient > 0 ? " + " : " - ");
                    if (coefficient > 0) {
                        output += " + ";
                    } else {
                        output += " - ";
                    }
                    
                } else {
                    isZero = false;
                    if (coefficient < 0) {
                        System.out.print("-");
                        output += "-";
                    }
                }
                if (i == 0) {
                    System.out.print(String.format(df.format(Math.abs(coefficient))));
                    output += String.format(df.format(Math.abs(coefficient)));
                } else if (i == 1) {
                    System.out.print(String.format(df.format(Math.abs(coefficient)))+" x");
                    output += String.format(df.format(Math.abs(coefficient)))+" x";
                } else {
                    System.out.print(String.format(df.format(Math.abs(coefficient))) + " x^" + i);
                    output += String.format(df.format(Math.abs(coefficient))) + " x^" + i;
                }
            }

            double result = 0.0;
            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                result += coefficient * Math.pow(soal, i);
            }

            System.out.println();
            System.out.print(String.format("f(" + df.format(soal) + ") = "));
            output += String.format("\nf(" + df.format(soal) + ") = ");
            for (int i = 0; i < n; i++) {
                double coefficient = hasilspl.matrix[i][0];
                if (Math.abs(coefficient) < 1e-4) {
                    continue;
                }

                if (!isZero2) {
                    System.out.print(coefficient > 0 ? " + " : " - ");
                    if (coefficient > 0) {
                        output += " + ";
                    } else {
                        output += " - ";
                    }
                } else {
                    isZero2 = false;
                    if (coefficient < 0) {
                        System.out.print("-");
                        output += "-";
                    }
                }

                if (i == 0) {
                    System.out.print(String.format(df.format(Math.abs(coefficient))));
                    output += String.format(df.format(Math.abs(coefficient)));
                } else if (i == 1) {
                    System.out.print(String.format(df.format(Math.abs(coefficient)))+ " * (" + df.format(Math.abs(soal)) + ")");
                    output += String.format(df.format(Math.abs(coefficient)))+ " * (" + df.format(Math.abs(soal)) + ")";
                } else {
                    System.out.print(String.format(df.format(Math.abs(coefficient))) + " * (" + df.format(Math.abs(soal)) + "^" + i + ")");
                    output += String.format(df.format(Math.abs(coefficient))) + " * (" + df.format(Math.abs(soal)) + "^" + i + ")"; 
                }
            }
            System.out.println(String.format(" = " + df.format(result)));
            output += String.format(" = " + df.format(result));
        } else{
            System.out.println();
            System.out.println("Tidak ada fungsi Polynomial");
            output += " Tidak ada fungsi Polynomial";
        } 

        try {
            OutputToFile(scanner,output);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // untuk interpolasi
    public Matrix hasilOBEGauss(){
        int now=0;
        while (now<this.rows && now<this.columns) {
            if (this.getElmt(now,now)==0) {

                int tukar=-1;
                int leading=Integer.MAX_VALUE;
                for (int i = 0; i < this.columns; i++) {
                    if (this.getElmt(now,i)!=0) {
                        leading=i;
                        break;
                    }
                }

                for (int i = now+1; i < this.rows; i++) {
                    int leading_temp=Integer.MAX_VALUE;
                    for (int j = 0; j < this.columns; j++) {
                        if (this.getElmt(i, j)!=0) {
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
                    Matrix temp = new Matrix(1, this.columns);
                    for (int j = 0; j < this.columns; j++) {
                        temp.setELmt(0, j, this.getElmt(tukar,j));
                        this.setELmt(tukar, j, this.getElmt(now,j));
                        this.setELmt(now, j, temp.getElmt(0,j));
                    }
                }
            }

            if (this.getElmt(now,now)!=0) {
                if (this.getElmt(now,now)!=1) {
                    double pembagi=this.getElmt(now,now);
                    for (int j = 0; j < this.columns; j++) {
                        if (this.getElmt(now,j)!=0) {
                            this.setELmt(now, j, (this.getElmt(now,j)/pembagi));   
                        }
                    }
                }

                for (int i = now+1; i < this.rows; i++) {
                    if (this.getElmt(i,now)!=0) {
                        double pengali=this.getElmt(i,now);
                        for (int j = 0; j < this.columns; j++) {
                            this.setELmt(i, j, this.getElmt(i,j)-pengali*this.getElmt(now,j));
                        }
                    }
                }
            }

            else{
                int leading=-1;
                for (int i = 0; i < this.columns; i++) {
                    if (this.getElmt(now, i)!=0) {
                        leading=i;
                        break;
                    }
                }
                if (leading!=-1) {
                    double pembagi=this.getElmt(now,leading);

                    if (pembagi!=1) {
                        for (int j = 0; j < this.columns; j++) {
                            if (this.getElmt(now,j)!=0) {
                                this.setELmt(now, j, (this.getElmt(now,j)/pembagi));   
                            }
                        }
                    }

                    for (int i = now+1; i < this.rows; i++) {
                        if (this.getElmt(i,leading)!=0) {
                            double pengali=this.getElmt(i,leading);
                            for (int j = 0; j < this.columns; j++) {
                                this.setELmt(i, j, this.getElmt(i,j)-pengali*this.getElmt(now,j));
                            }
                        }
                    }
                }
            }

            now++;

        }
        now=this.rows-1;
        while (now>=0) {
            int leading=-1;
            for (int i = 0; i < this.columns; i++) {
                if (this.getElmt(now, i)==1 ) {
                    leading=i;
                    break;
                }
            }
            if (leading!=-1) {
                for (int i = now-1; i >= 0; i--) {
                    if (this.getElmt(i,leading)!=0) {
                        double pengali=this.getElmt(i,leading);
                        for (int j = 0; j < this.columns; j++) {
                            this.setELmt(i, j, this.getElmt(i,j)-pengali*this.getElmt(now,j));
                        }
                    }
                }             
            }
            now--;
        }

        Matrix Mjawab= new Matrix(this.columns-1, 1);
        for (int i = 0; i < Mjawab.rows; i++) {
            Mjawab.setELmt(i, 0, this.getElmt(i, this.columns-1));
        }

        return Mjawab;
    }
    //tes dulu

    public Matrix createIdentitas(int rows){
        Matrix identity = new Matrix(rows,rows);
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                if(i==j){
                    identity.setELmt(i,j,1);
                }
            }
        }
        return identity;
    }
    
    public Matrix gabung(){
        Matrix m2 = this.createIdentitas(this.rows);
        int rows = this.rows;
        int columns = this.columns + m2.columns; 
        Matrix newMatrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double val;
                if (j < this.columns) {
                    val = this.getElmt(i, j);
                } else {
                    val = m2.getElmt(i, j - this.columns);
                }
                newMatrix.setELmt(i, j, val);
            }
        }

        return newMatrix;
    }

    public Matrix inverseIdentitas(){
        int a=0;
        Matrix input = this.gabung();
        input = input.OBE_red(input);
        Matrix inverse = new Matrix(this.rows,this.rows);
        int b= (input.columns)/2;
        for (int i=0;i<(input.columns/2);i++){
            if(input.getElmt(i,i) !=1){
                return this;
            }
        }
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<this.rows;j++){
                double val = input.getElmt(a,b);
                inverse.setELmt(i,j,val);
                b+=1;
                if(b==(input.columns)){
                    b=(input.columns)/2;
                    a+=1;
                }
            }
        }
        return inverse;
    }

    public Matrix hasilSPL(){
        Matrix Mdup=this.copyMatrix();

        if (Mdup.columns-1!=Mdup.rows) {
            return (new Matrix(Mdup.columns-1, 1));
        }else{
            Matrix Mcopy=new Matrix(Mdup.rows, Mdup.columns-1);
            for (int i = 0; i < Mcopy.rows; i++) {
                for (int j = 0; j < Mcopy.columns; j++) {
                    Mcopy.setELmt(i, j, Mdup.getElmt(i, j));
                }
            }
            double det=Mcopy.determinanOBEtanpaPrint();

            if (Mcopy.determinanOBEtanpaPrint() == 0){
                return (new Matrix(Mdup.columns-1, 1));
            }
            else{
                Matrix Mhasil= new Matrix(Mdup.rows, 1);
                for (int i = 0; i < Mhasil.rows; i++) {
                    Mhasil.setELmt(i, 0, Mdup.getElmt(i, Mdup.columns-1));
                }

                Matrix Mdet = Mhasil.copyMatrix();
                for (int i = 0; i < Mcopy.columns; i++) {
                    Matrix Mtemp = Mcopy.copyMatrix();
                    for (int j = 0; j < Mcopy.rows; j++) {
                        Mtemp.setELmt(j, i, Mhasil.getElmt(j, 0));
                    }
                    Mdet.setELmt(i, 0, Mtemp.determinanOBEtanpaPrint());
                }

                for (int i = 0; i < Mhasil.rows; i++) {
                    Mdet.setELmt(i, 0, Mdet.getElmt(i, 0)/det);
                }
                return Mdet;
            }

        }
    }

        public Matrix OBETanpaCara(Matrix M){
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
                }

                int count=0;
                for (int i = now+1; i < M.rows; i++) {
                    if (M.getElmt(i,now)!=0) {
                        double pengali=M.getElmt(i,now);
                        for (int j = 0; j < M.columns; j++) {
                            M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                        }
                        count++;
                    }
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
                    }
                    int count=0;
                    for (int i = now+1; i < M.rows; i++) {
                        if (M.getElmt(i,leading)!=0) {
                            double pengali=M.getElmt(i,leading);
                            for (int j = 0; j < M.columns; j++) {
                                M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                            }
                            count++;
                        }
                    }
                }
            }

            now++;
        }
        return M;
    }

    public Matrix OBE_redTanpaCara(Matrix M){
        M.OBETanpaCara(M);
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
                        count++;
                    }
                }                   
            }
            now--;
        }
        return M;
    }
    public Matrix InverseIdentitasTanpaCara(){
        int a=0;
        Matrix input = this.gabung();
        input = input.OBE_redTanpaCara(input);
        Matrix inverse = new Matrix(this.rows,this.rows);
        int b= (input.columns)/2;
        for (int i=0;i<(input.columns/2);i++){
            if(input.getElmt(i,i) !=1){
                return this;
            }
        }
        for (int i=0;i<this.rows;i++){
            for(int j=0;j<this.rows;j++){
                double val = input.getElmt(a,b);
                inverse.setELmt(i,j,val);
                b+=1;
                if(b==(input.columns)){
                    b=(input.columns)/2;
                    a+=1;
                }
            }
        }
        return inverse;
    }

    // Dari sini mulai bicubic
    public int checkPositionX(int cols){
        if(cols==0 || cols == 2){
            return 0;
        }
        else{
            return 1;
        }
    }
    public int checkPositionY(int cols){
        if(cols==0 || cols == 1){
            return 0;
        }
        else{
            return 1;
        }
    }
    public Matrix expansionMatrix(){
        int col = this.columns;
        int row = this.rows;
        int checkrow = 0;  //checkcol dan checkrow berupa penanda pada matrix hasil inputan
        int checkcol = 0;
        int expansionX = 0;
        int expansionY = 0;
        double val = 0;
        int turunan = 0;
        Matrix A = new Matrix(16,16);
        for(int a=0;a<16;a++){
            for(int b=0;b<16;b++){
                int x =this.checkPositionX(checkcol);
                int y =this.checkPositionY(checkcol);
                int j=expansionY;
                int i =expansionX;
                if (turunan ==0){
                    val = (Math.pow(x,i))*(Math.pow(y,j));
                }
                else if (turunan == 1){
                    if (i==0){
                        val = 0;
                    }
                    else{
                    val = i*(Math.pow(x,(i-1))*(Math.pow(y,j)));
                    }
                }
                else if (turunan == 2){
                    if (j==0){
                        val = 0;
                    }
                    else{
                    val = j*(Math.pow(x,i))*(Math.pow(y,(j-1)));
                    }
                }
                else{
                    if (j==0 || i ==0){
                        val =0;
                    }
                    else{
                    val = i*j*(Math.pow(x,(i-1)))*(Math.pow(y,(j-1)));
                    }
                }
                if(expansionX == col-1){
                    expansionY +=1;
                    expansionX = -1;
                }
                expansionX +=1;
                A.setELmt(a,b,val);
            }
            expansionY=0;
            if (checkcol == col-1){ //Setiap 1 baris sudah terisi pada matrix ekspansi, maka penanda bergeser
                checkrow +=1;
                checkcol =-1;
                turunan +=1;
            }
            checkcol+=1;
        }
        System.out.println("Didapat nilai hasil ekspansi atau A yaitu:");
        A.printMatrix();
        System.out.println();
        return A;
    }
    
    public Matrix multiply(Matrix m1,Matrix m2){
        int row = m1.rows;
        int cols = m2.columns;
        int cols1 = m1.columns;
        double m1value;
        double m2value;
        Matrix m3 = new Matrix(row,cols);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                double sum=0.0;
                for (int k = 0; k < cols1; k++) {
                    m1value = m1.getElmt(i,k);
                    m2value = m2.getElmt(k,j);
                    sum += m1value * m2value;
                }
                m3.setELmt(i, j, sum);
            }
        }
        return m3;
    }

    public Matrix MatrixTurunan(){
        Matrix turunan = new Matrix (16,1);
        double Nilaiturunan;
        int p=0;
        int q=0;
        for(int i=0;i<16;i++){
            for (int j=0;j<1;j++){
                turunan.setELmt(i,j,this.getElmt(q,p));
                p+=1;
                if(p==4){
                    p=0;
                    q+=1;
                }
            }
        }
        System.out.println();
        System.out.println("Matrix Inputan:");
        turunan.printMatrix();
        System.out.println();
        return turunan;
    }

    public Matrix InverseExpansion(){
        Matrix expansion = this.expansionMatrix();
        expansion = expansion.InverseIdentitasTanpaCara();
        System.out.println("Matrix A invers :");
        expansion.printMatrix();
        return expansion;
    }
    public double bicubicSplineInterpolation(double x,double y){
        Matrix expansion = InverseExpansion();
        Matrix turunan = this.MatrixTurunan();
        Matrix alpha = this.multiply(expansion,turunan);
        System.out.println();
        System.out.println("Menghitung nilai alpha dengan rumus y=A.alpha");
        Matrix alphaconvert = new Matrix(4,4);
        int u=0;
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                alphaconvert.setELmt(j,i,alpha.getElmt(u,0));
                u++;
            }
        }
        alphaconvert.printMatrix();
        int newX;
        double val =1;
        int newY;
        Matrix newMatrixX = new Matrix(1,4);
        Matrix newMatrixY = new Matrix(4,1);
        for (int i=0;i<1;i++){ // Deply the X elements
            for (int j=0;j<4;j++){
                newMatrixX.setELmt(i,j,val);
                val = val*x;
            }
        }
        val = 1;
        for (int a=0;a<4;a++){ //Deploy Y elements
            for (int b=0;b<1;b++){
                newMatrixY.setELmt(a,b,val);
                val = val*y;
            }
        }
        System.out.println();
        System.out.println("Matrix X:");
        newMatrixX.printMatrix();
        System.out.println();
        System.out.println("Matrix Y:");
        newMatrixY.printMatrix();
        System.out.println();
        Matrix hasil = multiply(multiply(newMatrixX,alphaconvert),newMatrixY);
        System.out.println("Nilai f("+x+","+y+") adalah "+hasil.getElmt(0,0));
        return hasil.getElmt(0,0);

    }

    //Dari sini kebawah itu Regresi
    public Matrix createXMatrix(){
        int rows = this.rows;
        int columns = this.columns;
        double val;
        int a=0;
        int b=0;
        Matrix newMatrix = new Matrix(rows,columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(j==0){
                    newMatrix.setELmt(i,j,1);
                }
                else{
                    val = this.getElmt(a,b);
                    newMatrix.setELmt(i,j,val);
                    b +=1;
                    if (b == columns){
                        b = 0;
                        a +=1;
                    }
                }
            }
        }
        return newMatrix;
    }

    public Matrix createYMatrix(){
        int rows = this.rows;
        int columns = this.columns;
        int a=0;
        Matrix newMatrix = new Matrix(rows,1);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(j==columns-1){
                    newMatrix.setELmt(a,0,this.getElmt(i,j));
                    a+=1;
                }
            }
        }
        return newMatrix;
    }

    public Matrix Beta(){
        Matrix newY = this.createYMatrix();
        Matrix newX = this.createXMatrix();
        Matrix newXTranspose = newX.transpose();
        Matrix newX2 = multiply(newXTranspose,newX);
        Matrix newXInverse2 = newX2.InverseIdentitasTanpaCara();
        Matrix Beta = multiply(multiply(newXInverse2,newXTranspose),newY);
        return Beta;
    }

    public static void OutputToFile (Scanner scanner,String result) throws IOException {
        System.out.println("\nApakah anda ingin menyimpan hasilnya dalam folder ?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");

        String pilihan;
        while (true) {
            System.out.print("\nKetik 1 Jika 'Ya' dan 2 jika 'Tidak' : ");
            pilihan = scanner.next();

            if (pilihan.equals("1") || pilihan.equals("2")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan ketik 1 untuk 'Ya' atau 2 untuk 'Tidak'.");
            }
        }
        if (pilihan.equals("1")){
            boolean saved = false;

            while (!saved){
                System.out.print("\nMasukan Nama Output file yang Anda Inginkan (beserta .txt): ");
                String fileName = scanner.next();

                while (!fileName.toLowerCase().endsWith(".txt")){
                    if (!fileName.toLowerCase().endsWith(".txt")) {
                        System.out.println("File harus disertai extension '.txt'. Tolong masukan Nama file yang benar.");
                        System.out.println();
                    }
                    System.out.print("Masukan Nama Output file yang Anda Inginkan (beserta .txt): ");
                    fileName = scanner.next();
                };

                String filePath = "../test/output/" + fileName;
                File file = new File(filePath);

                file.createNewFile();

                if (file.exists()) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                        writer.println(result);
                        System.out.println("Hasil telah disimpan ke " + fileName);
                        saved = true;
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                } else {
                    System.out.println("File '" + fileName + "' tidak ada.");
                }
            }
        }  
    }
}

