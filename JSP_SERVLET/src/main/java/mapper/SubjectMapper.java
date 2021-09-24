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

public interface SubjectMapper {
	// get all subject
    final String GET_ALL_SUBJECT = "SELECT * FROM subject";
 
    @Select(GET_ALL_SUBJECT)
    @Results(value = { 
    		@Result(property = "id", column = "id"),
            @Result(property = "name", column = "name") 
            
             
    })
    public List<Subject> getAll();
 
    // get subject by id
    final String GET_SUBJECT_BY_ID = "SELECT * FROM subject WHERE ID = #{id}";
 
    @Select(GET_SUBJECT_BY_ID)
    public Subject getById(long subjectId);
 
    // inert subject
    final String INSERT_SUBJECT = "INSERT INTO subject (name ) "
            + "VALUES (#{name}  )";
 
    @Update(INSERT_SUBJECT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Subject subject);
 
    // update subject
    final String UPDATE_SUBJECT= "UPDATE subject SET  NAME = #{name}   WHERE ID = #{id}";
 
    @Insert(UPDATE_SUBJECT)
    public void update(Subject subject);
 
    // delete subject by id
    final String DELETE_SUBJECT_BY_ID = "DELETE from subject WHERE ID = #{id}";
 
    @Delete(DELETE_SUBJECT_BY_ID)
    public void delete(long id);
}
