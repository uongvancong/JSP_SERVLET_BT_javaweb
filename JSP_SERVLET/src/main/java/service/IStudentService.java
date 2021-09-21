package service;

import java.util.List;

import model.Student;

public interface IStudentService {
	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudentById(long studentId);

	public List<Student> selectAllStudent();

	public Student selectStudentById(long studentId);
}
