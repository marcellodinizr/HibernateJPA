package repository;

import java.util.Objects;

import javax.persistence.EntityManager;

import model.EntidadeBase;

public class GenericDAO<T extends EntidadeBase> {

	private final EntityManager manager;

	GenericDAO(EntityManager manager) {
		this.manager = manager;
	}

	T buscaPorId(Class<T> clazz, Integer id) {
		return manager.find(clazz, id);
	}

	T salvaOuAtualiza(T t) {
		if (Objects.isNull(t.getId()))
			this.manager.persist(t);
		else
			t = this.manager.merge(t);
		return t;
	}

	void remove(T t) {
		manager.remove(t);
		manager.flush();
	}
}
