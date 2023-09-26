import java.util.*;

public class SPL {
    public static boolean page(Scanner scanner){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|           (1) Metode Eliminasi Gauss          |");
        System.out.println("|        (2) Metode Eliminasi Gauss-Jordan      |");
        System.out.println("|           (3) Metode Matriks Balikan          |");
        System.out.println("|               (4) Metode Cramer               |");
        System.out.println("|                  (5) Kembali                  |");
        Selection.ui();
        System.out.print("Pilih metode : ");
        String pilih=scanner.next();

        while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")&&!pilih.equals("4")&&!pilih.equals("5")) {
            System.out.println("Inputan tidak valid");
            System.out.print("Pilih metode : ");
            pilih=scanner.next();
        }

        if (pilih.equals("1")){
            System.out.println();
            Gauss(scanner);
            return true;
        }
        else if (pilih.equals("2")){
            System.out.println();
            return true;
        }
        else if (pilih.equals("3")){
            System.out.println();
            return true;
        }
        else if (pilih.equals("4")){
            System.out.println();
            return true;
        }
        else if (pilih.equals("5")){
            Selection.option_spl();
            return false;
        }
        return false;
    }

    public static void Gauss(Scanner scanner){
        Matrix M = new Matrix(0, 0);
        M.readMatrixFromTerminal(scanner);

        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix(M.matrix);

        M=Matrix.OBE(M);
    }
}
