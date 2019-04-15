import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Spr2 {


    public  Spr2 () {
        System.out.println("Wprowadź argumenty wielomianu:");
        List<Integer> list1 = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            list1.add(scan.nextInt());
        }
        List<Integer> licznik = new ArrayList<Integer>();
        List<Integer> mianownik = new ArrayList<Integer>();
        int b = 0;
        if(list1.get(list1.size() - 1) <= 0){
            b = list1.get(list1.size() - 1) * -1;
        }
        else{ b = list1.get(list1.size() - 1);}
        for (int i = 1; i <= b; i++) {
            if ( b % i == 0) {
                licznik.add(i);
            }
        }
        if(list1.get(0) <= 0){
            b = list1.get(0) * -1;
        }
        else{ b = list1.get(0);}
        for (int i = 1; i <= b; i++) {
            if ( b % i == 0) {
                mianownik.add(i);
                mianownik.add(-i);
            }
        }
        List<Integer> pierwiastek = new ArrayList<Integer>();
        Collections.reverse(list1);
        for (int i = 0; i < mianownik.size(); i++) {
            int l = mianownik.get(i);
            for (int j = 0; j < licznik.size(); j++) {
                int m = licznik.get(j);
                if (Potęgi(list1, l, m)) {
                    pierwiastek.add(l);
                    pierwiastek.add(m);
                    System.out.println("gut");
                }
                else{System.out.println("not gut");}
                ;
            }
        }
        System.out.println("Pierwiastki wielomianu:");
        for (int i = 0; i < pierwiastek.size(); i ++) {
           /* if (((float) pierwiastek.get(i) / (float) pierwiastek.get(i + 1)) % 1 == 0) {
                System.out.println(pierwiastek.get(i) / pierwiastek.get(i + 1));
            } else {
                System.out.println(pierwiastek.get(i) + "/" + pierwiastek.get(i + 1));
            }*/
            System.out.println(pierwiastek.get(i));
        }
    }

    public boolean Potęgi(List wielomian, int l, int m){
        int spr = 0;
        int max_pot = wielomian.size() - 1;
        for(int i=0; i<wielomian.size(); i++){

            int licznik = (int) wielomian.get(i) * (int) pow(l,i) * (int) pow(m,max_pot);
            max_pot-=1;
            spr+=licznik;

        }
        return spr == 0;
    }

    /*public int[] Horner(List wiel, List pierw){

    }*/







    public static void main(String[] args){
        Spr2 malwina = new Spr2();}
}