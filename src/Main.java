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
                boolean selesai = false;
                while (!selesai) {
                    Selection.option_spl();
                    String pilihan_input="";
                    pilihan_input=scanner.next();
                    while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Jenis Input : ");
                        pilihan_input=scanner.next();
                    }
                    if (pilihan_input.equals(Selection.submenu_1)) {
                        selesai=SPL.page(scanner,pilihan_input);
                        if (selesai) {
                            pilihan=Selection.kembali(scanner);   
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_2)) {
                        selesai=SPL.page(scanner,pilihan_input);
                        if (selesai) {
                            pilihan=Selection.kembali(scanner);   
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_3)) {
                        Selection.menu_utama();
                        selesai=true;
                    }   
                }
            }

            else if (pilihan.equals(Selection.menu_determinan)) {
                boolean selesai = false;
                while (!selesai){
                    Selection.option_determinan();
                    String pilihan_input="";
                    pilihan_input=scanner.next();
                    while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                        System.out.println("Inputan tidak valid. Program hanya menerima input dari angka 1 sampai 3");
                        System.out.print("Jenis Input : ");
                        pilihan_input=scanner.next();
                    }
                    if (pilihan_input.equals(Selection.submenu_1)) {
                        selesai = Determinan.Page(scanner);
                        if(selesai){
                            pilihan=Selection.kembali(scanner);
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_2)) {
                        selesai = Determinan.Page(scanner);
                        if(selesai){
                            pilihan=Selection.kembali(scanner);
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_3)) {
                        Selection.menu_utama();
                        selesai = true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_invers)) {
                boolean selesai = false;
                while (!selesai){
                    Selection.option_invers();
                    String pilihan_input="";
                    pilihan_input=scanner.next();
                    while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                        System.out.println("Inputan tidak valid. Program hanya menerima input dari angka 1 sampai 3");
                        System.out.print("Jenis Input : ");
                        pilihan_input=scanner.next();
                    }
                    if (pilihan_input.equals(Selection.submenu_1)) {
                        selesai = Inverse.Page(scanner,pilihan_input);
                        if(selesai){
                            pilihan=Selection.kembali(scanner);
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_2)) {
                        selesai = Inverse.Page(scanner,pilihan_input);
                        if(selesai){
                            pilihan=Selection.kembali(scanner);
                        }
                    }
                    else if (pilihan_input.equals(Selection.submenu_3)) {
                        Selection.menu_utama();
                        selesai = true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_interpolasi)) {
                Selection.option_interpolasi();
                String pilihan_input="";
                pilihan_input=scanner.next();
                while (!pilihan_input.equals(Selection.submenu_1) && !pilihan_input.equals(Selection.submenu_2) && !pilihan_input.equals(Selection.submenu_3)) {
                    System.out.println("Inputan tidak valid");
                    System.out.print("Jenis Input : ");
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
                    System.out.print("Jenis Input : ");
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
                    System.out.print("Jenis Input : ");
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
                System.out.println("Opsi Menu tidak tersedia. Program hanya menerima input 1 sampai 7");
            }
        }
        scanner.close();
    }
}
