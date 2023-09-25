import java.util.Scanner;

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
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.flush();
            }
        } catch (Exception e) {}
    }

    public static int menu_spl=1;
    public static int menu_determinan=2;
    public static int menu_invers=3;
    public static int menu_interpolasi=4;
    public static int menu_regresi=5;
    public static int menu_exit=6;

    public static int submenu_1=1;
    public static int submenu_2=2;
    public static int submenu_3=3;

    public static void option(){
        System.out.println("|                  Select Menu                  |");
        Selection.ui();
        System.out.println("|                   (1) SPL                     |");
        System.out.println("|                (2) Determinan                 |");
        System.out.println("|                 (3) Invers                    |");
        System.out.println("|               (4) Interpolasi                 |");
        System.out.println("|                 (5) Regresi                   |");
        System.out.println("|                   (6) Exit                    |");
        Selection.ui();
    }

    public static void option_spl(){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|            Apau & Apin SPL Calculator         |");
        Selection.ui();
        System.out.println("|            Sistem Persamaan Linear            |");
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
        System.out.println("|            Apau & Apin SPL Calculator         |");
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
        System.out.println("|            Apau & Apin SPL Calculator         |");
        Selection.ui();
        System.out.println("|                    INVERS                     |");
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
        System.out.println("|            Apau & Apin SPL Calculator         |");
        Selection.ui();
        System.out.println("|                  INTERPOLASI                  |");
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
        System.out.println("|            Apau & Apin SPL Calculator         |");
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

    public static int kembali(){
        Scanner scanner = new Scanner(System.in);
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
            return 0;
        }
        else if (kembali.equalsIgnoreCase("Y")) {
            Selection.option_exit();
            return 6;
        }
        return 0;
    }
}
