package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Locacao;

public class repoLocacao {

	private final EntityManager manager;
	private GenericDAO<Locacao> daoGenerico;

	public repoLocacao(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new GenericDAO<Locacao>(manager);
	}

	public Locacao buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Locacao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Locacao> findAll() {
		return manager.createQuery("FROM " + Locacao.class.getName()).getResultList();
	}

	public Locacao salvaOuAtualiza(Locacao locacao) {
		return daoGenerico.salvaOuAtualiza(locacao);
	}

	public void remove(Locacao imovel) {
		daoGenerico.remove(imovel);
	}
}
