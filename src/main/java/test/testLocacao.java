package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Locacao;
import util.JpaUtil;

public class testLocacao {

	public static void main(String[] args) {

//		create();
//		update();
//		find();
//		query();
//		remove();
	}

	private static void create() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Locacao locacao = new Locacao();
		locacao.setValor_aluguel(800);
		locacao.setDia_vencimento(10);

		manager.persist(locacao);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void update() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Locacao locacao = new Locacao();
		locacao.setId(1);
		locacao.setValor_aluguel(400);
		locacao.setDia_vencimento(20);

		manager.merge(locacao);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void find() {
		EntityManager manager = JpaUtil.getEntityManager();

		Integer primaryKey = 1;
		Locacao locacao = manager.find(Locacao.class, primaryKey);

		System.out.println("ID \t" + locacao.getId());
		System.out.println("Valor \t" + locacao.getValor_aluguel());
		System.out.println("Dia Venc \t" + locacao.getDia_vencimento());

		manager.close();
		JpaUtil.close();
	}

	private static void query() {
		EntityManager manager = JpaUtil.getEntityManager();

		String jpql = "SELECT a FROM Clientes a";
		Query query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<Locacao> listLocacao = query.getResultList();

		for (Locacao locacao : listLocacao) {
			System.out
					.println(locacao.getId() + ", " + locacao.getValor_aluguel() + ", " + locacao.getDia_vencimento());

		}
	}

	private static void remove() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Integer primaryKey = 1;
		Locacao locacao = manager.find(Locacao.class, primaryKey);
		manager.remove(locacao);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
