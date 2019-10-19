package com.gy.util;

import java.io.IOException;

import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gy.pj.sys.entity.Pay;

public class PayJson {
	/**
	 * 
	 * @param dd 订单号,传入订单号进行查询 反序列化到POJO对象
	 * @return 返回POJO Pay对象
	 * @throws IOException 可能会报IO流异常,其原因跨域访问网页出错
	 */
	public static Pay cx(String dd) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper(); //	2019092210340664
		String str = "http://pay.ww1994.com/api.php?act=order&pid=10016&key=7NZVgn98tGR9VgDbc9Hc93Ddn8vVc96Z&out_trade_no="+dd;
		str = Jsoup.connect(str)
				.execute()
				.body();
		System.out.println(str);

		// 将Json字符串反序列化为Java对象
		Pay pay = objectMapper.readValue(str, Pay.class);  
		System.out.println(pay);
		return pay;
	}

}
