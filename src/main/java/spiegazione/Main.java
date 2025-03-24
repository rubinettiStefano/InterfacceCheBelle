package spiegazione;

import org.hibernate.Session;
import utility.HibernateUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
	static Scanner sc = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	static iPersonaDAO dao = new PersonaDAOMock();

	public static void main(String[] args)
	{
		boolean continua;
		String cmd;

		do
		{
			System.out.println("Inserisci comando");
			cmd = sc.nextLine();

			switch (cmd.toUpperCase())
			{
				case "TUTTI" -> leggiTutti();
				case "UNO" -> leggiUno();
				case "SALVA" -> salva();
				case "ETA" -> eta2();
				case "ALFA" -> alfabetico();
				case "CANCELLA" -> CANCELLA();
				case "QUIT" -> System.out.println("ADDIO");
				default -> System.out.println("METTI GIUSTO MANNAGGIA A TE");
			}

			continua = !cmd.equalsIgnoreCase("QUIT");

		}while(continua);
	}

	private static void eta2()
	{
		List<Persona> persone = dao.findAll();
		Collections.sort(persone);

		for(Persona p:persone)
			System.out.println(p);
	}

	private static void alfabetico2()
	{
		List<Persona> persone = dao.findAll();
//		persone.sort((o1, o2) -> (o1.getNome() + o1.getCognome()).compareTo(o2.getNome() + o2.getCognome()));

		for(Persona p:persone)
			System.out.println(p);
	}


	private static void eta()
	{
		List<Persona> nonOrdinate = dao.findAll();
		List<Persona> ordinate = new ArrayList<>();

		//scorro la lista, trovo il più giovane, lo inserisco nella lista ordinata
		// e lo tolgo da quella non ordinata

		int numeroPersone = nonOrdinate.size();

		for(int i=0;i<numeroPersone;i++)
		{
			Persona giovincello = nonOrdinate.getFirst();

			for(Persona p : nonOrdinate)
				if(p.getEta()<giovincello.getEta())
					giovincello=p;

			nonOrdinate.remove(giovincello);
			ordinate.add(giovincello);
		}

		for(Persona p:ordinate)
			System.out.println(p);
	}

	private static void alfabetico()
	{
		List<Persona> nonOrdinate = dao.findAll();
		List<Persona> ordinate = new ArrayList<>();

		//scorro la lista, trovo il più giovane, lo inserisco nella lista ordinata
		// e lo tolgo da quella non ordinata

		int numeroPersone = nonOrdinate.size();

		for(int i=0;i<numeroPersone;i++)
		{
			Persona giovincello = nonOrdinate.getFirst();

			for(Persona p : nonOrdinate)
				if((p.getNome()+p.getCognome()).compareTo(giovincello.getNome()+giovincello.getCognome())<0)
					giovincello=p;

			nonOrdinate.remove(giovincello);
			ordinate.add(giovincello);
		}

		for(Persona p:ordinate)
			System.out.println(p);
	}

	private static void leggiTutti()
	{
		for(Persona p: dao.findAll())
			System.out.println(p);
	}

	private static void leggiUno()
	{
		System.out.println("DAMMI ID");
		Persona p = dao.findById(Long.parseLong(sc.nextLine()));

		if(p==null)
			System.out.println("BUFFONE, ID SBAGLIATO");
		else
			System.out.println(p);
	}

	private static void salva()
	{
		Persona p = new Persona();
		System.out.println("Dammi nome");
		p.setNome(sc.nextLine());
		System.out.println("Dammi cognome");
		p.setCognome(sc.nextLine());

		dao.save(p);

		System.out.println("salvato");
	}

	private static void CANCELLA()
	{
		System.out.println("DAMMI id");
		dao.delete(Long.parseLong(sc.nextLine()));
		System.out.println("Cancellato");
	}
}
