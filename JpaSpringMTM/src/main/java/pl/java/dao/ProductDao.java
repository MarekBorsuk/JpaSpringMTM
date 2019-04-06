package pl.java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.java.model.Product;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
	
}
