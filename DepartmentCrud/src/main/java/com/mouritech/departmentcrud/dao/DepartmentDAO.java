package com.mouritech.departmentcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.departmentcrud.entity.Department;
import com.mouritech.departmentcrud.util.HibernateUtil;

public class DepartmentDAO {

	public List<Department> getAllDepartments() {
		Transaction transaction = null;
		List<Department> depList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			
			
			//get entity from database
			depList = session.createQuery("from Department").getResultList();
	
			//commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return depList;
	}
	public void saveDepartment(Department dept) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the department object in to database
			session.save(dept);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}
	public void deleteDepartment(Long depid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			//find the employee object from the database
			Department dep = session.get(Department.class, depid);
			if(dep != null) {
			// delete the employee object in to database
			session.delete(dep);
			System.out.println("Department deleted");
			}
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}
	
	public void updateDepartment(Department dept) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();

			session.saveOrUpdate(dept);
	
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public Department getDepartment(Long deptid) {
		Transaction transaction = null;
		Department depById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
		
			
			//get entity from database using employee id
			depById = session.get(Department.class, deptid);
			if(depById!=null) {
				
				System.out.println("Department details are = " + depById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return depById;
	}

}
