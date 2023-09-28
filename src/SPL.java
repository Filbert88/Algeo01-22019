import java.util.*;

public class SPL {
    public static boolean page(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 Select Method                 |");
        Selection.ui();
        System.out.println("|           (1) Metode Eliminasi Gauss          |");
        System.out.println("|        (2) Metode Eliminasi Gauss-Jordan      |");
        System.out.println("|           (3) Metode Matriks Balikan          |");
        System.out.println("|               (4) Metode Cramer               |");
        System.out.println("|                  (5) Kembali                  |");
        Selection.ui();
        System.out.print("Pilih metode : ");
        String pilih=scanner.next();

        while (!pilih.equals("1")&&!pilih.equals("2")&&!pilih.equals("3")&&!pilih.equals("4")&&!pilih.equals("5")) {
            System.out.println("Inputan tidak valid");
            System.out.print("Pilih metode : ");
            pilih=scanner.next();
        }

        if (pilih.equals("1")){
            System.out.println();
            Gauss(scanner,pilihan_input);
            return true;
        }
        else if (pilih.equals("2")){
            System.out.println();
            GaussJordan(scanner,pilihan_input);
            return true;
        }
        else if (pilih.equals("3")){
            System.out.println();
            SPLInverse(scanner, pilihan_input);
            return true;
        }
        else if (pilih.equals("4")){
            System.out.println();
            return true;
        }
        else if (pilih.equals("5")){
            Selection.option_spl();
            return false;
        }
        return false;
    }

    public static void Gauss(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 METODE GAUSS                  |");
        Selection.ui();        
        Matrix M = new Matrix(0, 0);
        
        if (pilihan_input.equals(Selection.submenu_1)) {
            M.readMatrixFromTerminal(scanner);   
        }
        else if (pilihan_input.equals(Selection.submenu_2)) {
            M.readMatrixFromFile(scanner);
        }

        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();

        M.OBE(M);

        boolean valid=true;
        for (int i = 0; i < M.rows; i++) {
            boolean temp=false;
            for (int j = 0; j < M.columns-1; j++) {
                if (M.getElmt(i, j)!=0) {
                    temp=true;
                }
                if (M.getElmt(i, M.columns-1)==0) {
                    temp=true;
                }
            }
            if (!temp) {
                valid=false;
            }
        }

        if (valid) {
            int now=M.rows-1;
            while (now>=0) {
                int leading=-1;
                for (int i = 0; i < M.columns; i++) {
                    if (M.getElmt(now, i)==1) {
                        leading=i;
                        break;
                    }
                }
                if (leading!=-1) {
                    for (int i = now-1; i >= 0; i--) {
                        if (M.getElmt(i,leading)!=0) {
                            double pengali=M.getElmt(i,leading);
                            for (int j = 0; j < M.columns; j++) {
                                M.setELmt(i, j, M.getElmt(i,j)-pengali*M.getElmt(now,j));
                            }
                        }
                    }               
                }
                now--;
            }

            Matrix solusi=new Matrix(M.columns-1, M.columns);

            double mark=-1.294162401283;
            for (int i = 0; i < solusi.rows; i++) {
                solusi.setELmt(i, M.columns-1, mark);
            }

            for (int i = 0; i < M.rows; i++) {
                boolean leading=false;
                int base=-1;
                for (int j = 0; j < M.columns-1; j++) {
                    if (M.getElmt(i, j)==1 && !leading) {
                        base=j;
                        leading=true;
                    }
                    else if(base!=-1 && leading){
                        solusi.setELmt(base,j,M.getElmt(i, j));   
                    }
                    if (base!=-1 && leading) {
                        solusi.setELmt(base, M.columns-1,M.getElmt(i, M.columns-1));
                    }
                }
            }

            System.out.println();
            System.out.println("Solusi Persamaan Linear :");

            for (int i = 0; i < solusi.rows; i++) {
                String var = "a";
                System.out.print(var+String.valueOf(i+1)+" = ");
                boolean all0=true;
                for (int j = 0; j < solusi.columns-1; j++) {
                    if (solusi.getElmt(i, j)!=0) {
                        all0=false;
                    }
                }

                if (all0) {
                    if (solusi.getElmt(i, solusi.columns-1)!=mark) {
                        System.out.println(String.format("%.2f",solusi.getElmt(i, solusi.columns-1)));
                    }
                    else{
                        System.out.println(var+String.valueOf(i+1)+" (sembarang bilangan real)");
                    }
                }
                else{
                    int count=0;
                    for (int j = 0; j < solusi.columns-1; j++) {
                        if (solusi.getElmt(i, j)!=0) {
                            if (solusi.getElmt(i, j)>0) {
                                if (count>0) {
                                    System.out.print(" - ("+String.format("%.2f",solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));                                    
                                }
                                else{
                                    System.out.print("-("+String.format("%.2f",solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));
                                }
                            }
                            else{
                                if (count>0) {
                                    System.out.print(" + ("+String.format("%.2f",(-1)*solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));
                                }
                                else{
                                    System.out.print("("+String.format("%.2f",(-1)*solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));

                                }
                            }
                            count++;
                        }
                    }
                    if (solusi.getElmt(i, solusi.columns-1)==0) {
                        System.out.println();
                    }
                    else{
                        if (solusi.getElmt(i, solusi.columns-1)>0) {
                            System.out.println(" + "+String.format("%.2f",solusi.getElmt(i, solusi.columns-1)));
                        }
                        else{
                            System.out.println(" - "+String.format("%.2f",(-1)*solusi.getElmt(i, solusi.columns-1)));
                        }
                    }
                }

            }
        }
        else{
            System.out.println();
            System.out.println("Tidak memiliki penyelesaian.");
        }
    }

