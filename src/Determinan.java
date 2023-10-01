import java.io.IOException;
import java.util.*;

public class Determinan {
    public static void landingpage(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                  DETERMINAN                   |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|           (1) Metode Reduksi Baris            |");
        System.out.println("|         (2) Metode Ekspansi Kofaktor          |");
        System.out.println("|                 (3) Menu Utama                |");
        Selection.ui();
        System.out.print("Pilih metode : ");
    }
    
    public static void DetOBEpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                   DETERMINAN                  |");
        Selection.ui();
        System.out.println("|              METODE REDUKSI BARIS             |");
        Selection.ui();
    }

    public static void DetCofpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                   DETERMINAN                  |");
        Selection.ui();
        System.out.println("|            METODE EKSPANSI KOFAKTOR           |");
        Selection.ui();
    }

    public static void Detkofaktor(Scanner scanner,String pilihan_input){
        DetCofpage();
        Matrix M = new Matrix(0, 0);
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            M.readMatrixFromFile(scanner);
        }
        M.determinanCofExp(scanner);
    }

    public static void DetOBE(Scanner scanner,String pilihan_input){
        DetOBEpage();
        Matrix M = new Matrix(0, 0);
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            M.readMatrixFromFile(scanner);
        }
 
        try {
            String output = String.format("%.2f", M.determinanOBE());
            Matrix.OutputToFile(scanner,output);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
