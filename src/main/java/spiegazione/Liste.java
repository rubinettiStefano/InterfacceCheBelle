package spiegazione;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Liste
{

	public static void main(String[] args)
	{
		List<String> lista = new LinkedList<>();

		lista.add("pippo");
		lista.add("pluto");
		lista.add("paperino");


		System.out.println("Ho una lista di "+lista.size()+" elementi");
		System.out.println("------------------------------");
		//stampo pluto
		System.out.println(lista.get(1));
		System.out.println("------------------------------");
		//stampo tutti in ordine
		for(String s:lista)
			System.out.println(s);
		System.out.println("------------------------------");
		//addio pluto
		lista.remove(1);

		//ristampo
		for(String s:lista)
			System.out.println(s);
	}
}
