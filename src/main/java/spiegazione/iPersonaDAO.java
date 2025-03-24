package spiegazione;

import java.util.List;

public interface iPersonaDAO
{
	//public abstract nelle interfacce è IMPLICITO
	/*public abstract */ Persona findById(Long id);
	List<Persona> findAll();
	void save(Persona p);
	void delete(Long id);
}
