package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ClienteDao;
import br.com.fiap.tds.dao.impl.ClienteDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.entity.Movimentacao;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	public static void main(String[] args) {
		
		// Instanciar um cliente
		Cliente cliente = new Cliente(1234567890, "João Carlos", new GregorianCalendar(
				1993,Calendar.NOVEMBER, 12), "Avenida Paulista", 1194707219, 20974554,
				"joaocarlos@gmail.com", "médico", 8000.0);
		
		// Instanciar duas movimentações
		Movimentacao mov1 = new Movimentacao(new GregorianCalendar(2021,
				Calendar.SEPTEMBER,6), 4201, 1234567891, 12345667, 
				3000.0, "crédito");
		Movimentacao mov2 = new Movimentacao(new GregorianCalendar(2021,
				Calendar.SEPTEMBER,1), 4202, 1234562332, 44445667, 
				1000.0, "débito");
		
		// Adicionar as movimentações ao Cliente
		cliente.addMovimentacao(mov1);
		cliente.addMovimentacao(mov2);
		
		// Cadastrar um cliente
		// Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		// Instanciar um clienteDao
		ClienteDao dao = new ClienteDaoImpl(em);
		
		try {
			// Persistir o sistema
			dao.create(cliente);
			
			// Commit 
			dao.commit();
			System.out.println("Tudo ok!");
		}catch(CommitException e) {
			System.out.println("Deu ruim...");
		}
		
		// Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
