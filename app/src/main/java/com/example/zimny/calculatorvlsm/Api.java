package com.example.zimny.calculatorvlsm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author ZimnY
 */
public class Api {
    public static ArrayList<Integer> validacjaIP (String s){
        ArrayList<Integer> oktet = new ArrayList<>();
        try {
            StringTokenizer tokenizer = new StringTokenizer(s, ".//");
            while (tokenizer.hasMoreTokens()) {
                oktet.add(Integer.valueOf(tokenizer.nextToken()));
            }
            if (oktet.size() == 5) {
                if (oktet.get(0) <= 255 && oktet.get(1) <= 255 && oktet.get(2) <= 255 && oktet.get(3) <= 255) {
                    if (!(oktet.get(4) <= 32)){


                        oktet.clear();
                    }
                } else {
                    oktet.clear();
                }
            } else {
                oktet.clear();
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            oktet.clear();
        }

        return oktet;
    }
    public static ArrayList<Integer> validacjaPodsieci (ArrayList<Integer> oktet){

        ArrayList<Integer> lista = oktet;
        Collections.sort(oktet);
        for (Integer i : oktet)
        {
            if (i<0 && i>254)
                lista.clear();
        }
        return lista;
    }
    public static String kalkulacja(ArrayList<Integer> oktet, ArrayList<Integer> ilosc_hostow)
    {
        ArrayList<Integer> host = new ArrayList<Integer>();
        Integer oktet1 = 0, oktet2 = 0, oktet3 = 0, oktet4 = 0, maska = 0,ilosc_podsieci=ilosc_hostow.size();
        double suma = 0;
        String wynik ="";
        Boolean wlany = false;
        host.clear();
        oktet1 = oktet.get(0);
        oktet2 = oktet.get(1);
        oktet3 = oktet.get(2);
        oktet4 = oktet.get(3);
        maska = oktet.get(4);
        for (int j = 0; j < ilosc_hostow.size(); j++) {

            host.add(ilosc_hostow.get(j));
            suma = suma + Math.pow(2, 32 - Lib.Maskazhostow((host.get(j))));
        }

        if (suma <= Math.pow(2, (32 - maska))) {

            String s = "";
            int j = 0, i = 0, il = 0;
            int tmp = 0;
            for (int iii = 0; iii < host.size(); iii++) {
                tmp = (int) Math.pow(2, 32 - Lib.Maskazhostow(host.get(iii)));
                wynik+=("Podsiec " + (iii + 1) + " " + host.get(iii) + " -> " + tmp + " Zmarnowane " + (tmp - host.get(iii)) + " hostow\n");
                j = j + 1;
            }

            s = Lib.as(oktet1, oktet2, oktet3, oktet4, maska);
            wynik+=("Adres podsieci         " + (il + 1) + " : " + Lib.ipdec(s)+"\n");
            j = j + 1;
            s = Lib.bc(s, Lib.Maskazhostow(host.get(i)));
            wynik+=("Broadcast podsieci " + (il + 1) + " : " + Lib.ipdec(s)+"\n");
            j = j + 1;
            wynik+=("Maska posieci          " + (i + 1) + " : " + Lib.maskadec(Lib.maska(Lib.Maskazhostow(host.get(i))))+"\n");
            int x = ilosc_podsieci;
            while (x - 1 > 0) {
                j = j + 1;
                il = il + 1;
                s = Lib.bcnext(s);
                wynik+=("Adres podsieci         " + (il + 1) + " : " + Lib.ipdec(s)+"\n");
                j = j + 1;
                i = i + 1;
                s = Lib.bc(s, Lib.Maskazhostow(host.get(i)));
                wynik+=("Broadcast podsieci " + (il + 1) + " : " + Lib.ipdec(s)+"\n");
                j = j + 1;
                wynik+=("Maska posieci          " + (i + 1) + " : " + Lib.maskadec(Lib.maska(Lib.Maskazhostow(host.get(i))))+"\n");
                x = x - 1;

            }

            il = il + 1;
            String xx = Lib.bc(oktet1, oktet2, oktet3, oktet4, maska);
//				System.out.println(ipdec(bcnext(s)));
//				System.out.println(bc(o1,o2,o3,o4,m).length());
            int size = host.size();
            String tmps = s;
            //System.out.println(ipdec( bc(o1,o2,o3,o4,m)));
            int w = 1;
            do {

                if (Lib.porownajStringi(s, Lib.bc(oktet1, oktet2, oktet3, oktet4, maska)) == false) {
                    wlany = true;

                    break;
                }

                s = Lib.bcnext(s);
                if (Lib.porownajStringi(s, Lib.bc(oktet1, oktet2, oktet3, oktet4, maska)) == false) {
                    wlany = true;

                    break;
                }

                s = Lib.bc(s, 30);

                w = w + 1;
            } while (w < size);

            if (wlany == true) {
                j = j + 1;
                wynik+=("Siec da sie stworzyz tylko logicznie.\n");
            }
            s = tmps;
            String tmpip = "";
            if (wlany == false) {
                s = Lib.bcnext(s);
                for (int ii = 1; ii <= size; ii++) {
                    s = Lib.bcnext(s);
                    j = j + 1;
                    wynik+=("Wan " + (ii + (ii - 1)) + " : " + Lib.ipdec(s)+"\n");
                    //s=bc(s,30);
                    s = Lib.bcnext(s);
                    j = j + 1;
                    wynik+=("Wan " + (ii + ii) + " : " + Lib.ipdec(s)+"\n");
                    s = Lib.bcnext(s);
                    s = Lib.bcnext(s);
                }
            }
            wlany = false;
            if (Lib.porownajStringi(s, Lib.bc(oktet1, oktet2, oktet3, oktet4, maska)) == true) {
                j = j + 1;
                String s1 = Lib.bcnext(s);
                wynik+=("Wolne miejsce od       : " + Lib.ipdec(s)+"\n");

                //s=bc(s,Maskazhostow(host.get(i)));
                s = Lib.bc(oktet1, oktet2, oktet3, oktet4, maska);
                String s2 = s;
                j = j + 1;
                wynik+=("do       : " + Lib.ipdec(s)+"\n");
                j = j + 1;
                wynik+=("Pozostalo jeszcze " + Lib.pozostaleHosty(s2, s1) + " hostow .\n");

            } else {
                j = j + 1;
                wynik+=("Nie ma juz wolnych hostow w sieci.\n");

            }

        }
        return wynik;
    }
}
