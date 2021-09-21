package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.*;

public interface StudentMapper {
	// get all student
    final String GET_ALL_STUDENT = "SELECT * FROM student";
 
    @Select(GET_ALL_STUDENT)
    @Results(value = { 
    		@Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "address", column = "address")
            
             
    })
    public List<Student> getAll();
 
    // get student by id
    final String GET_STUDENT_BY_ID = "SELECT * FROM student WHERE ID = #{id}";
 
    @Select(GET_STUDENT_BY_ID)
    public Student getById(long studentId);
 
    // inert student
    final String INSERT_STUDENT = "INSERT INTO student (name, age, address) "
            + "VALUES (#{name},#{age},#{address}  )";
 
    @Update(INSERT_STUDENT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Student student);
 
    // update student
    final String UPDATE_STUDENT= "UPDATE student SET  NAME = #{name}, age = #{age}, address=#{address}  WHERE ID = #{id}";
 
    @Insert(UPDATE_STUDENT)
    public void update(Student student);
 
    // delete student by id
    final String DELETE_STUDENT_BY_ID = "DELETE from student WHERE ID = #{id}";
 
    @Delete(DELETE_STUDENT_BY_ID)
    public void delete(long id);
}
