package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Alugueis;

public class repoAlugueis {

	private final EntityManager manager;
	private GenericDAO<Alugueis> daoGenerico;

	public repoAlugueis(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new GenericDAO<Alugueis>(manager);
	}

	public Alugueis buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Alugueis.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Alugueis> findAll() {
		return manager.createQuery("FROM " + Alugueis.class.getName()).getResultList();
	}

	public Alugueis salvaOuAtualiza(Alugueis aluguel) {
		return daoGenerico.salvaOuAtualiza(aluguel);
	}

	public void remove(Alugueis aluguel) {
		daoGenerico.remove(aluguel);
	}
}
