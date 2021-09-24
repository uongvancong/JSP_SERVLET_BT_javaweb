package service;

import java.util.List;

import model.Subject;

public interface ISubjectService {
	public void insertSubject(Subject subject);

	public void updateSubject(Subject subject);

	public void deleteSubjectById(long subjectId);

	public List<Subject> selectAllSubject();

	public Subject selectSubjectById(long subjectId);
}
