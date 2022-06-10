package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	//cria dependencia de uma coneção
	public SellerDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		/*
		 * SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id Where seller.Id = ?
		 * */
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
						"SELECT seller.*,department.Name as DepName "
						+ "FROM seller INNER JOIN department "
						+ "ON seller.DepartmentId = department.Id " 
						+ "Where seller.Id = ?");
			
			st.setInt(1, id);// faz a consulta passando o id
			rs = st.executeQuery(); // guarda o resultado dentro de um result set
			// trasformando result set em objeto
			
			//verifica se veio um resultado transforma em um objeto
			if (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));	
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getNString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);
				
				return obj; // retor um objeto seller por id
			}
			return null; // não existe nenhum vendedor com esse id
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
