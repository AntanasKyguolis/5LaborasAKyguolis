package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DarbininkasImpl d1 = new DarbininkasImpl("A Dangteliai", 2, 2);
        DarbininkasImpl d2 = new DarbininkasImpl("X Stabdziu kaladeles", 152, 6.7);
        DarbininkasImpl d3 = new DarbininkasImpl("Z Metalo laikikliai", 1952, 0.52);
        DarbininkasImpl d4 = new DarbininkasImpl("B Stabdziu diskai", 152, 36.2);
        DarbininkasImpl d5 = new DarbininkasImpl("Padangos", 114, 18.1);
        DarbininkasImpl d6 = new DarbininkasImpl("Ratlankiai", 15, 155.12);
        DarbininkasImpl d7 = new DarbininkasImpl("Turbinos", 95, 312.64);
        DarbininkasImpl d8 = new DarbininkasImpl("C Turbinos valdymas", 152, 85.97);
        DarbininkasImpl d9 = new DarbininkasImpl("Ismetimo vamzdziai", 52, 940);
        DarbininkasImpl d10 = new DarbininkasImpl("Varikliai", 8, 8521.69);

        List<DarbininkasImpl> list = new ArrayList<>();

        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);
        list.add(d7);
        list.add(d8);
        list.add(d9);
        list.add(d10);
        System.out.println("Bendra pagamintu detaliu dienos suvestine (detalė - pagamintas kiekis - suma(kiekis*kaina))\n");
        suma(list);
        atstatytiPradineKaina(list);
        System.out.println("\nSuvestine surikiuojama pagal pagamintu detaliu kieki nuo max iki min, jeigu kiekis vienodas pagal pavadinima\n");

//        Collections.sort(list);

        Collections.sort(list, DarbininkasImpl.surikiuotiPagalPav);



        spausdinti(list);
        System.out.println("\nDienos norma \n");

        dienosNorma(list);
        pasalintiIrasus(list);
        System.out.println("\nPasalinami irasai kuriuose detales kaina virsija 100eu \n");
        spausdinti(list);
    }


    public static void spausdinti(List<DarbininkasImpl> list) {
        Iterator<DarbininkasImpl> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * funkcija randanti sandauga detales kainos ir detaliu pagaminto kiekio
     * @param list DarbininkasImpl sarasas
     */
    public static void suma(List<DarbininkasImpl> list) {

        for (DarbininkasImpl darb : list) {
            darb.setDetalesKaina(darb.getDetalesKaina() * darb.getPagamintasKiekis());
            System.out.println(darb.toString());
        }
    }

    /**
     * funkcija skaiciuojanti dienos norma
     * @param list DarbininkasImpl sarasas
     */
    public static void dienosNorma(List<DarbininkasImpl> list) {
        for (DarbininkasImpl darb : list) {

            if (darb.getPagamintasKiekis() < 1000) {
                System.out.println(darb.toString() + " NORMA NEĮVYKDYTA");
            } else {
                System.out.println(darb.toString() + " NORMA ĮVYKDYTA");
            }
        }
    }

    /**
     * Funkcija atstatanti pradine kaina, reikalinga kadangi buvo panaudota funkcija "suma(list)"
     * @param list DarbininkasImpl sarasas
     */

    public static void atstatytiPradineKaina(List<DarbininkasImpl> list) {
        for (DarbininkasImpl darb : list) {
            darb.setDetalesKaina(darb.getDetalesKaina() / darb.getPagamintasKiekis());
        }
    }

    /**
     * Funkcija pasalinanti irasus, kai detales kaina virsija 100eu
     * @param list DarbininkasImpl sarasas
     */
    public static void pasalintiIrasus(List<DarbininkasImpl> list) {
        Iterator<DarbininkasImpl> it = list.iterator();

        while (it.hasNext()) {
            if (it.next().getDetalesKaina() > 100) {
                it.remove();
            }
        }
    }
}


