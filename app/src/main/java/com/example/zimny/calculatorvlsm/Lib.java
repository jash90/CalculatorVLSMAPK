package com.example.zimny.calculatorvlsm;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZimnY
 */

import java.util.ArrayList;


public class Lib {

    public static String dectobin(int dec) {
        String tmp = "";

        for (int i = 7; i >= 0; i--) {
            if (dec >= (int) (Math.pow(2, i))) {
                tmp += "1";
                dec = dec - (int) (Math.pow(2, i));
            } else {
                tmp += "0";
            }
        }

        return tmp;
    }

    public static int bintodec(String bin) {
        int tmp = 0;
        int j = 0;
        for (int i = 7; i >= 0; i--) {
            if (bin.charAt(j) == '1') {
                tmp += (int) Math.pow(2, i);

            }
            j = j + 1;

        }
        return tmp;
    }

    public static int maskapot(int ilosc_hostow) {
        int tmp = 0;
        int ii = 0;
        do {
            if (tmp < ilosc_hostow) {
                tmp = (int) (Math.pow(2, ii));
            }
            ii += 1;
        } while (tmp < ilosc_hostow);
        int i = 0;
        do {
            if (Math.pow(2, i) >= tmp) {

                break;
            }
            i += 1;
        } while (Math.pow(2, i) < tmp);
        return 32 - i;

    }

    public static String maskak(int m) {
        String tmp = "";
        for (int i = 0; i <= 32; i++) {
            if (i < m) {
                tmp += "1";
            } else {
                tmp += "0";
            }
        }

        return tmp.substring(0, 8) + "." + tmp.substring(8, 16) + "." + tmp.substring(16, 24) + "." + tmp.substring(24, 32);
    }

    public static String maska(Integer m) {
        String tmp = "";
        for (int i = 0; i < 32; i++) {
            if (i < m) {
                tmp += "1";

            } else {
                tmp += "0";
            }
        }

        return tmp;
    }

    public static String maskadec(String s) {
        if (s.length() == 32) {
            return bintodec(s.substring(0, 8)) + "." + bintodec(s.substring(8, 16)) + "." + bintodec(s.substring(16, 24)) + "." + bintodec(s.substring(24, 32));
        } else {
            return "" + s.length();
        }
    }

    public static String ipdec(String s) {

        //	tmp=s.substring(0,8);
        //	tmp=s.substring(9, 17);
        //	tmp=s.substring(18,26);
        //	tmp=s.substring(27,35);
        return String.valueOf(bintodec(s.substring(0, 8))) + "." + String.valueOf(bintodec(s.substring(9, 17))) + "." + String.valueOf(bintodec(s.substring(18, 26))) + "." + String.valueOf(bintodec(s.substring(27, 35)));
    }

    public static String ipdecnext(String s) {

        //	tmp=s.substring(0,8);
        //	tmp=s.substring(9, 17);
        //	tmp=s.substring(18,26);
        //	tmp=s.substring(27,35);
        return String.valueOf(bintodec(s.substring(0, 8))) + "." + String.valueOf(bintodec(s.substring(9, 17))) + "." + String.valueOf(bintodec(s.substring(18, 26))) + "." + String.valueOf(bintodec(s.substring(27, 35)) + (int) 1);
    }

    public static int asn(String s) {
        //String tmp;
        //	tmp=s.substring(0,8);
        //	tmp=s.substring(9, 17);
        //	tmp=s.substring(18,26);
        //	tmp=s.substring(27,35);
        return bintodec(s.substring(27, 35)) + (int) 1;
    }

    public static String ipdec2(String s) {
        String tmp = "", tmp1 = "";
        for (int i = 0; i <= s.length() - 1; i++) {

            if ((s.charAt(i) != '.') && (s.charAt(i) != ' ')) {
                tmp += s.charAt(i);
            }

            if (tmp.length() == 8) {
                tmp1 += bintodec(tmp);
                if (i < 32) {
                    tmp1 += ".";
                }
                tmp = "";
            }

        }
        return tmp1;
    }

    public static String ipdectobin(int p, int d, int t, int c) {
        return dectobin(p) + "." + dectobin(d) + "." + dectobin(t) + "." + dectobin(c);
    }

