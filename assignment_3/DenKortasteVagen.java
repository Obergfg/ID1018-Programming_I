
public class DenKortasteVagen
{
    // Metod som skapar en vektor "resvagar" innehållandes alla möjliga resvägar
    public static double[] vaglangder(double[] dist12, double[][] dist23, double[] dist34)
    {
        double[] resvagar = new double[dist12.length * dist34.length];
        int k = 0;

        for (int i = 0; i < dist12.length; i++)
            for (int j = 0; j < dist34.length; j++) {
                resvagar[k] = (dist12[i] + dist23[i][j] + dist34[j]);
                ++k;
            }

        return resvagar;
    }

    // Metod som returnerar den kortaste av alla väglängder
    public static double kortasteVaglangd(double[] resvagar)
    {
        double minst = resvagar[0];

        for (int i = 1; i < resvagar.length; i++)
            if (resvagar[i] < minst)
                minst = resvagar[i];

        return minst;
    }

    // Metod som avgör index för de stationer som har den kortaste väglängden
    public static int[] mellanstationer(double[] dist12, double[][] dist23, double[] dist34)
    {
        int[] index = new int[2];
        double kortaste = (dist12[0] + dist23[0][0] + dist34[0]);

        for (int i = 0; i < dist12.length; i++)
            for (int j = 0; j < dist34.length; j++) {
                if ((dist12[i] + dist23[i][j] + dist34[j]) < kortaste)
                {
                    kortaste = (dist12[i] + dist23[i][j] + dist34[j]);
                    index[0] = i;
                    index[1] = j;
                }
            }

        return index;
    }

    // Metod som returnerar väglängden på den kortaste vägen
    public static double langd(double a, double b, double c)
    {
        double l = (a + b + c);
        return l;
    }


}