package spiegazione;

import org.hibernate.Session;
import utility.HibernateUtil;

import java.util.Scanner;

public class Main
{
	static Scanner sc = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	static iPersonaDAO dao = new PersonaDAOVero(session);

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
				case "CANCELLA" -> CANCELLA();
				case "QUIT" -> System.out.println("ADDIO");
				default -> System.out.println("METTI GIUSTO MANNAGGIA A TE");
			}

			continua = !cmd.equalsIgnoreCase("QUIT");

		}while(continua);
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
