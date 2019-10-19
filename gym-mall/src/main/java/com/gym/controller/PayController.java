package com.gym.controller;
//package com.gy.pj.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.gym.dao.PayDao;
//import com.gym.entity.Pay;
//import com.gym.util.PayJson;
//
//@Controller 
//@RequestMapping("pay")
//public class PayController {
//	@Autowired
//	private PayDao payDao;
//
//	@RequestMapping("TLS")
//	public String TLS(String out_trade_no) throws Exception {
//			Pay p = new Pay();
//			p = PayJson.cx(out_trade_no);
//			System.out.println(p);
//			//1.0读数据库查询订单信息(根据Pay对象中的订单号查询)
//			//1.1核实订单信息的真实性
//			//			if() {
//			//				
//			//			}
//			//2.0基于订单信息和Pay对象的数据做比对
//			//2.1核实后将订单的code状态码改为已支付(不做处理即视为----未支付订单)
//			Long status = p.getStatus();
//			if(status==1) {
//				//payServiceImpl.updatePay("已支付",out_trade_no);
//				payDao.updatePay("1", out_trade_no);
//			}
//			
//		return "pay/TLS";
//	}
//
//}
