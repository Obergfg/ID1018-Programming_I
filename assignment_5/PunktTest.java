import java.io.PrintWriter; // PrintWriter

public class PunktTest
{
    public static void main (String[] args)
    {
        PrintWriter out = new PrintWriter (System.out, true);
// testa en konstruktor och en transformator
        Punkt p1 = new Punkt("A", 3,4);
        Punkt p2 = new Punkt("B", -2,6);
        Punkt p3 = new Punkt("C", 0,2);
        Punkt p4 = new Punkt("D", 2,7);
        Punkt[] p = new Punkt[]{p1,p2,p3,p4};
        Polylinje pl1 = new Polylinje();
        //out.println(pl1);
        pl1 = new Polylinje(p);
       // out.println(pl1);

        out.println(p1.avstand(p2));
/*

// testa inspektorer
        Polylinje pl2 = new Polylinje(pl1.getHorn());
        out.println (pl2);
        String farg = pl1.getFarg();
        out.println(farg);
        int bredd = pl1.getBredd();
        out.println(bredd);

        // testa mutatorer
        pl1.setBredd (5);
        pl1.setFarg ("Lila");
        out.println (pl1);
        out.println (pl1.getBredd());
        out.println (pl1.getFarg());


// testa en kombinator och en komparator
        double langd = pl1.langd();
        out.println (langd);
*/
        // testa polylinje.laggtill
        Punkt p5 = new Punkt("E", 3,10);
        pl1.laggTill(p5);
       // out.println (pl1);



// testa laggTillFramfor
        Punkt p6 = new Punkt("F", 0,-5);
        Polylinje pl3 = new Polylinje();

        out.println (pl3);

        pl3.laggTill(p1);
        out.println (pl3);

        pl3.laggTill(p2);
        out.println (pl3);


        pl3.laggTillFramfor(p6, "A");
        out.println (pl3);
        //testa taBort
       /* pl1.taBort("B");
        out.println (pl1);
        pl1.taBort("E");
        out.println (pl1);
        pl1.taBort("F");
        out.println (pl1);
        pl1.taBort("A");
        out.println (pl1);


        pl1.laggTillFramfor(p2, "C");
        out.println (pl1);
        pl1.laggTillFramfor(p1, "B");
        out.println (pl1);
        */
    }

}
