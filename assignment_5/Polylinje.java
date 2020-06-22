public class Polylinje
{
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje ()
    {
        this.horn = new Punkt[0];
    }

    public Polylinje (Punkt[] horn)
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
        Punkt[] kopia = new Punkt[horn.length];

        for (int i = 0; i < horn.length; i++)
        {
            kopia[i] = new Punkt(horn[i]);
        }

        return kopia;
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
        h[i] = new Punkt (horn);

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

                ny[index] = new Punkt(horn);

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

    public PolylinjeIterator getIterator()
    {
        return new PolylinjeIterator();
    }


    public class PolylinjeIterator
    {
        private int aktuell = -1;

        public PolylinjeIterator ()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public boolean finnsHorn ()
        {
            return aktuell != -1;
        }

        public Punkt horn () throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException (
                        "slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        public void gaFram ()
        {
            if (aktuell >= 0 &&
                    aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}
