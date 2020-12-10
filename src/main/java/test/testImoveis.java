package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Imoveis;
import util.JpaUtil;

public class testImoveis {

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

		Imoveis imovel = new Imoveis();
		imovel.setTipo_imovel("Teste2");
		imovel.setValor_aluguel(700);
		imovel.setBairro("Teste2");
		imovel.setEndereco("Teste2");
		imovel.setCep(6700);

		manager.persist(imovel);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void update() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Imoveis imovel = new Imoveis();
		imovel.setId(6);
		imovel.setTipo_imovel("Casa");
		imovel.setValor_aluguel(900);
		imovel.setBairro("Vinhais");
		imovel.setEndereco("Rua Itaparica");
		imovel.setCep(6543);

		manager.merge(imovel);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void find() {
		EntityManager manager = JpaUtil.getEntityManager();

		Integer primaryKey = 1;
		Imoveis imovel = manager.find(Imoveis.class, primaryKey);

		System.out.println("ID \t" + imovel.getId());
		System.out.println("Tipo \t" + imovel.getTipo_imovel());
		System.out.println("Valor \t" + imovel.getValor_aluguel());
		System.out.println("Bairro \t" + imovel.getBairro());
		System.out.println("Endereco \t" + imovel.getEndereco());
		System.out.println("CEP \t" + imovel.getCep());

		manager.close();
		JpaUtil.close();
	}

	private static void query() {
		EntityManager manager = JpaUtil.getEntityManager();

		String jpql = "SELECT a FROM Imoveis a";
		Query query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<Imoveis> listImoveis = query.getResultList();

		for (Imoveis imovel : listImoveis) {
			System.out
					.println(imovel.getId() + ", " + imovel.getTipo_imovel() + ", " + imovel.getValor_aluguel());

		}
	}

	private static void remove() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Integer primaryKey = 1;
		Imoveis imovel = manager.find(Imoveis.class, primaryKey);
		manager.remove(imovel);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
