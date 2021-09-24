package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Register;

public interface RegisterMapper {
	// get all register
	final String GET_ALL_REGISTER = "SELECT * FROM register";

	@Select(GET_ALL_REGISTER)
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "idstudent", column = "idstudent"),
			@Result(property = "idsubject", column = "idsubject")

	})
	public List<Register> getAll();

	// get register by id
	final String GET_REGISTER_BY_ID = "SELECT * FROM register WHERE ID = #{id}";

	@Select(GET_REGISTER_BY_ID)
	public Register getById(long registerId);
	
	// get register by idstudent
	final String GET_REGISTER_BY_IDSTUDENT = "SELECT * FROM register WHERE idstudent = #{idstudent}";

	@Select(GET_REGISTER_BY_IDSTUDENT)
	public List<Register> getByIdStudent(long studentId);
	
		

	// inert register
	final String INSERT_REGISTER = "INSERT INTO register ( idstudent, idsubject) "
			+ "VALUES (#{idstudent},#{idsubject}  )";

	@Update(INSERT_REGISTER)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(Register register);

	// update register
	final String UPDATE_REGISTER = "UPDATE register SET    idstudent = #{idstudent}, idsubject=#{idsubject}  WHERE ID = #{id}";

	@Insert(UPDATE_REGISTER)
	public void update(Register register);

	// delete register by id
	final String DELETE_REGISTER_BY_ID = "DELETE from register WHERE ID = #{id}";

	@Delete(DELETE_REGISTER_BY_ID)
	public void delete(long id);

	// delete register by idstudent
	final String DELETE_REGISTER_BY_ID_STUDENT = "DELETE from REGISTER WHERE idstudent = #{idstudent}";

	@Delete(DELETE_REGISTER_BY_ID_STUDENT)
	public void deleteByIdStudent(long idStudent);

	// delete register by idstudent
	final String DELETE_REGISTER_BY_ID_SUBJECT = "DELETE from REGISTER WHERE idsubject = #{idsubject}";

	@Delete(DELETE_REGISTER_BY_ID_SUBJECT)
	public void deleteByIdSubject(long idSubject);
}