    public static void GaussJordan(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|              METODE GAUSS JORDAN              |");
        Selection.ui();
        Matrix M = new Matrix(0, 0);
        M.readMatrixFromTerminal(scanner);

        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();

        M.OBE_red(M);

        boolean valid=true;
        for (int i = 0; i < M.rows; i++) {
            boolean temp=false;
            for (int j = 0; j < M.columns-1; j++) {
                if (M.getElmt(i, j)!=0) {
                    temp=true;
                }
                if (M.getElmt(i, M.columns-1)==0) {
                    temp=true;
                }
            }
            if (!temp) {
                valid=false;
            }
        }

        if (valid) {
            Matrix solusi=new Matrix(M.columns-1, M.columns);

            double mark=-1.294162401283;
            for (int i = 0; i < solusi.rows; i++) {
                solusi.setELmt(i, M.columns-1, mark);
            }

            for (int i = 0; i < M.rows; i++) {
                boolean leading=false;
                int base=-1;
                for (int j = 0; j < M.columns-1; j++) {
                    if (M.getElmt(i, j)==1 && !leading) {
                        base=j;
                        leading=true;
                    }
                    else if(base!=-1 && leading){
                        solusi.setELmt(base,j,M.getElmt(i, j));   
                    }
                    if (base!=-1 && leading) {
                        solusi.setELmt(base, M.columns-1,M.getElmt(i, M.columns-1));
                    }
                }
            }

            System.out.println();
            System.out.println("Solusi Persamaan Linear :");

            for (int i = 0; i < solusi.rows; i++) {
                String var = "a";
                System.out.print(var+String.valueOf(i+1)+" = ");
                boolean all0=true;
                for (int j = 0; j < solusi.columns-1; j++) {
                    if (solusi.getElmt(i, j)!=0) {
                        all0=false;
                    }
                }

                if (all0) {
                    if (solusi.getElmt(i, solusi.columns-1)!=mark) {
                        System.out.println(String.format("%.2f",solusi.getElmt(i, solusi.columns-1)));
                    }
                    else{
                        System.out.println(var+String.valueOf(i+1)+" (sembarang bilangan real)");
                    }
                }
                else{
                    int count=0;
                    for (int j = 0; j < solusi.columns-1; j++) {
                        if (solusi.getElmt(i, j)!=0) {
                            if (solusi.getElmt(i, j)>0) {
                                if (count>0) {
                                    System.out.print(" - ("+String.format("%.2f",solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));                                    
                                }
                                else{
                                    System.out.print("-("+String.format("%.2f",solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));
                                }
                            }
                            else{
                                if (count>0) {
                                    System.out.print(" + ("+String.format("%.2f",(-1)*solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));
                                }
                                else{
                                    System.out.print("("+String.format("%.2f",(-1)*solusi.getElmt(i, j))+")*"+var+String.valueOf(j+1));

                                }
                            }
                            count++;
                        }
                    }
                    if (solusi.getElmt(i, solusi.columns-1)==0) {
                        System.out.println();
                    }
                    else{
                        if (solusi.getElmt(i, solusi.columns-1)>0) {
                            System.out.println(" + "+String.format("%.2f",solusi.getElmt(i, solusi.columns-1)));
                        }
                        else{
                            System.out.println(" - "+String.format("%.2f",(-1)*solusi.getElmt(i, solusi.columns-1)));
                        }
                    }
                }

            }
        }
        else{
            System.out.println();
            System.out.println("Tidak memiliki penyelesaian.");
        }
    }

