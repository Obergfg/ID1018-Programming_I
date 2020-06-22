import java.util.Scanner;

public class BestamDenKortasteVagen
{
	public static void main(String[] args)
	{
		System.out.println("Den kortaste vägen\n");
		
		Scanner Scanner = new Scanner (System.in);
		
		System.out.println("Ange hur många stationer det är i zon 2");
		int z2 = Scanner.nextInt();
		System.out.println("Ange hur många stationer det är i zon 3");
		int z3 = Scanner.nextInt();

		double[] dist12 = new double[z2];
		double[] dist34 = new double[z3];
		double[][] dist23 = new double[z2][z3];
		
		System.out.println("Ange avståndet mellan stationen i zon 1 och stationerna i zon 2");
		for (int i = 0; i < z2; i++)
			dist12[i] =  Scanner.nextDouble();
		System.out.println("Ange avståndet mellan stationen i zon 4 och stationerna i zon 3");
		for (int j = 0; j < z3; j++)
			dist34[j] =  Scanner.nextDouble();
		System.out.println("Ange avståndet mellan stationerna i zon 2 och stationerna i zon 3");
		for (int i = 0; i < z2; i++)
		{
			for (int j = 0; j < z3; j++)
			{
				dist23[i][j] =  Scanner.nextDouble();	
			}
		}
        System.out.println();

		double[] resvagar = new double[dist12.length*dist34.length];
		double minVag;
		int[] index = new int[2];
		double langd;

		resvagar = DenKortasteVagen.vaglangder(dist12, dist23, dist34);
		minVag = DenKortasteVagen.kortasteVaglangd(resvagar);
		index = DenKortasteVagen.mellanstationer(dist12, dist23, dist34);
		langd = DenKortasteVagen.langd(dist12[index[0]], dist23[index[0]][index[1]], dist34[index[1]]);


        System.out.println("Längden på alla resvägar\n");
		for (int i = 0; i < resvagar.length; i++)
		System.out.println(resvagar[i]);
		System.out.println();
		System.out.println("Kortaste vägen med indexmetoden är " + langd + " längdenheter");
		System.out.println();
		System.out.println("Kortaste vägen med väglängdsmetoden är " + minVag + " längdenheter");
	}
}
