package model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class  Locacao implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_locacao")
	private Integer id;

	@Column(nullable = true)
	private float valor_aluguel;

	@Column(nullable = true)
	private float perc_multa;

	@Column(nullable = true)
	private Integer dia_vencimento;

	@Column(nullable = true)
	private Date dia_inicio;

	@Column(nullable = true)
	private Date data_fim;

	private boolean ativo;

	@Column(columnDefinition = "text")
	private String obs;

	@ManyToOne
	@JoinColumn(name = "id_inquilino")
	private Clientes cliente;

	@ManyToOne
	@JoinColumn(name = "id_imovel")
	private Imoveis imovel;
	
	@OneToMany(mappedBy = "locacao", cascade = CascadeType.REMOVE)
	private Set<Alugueis> aluguel = new LinkedHashSet<>();

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(float valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public float getPerc_multa() {
		return perc_multa;
	}

	public void setPerc_multa(float perc_multa) {
		this.perc_multa = perc_multa;
	}

	public Integer getDia_vencimento() {
		return dia_vencimento;
	}

	public void setDia_vencimento(Integer dia_vencimento) {
		this.dia_vencimento = dia_vencimento;
	}

	public Date getDia_inicio() {
		return dia_inicio;
	}

	public void setDia_inicio(Date dia_inicio) {
		this.dia_inicio = dia_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Locacao locacao = (Locacao) o;
		return Objects.equals(id, locacao.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
