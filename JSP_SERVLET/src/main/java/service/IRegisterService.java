package service;

import java.util.List;

import model.Register;

public interface IRegisterService {
	public void insertRegister(Register register);

	public void updateRegister(Register register);

	public void deleteRegisterById(long registerId);

	public void deleteRegisterByIdStudent(long IdStudent);

	public void deleteRegisterByIdSubject(long IdSubject);
	
	public List<Register> selectAllRegister();
	
	public List<Register> selectRegisterByStudentId(long studentId);
	

	public Register selectRegisterById(long registerId);
}
