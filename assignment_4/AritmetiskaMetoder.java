public class AritmetiskaMetoder
{

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2)
    {
        StringBuilder sum = new StringBuilder();
        int summa;
        int minne = 0;
        char t1;
        char t2;

        if (tal2.length() > tal1.length())
        {
            String store = tal2;
            tal2 = tal1;
            tal1 = store;
        }

        for(int i = tal2.length() -1; i >= 0; i--)
        {
            t1 = tal1.charAt(i + tal1.length() - tal2.length());
            t2 = tal2.charAt(i);
            summa = (t1 - '0' + t2 - '0') + minne;

            if (summa > 9)
                minne = summa / 10;
            else
                minne = 0;

            sum.insert(0,summa % 10);
        }

        for (int i = tal1.length() - tal2.length() -1; i >= 0; i--)
        {
            t1 = tal1.charAt(i);
            summa = (t1 - '0') + minne;

            if (summa > 9)
                minne = summa / 10;
            else
                minne = 0;

            sum.insert(0,summa % 10);
        }

        if (minne > 0)
            sum.insert(0, minne);

        return sum.toString();
    }

    // subtrahera tar emot  två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2)
    {
        StringBuilder diff = new StringBuilder();
        int differens;
        int minne = 0;
        char t1;
        char t2;

        for (int i = tal2.length() - 1; i >= 0; i--)
        {
            t1 = tal1.charAt(i + tal1.length() - tal2.length());
            t2 = tal2.charAt(i);
            differens = t1 - '0' - (t2 - '0') - minne;

            if (differens < 0)
            {
                differens += 10;
                minne = 1;
            }
            else
                minne = 0;

            diff.insert(0, differens);
        }

        if (tal1.length() > tal2.length())
        {
            for (int i = tal1.length() - tal2.length() - 1; i >= 0; i--)
            {
                t1 = tal1.charAt(i);
                differens = t1 - '0' - minne;

                if (differens < 0)
                {
                    minne = 1;
                    differens += 10;
                }
                else
                    minne = 0;

                diff.insert(0, differens);
            }
        }

        while (diff.charAt(0) - 48 == 0)
            diff.deleteCharAt(0);

        return diff.toString();
    }
}
