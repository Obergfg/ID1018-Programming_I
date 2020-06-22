import java.util.Scanner;    // Scanner
import static java.lang.System.out;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main(String[] args)
    {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner    in = new Scanner (System.in);
        out.println ("Två naturliga heltal:");
        String    tal1 = in.next ();
        String    tal2 = in.next ();
        out.println ();

        // addera heltalen och visa
        String summa = AritmetiskaMetoder.addera(tal1, tal2);
        visa (tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        String differens = AritmetiskaMetoder.subtrahera(tal1, tal2);
        visa(tal1,tal2, differens, '-');
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
       public static void visa (String tal1, String tal2, String resultat, char operator)
    {
        // sätt en lämplig längd på heltalen och resultatet
        int    len1 = tal1.length ();
        int    len2 = tal2.length ();
        int    len  = resultat.length ();
        int    maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);
        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println ("  " + tal1);
        out.println ("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();
        out.println ("  " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal)
    {
        StringBuilder    sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");

        return sb.toString ();
    }
}