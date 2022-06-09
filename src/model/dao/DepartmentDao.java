package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	// insere dados no banco de dados
	void insert(Department obj);

	// atualiza os dados do banco de dados
	void update(Department obj);

	// deleta informações da base de dados
	void deleteById(Integer id);

	// verifica no banco se tem objeto com esse id se sim retorna se não retorna null
	Department findById(Integer id);

	// retorna todos departamentos
	List<Department> findAll();

}
