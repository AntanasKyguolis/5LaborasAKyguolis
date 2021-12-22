package com.company;

import java.util.Comparator;

public class DarbininkasImpl implements Darbininkas {
    private String detale;
    private int pagamintasKiekis;
    private double detalesKaina;

    public DarbininkasImpl(String detale, int pagamintasKiekis, double detalesKaina) {
        this.detale = detale;
        this.pagamintasKiekis = pagamintasKiekis;
        this.detalesKaina = detalesKaina;
    }

    public static final Comparator<DarbininkasImpl> surikiuotiPagalPav = new Comparator<DarbininkasImpl>() {
        @Override
        public int compare(DarbininkasImpl o1, DarbininkasImpl o2) {

            int kiekis1 = o1.getPagamintasKiekis();
            int kiekis2 = o2.getPagamintasKiekis();

            if (kiekis1 == kiekis2) {
                String pav1 = o1.getDetale();
                String pav2 = o2.getDetale();
                return pav1.compareTo(pav2);
            }
            return Integer.compare(kiekis1, kiekis2);
        }
    };

    @Override
    public String getDetale() {
        return detale;
    }

    @Override
    public void setDetale(String detale) {
        this.detale = detale;
    }

    @Override
    public int getPagamintasKiekis() {
        return pagamintasKiekis;
    }

    @Override
    public void setPagamintasKiekis(int pagamintasKiekis) {
        this.pagamintasKiekis = pagamintasKiekis;
    }

    @Override
    public double getDetalesKaina() {
        return detalesKaina;
    }

    @Override
    public void setDetalesKaina(double kaina) {
        this.detalesKaina = detalesKaina;
    }

    @Override
    public String toString() {
        return "DarbininkasImpl{" +
                "detale='" + detale + '\'' +
                ", pagamintasKiekis=" + pagamintasKiekis +
                ", detalesKaina=" + detalesKaina +
                '}';
    }
}
// pirmas budas

//    @Override
//    public int compareTo(Object o) {
//        return Comparator
//                .comparing(DarbininkasImpl::getPagamintasKiekis)
//                .reversed()
//                .compare(this, (DarbininkasImpl) o);
//    }

// antras budas

//    public static final Comparator<DarbininkasImpl> surikiuotiPagalPav = new Comparator<DarbininkasImpl>() {
//        @Override
//        public int compare(DarbininkasImpl o1, DarbininkasImpl o2) {
//
//            int kiekis1 = o1.getPagamintasKiekis();
//            int kiekis2 = o2.getPagamintasKiekis();
//
//            if (kiekis1 == kiekis2) {
//                String pav1 = o1.getDetale();
//                String pav2 = o2.getDetale();
//                return pav1.compareTo(pav2);
//            }
//            return Integer.compare(kiekis1, kiekis2);
//        }
//    };

// trecias budas, nedadaryta

//    public static void rikiuoti(List<DarbininkasImpl> list) {
//        Iterator <DarbininkasImpl> it = list.iterator();
//        for(int i = 0; i <list.size() - 1; i++) {
//            for(int j = list.size() - 1; j > i; j--) {
//                int kiekis1 = it.next().getPagamintasKiekis(j - 1);
//                int kiekis2 = it.next().getPagamintasKiekis(j);
//            }
//        }
//    }