    public static void SPLInverse(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|        METODE MATRIKS BALIKAN / INVERS        |");
        Selection.ui();

        Matrix M = new Matrix(0, 0);
        M.readMatrixFromTerminal(scanner);

        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();

        if (M.columns-1!=M.rows) {
            System.out.println("Ukuran matriks salah. Contoh : n x (n-1)");
            System.out.println();
            System.out.println("Tidak memiliki penyelesaian.");
        }

        else{

            Matrix Mcopy=new Matrix(M.rows, M.columns-1);
            for (int i = 0; i < Mcopy.rows; i++) {
                for (int j = 0; j < Mcopy.columns; j++) {
                    Mcopy.setELmt(i, j, M.getElmt(i, j));
                }
            }

            System.out.println();
            if (Mcopy.determinanCof() == 0){
                System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
                System.out.println();
                System.out.println("Tidak memiliki penyelesaian.");
            }
            else{
                Matrix Inverse = Mcopy.inverseAdjoinFunc();
                System.out.println();
                System.out.println("Matriks Inverse A^(-1) :");
                Inverse.printMatrix();

                Matrix Mpengali= new Matrix(M.rows, 1);
                for (int i = 0; i < Mpengali.rows; i++) {
                    Mpengali.setELmt(i, 0, M.getElmt(i, M.columns-1));
                }

                System.out.println();
                System.out.println("Matriks pengali B : ");
                Mpengali.printMatrix();

                Matrix Mhasil = Mpengali.copyMatrix();
                for (int i = 0; i < Inverse.rows; i++) {
                    double hasil=0;
                    for (int j = 0; j < Inverse.columns; j++) {
                        hasil+=Inverse.getElmt(i, j)*Mpengali.getElmt(j, 0);
                    }
                    Mhasil.setELmt(i,0, hasil);
                }

                System.out.println();
                System.out.println("(A * x = B) ==> (x = A^(-1) * B)");

                System.out.println();
                System.out.println("Matriks x : ");
                Mhasil.printMatrix();

                System.out.println();
                System.out.println("Solusi Persamaan Linear :");
                String var="a";
                for (int i = 0; i < Mhasil.rows; i++) {
                    System.out.println(var+String.valueOf(i+1)+" = "+String.valueOf(Mhasil.getElmt(i, 0)));
                }
            }
        }
    }

    public static void Cramer(Scanner scanner,String pilihan_input){
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 METODE CRAMER                 |");
        Selection.ui();

        Matrix M = new Matrix(0, 0);
        M.readMatrixFromTerminal(scanner);

        System.out.println();
        System.out.println("Matriks :");
        M.printMatrix();

        if (M.columns-1!=M.rows) {
            System.out.println("Ukuran matriks salah. Contoh : n x (n-1)");
            System.out.println();
            System.out.println("Tidak memiliki penyelesaian.");
        }

        else{

            Matrix Mcopy=new Matrix(M.rows, M.columns-1);
            for (int i = 0; i < Mcopy.rows; i++) {
                for (int j = 0; j < Mcopy.columns; j++) {
                    Mcopy.setELmt(i, j, M.getElmt(i, j));
                }
            }

            System.out.println();
            if (Mcopy.determinanCof() == 0){
                System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
                System.out.println();
                System.out.println("Tidak memiliki penyelesaian.");
            }
            else{
                Matrix Mhasil= new Matrix(M.rows, 1);
                for (int i = 0; i < Mhasil.rows; i++) {
                    Mhasil.setELmt(i, 0, M.getElmt(i, M.columns-1));
                }

                System.out.println();
                System.out.println("Matriks B : ");
                Mhasil.printMatrix();

            }

        }

    }
}

