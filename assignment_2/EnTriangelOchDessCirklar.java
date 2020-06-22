import java.util.Scanner;


class EnTriangelOchDessCirklar
{
	public static void main(String[] args)
	{
		System.out.println("En triangel och dess cirklar\n");

		Scanner	Scanner = new Scanner (System.in);

		double[] Sidor = new double[3];

		System.out.println("Mata in sidorna på en given triangel");

		for (int i = 0; i < 3; i++)
			Sidor[i] = Scanner.nextDouble();

		double InreRadie;
		double YttreRadie;

		Triangel Cirkel = new Triangel();

		InreRadie = Cirkel.iRadie(Sidor[0], Sidor[1], Sidor[2]);

		YttreRadie = Cirkel.yRadie(Sidor[0], Sidor[1], Sidor[2]);

		System.out.println();
		System.out.println("Den inskrivna cirkelns radie är " + InreRadie + " längdenheter");

		System.out.println();
		System.out.println("Den omnskrivna cirkelns radie är " + YttreRadie + " längdenheter");
	}
}
