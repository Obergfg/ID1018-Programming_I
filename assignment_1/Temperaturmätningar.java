import java.util.Locale;
import java.util.Scanner; // Scanner, Locale

public class Temperaturmätningar
{
        public static void main (String[] args)
        {
            System.out.println ("TEMPERATURER\n");

            // inmatningsverktyg
            Scanner in = new Scanner (System.in);
            in.useLocale (Locale.US);

            // mata in uppgifter om antalet veckor och antalet mätningar
            System.out.print ("Antalet veckor: ");
            int antalVeckor = in.nextInt ();
            System.out.print ("Antalet mätningar per vecka: ");
            int antalMatningarPerVecka = in.nextInt ();

            // plats att lagra temperaturer
            double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

            // mata in temperaturerna
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                System.out.println ("Temperaturer - vecka " + vecka + ":");
                for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                    t[vecka][matning] = in.nextDouble ();
            }
            System.out.println ();

            // visa temperaturerna
            System.out.println ("Temperaturerna:");
            System.out.println();
            for (int vecka = 1; vecka <= antalVeckor; vecka++)
            {
                for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                    System.out.print (t[vecka][matning] + " ");
                System.out.println ();
            }
            System.out.println ();

            // den minsta, den största och medeltemperaturen – veckovis

            double[] minT = new double[antalVeckor + 1];
            double[] maxT = new double[antalVeckor + 1];

            double[] sumT = new double[antalVeckor + 1];
            double[] medelT = new double[antalVeckor + 1];

            for (int i = 1; i < t.length; i++)
            {
                minT[i] = t[i][1];
                maxT[i] = t[i][1];
                sumT[i] = t[i][1];
                for (int j = 2; j < t[i].length; j++)
                {
                    if (t[i][j] < minT[i])
                        minT[i] = t[i][j];
                    if (t[i][j] > maxT[i])
                        maxT[i] = t[i][j];
                    sumT[i] += t[i][j];

                }
                medelT[i] = sumT[i]/antalMatningarPerVecka;
            }

            // visa den minsta, den största och medeltemperaturen för varje vecka

        System.out.println("Minsta- största- och medeltemperaturen veckovis");
            System.out.println();
            for (int i = 1; i < t.length; i++)
                System.out.printf("Vecka %d - %3.2f | %3.2f | %3.2f\n", i, minT[i],  maxT[i],  medelT[i]);
            System.out.println();

            double minTemp = minT[1];
            double maxTemp = maxT[1];
            double sumTemp = sumT[1];
            double medelTemp;

            // visa den minsta, den största och medeltemperaturen i hela mätperioden

            for (int i = 2; i < t.length; i++)
            {
                if (minTemp > minT[i])
                    minTemp = minT[i];
                if (maxTemp < maxT[i])
                    maxTemp = maxT[i];
                sumTemp += sumT[i];
            }

            medelTemp = sumTemp/(antalVeckor*antalMatningarPerVecka);

            System.out.println("Minsta- största- och medeltemperaturen för hela mätperioden");
            System.out.println();
            System.out.printf("%3.2f | %3.2f | %3.2f\n", minTemp,  maxTemp,  medelTemp);
        }
}


