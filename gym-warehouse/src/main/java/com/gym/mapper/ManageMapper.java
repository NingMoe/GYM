package com.gym.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gym.pojo.itemState;

public interface ManageMapper extends BaseMapper<itemState>{

	int getRowCount(@Param("name")String name);

}
