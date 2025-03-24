package spiegazione;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.StringJoiner;

@Entity
public class Persona implements Comparable<Persona>
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome,cognome;

	private int eta;

	public Persona(){}

	public Persona(Long id, String nome, String cognome, int eta)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public Persona(String nome, String cognome, int eta)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}


	public int getEta()
	{
		return eta;
	}

	public void setEta(int eta)
	{
		this.eta = eta;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(" ", "", ".")
				.add("id: " + id)
				.add("nome: " + nome)
				.add("cognome: " + cognome)
				.add("eta: " + eta)
				.toString();
	}

	@Override
	public int compareTo(Persona o)
	{
//		fa restituire numero positivo quando this è più grande di o
//		0 quando this è uguale a o
//		negativo quando this è più piccolo di o
		//il criterio lo decidiamo noi qui

//		if(this.getEta()>o.getEta())
//			return 1;
//
//		if(this.getEta()==o.getEta())
//			return 0;
//
//		return -1;
		return this.getEta()-o.getEta();
	}
}
