package spiegazione;

import java.util.List;

public interface iCosaDAO
{
	/**
	 * Deve restituire una Cosa dato il suo id, null se non la trova
	 */
	Cosa findById(Long id);
	/**
	 * Deve restituire una lista con tutte e cos dentro la tabella
	 */
	List<Cosa> findAll();
	/**
	 * Deve fare upsert della cosa passata come parametro
	 */
	void save(Cosa p);
	/**
	 * Deve cancellare la cosa che ha id passato come parametro, dare eccezione paperino se non esiste
	 */
	void delete(Long id);
}
