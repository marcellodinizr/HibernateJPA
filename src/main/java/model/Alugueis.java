package model;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Alugueis implements EntidadeBase {

	
	private Integer id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Integer data_vencimento;

	@Column(nullable = true)
	private float valor_pago;

	@Column(nullable = true)
	private Integer data_pagamento;

	@Column(columnDefinition = "text")
	private String obs;

	@ManyToOne
	@JoinColumn(name = "id_locacao")
	private Locacao locacao;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(Integer data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public float getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(float valor_pago) {
		this.valor_pago = valor_pago;
	}

	public Integer getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Integer data_pagamento) {
		this.data_pagamento = data_pagamento;
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
		Alugueis aluguel = (Alugueis) o;
		return Objects.equals(id, aluguel.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
