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
        boolean validXInput = false;
        boolean validYInput = false;
        double x=0;
        double y=0;
        if(pilihan_input.equals(Selection.submenu_1)){
            M.readMatrixFromTerminalforBicubic(scanner);
            while (!validXInput) {
                try {
                    System.out.print("\nMasukkan nilai titik x yang ingin ditafsir: ");
                    x = scanner.nextDouble();
                    if (x>=0 && x <=1){
                        validXInput = true; 
                    }
                    else{
                    System.out.println("Input taksiran harus diantara 0 dan 1");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid Input. Tolong masukkan input sesuai format.\n");
                    scanner.nextLine(); 
                }
            }

            while (!validYInput) {
                try {
                    System.out.print("Masukkan nilai titik y yang ingin ditafsir: ");
                    y = scanner.nextDouble();
                    if (y>=0 && y <=1){
                        validYInput = true; 
                    }
                    else{
                        System.out.println("Input taksiran harus diantara 0 dan 1\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid Input. Tolong masukkan input sesuai format.");
                    scanner.nextLine(); 
                }
            }

                M.bicubicSplineInterpolation(x,y);
            }
        else if (pilihan_input.equals(Selection.submenu_2)){
            Matrix taksiran = M.readMatrixFromFileForBicubic(scanner);
            M.bicubicSplineInterpolation(taksiran.getElmt(0,0),taksiran.getElmt(0,1));
        }
    }
}
