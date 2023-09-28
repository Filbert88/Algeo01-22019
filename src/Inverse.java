import java.util.*;
import java.io.*;

public class Inverse{
    public static boolean Page(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                 Matriks Balikan               |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|           (1) Metode Eliminasi Gauss          |");
        System.out.println("|                  (2) Adjoin                   |");
        System.out.println("|                  (3) Kembali                  |");
        Selection.ui();
        System.out.print("Pilih metode : ");
        String pilih=scanner.next();

        while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Pilih metode : ");
                    pilih=scanner.nextL();
                }

        if (pilih.equals("1")){
            System.out.println("HALO");
            return true;
        }
        else if (pilih.equals("2")){
            System.out.println();
            inversAdjoin(scanner,pilihan_input);
            return true;

        }
        else if (pilih.equals("3")){
            Selection.option_invers();
            return false;
        }
        return false;
    }

    public static void inversAdjoin(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|               MATRIKS BALIKAN                 |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|               METODE ADJOIN                   |");
        Selection.ui();        
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
        if (M.determinanCof() == 0){
            System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
        }
        else{
        Matrix Inverse = M.inverseAdjoinFunc();
        System.out.println("Hasil Inverse :");
        Inverse.printMatrix();
        }
    }
    }