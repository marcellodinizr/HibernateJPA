package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Clientes;

public class repoClientes {

	private final EntityManager manager;
	private GenericDAO<Clientes> daoGenerico;

	public repoClientes(EntityManager manager) {
		this.manager = manager;
		daoGenerico = new GenericDAO<Clientes>(manager);
	}

	public Clientes buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Clientes.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Clientes> findAll() {
		return manager.createQuery("FROM " + Clientes.class.getName()).getResultList();
	}

	public Clientes salvaOuAtualiza(Clientes cliente) {
		return daoGenerico.salvaOuAtualiza(cliente);
	}

	public void remove(Clientes cliente) {
		daoGenerico.remove(cliente);
	}
}
