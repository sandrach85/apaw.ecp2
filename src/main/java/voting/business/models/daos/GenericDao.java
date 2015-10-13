package voting.business.models.daos;

public interface GenericDao<T1, T2> {

	void create(T entity);

	T read(ID id);

	void update(T entity);

	void deleteById(ID id);

	void deleteById(ID id);

}
