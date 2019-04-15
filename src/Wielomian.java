import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Wielomian {


    public  Wielomian () {
        System.out.println("Wprowadź współczynniki wielomianu:");
        List<Integer> współczynniki = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            współczynniki.add(scan.nextInt());
        }

        List<Integer> licznik = new ArrayList<Integer>();
        List<Integer> mianownik = new ArrayList<Integer>();
        int b = 0;
        if (współczynniki.get(współczynniki.size() - 1) < 0) {
            b = współczynniki.get(współczynniki.size() - 1) * -1;
        }
        else if (współczynniki.get(współczynniki.size() - 1) == 0){
            licznik.add(0);
        }
        else {
            b = współczynniki.get(współczynniki.size() - 1);
        }
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                licznik.add(i);
                licznik.add(-i);
            }
        }
        if (współczynniki.get(0) <= 0) {
            b = współczynniki.get(0) * -1;
        } else {
            b = współczynniki.get(0);
        }
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                mianownik.add(i);
            }
        }


        List<Integer> odwrócone = new ArrayList<Integer>();
        for (int i=współczynniki.size()-1; i>=0; i--){
            odwrócone.add(współczynniki.get(i));
        }
        List<Integer> pierwiastek = new ArrayList<Integer>();
        for (int i = 0; i < mianownik.size(); i++) {
            int m = mianownik.get(i);
            for (int j = 0; j < licznik.size(); j++) {
                int l = licznik.get(j);
                if (Pierwiastek(odwrócone, l, m)) {
                    if (((float) l / (float) m) % 1 == 0) {
                        pierwiastek.add(l / m);
                        pierwiastek.add(1);
                    } else {
                        pierwiastek.add(l);
                        pierwiastek.add(m);
                    }
                    List<Integer> zeruj = new ArrayList<Integer>();
                    zeruj = Horner(współczynniki, l, m);
                    int k = 0;
                    while (zeruj.get(zeruj.size() - 1) == 0) {
                        k += 1;
                        zeruj.remove(zeruj.size() - 1);
                        zeruj = Horner(zeruj, l, m);
                    }
                    pierwiastek.add(k);
                }
            }
        }

        System.out.println("Pierwiastki wielomianu:");
        for (int i = 0; i < pierwiastek.size() - 2; i += 3) {
            if (pierwiastek.get(i + 1) != 1) {
                System.out.println(pierwiastek.get(i) + "/" + pierwiastek.get(i + 1) + " :  " + pierwiastek.get(i + 2) + "-krotny");
            } else {
                System.out.println(pierwiastek.get(i) + " :  " + pierwiastek.get(i + 2) + "-krotny");
            }
        }
    }

    public boolean Pierwiastek(List wielomian, int l, int m){
        int spr = 0;
        int max_pot = wielomian.size() - 1;
        for(int i=0; i<wielomian.size(); i++){

            int licznik = (int) wielomian.get(i) * (int) pow(l,i) * (int) pow(m,max_pot);
            max_pot-=1;
            spr+=licznik;

        }
        return spr == 0;
    }

    public List<Integer> Horner(List wiel, int l, int m){
        List<Integer> wynik = new ArrayList<Integer>();
        wynik.add( (int) wiel.get(0));
        int p = 1;
        for(int i=1; i<wiel.size(); i++) {
            int a = wynik.get(wynik.size() - 1);
            wynik.add((int) ((l * a) + ((int) wiel.get(i) * pow(m, p))));
            p += 1;
        }
        return wynik;
    }







    public static void main(String[] args){
        Wielomian malwina = new Wielomian();}
}