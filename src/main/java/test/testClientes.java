package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Clientes;
import util.JpaUtil;

public class testClientes {

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

		Clientes cliente = new Clientes();
		cliente.setNome_cliente("Teste1");
		cliente.setCpf(333);
		cliente.setTelefone1(555);

		manager.persist(cliente);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void update() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Clientes cliente = new Clientes();
		cliente.setId(6);
		cliente.setNome_cliente("Teste1");
		cliente.setCpf(111);
		cliente.setTelefone1(222);

		manager.merge(cliente);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	private static void find() {
		EntityManager manager = JpaUtil.getEntityManager();

		Integer primaryKey = 1;
		Clientes cliente = manager.find(Clientes.class, primaryKey);

		System.out.println("ID \t" + cliente.getId());
		System.out.println("Nome \t" + cliente.getNome_cliente());
		System.out.println("CPF \t" + cliente.getCpf());
		System.out.println("Telefone \t" + cliente.getTelefone1());

		manager.close();
		JpaUtil.close();
	}

	private static void query() {
		EntityManager manager = JpaUtil.getEntityManager();

		String jpql = "SELECT a FROM Clientes a";
		Query query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<Clientes> listClientes = query.getResultList();

		for (Clientes cliente : listClientes) {
			System.out.println(cliente.getId() + ", " + cliente.getNome_cliente() + ", " + cliente.getCpf());

		}
	}

	private static void remove() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Integer primaryKey = 1;
		Clientes cliente = manager.find(Clientes.class, primaryKey);
		manager.remove(cliente);

		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
