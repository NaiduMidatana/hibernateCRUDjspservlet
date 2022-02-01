package com.mouritech.departmentcrud.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouritech.departmentcrud.dao.DepartmentDAO;
import com.mouritech.departmentcrud.entity.Department;


/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	private DepartmentDAO depDao;

	public void init() {
		depDao = new DepartmentDAO();
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		try {

			switch (action) {
			case "/new":
				showNewDepartmentForm(req,resp);
				break;
			case "/insert":
				insertDepartment(req,resp);
				break;
			case "/list":
				listDepartment(req,resp);
				break;
			case "/update":
				updateDepartment(req,resp);
				break;
			case "/edit":	
				showEditDepartmentForm(req,resp);
				break;
			case "/delete":
				deleteDepartment(req,resp);
				break;
			default:
				break;
			}//close of switch

		} catch (Exception e) {
			e.printStackTrace();
		}//close catch
		
	}//close of doPost
	
	private void insertDepartment(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Long empid =      (long) Integer.parseInt(req.getParameter("eid"));
		String depname = req.getParameter("dname");
		String dephead = req.getParameter("dhead");
		
		
		Department dep = new Department(depname,dephead);
	    depDao.saveDepartment(dep);
		resp.sendRedirect("list");
		
	}
	
	private void showEditDepartmentForm(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException,ServletException,SQLException {
		
		Long empid = Long.valueOf(req.getParameter("id"));
		
		Department existingDepartment = depDao.getDepartment(empid);
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		req.setAttribute("existingDepartment", existingDepartment);
		rd.forward(req, resp);
	}
	
	private void updateDepartment(HttpServletRequest req, HttpServletResponse resp) 	
			throws IOException,ServletException,SQLException {
		Long depid = Long.valueOf(req.getParameter("did"));
		String depname = req.getParameter("dname");
		String dephead = req.getParameter("dhead");
		
		
		Department dep = new Department(depid,depname,dephead);
		depDao.updateDepartment(dep);
		resp.sendRedirect("list");
		
	}

	private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Long depid = Long.valueOf(req.getParameter("id"));
		depDao.deleteDepartment(depid);
		resp.sendRedirect("list");
		
	}

	private void showNewDepartmentForm(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("department-form.jsp");
		rd.forward(req, resp);
		
	}

	private void listDepartment(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException ,SQLException {
		
		List<Department> listOfDepartments  = depDao.getAllDepartments();
		req.setAttribute("listDeps",listOfDepartments );
		RequestDispatcher rd = req.getRequestDispatcher("department-list.jsp");
		rd.forward(req, res);
	}

}
