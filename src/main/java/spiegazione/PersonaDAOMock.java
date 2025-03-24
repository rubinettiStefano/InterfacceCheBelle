package spiegazione;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAOMock implements iPersonaDAO
{
	private List<Persona> fintoDb = new ArrayList<>();

	private static Long nuovoId = 11L;

	public PersonaDAOMock() {
		fintoDb.add(new Persona(1L, "Mario", "Rossi",68));
		fintoDb.add(new Persona(2L, "Giulia", "Bianchi",50));
		fintoDb.add(new Persona(3L, "Giulia", "Verdi",42));
		fintoDb.add(new Persona(4L, "Francesco", "Pierno",36));
		fintoDb.add(new Persona(5L, "Alessandro", "Romano",18));
		fintoDb.add(new Persona(6L, "Chiara", "Gallo",25));
		fintoDb.add(new Persona(7L, "Stefano", "Leone",33));
		fintoDb.add(new Persona(8L, "Federica", "Sanna",44));
		fintoDb.add(new Persona(9L, "Davide", "Ferrari",22));
		fintoDb.add(new Persona(10L, "Elena", "Conti",89));
	}

	@Override
	public Persona findById(Long id)
	{
		for(Persona p:fintoDb)
			if(p.getId()==id)
				return p;

		return null;
	}

	@Override
	public List<Persona> findAll()
	{
		return fintoDb;
	}

	@Override
	public void save(Persona p)
	{
		p.setId(nuovoId++);
		fintoDb.add(p);
	}

	@Override
	public void delete(Long id)
	{
		Persona toRemove = findById(id);
		fintoDb.remove(toRemove);
	}
}
