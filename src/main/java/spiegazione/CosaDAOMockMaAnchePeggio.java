package spiegazione;

import java.util.List;

public class CosaDAOMockMaAnchePeggio implements iCosaDAO
{
	@Override
	public Cosa findById(Long id)
	{
		return null;
	}

	@Override
	public List<Cosa> findAll()
	{
		return List.of();
	}

	@Override
	public void save(Cosa p)
	{

	}

	@Override
	public void delete(Long id)
	{

	}
}
