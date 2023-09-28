import java.util.*;

public class Determinan {
    public static boolean Page(Scanner scanner){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                  DETERMINAN                   |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|          (1) Metode Ekspansi Kofaktor         |");
        System.out.println("|               (2) Metode OBE                  |");
        System.out.println("|                 (3) Kembali                   |");
        Selection.ui();
        System.out.print("Pilih Metode : ");
        String pilih = scanner.next();

        while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")) {
            System.out.println("Inputan tidak valid. Program hanya menerima input 1 sampai 3");
            System.out.print("Pilih metode : ");
            pilih=scanner.next();
        }

        if (pilih.equals("1")){
            System.out.println();
            Detkofaktor(scanner);
            return true;
        }
        else if (pilih.equals("2")){
            System.out.println();
            DetOBE(scanner);
            return true;
        }
        else if (pilih.equals("3")){
            Selection.option_spl();
            return false;
        }
        return false;
    }
    
    public static void Detkofaktor(Scanner scanner){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|                  DETERMINAN                   |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|               METODE KOFAKTOR                 |");
        Selection.ui();        

        Matrix M = new Matrix(0, 0);
        M.readSquareMatrix(scanner);
        M.determinanCofExp();
    }

    public static void DetOBE(Scanner scanner){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                   METODE OBE                  |");
        Selection.ui();
        
        Matrix M = new Matrix(0, 0);
        M.readSquareMatrix(scanner);
        M.determinanOBE();
        
    }
 
}
