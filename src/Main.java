import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pilihan = "";

        Selection.menu_utama();

        while(!pilihan.equals(Selection.menu_exit)){
            System.out.print("Pilih menu : ");
            pilihan = scanner.next();
            if (pilihan.equals(Selection.menu_spl)) {
                boolean selesai=false;
                while(!selesai){
                    SPL.landingpage();
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")&&!pilih.equals("4")&&!pilih.equals("5")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        SPL.gausspage();
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            SPL.Gauss(scanner, jenis_input);
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        SPL.gausspage();
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            SPL.GaussJordan(scanner, jenis_input);
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("3")){
                        SPL.balikanpage();
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            SPL.SPLInverse(scanner, jenis_input);
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("4")){
                        SPL.cramerpage();
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            SPL.Cramer(scanner, jenis_input);
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("5")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_determinan)) {
                boolean selesai=false;
                while(!selesai){
                    //GANTI INI
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("3")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_invers)) {
                boolean selesai=false;
                while(!selesai){
                    //GANTI INI
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("3")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_interpolasi)) {
                boolean selesai=false;
                while(!selesai){
                    //GANTI INI
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_interpolasi_bicubic)) {
                boolean selesai=false;
                while(!selesai){
                    //GANTI INI
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_regresi)) {
                boolean selesai=false;
                while(!selesai){
                    //GANTI INI
                    String pilih=scanner.next();
                    while (!pilih.equals("1")&&!pilih.equals("2")) {
                        System.out.println("Inputan tidak valid");
                        System.out.print("Pilih metode : ");
                        pilih=scanner.next();
                    }

                    if (pilih.equals("1")){
                        //GANTI INI
                        Selection.option_spl();
                        System.out.print("Jenis input : ");
                        String jenis_input="";
                        jenis_input=scanner.next();

                        while(!jenis_input.equals(Selection.submenu_1)&&!jenis_input.equals(Selection.submenu_2)&&!jenis_input.equals(Selection.submenu_3)){
                            System.out.println("Inputan tidak valid");
                            System.out.print("Jenis Input : ");
                            jenis_input=scanner.next();
                        }

                        if (!jenis_input.equals(Selection.submenu_3)) {
                            //GANTI INI
                            selesai=true;
                            pilihan=Selection.kembali(scanner);                            
                        }
                    }
                    else if (pilih.equals("2")){
                        Selection.menu_utama();
                        selesai=true;
                    }
                }
            }

            else if (pilihan.equals(Selection.menu_exit)){
                Selection.option_exit();
            }
            else{
                System.out.println("Opsi Menu tidak tersedia. Program hanya menerima input 1 sampai 7");
            }
        }
        scanner.close();
    }
}
