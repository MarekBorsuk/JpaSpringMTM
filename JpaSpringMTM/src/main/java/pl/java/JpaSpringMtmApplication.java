package pl.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.java.dao.ClientDao;
import pl.java.model.Client;
import pl.java.model.Order;
import pl.java.model.Product;

@SpringBootApplication
public class JpaSpringMtmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JpaSpringMtmApplication.class, args);
		
		Client client = new Client("Jan", "Kowalski", "Rzeszowskie przedmieście 3, Rzeszów");		
		Order order = new Order("z dostawą do domu");		
		Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
	    Product product2 = new Product("Telefon APple iPhone SE", 2200.0, "pokrowiec gratis");
	    
	    order.getProducts().add(product1);
	    order.getProducts().add(product2);
	    client.addOrder(order);
	    
	    ClientDao clientDao = ctx.getBean(ClientDao.class);
	    clientDao.save(client);
	    
	    Client geClient = clientDao.get(client.getId());
	    System.out.println(geClient);
	    
	    clientDao.removeAllOrders(client);;
	    
	    
	    
	    ctx.close();
	}

}
