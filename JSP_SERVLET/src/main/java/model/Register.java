package model;

public class Register {
	private Long id;
	private Long idstudent;
	private Long idsubject;
	
	public Register() {
		
	}
	public Register(Long idstudent, Long idsubject) {
		this.idstudent = idstudent;
		this.idsubject = idsubject;
		
	}
	public Register(Long id,Long idstudent, Long idsubject) {
		this.id = id;
		this.idstudent = idstudent;
		this.idsubject = idsubject;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(Long idstudent) {
		this.idstudent = idstudent;
	}
	public Long getIdsubject() {
		return idsubject;
	}
	public void setIdsubject(Long idsubject) {
		this.idsubject = idsubject;
	}
	
	public String toString() {
		return this.id + " " + this.idstudent +  " " + this.idsubject;
		
	}
	
}
