package spiegazione;

import java.util.List;

public class CosaUsaCosa
{
	static iCosaDAO dao = new CosaDAOMockMaAnchePeggio();

	public static void main(String[] args)
	{
		List<Cosa> cose = dao.findAll();
	}
}
