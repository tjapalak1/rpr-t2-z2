package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna_tacka;
    private double krajnja_tacka;
    private boolean ukljucena_prva;
    private boolean ukljucena_druga;


    Interval(double prva, double druga, boolean jeste_prva, boolean jeste_druga) {
        if (Double.compare(prva, druga) == 1) throw new IllegalArgumentException("Besmisleni ulazni podaci");

        this.pocetna_tacka = prva;
        this.krajnja_tacka = druga;
        this.ukljucena_prva = jeste_prva;
        this.ukljucena_druga = jeste_druga;

    }

    Interval() {
        new Interval(0, 0, false, false);
    }



    public boolean isNull() {
        if (Double.compare(this.pocetna_tacka, this.krajnja_tacka) == 0 && Double.compare(this.pocetna_tacka, 0) == 0) {
            if (!this.ukljucena_prva && !this.ukljucena_druga)
                return true;
        }
        return false;
    }

    public boolean isIn(double tacka)
    {
        if(Double.compare(this.pocetna_tacka,tacka)==-1 && Double.compare(tacka,this.krajnja_tacka)==-1 )
            return true;

        if(Double.compare(this.pocetna_tacka,tacka)==0)
        {
            if(this.ukljucena_prva==true)
                return true;

            return false;
        }




        return false;
    }


    public Interval intersect(Interval interval)
    {
        double pocetna=0;
        double krajnja=0;
        boolean pripada_prva=false;
        boolean pripada_druga=false;
        switch(Double.compare(this.pocetna_tacka,interval.pocetna_tacka)) {
            case -1:
                pocetna = interval.pocetna_tacka;
                pripada_prva = interval.ukljucena_prva;
                break;
            case 1:
                pocetna = this.pocetna_tacka;
                pripada_prva = this.ukljucena_prva;
                break;
            case 0:
                pocetna = this.pocetna_tacka;
                if (this.ukljucena_prva && interval.ukljucena_prva)
                    pripada_prva = true;
                else
                    pripada_prva = false;
                break;
        }

        switch(Double.compare(this.krajnja_tacka,interval.krajnja_tacka)) {
            case -1:
                krajnja = this.krajnja_tacka;
                pripada_druga = this.ukljucena_druga;
                break;
            case 1:
                krajnja = interval.krajnja_tacka;
                pripada_druga = interval.ukljucena_druga;
                break;
            case 0:
                krajnja = this.pocetna_tacka;
                if (this.ukljucena_prva && interval.ukljucena_prva)
                    pripada_druga = true;
                else
                    pripada_druga = false;
                break;
        }

        return new Interval(pocetna,krajnja,pripada_prva,pripada_druga);
    }

    public static Interval intersect(Interval i, Interval i2)
    {
        double pocetna=0;
        double krajnja=0;
        boolean pripada_prva=false;
        boolean pripada_druga=false;
        switch(Double.compare(i.pocetna_tacka,i2.pocetna_tacka)) {
            case -1:
                pocetna = i2.pocetna_tacka;
                pripada_prva = i2.ukljucena_prva;
                break;
            case 1:
                pocetna = i.pocetna_tacka;
                pripada_prva = i.ukljucena_prva;
                break;
            case 0:
                pocetna = i.pocetna_tacka;
                if (i.ukljucena_prva && i2.ukljucena_prva)
                    pripada_prva = true;
                else
                    pripada_prva = false;
                break;
        }

        switch(Double.compare(i.krajnja_tacka,i2.krajnja_tacka)) {
            case -1:
                krajnja = i.krajnja_tacka;
                pripada_druga = i.ukljucena_druga;
                break;
            case 1:
                krajnja = i2.krajnja_tacka;
                pripada_druga = i2.ukljucena_druga;
                break;
            case 0:
                krajnja = i.pocetna_tacka;
                if (i.ukljucena_prva && i2.ukljucena_prva)
                    pripada_druga = true;
                else
                    pripada_druga = false;
                break;
        }

        return new Interval(pocetna,krajnja,pripada_prva,pripada_druga);

    }
    @Override
    public String toString()
    {
        String string="";

        if(this.ukljucena_prva)
            string+="[";
        else
            string+="(";

        if(Double.compare(this.pocetna_tacka,0)!=0)
            string+=this.pocetna_tacka;
        if(Double.compare(this.pocetna_tacka,0)!=0 || Double.compare(this.krajnja_tacka,0)!=0)
            string+=",";

        if(Double.compare(this.krajnja_tacka,0)!=0)
            string+=this.krajnja_tacka;

        if(this.ukljucena_druga)
            string+="]";
        else
            string+=")";

        return string;
    }

    @Override
    public boolean equals(Object o)
    {
        Interval interval = (Interval) o;
        if(Double.compare(this.pocetna_tacka,interval.pocetna_tacka)==0 && Double.compare(this.krajnja_tacka,interval.krajnja_tacka)==0 && this.ukljucena_prva==interval.ukljucena_prva && this.ukljucena_druga==interval.ukljucena_druga )
            return true;

        return false;
    }


}