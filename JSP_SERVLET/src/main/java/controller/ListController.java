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
import serviceimpl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/list" })
public class ListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StudentServiceImpl service = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Student> list;

		resp.setContentType("text/html");

		String id = req.getParameter("iddelete");

		deleteStudent(id);

		String name = req.getParameter("name");

		String age = req.getParameter("age");

		String address = req.getParameter("address");

		String idedit = req.getParameter("idedit");
		addOrEditStudent(name, age, address, idedit);

		list = service.selectAllStudent();

		req.setAttribute("model", list);

		RequestDispatcher rd = req.getRequestDispatcher("/views/list.jsp");

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

	public void deleteStudent(String id) {
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

	public void addOrEditStudent(String name, String age, String address, String edit) {
		if (checkNumber(edit)) {
			long idTMP;

			if (StringUtils.isNumericSpace(edit)) {

				idTMP = Long.parseLong(edit);
				if (idTMP > 0) {

					editStudent(edit, name, age, address);
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
