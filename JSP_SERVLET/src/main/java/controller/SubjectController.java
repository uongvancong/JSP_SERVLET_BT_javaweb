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
import serviceimpl.SubjectServiceImpl;

@WebServlet(urlPatterns = { "/subject" })
public class SubjectController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SubjectServiceImpl service = new SubjectServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Subject> list;

		resp.setContentType("text/html");

		String id = req.getParameter("iddelete");

		deleteSubject(id);

		String name = req.getParameter("name");

		String idedit = req.getParameter("idedit");
		addOrEditSubject(name, idedit);

		list = service.selectAllSubject();

		req.setAttribute("modelsj", list);

		RequestDispatcher rd = req.getRequestDispatcher("/views/listsubject.jsp");

		rd.forward(req, resp);
	}

	public void editSubject(String id, String name) {
		if (checkNumber(id)) {
			long idTMP;

			idTMP = Long.parseLong(id);

			if (idTMP > 0) {

				Subject tmp = new Subject(idTMP, name);

				service.updateSubject(tmp);

			}

		}
	}

	public void deleteSubject(String id) {
		if (checkNumber(id)) {
			long idTMP;

			if (StringUtils.isNumericSpace(id)) {

				idTMP = Long.parseLong(id);
				if (idTMP > 0) {
					service.deleteSubjectById(idTMP);

				}
			}

		}

	}

	public void addOrEditSubject(String name, String edit) {
		if (checkNumber(edit)) {
			long idTMP;

			if (StringUtils.isNumericSpace(edit)) {

				idTMP = Long.parseLong(edit);
				if (idTMP > 0) {

					editSubject(edit, name);
					return;
				}
			}
		}

		if (name != null && !name.trim().isEmpty()) {

			service.insertSubject(new Subject(name));

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