    public static String bcporownaj(String s1, String s2) {
        String tmp = "";
        for (int i = 0; i <= s1.length() - 1; i++) {
            if (s2.charAt(i) == '1') {
                tmp += String.valueOf(s1.charAt(i));
            } else if (s2.charAt(i) == '.') {
                tmp += ".";
            } else if (s2.charAt(i) == '0') {
                tmp += "1";
            }
        }
        return tmp;
    }

    public static String asporownaj(String s1, String s2) {
        String tmp = "";
        for (int i = 0; i <= s1.length() - 1; i++) {
            if ((s1.charAt(i) == '1') && (s2.charAt(i) == '1')) {
                tmp += "1";
            } else {
                if ((s2.charAt(i) != '.') && (s1.charAt(i) != '.')) {
                    tmp += "0";
                } else {
                    tmp += ".";
                }
            }
        }
        return tmp;
    }

    public static String as(int o1, int o2, int o3, int o4, int m) {
        String tmp = "";
        String Maska = maskak(m);
        String IP = dectobin(o1) + "." + dectobin(o2) + "." + dectobin(o3) + "." + dectobin(o4);
        tmp = asporownaj(IP, Maska);
        //	tmp=ipdec(tmp);
        return tmp;
    }

    public static String bc(int o1, int o2, int o3, int o4, int m) {
        String tmp = "";
        String Maska = maskak(m);
        String IP = dectobin(o1) + "." + dectobin(o2) + "." + dectobin(o3) + "." + dectobin(o4);
        tmp = bcporownaj(IP, Maska);
        //tmp=ipdec(tmp);
        return tmp;
    }

    public static String bc(String IP, int m) {
        String tmp = "";
        String Maska = maskak(m);
//		String IP=dectobin(o1)+"."+dectobin(o2)+"."+dectobin(o3)+"."+dectobin(o4);
        tmp = bcporownaj(IP, Maska);
        //tmp=ipdec(tmp);
        return tmp;
    }

    public static String asnext(int o1, int o2, int o3, int o4, int m) {
        String tmp = "";
        String Maska = maskak(m);
        String IP = dectobin(o1) + "." + dectobin(o2) + "." + dectobin(o3) + "." + dectobin(o4);
        tmp = bcporownaj(IP, Maska);
        tmp = ipdecnext(tmp);
        return tmp;
    }

    public static int Maskazhostow(int h) {
        int tmp = 0;
        for (int i = 32; i >= 0; i--) {
            if (Math.pow(2, 32 - i) - 2 >= h) {
                tmp = i;
                break;
            }
        }
        return tmp;
    }

    public static String bcnext(String s) {
        int o1 = bintodec(s.substring(0, 8));
        int o2 = bintodec(s.substring(9, 17));
        int o3 = bintodec(s.substring(18, 26));
        int o4 = bintodec(s.substring(27, 35));
        if (o4 + 1 >= 255) {
            if (o3 + 1 >= 255) {
                if (o2 + 1 >= 255) {
                    if (o1 + 1 >= 255) {
                        o1 = 0;
                        o2 = 0;
                        o3 = 0;
                        o4 = 0;
                    } else {
                        o1 = o1 + 1;
                        o2 = 0;
                        o3 = 0;
                        o4 = 0;
                    }
                } else {
                    o2 = o2 + 1;
                    o3 = 0;
                    o4 = 0;
                }
            } else {
                o3 = o3 + 1;
                o4 = 0;
            }
        } else {
            o4 = o4 + 1;
        }
        return dectobin(o1) + "." + dectobin(o2) + "." + dectobin(o3) + "." + dectobin(o4);
    }

    public static String pozostaleHosty(String s1, String s2) {

        //	tmp=s.substring(0,8);
        //	tmp=s.substring(9, 17);
        //	tmp=s.substring(18,26);
        //	tmp=s.substring(27,35);
        return String.valueOf(bintodec(s1.substring(27, 35)) - bintodec(s2.substring(27, 35)) + 1);
    }

    public static Boolean przydzialHostow(ArrayList<Integer> host, String s2) {
        Boolean tmp = false;
        int suma = 0;
        for (int i = 0; i < host.size(); i++) {
            suma = suma + host.get(i);
        }
        if (suma > Math.pow(2, 32 - Integer.valueOf(s2))) {
            tmp = true;
        }
        return tmp;
    }

    public static Boolean porownajStringi(String s1, String s2) {
        Boolean tmp = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                tmp = true;
            }
        }
        return tmp;
    }

}
