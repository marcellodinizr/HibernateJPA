package model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Imoveis implements EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imovel")
	private Integer id;

	@Column(nullable = true)
	private String tipo_imovel;

	@Column(nullable = true)
	private String endereco;

	@Column(nullable = true)
	private String bairro;

	@Column(nullable = true)
	private float cep;

	@Column(nullable = true)
	private float metragem;

	@Column(nullable = true)
	private Integer dormitorios;

	@Column(nullable = true)
	private Integer banheiros;

	@Column(nullable = true)
	private Integer suites;

	@Column(nullable = true)
	private Integer vagas_garagem;

	@Column(nullable = true)
	private float valor_aluguel;

	@Column(columnDefinition = "text")
	private String obs;

	@OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
	private Set<Locacao> locacao = new LinkedHashSet<>();

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo_imovel() {
		return tipo_imovel;
	}

	public void setTipo_imovel(String tipo_imovel) {
		this.tipo_imovel = tipo_imovel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public float getCep() {
		return cep;
	}

	public void setCep(float cep) {
		this.cep = cep;
	}

	public float getMetragem() {
		return metragem;
	}

	public void setMetragem(float metragem) {
		this.metragem = metragem;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public int getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}

	public int getVagas_garagem() {
		return vagas_garagem;
	}

	public void setVagas_garagem(int vagas_garagem) {
		this.vagas_garagem = vagas_garagem;
	}

	public float getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(float valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
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
		Imoveis imovel = (Imoveis) o;
		return Objects.equals(id, imovel.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
