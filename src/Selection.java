import java.io.*;
import java.util.*;

public class Selection {
    public static void menu_utama(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|     Welcome to Apau & Apin SPL Calculator     |");
        Selection.ui();
        Selection.option(); 
    }

    public static void ui(){
        System.out.println("=================================================");
    }

    public static void clear(){
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }
            processBuilder.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String menu_spl="1";
    public static String menu_determinan="2";
    public static String menu_invers="3";
    public static String menu_interpolasi="4";
    public static String menu_interpolasi_bicubic="5";
    public static String menu_regresi="6";
    public static String menu_exit="7";

    public static String submenu_1="1";
    public static String submenu_2="2";
    public static String submenu_3="3";

    public static void option(){
        System.out.println("|                  Select Menu                  |");
        Selection.ui();
        System.out.println("|         (1) Sistem Persamaan Linear           |");
        System.out.println("|                (2) Determinan                 |");
        System.out.println("|             (3) Matriks Balikan               |");
        System.out.println("|           (4) Interpolasi Polinom             |");
        System.out.println("|        (5) Interpolasi Bicubic Spline         |");
        System.out.println("|          (6) Regresi linier berganda          |");
        System.out.println("|                   (7) Exit                    |");
        Selection.ui();
    }

    public static void option_spl(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_determinan(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                  DETERMINAN                   |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_invers(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                MATRIKS BALIKAN                |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_interpolasi(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|              INTERPOLASI POLINOM              |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_interpolasi_bicubic(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|           INTERPOLASI BICUBIC SPLINE          |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_regresi(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|                REGRESI LINEAR                 |");
        Selection.ui();
        System.out.println("|                 Please Select                 |");
        Selection.ui();
        System.out.println("|               (1) Input Manual                |");
        System.out.println("|                (2) Input File                 |");
        System.out.println("|                (3) Menu Utama                 |");
        Selection.ui();
        System.out.print("Pilih input : ");
    }

    public static void option_exit(){
        Selection.ui();
        System.out.println("|  Terima kasih telah memakai layanan kami :)   |");
        Selection.ui();
        System.out.println();
    }

    public static String kembali(Scanner scanner){
        String kembali;
        System.out.println();
        System.out.print("Apakah anda ingin keluar dari program (Y/N) : ");
        kembali=scanner.next();
        while (!kembali.equalsIgnoreCase("Y") && !kembali.equalsIgnoreCase("N")) {
            System.out.println("Inputan tidak valid selain (Y/N)");
            System.out.print("Apakah anda ingin keluar dari program (Y/N) : ");
            kembali=scanner.next();            
        }
        if (kembali.equalsIgnoreCase("N")) {
            Selection.menu_utama();
            return "";
        }
        else if (kembali.equalsIgnoreCase("Y")) {
            Selection.option_exit();
            return "6";
        }
        return "";
    }
}
