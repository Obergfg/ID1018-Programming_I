import sun.font.TrueTypeFont;

import java.util.Random;

public class ValjPolylinje
{
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        Polylinje kortasteGula = new Polylinje();

        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje ();

        // visa polylinjerna
        System.out.println("De skapade polylinjerna:\n");
        for (int i = 0; i < polylinjer.length; i++)
        {
            System.out.println(polylinjer[i]);

            // bestäm den kortaste av de polylinjer som är gula
            if (polylinjer[i].getFarg() == "Gul" && kortasteGula.getHorn().length == 0)
            {
                kortasteGula = polylinjer[i];
            }
            else
            {
                if (polylinjer[i].getFarg() == "Gul" && polylinjer[i].langd() < kortasteGula.langd())
                    kortasteGula = polylinjer[i];
            }
        }
        System.out.println();

        // visa den valda polylinjen
        if (kortasteGula.getHorn().length == 0)
            System.out.println("Det finns ingen gul linje");
        else
            System.out.println("Den kortaste gula linjen är:\n\n" + kortasteGula);
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        String[] farg = new String[]{"Blå", "Gul", "Röd"};
        boolean[] valdaNamn = new boolean[26];
        int antalHorn = 2 + rand.nextInt (7);
        Punkt valdPunkt = null;

        for (int antalValdaHorn = 0; antalValdaHorn < antalHorn; antalValdaHorn++)
        {
            valdPunkt = slumpPunkt();

            // ett och samma namn kan inte förekomma flera gånger
            while (valdaNamn[valdPunkt.getNamn().charAt(0) - 'A'] == true)
                valdPunkt = slumpPunkt();

            polylinje.laggTill(valdPunkt);
            valdaNamn[valdPunkt.getNamn().charAt(0) - 'A'] = true;
        }

        // sätt färg
        polylinje.setFarg(farg[rand.nextInt(3)]);

        return polylinje;
    }
}
