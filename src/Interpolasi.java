import java.util.Scanner;

public class Interpolasi {
    public static void landingpage(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|             INTERPOLASI POLINOMIAL            |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|                  (1) Lanjut                   |");
        System.out.println("|                (2) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih metode : ");
    }

    public static void InterpolasiPage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|             INTERPOLASI POLINOMIAL            |");
        Selection.ui();
    }

    public static void InterpolasiPolinom(Scanner scanner,String pilihan_input){
        InterpolasiPage();
        if(pilihan_input.equals(Selection.submenu_1)){
            Matrix.interPolim(scanner);
        }
        else if (pilihan_input.equals(Selection.submenu_2)){
            Matrix.InterPolimFromFile(scanner);
        }
    }
} 
