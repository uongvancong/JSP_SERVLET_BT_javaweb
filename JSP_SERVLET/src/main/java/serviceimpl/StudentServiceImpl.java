package serviceimpl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;
import mapper.StudentMapper;
import service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	@Override
	public void insertStudent(Student student) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("StudentSqlMapConfig.xml");

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create student mapper
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);

			studentMapper.insert(student);
			session.commit();
			System.out.println("insert sucessfully");

			// close session
			session.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close session
			if (session != null)
				session.close();
		}
	}

	@Override
	public void updateStudent(Student student) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("StudentSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create student mapper
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);

			// update student

			studentMapper.update(student);
			session.commit();
			System.out.println("update sucessfully");

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			// close session
			if (session != null)
				session.close();
		}

	}

	@Override
	public void deleteStudentById(long studentId) {
//		// delete register byID
//		RegisterServiceImpl registerService = new RegisterServiceImpl();
//
//		registerService.deleteRegisterByIdStudent(studentId);
		// delete student
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("StudentSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create student mapper
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);

			// delete student
			studentMapper.delete(studentId);

			session.commit();

			System.out.println("delete successfully");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close session
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Student> selectAllStudent() {

		Reader reader;
		SqlSession session = null;
		try {
		 
			reader = Resources.getResourceAsReader("StudentSqlMapConfig.xml");
		 
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			session = sqlSessionFactory.openSession();

			// create student mapper
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);

			// show list student
			List<Student> listStudents = studentMapper.getAll();

			return listStudents;

		} catch (IOException e) {

			return null;

		} finally {
			// close session
			if (session != null)
				session.close();
		}

	}

	@Override
	public Student selectStudentById(long studentId) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("StudentSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create student mapper
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);

			// get student by Id

			return studentMapper.getById(studentId);

		} catch (IOException e) {
			return null;

		} finally {
			// close session
			if (session != null)
				session.close();
		}
	}
}
