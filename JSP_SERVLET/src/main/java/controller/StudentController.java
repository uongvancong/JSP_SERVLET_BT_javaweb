package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.plexus.util.StringUtils;

import model.*;
import serviceimpl.RegisterServiceImpl;
import serviceimpl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/student" })
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StudentServiceImpl service = new StudentServiceImpl();
	private static RegisterServiceImpl registerService = new RegisterServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		resp.setContentType("text/html");

		deleteStudent(req);

		addOrEditStudent(req);

		
		List<Student> listStudent = service.selectAllStudent();

		req.getSession().setAttribute("model", listStudent);
		
		List<Register> listRegister = null;
		
		
/*
		String idClick = req.getParameter("idclick");
		System.out.println("idClick = " + idClick); 
		
		if(checkNumber(idClick)) {
			long tmp;
			
			if(StringUtils.isNumericSpace(idClick)) {
				tmp = Long.parseLong(idClick);
				System.out.println("idClick = " + tmp); 
  				
				// listRegister = registerService.selectRegisterByStudentId(tmp);
 				 
				  
			}
			 
		}
		 */
		listRegister = registerService.selectAllRegister();
		 
		 
		if(listRegister != null) {
			for(Register r: listRegister) {
				System.out.println(r.toString());
			}
		}
		 
		req.getSession().setAttribute("register2", listRegister);

		RequestDispatcher rd = req.getRequestDispatcher("/views/liststudent.jsp");

		rd.forward(req, resp);
	}

	public void editStudent(String id, String name, String age, String address) {
		if (checkNumber(id)) {
			long idTMP;

			idTMP = Long.parseLong(id);

			if (idTMP > 0) {

				Student tmp = new Student(idTMP, name, age, address);

				service.updateStudent(tmp);

			}

		}
	}

	public void deleteStudent(HttpServletRequest req) {
		// delete Student

		String id = req.getParameter("iddelete");

		if (checkNumber(id)) {
			long idTMP;

			if (StringUtils.isNumericSpace(id)) {

				idTMP = Long.parseLong(id);
				if (idTMP > 0) {
					service.deleteStudentById(idTMP);

				}
			}

		}

	}

	public void addOrEditStudent(HttpServletRequest req) {
		// add or update student

		String name = req.getParameter("name");

		String age = req.getParameter("age");

		String address = req.getParameter("address");

		String idedit = req.getParameter("idedit");

		if (checkNumber(idedit)) {
			long idTMP;

			if (StringUtils.isNumericSpace(idedit)) {

				idTMP = Long.parseLong(idedit);
				if (idTMP > 0) {

					editStudent(idedit, name, age, address);
					return;
				}
			}
		}

		if (name != null && age != null && address != null && !name.trim().isEmpty() && !age.trim().isEmpty()
				&& !address.trim().isEmpty()) {

			service.insertStudent(new Student(name, age, address));

		}

	}

	public boolean checkNumber(String id) {
		if (id == null || id.isEmpty())
			return false;
		try {
			long tmp = Long.parseLong(id);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
