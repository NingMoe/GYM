package com.gy.pj.sys.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.gy.pj.sys.entity.SysStudent;

@Mapper
public interface SysStudentDao {
	List<SysStudent> findPageObjects(
			@Param("name") String name, 
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	int getRowCount(@Param("name") String name);
	int deleteObjects(@Param("ids")Integer... ids);
	int insertObject(SysStudent entity);
	int updateObject(SysStudent entity);
}
