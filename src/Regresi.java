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
            double peubah;
            double data;
            M.readMatrixFromTerminalRegresi(scanner);
            peubah = M.getColumn()-1;
            data = M.getRow();
            Matrix BETA = M.Beta(peubah);
            double taksiran = BETA.getElmt(0,0);
            for (int i = 0; i < peubah; i++) {
                boolean validInput = false;
                double xk = 0.0;
                while (!validInput) {
                    try {
                        System.out.print("Masukkan nilai Xk-" + (i + 1) + " : ");
                        xk = scanner.nextDouble();
                        validInput = true; 
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid Input. Tolong masukkan input sesuai format.");
                        scanner.nextLine(); 
                    }
                }
                taksiran += (xk * (BETA.getElmt(i + 1, 0)));
            }
            System.out.print("Hasil taksiran yaitu: ");
            System.out.println(taksiran);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            double peubah;
            double data;
            Matrix size = M.readMatrixFromFileForRegression(scanner);
            peubah = size.getElmt(0,1);
            data = size.getElmt(0,0);
            Matrix BETA = M.Beta(peubah);
            double taksiran = BETA.getElmt(0,0);
            for (int i = 0; i < peubah; i++) {
                boolean validInput = false;
                double xk = 0.0;
                while (!validInput) {
                    try {
                        System.out.print("Masukkan nilai Xk-" + (i + 1) + " : ");
                        xk = scanner.nextDouble();
                        validInput = true; 
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid Input. Tolong masukkan input sesuai format.");
                        scanner.nextLine(); 
                    }
                }
                taksiran += (xk * (BETA.getElmt(i + 1, 0)));
            }
            System.out.print("Hasil taksiran yaitu: ");
            System.out.println(taksiran);
        }
    }
}
