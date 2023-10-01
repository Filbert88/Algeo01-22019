import java.util.*;

public class Bicubic{
    public static void BicubicPage(Scanner scanner,String pilihan_input){
        double x;
        double y;
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                MATRIKS BALIKAN                |");
        Selection.ui();
        Matrix M = new Matrix(0, 0);
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
            System.out.print("Masukkan nilai titik x yang ingin ditafsir:");
            x = scanner.nextDouble();
            System.out.print("Masukkan nilai titik y yang ingin ditafsir:");
            y = scanner.nextDouble();
            M.bicubicSplineInterpolation(x,y);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            M.readMatrixFromFile(scanner);
        }
    }
}