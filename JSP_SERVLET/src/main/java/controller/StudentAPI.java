package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Register;
import serviceimpl.RegisterServiceImpl;
import serviceimpl.StudentServiceImpl;

@WebServlet(urlPatterns = { "/update" })
public class StudentAPI extends HttpServlet {

	private static StudentServiceImpl service = new StudentServiceImpl();
	private static RegisterServiceImpl registerService = new RegisterServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		List<Register> listRegister = null;

		String id = req.getParameter("id");
		listRegister = registerService.selectRegisterByStudentId(Integer.parseInt(id));

		Map<String, Long> map = new HashMap<String, Long>();
		Long zid = listRegister.get(0).getId();
		Long zidstudent = listRegister.get(0).getIdstudent();
		Long zidsubject = listRegister.get(0).getIdsubject();
		map.put("id", zid);
		map.put("idstudent", zidstudent);
		map.put("idsubject", zidsubject);
		
		List<Register> listTMP = registerService.selectAllRegister();
		
		req.setAttribute("listtmp", listTMP);
		
		resp.getWriter().write(new Gson().toJson(map));

	}
}
