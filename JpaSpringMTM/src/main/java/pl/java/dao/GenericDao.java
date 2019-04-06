package pl.java.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDao<T, K> {
	
	@PersistenceContext
	private EntityManager entityManager;
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		type = (Class<T>)((ParameterizedType)this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public T get (K key) {
		T find = entityManager.find(type, key);
		return find;
	}
	
	public void remove(T entity) {
		T managedEnity = entityManager.merge(entity);
		entityManager.remove(managedEnity);
	}
}
