package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	// insere dados no banco de dados
	void insert(Seller obj);

	// atualiza os dados do banco de dados
	void update(Seller obj);

	// deleta informações da base de dados
	void deleteById(Integer id);

	// verifica no banco se tem objeto com esse id se sim retorna se não retorna null
	Seller findById(Integer id);

	// retorna todos departamentos
	List<Seller> findAll();
	
	//retorna todos por departamento
	List<Seller> findByDepartment(Department department);
	
}
