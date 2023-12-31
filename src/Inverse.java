import java.util.*;
import java.io.IOException;
public class Inverse{
    public static void landingpage(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                MATRIKS BALIKAN                |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|           (1) Metode Eliminasi Gauss          |");
        System.out.println("|                (2) Metode Adjoin              |");
        System.out.println("|                  (3) Menu Utama               |");
        Selection.ui();
        System.out.print("Pilih metode : ");
    }
    
    public static void inverseIdentitaspage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                MATRIKS BALIKAN                |");
        Selection.ui();
        System.out.println("|             METODE ELIMINASI GAUSS            |");
        Selection.ui();
    }

    public static void adjoinpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                MATRIKS BALIKAN                |");
        Selection.ui();
        System.out.println("|                 METODE ADJOIN                 |");
        Selection.ui();
    }

    public static void inversAdjoin(Scanner scanner,String pilihan_input){     
        String output = "";
        Matrix M = new Matrix(0, 0);
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            M.readMatrixFromFile(scanner);
        }
        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();
        System.out.println();
        if (M.determinanOBEtanpaPrint() == 0){
            System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
        }
        else{
        Matrix Inverse = M.inverseAdjoinFunc();
        System.out.println();
        System.out.println("Matriks Inverse :");
        Inverse.printMatrix();
        try {
            for (int x=0;x<Inverse.getRow();x++){
                for(int y=0;y<Inverse.getColumn();y++){
                    output += String.format("%2f",Inverse.getElmt(x, y)); 
                    output += " ";               
                }   
                output += "\n";
            }
            Matrix.OutputToFile(scanner,output);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        }
    }
    public static void inverseIdentitas(Scanner scanner,String pilihan_input){  
        String output = "";  
        Matrix M = new Matrix(0, 0);
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            M.readMatrixFromFile(scanner);
        }
        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();
        System.out.println();
        if (M.determinanOBEtanpaPrint() == 0){
            System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
        }
        else{
            Matrix Inverse = M.inverseIdentitas();
            System.out.println();
            System.out.println("Matriks Inverse :");
            Inverse.printMatrix();
            try {
                for (int x=0;x<Inverse.getRow();x++){
                    for(int y=0;y<Inverse.getColumn();y++){
                        output += String.format("%2f",Inverse.getElmt(x, y)); 
                        output += " ";               
                    }   
                    output += "\n";
                }
                Matrix.OutputToFile(scanner,output);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }
}