package br.com.alura.loja.ultil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUltil {
	
	//criando um objeto do tipo EntiyManager
	//O par�metro passadoo no factory � o  name do persistence-unit que esta no persistence.xml
	//Colocando como statico para n�o ficar criando toda vez o entityMFactory
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
