package spiegazione;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAOMock implements iPersonaDAO
{
	private List<Persona> fintoDb = new ArrayList<>();

	private static Long nuovoId = 11L;

	public PersonaDAOMock() {
		fintoDb.add(new Persona(1L, "Mario", "Rossi"));
		fintoDb.add(new Persona(2L, "Luca", "Bianchi"));
		fintoDb.add(new Persona(3L, "Giulia", "Verdi"));
		fintoDb.add(new Persona(4L, "Francesca", "Neri"));
		fintoDb.add(new Persona(5L, "Alessandro", "Romano"));
		fintoDb.add(new Persona(6L, "Chiara", "Gallo"));
		fintoDb.add(new Persona(7L, "Stefano", "Leone"));
		fintoDb.add(new Persona(8L, "Federica", "Sanna"));
		fintoDb.add(new Persona(9L, "Davide", "Ferrari"));
		fintoDb.add(new Persona(10L, "Elena", "Conti"));
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
