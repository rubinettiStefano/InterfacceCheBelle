package spiegazione;

import java.util.Comparator;

public class ComparatoreAlfabetico implements Comparator<Persona>
{
	@Override
	public int compare(Persona o1, Persona o2)
	{
		return (o1.getNome()+o1.getCognome()).compareTo(o2.getNome()+o2.getCognome());
	}
}
