package pl.java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.java.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long>{
		
	public void removeAllOrders(Client client) {
		Client managedClient = get(client.getId());
		managedClient.getOrders().clear();
	}
	
}
