package model.dao;

import model.dao.impl.SellerDaoJDBC;

//calss auxiliar responsavel por instanciar os DAO
public class DaoFactory {

	public static SellerDao createSellerDao() {//retorna o tipo da interface mais intermanamente e retorna uma instancia de uma implementação
		return new SellerDaoJDBC();//
	}
}
