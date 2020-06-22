public class Triangel
{
    public static double iRadie(double s1, double s2, double s3)
    {
        double s = (s1 + s2 + s3)/2;
        double r2 = (s - s1)*(s - s2)*(s - s3)/s;
        double radie = Math.sqrt(r2);

        return radie;
    }

    public static double yRadie(double s1, double s2, double s3)
    {
        double t = s1 * s2 * s3;
        double n = (s1 + s2 + s3)*(s2 + s3 - s1)*(s1 + s3 - s2)*(s1 + s2 - s3);
        double radie = t/Math.sqrt(n);

        return radie;
    }
}
