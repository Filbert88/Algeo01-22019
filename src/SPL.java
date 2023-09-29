import java.util.*;

public class SPL {

    public static void landingpage(){
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
        System.out.println("|                 (5) Menu Utama                |");
        Selection.ui();
        System.out.print("Pilih metode : ");
    }

    //TAMPILAN DEPAN METODE SPL
    public static void gausspage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 METODE GAUSS                  |");
        Selection.ui();
    }

    public static void gaussjordanpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|              METODE GAUSS JORDAN              |");
        Selection.ui();
    }

    public static void balikanpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|        METODE MATRIKS BALIKAN / INVERS        |");
        Selection.ui();
    }

    public static void cramerpage(){
        System.out.println();
        Selection.clear();
        System.out.println();
        Selection.ui();
        System.out.println("|           Apau & Apin SPL Calculator          |");
        Selection.ui();
        System.out.println("|            SISTEM PERSAMAAN LINEAR            |");
        Selection.ui();
        System.out.println("|                 METODE CRAMER                 |");
        Selection.ui();
    }

    //PERHITUNGAN MENGGUNAKAN METODE SPL
    public static void Gauss(Scanner scanner,String pilihan_input){
        gausspage();
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
        gaussjordanpage();
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
        balikanpage();
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

        if (M.columns-1!=M.rows) {
            System.out.println("Ukuran matriks salah. Contoh : n x (n-1)");
            System.out.println();
            System.out.println("Tidak berlaku matriks inverse.");
        }

        else{

            Matrix Mcopy=new Matrix(M.rows, M.columns-1);
            for (int i = 0; i < Mcopy.rows; i++) {
                for (int j = 0; j < Mcopy.columns; j++) {
                    Mcopy.setELmt(i, j, M.getElmt(i, j));
                }
            }

            System.out.println();
            if (Mcopy.determinanOBEtanpaPrint() == 0){
                System.out.println("Matriks tidak memiliki balikan karena determinan = 0");
                System.out.println();
                System.out.println("Tidak berlaku matriks inverse.");
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
                    System.out.println(var+String.valueOf(i+1)+" = "+String.format("%.2f",Mhasil.getElmt(i, 0)));
                }
            }
        }
    }

    public static void Cramer(Scanner scanner,String pilihan_input){
        cramerpage();
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

        if (M.columns-1!=M.rows) {
            System.out.println("Ukuran matriks salah. Contoh : n x (n-1)");
            System.out.println();
            System.out.println("Tidak berlaku metode cramer.");
        }

        else{

            Matrix Mcopy=new Matrix(M.rows, M.columns-1);
            for (int i = 0; i < Mcopy.rows; i++) {
                for (int j = 0; j < Mcopy.columns; j++) {
                    Mcopy.setELmt(i, j, M.getElmt(i, j));
                }
            }

            System.out.println();
            System.out.println("Matriks persamaan linear a :");
            Mcopy.printMatrix();
            double det=Mcopy.determinanOBEtanpaPrint();
            System.out.println("Determinan a : "+String.format("%.2f",det));

            if (Mcopy.determinanOBEtanpaPrint() == 0){
                System.out.println();
                System.out.println("Tidak berlaku metode cramer karena determinan = 0");
            }
            else{
                Matrix Mhasil= new Matrix(M.rows, 1);
                for (int i = 0; i < Mhasil.rows; i++) {
                    Mhasil.setELmt(i, 0, M.getElmt(i, M.columns-1));
                }

                Matrix Mdet = Mhasil.copyMatrix();

                String var="a";
                for (int i = 0; i < Mcopy.columns; i++) {
                    Matrix Mtemp = Mcopy.copyMatrix();
                    for (int j = 0; j < Mcopy.rows; j++) {
                        Mtemp.setELmt(j, i, Mhasil.getElmt(j, 0));
                    }
                    System.out.println();
                    System.out.println("Matriks "+var+String.valueOf(i+1)+" : "+"(Tukar kolom "+(i+1)+" matriks a dengan hasil SPL)");
                    Mtemp.printMatrix();
                    System.out.println("Determinan "+var+String.valueOf(i+1)+" : "+String.format("%.2f",Mtemp.determinanOBEtanpaPrint()));

                    Mdet.setELmt(i, 0, Mtemp.determinanOBEtanpaPrint());
                }

                System.out.println();
                System.out.println("Solusi Persamaan Linear : ");
                for (int i = 0; i < Mhasil.rows; i++) {
                    System.out.println(var+String.valueOf(i+1)+" = "+"det("+var+String.valueOf(i+1)+") / det("+var+") = "+String.format("%.2f", Mdet.getElmt(i, 0)/det));
                }
            }

        }

    }
}

