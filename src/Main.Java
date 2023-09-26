import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pilihan = "";

        Selection.menu_utama();

        while (!pilihan.equals(Selection.menu_exit)){
            System.out.print("Input Pilihan : ");
            pilihan=scanner.next();

            if (pilihan.equals(Selection.menu_spl)) {
                Selection.option_spl();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP SISTEM PERSAMAAN LINEAR");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP SISTEM PERSAMAAN LINEAR 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_determinan)) {
                Selection.option_determinan();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP DETERMINAN");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP DETERMINAN 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_invers)) {
                Selection.option_invers();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP INVERS");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP INVERS 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_interpolasi)) {
                Selection.option_interpolasi();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP INTERPOLASI");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP INTERPOLASI 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_interpolasi_bicubic)) {
                Selection.option_interpolasi_bicubic();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP INTERPOLASI BICUBIC");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP INTERPOLASI BICUBIC 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_regresi)) {
                Selection.option_regresi();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Input Pilihan : ");
                    pilihan_input=scanner.next();
                }
                if (pilihan_input.equals(Selection.submenu_1)) {
                    System.out.println("MANTAP REGRESI");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_2)) {
                    System.out.println("MANTAP REGRESI 2");
                    pilihan=Selection.kembali(scanner);
                }
                else if (pilihan_input.equals(Selection.submenu_3)) {
                    Selection.menu_utama();
                }
            }

            else if (pilihan.equals(Selection.menu_exit)) {
                Selection.option_exit();
            }

            else{
                System.out.println("Opsi Menu tidak tersedia");
            }
        }
        scanner.close();
    }
}