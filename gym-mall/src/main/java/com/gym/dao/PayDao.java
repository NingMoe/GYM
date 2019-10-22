package com.gym.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PayDao {
	
	@Update("update gym_orders set pay_time=now(),pay_state=#{Pay_state},pay_type=#{type} where order_id=#{out_trade_no}")
	int updatePay(String Pay_state,String out_trade_no,String type);
}
