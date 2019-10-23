package com.gym.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gym.pojo.ExPojo;

public interface ExMapper extends BaseMapper<ExPojo> {
	@Select("SELECT * FROM ex_warehouse ORDER BY updated DESC LIMIT #{start},#{rows}")
	List<ExPojo> findItemByPage(int start, Integer rows);

}
