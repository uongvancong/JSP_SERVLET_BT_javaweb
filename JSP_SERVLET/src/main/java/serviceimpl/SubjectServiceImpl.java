package serviceimpl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.SubjectMapper;
import model.Subject;
import service.ISubjectService;
 

public class SubjectServiceImpl implements ISubjectService {
	@Override
	public void insertSubject(Subject subject) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("SubjectSqlMapConfig.xml");

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create subject mapper
			SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);

			subjectMapper.insert(subject);
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
	public void updateSubject(Subject subject) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("SubjectSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create subject mapper
			SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);

			// update subject

			subjectMapper.update(subject);
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
	public void deleteSubjectById(long subjectId) {
 
		// delete subject
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("SubjectSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create subject mapper
			SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);

			// delete subject
			subjectMapper.delete(subjectId);

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
	public List<Subject> selectAllSubject() {

		Reader reader;
		SqlSession session = null;
		try {

			reader = Resources.getResourceAsReader("SubjectSqlMapConfig.xml");

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			session = sqlSessionFactory.openSession();

			// create subject mapper
			SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);

			// show list subject
			List<Subject> listSubjects = subjectMapper.getAll();

			return listSubjects;

		} catch (IOException e) {

			return null;

		} finally {
			// close session
			if (session != null)
				session.close();
		}

	}

	@Override
	public Subject selectSubjectById(long subjectId) {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("SubjectSqlMapConfig.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// create subject mapper
			SubjectMapper subjectMapper = session.getMapper(SubjectMapper.class);

			// get subject by Id

			return subjectMapper.getById(subjectId);

		} catch (IOException e) {
			return null;

		} finally {
			// close session
			if (session != null)
				session.close();
		}
	}
}
