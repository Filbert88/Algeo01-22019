import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        Selection.menu_utama();

        while (pilihan != Selection.menu_exit){
            System.out.print("Input Pilihan : ");
            pilihan=scanner.nextInt();

            if (pilihan==Selection.menu_spl) {
                Selection.option_spl();
                int pilihan_input=0;
                pilihan_input=scanner.nextInt();
                while (pilihan_input!=Selection.submenu_1 && pilihan_input!=Selection.submenu_2 && pilihan_input!=Selection.submenu_3) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.nextInt();
                }
                if (pilihan_input==Selection.submenu_1) {
                    System.out.println("MANTAP SISTEM PERSAMAAN LINEAR");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_2) {
                    System.out.println("MANTAP SISTEM PERSAMAAN LINEAR 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_3) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan==Selection.menu_determinan) {
                Selection.option_determinan();
                int pilihan_input=0;
                pilihan_input=scanner.nextInt();
                while (pilihan_input!=Selection.submenu_1 && pilihan_input!=Selection.submenu_2 && pilihan_input!=Selection.submenu_3) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.nextInt();
                }
                if (pilihan_input==Selection.submenu_1) {
                    System.out.println("MANTAP DETERMINAN");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_2) {
                    System.out.println("MANTAP DETERMINAN 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_3) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan==Selection.menu_invers) {
                Selection.option_invers();
                int pilihan_input=0;
                pilihan_input=scanner.nextInt();
                while (pilihan_input!=Selection.submenu_1 && pilihan_input!=Selection.submenu_2 && pilihan_input!=Selection.submenu_3) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.nextInt();
                }
                if (pilihan_input==Selection.submenu_1) {
                    System.out.println("MANTAP INVERS");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_2) {
                    System.out.println("MANTAP INVERS 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_3) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan==Selection.menu_interpolasi) {
                Selection.option_interpolasi();
                int pilihan_input=0;
                pilihan_input=scanner.nextInt();
                while (pilihan_input!=Selection.submenu_1 && pilihan_input!=Selection.submenu_2 && pilihan_input!=Selection.submenu_3) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.nextInt();
                }
                if (pilihan_input==Selection.submenu_1) {
                    System.out.println("MANTAP INTERPOLASI");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_2) {
                    System.out.println("MANTAP INTERPOLASI 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_3) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan==Selection.menu_regresi) {
                Selection.option_regresi();
                int pilihan_input=0;
                pilihan_input=scanner.nextInt();
                while (pilihan_input!=Selection.submenu_1 && pilihan_input!=Selection.submenu_2 && pilihan_input!=Selection.submenu_3) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.nextInt();
                }
                if (pilihan_input==Selection.submenu_1) {
                    System.out.println("MANTAP REGRESI");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_2) {
                    System.out.println("MANTAP REGRESI 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input==Selection.submenu_3) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan==Selection.menu_exit) {
                Selection.option_exit();
            }

            else{
                System.out.println("Opsi Menu tidak tersedia");
            }
        }
        scanner.close();
    }
}