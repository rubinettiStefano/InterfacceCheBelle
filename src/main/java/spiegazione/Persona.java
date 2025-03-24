package spiegazione;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.StringJoiner;

@Entity
public class Persona
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome,cognome;

	public Persona(){}

	public Persona(Long id, String nome, String cognome)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Persona(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
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

	@Override
	public String toString()
	{
		return new StringJoiner(" ", "", ".")
				.add("id: " + id)
				.add("nome: " + nome)
				.add("cognome: " + cognome)
				.toString();
	}
}
