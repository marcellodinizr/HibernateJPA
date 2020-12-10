package model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Clientes implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;

	@Column(nullable = false)
	private String nome_cliente;

	@Column(unique = true)
	private float cpf;

	@Column(unique = true)
	private float telefone1;

	@Column(unique = true)
	private float telefone2;

	@Column(unique = true)
	private String email;

	@Column(nullable = true)
	private Date dt_nascimento;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Locacao> locacao = new LinkedHashSet<>();

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public float getCpf() {
		return cpf;
	}

	public void setCpf(float cpf) {
		this.cpf = cpf;
	}

	public float getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(float telefone1) {
		this.telefone1 = telefone1;
	}

	public float getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(float telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Clientes cliente = (Clientes) o;
		return Objects.equals(id, cliente.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
