package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Imoveis;

public class repoImoveis {

	private final EntityManager manager;
	private GenericDAO<Imoveis> daoGenerico;

	public repoImoveis(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new GenericDAO<Imoveis>(manager);
	}

	public Imoveis buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Imoveis.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Imoveis> findAll() {
		return manager.createQuery("FROM " + Imoveis.class.getName()).getResultList();
	}

	public Imoveis salvaOuAtualiza(Imoveis imovel) {
		return daoGenerico.salvaOuAtualiza(imovel);
	}

	public void remove(Imoveis imovel) {
		daoGenerico.remove(imovel);
	}
}
