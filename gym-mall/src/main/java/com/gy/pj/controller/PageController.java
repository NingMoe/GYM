package com.gy.pj.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy.pj.sys.dao.PayDao;
import com.gy.pj.sys.entity.Pay;
import com.gy.pj.sys.serviceImpl.SysClassServiceImpl;
import com.gy.util.PayJson;
import com.gy.util.ShortMessage;

@Controller
@RequestMapping("/")
public class PageController {
	@Resource
	private SysClassServiceImpl service;
	
	
	@RequestMapping({"doIndexUI",""})
	public String doIndexUI() {
		return "HomePage";
	}
	
	
	@RequestMapping("{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {	
		return moduleUI;
	}
	
	@Autowired
	private PayDao payDao;

	@RequestMapping("pay/TLS")
	@ResponseBody()
	public String TLS(String out_trade_no,String type) throws Exception {
			Pay p = new Pay();
			System.out.println(out_trade_no);
			if (out_trade_no!=null) 			
			p = PayJson.cx(out_trade_no);
			System.out.println(p);
			//1.0读数据库查询订单信息(根据Pay对象中的订单号查询)
			//1.1核实订单信息的真实性
			//2.0基于订单信息和Pay对象的数据做比对
			//2.1核实后将订单的code状态码改为已支付(不做处理即视为----未支付订单)
			Long status = p.getStatus();
			if(status==1) {
				//payServiceImpl.updatePay("已支付",out_trade_no);
				payDao.updatePay("1", out_trade_no,type);
				//短信接口
				ShortMessage a =  new ShortMessage();
				a.dx("我先写死字符串");
			}
			
		return "Pay/TLS";
	}
	
	
}
