import java.util.*;

public class Regresi{
    public static void landingPage(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|             DOUBLE LINEAR REGRESSION          |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|                  (1) Lanjut                   |");
        System.out.println("|                (2) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih metode : ");   
    }

    public static void RegressionPage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            DOUBLE LINEAR REGRESSION           |");
        Selection.ui();
    }

    public static void Regression(Scanner scanner,String pilihan_input){
        RegressionPage();
        Matrix M = new Matrix(0, 0);
        double x;
        double y;
        if(pilihan_input.equals(Selection.submenu_1)){
            int peubah;
            int data;
            int xk;
            System.out.print("Masukkan jumlah peubah X:");
            peubah =scanner.nextInt();
            System.out.print("Masukkan jumlah sampel:");
            data =scanner.nextInt();
            M.readMatrixFromTerminalRegresi(data,(peubah+1),scanner);
            Matrix Beta = M.Beta(peubah);
            Beta.printMatrix();
            // for (int i=0;i<peubah;i++){
            //     System.out.print("Masukkan nilai Xk-"+(i+1)+" :");
            //     xk = scanner.nextInt();

            // }
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            int peubah;
            int data;
            int xk;
            System.out.print("Masukkan jumlah peubah X:");
            peubah =scanner.nextInt();
            System.out.print("Masukkan jumlah sampel:");
            data =scanner.nextInt();
            M.readMatrixFromFileForRegression(scanner,peubah,data);
            Matrix Beta = M.Beta(peubah);
            for (int i=0;i<peubah;i++){
                System.out.print("Masukkan nilai Xk-"+(i+1)+" :");
                xk = scanner.nextInt();

            }
        }
    }
}
