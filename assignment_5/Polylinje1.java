public class Polylinje1
{
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje1()
    {
        this.horn = new Punkt[0];
    }

    public Polylinje1(Punkt[] horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt(horn[i]);
    }

    public String toString ()
    {
       if (this.horn.length == 0)
           return "Det finns ingen polylinje";
       else if (this.horn.length == 1)
           return "Det finns bara en punkt på polylinjen " + this.horn[0];
       else
       {
           String polyl = "{[";

           for (int i = 0; i < horn.length; i++) {
               polyl += horn[i];
           }

           return polyl + "], " + farg + ", " + bredd + "}";
       }
    }

    public Punkt[] getHorn ()
    {
        return this.horn;
    }

    public String getFarg ()
    {
        return farg;
    }

    public int getBredd ()
    {
        return bredd;
    }

    public void setFarg (String farg)
    {
        this.farg = farg;
    }

    public void setBredd (int bredd)
    {
        this.bredd = bredd;
    }

    public double langd ()
    {
        double langd = 0;

        for (int i = 0; i < horn.length - 1; i++)
        {
            langd += this.horn[i].avstand(this.horn[i+1]);
        }

        return langd;
    }

    public void laggTill (Punkt horn)
    {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = horn;

        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn)
    {
        Punkt[] ny = new Punkt[this.horn.length + 1];
        int index = -1;

            for (int i = 0; i < this.horn.length; i++)
                if (hornNamn == this.horn[i].getNamn())
                    index = i;

            if (index == -1)
                System.out.println("Punkten " + hornNamn + " existerar inte på polylinjen");
            else
            {
                for (int i = 0; i < index; i++)
                    ny[i] = this.horn[i];

                ny[index] = horn;

                for (int i = index + 1; i < ny.length; i++)
                    ny[i] = this.horn[i - 1];

                this.horn = ny;
            }
    }

    public void taBort (String hornNamn)
    {
        Punkt[] ny = new Punkt[this.horn.length - 1];
        int index = -1;

        for (int i = 0; i < this.horn.length; i++)
            if (hornNamn == this.horn[i].getNamn())
                index = i;

        if (index == -1)
            System.out.println("Punkten " + hornNamn + " existerar inte på polylinjen");
        else
        {
            for (int i = 0; i < index; i++)
                ny[i] = this.horn[i];

            for (int i = index + 1; i <= ny.length; i++)
                ny[i - 1] = this.horn[i];

            this.horn = ny;
        }
    }
}
