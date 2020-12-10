package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Alugueis;
import util.JpaUtil;

public class testAlugueis {

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

		Alugueis aluguel = new Alugueis();
		aluguel.setData_pagamento(2020);
		aluguel.setData_vencimento(2022);
		aluguel.setValor_pago(800);

		manager.persist(aluguel);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void update() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Alugueis aluguel = new Alugueis();
		aluguel.setId(1);
		aluguel.setData_pagamento(2021);
		aluguel.setData_vencimento(2023);
		aluguel.setValor_pago(500);

		manager.merge(aluguel);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void find() {
		EntityManager manager = JpaUtil.getEntityManager();

		Integer primaryKey = 1;
		Alugueis aluguel = manager.find(Alugueis.class, primaryKey);

		System.out.println("ID \t" + aluguel.getId());
		System.out.println("Data Pag \t" + aluguel.getData_pagamento());
		System.out.println("Data Venc \t" + aluguel.getData_vencimento());
		System.out.println("Pago \t" + aluguel.getValor_pago());

		manager.close();
		JpaUtil.close();
	}

	private static void query() {
		EntityManager manager = JpaUtil.getEntityManager();

		String jpql = "SELECT a FROM Imoveis a";
		Query query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<Alugueis> listAlugueis = query.getResultList();

		for (Alugueis aluguel : listAlugueis) {
			System.out.println(aluguel.getId() + ", " + aluguel.getValor_pago());

		}
	}

	private static void remove() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Integer primaryKey = 1;
		Alugueis aluguel = manager.find(Alugueis.class, primaryKey);
		manager.remove(aluguel);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
