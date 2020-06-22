public class Punkt
{
    // Instansvariabler
    private int x;
    private int y;
    private String punktnamn;
    // Konstruktor
    public Punkt(String p, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.punktnamn = p;
    }

    // Transformator
    public String toString()
    {
        return "(" + this.punktnamn + " " + this.x + " " + this.y + ")";
    }

    // Inspektorer
    public String getNamn()
    {
        return punktnamn;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    // Kombinator
    public double avstand (Punkt p)
    {
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }

    // Komparator
    public boolean equals (Punkt p)
    {
        return this.x == p.x && this.y == p.y;
    }

    // Mutatorer
    public int setX(int x)
    {
        return this.x = x;
    }

    public int setY(int y)
    {
        return this.y = y;
    }

    // Konstruktor 2
    public Punkt(Punkt p)
    {
        this.x = p.x;
        this.y = p.y;
        this.punktnamn = p.punktnamn;
    }
}

