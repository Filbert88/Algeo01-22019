import java.util.*;

public class Bicubic{
    public static void landingPage(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|           INTERPOLASI BICUBIC SPLINE          |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|                  (1) Lanjut                   |");
        System.out.println("|                (2) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih metode : ");   
    }

    public static void BicubicPage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|           INTERPOLASI BICUBIC SPLINE          |");
        Selection.ui();
    }

    public static void BicubicInterpolation(Scanner scanner,String pilihan_input){
        BicubicPage();
        Matrix M = new Matrix(0, 0);
        double x;
        double y;
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readSquareMatrix(scanner);
            System.out.print("Masukkan nilai titik x yang ingin ditafsir:");
            x = scanner.nextDouble();
            System.out.print("Masukkan nilai titik y yang ingin ditafsir:");
            y = scanner.nextDouble();
            M.bicubicSplineInterpolation(x,y);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            Matrix taksiran = M.readMatrixFromFileForBicubic(scanner);
            M.bicubicSplineInterpolation(taksiran.getElmt(0,0),taksiran.getElmt(0,1));
        }
    }
}
