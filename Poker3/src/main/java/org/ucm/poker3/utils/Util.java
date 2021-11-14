package org.ucm.poker3.utils;

public class Util {

    public static int parseaNumCarta(char c) {
        int ca;
        switch (c) {
            case 'A':
                ca = 14;
                break;
            case 'T':
                ca = 10;
                break;
            case 'J':
                ca = 11;
                break;
            case 'Q':
                ca = 12;
                break;
            case 'K':
                ca = 13;
                break;
            default:
                ca = Character.getNumericValue(c);
                break;
        }
        return ca;
    }
    
    public static int paloANum(char palo){
        switch (palo) {
            case 's':
                return 0;
            case 'c':
                return 1;
            case 'd':
                return 2;
            case 'h':
                return 3;
        }
        return -1;
    }
    
    public static char numAPalo(int palo){
        switch (palo) {
            case 0:
                return 's';
            case 1:
                return 'c';
            case 2:
                return 'd';
            case 3:
                return 'h';
        }
        return 'f';
    }
    
    public static String cartaAString(int c) {
        Integer a = c;
        switch (c) {
            case 14:
                return "ace";               
            case 11:
                return "jack";
            case 12:
                return "queen";
            case 13:
               return "king";
            default:
                return a.toString();
        }
    }
}
