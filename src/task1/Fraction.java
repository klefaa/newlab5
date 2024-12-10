package task1;

public class Fraction implements IFraction {
    private int chisl;
    private int znam;
    private Double cache = null;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.chisl = numerator;
        this.znam = denominator;
    }

    public void setChisl(int chisl) {
        this.chisl = chisl;
        cache = null;
    }
    public void setZnam(int znam) {
        if (znam == 0) throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        if (znam < 0) {
            this.chisl *= -1;
            znam *= -1;
        }
        this.znam = znam;
        cache = null;
    }

    public int getChisl() {
        return chisl;
    }
    public int getZnam() {
        return znam;
    }
    public double getDoubleValue() {
        if (cache == null) {
            cache = (double) chisl / znam;
        }
        return cache;
    }

    public String toString(){
        return chisl + "/" + znam;
    }
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Fraction fraction = (Fraction) object;

        return this.chisl == fraction.getChisl()  && this.znam == fraction.getZnam();
    }
}