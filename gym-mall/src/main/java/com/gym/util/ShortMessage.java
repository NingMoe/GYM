package com.gym.util;
import java.io.IOException;

import javax.xml.ws.http.HTTPException;
import org.json.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import lombok.Data;

@Data
public class ShortMessage {
	// 短信应用 SDK AppID
	private int appid = 1400252981; // SDK AppID 以1400开头
	// 短信应用 SDK AppKey
	private String appkey = "28a198bfc374bc6352c1d3c6bec6ecce";
	// 需要发送短信的手机号码
	private String[] phoneNumbers = {"15399791780","15399791780"};//数组
	// 短信模板 ID，需要在短信应用中申请
	private int templateId = 1998; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
	// 签名
	private String smsSign = "2b3k天蓝色"; 
	/* NOTE: 签名参数使用的是`签名内容`
	而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请*/
	public void dx(String yzm) throws Exception {
		String msg = yzm+"为您的登录验证码，请于尽快内填写。如非本人操作，请忽略本短信。";
		try {
			//遍历发送phoneNumbers数组里的手机号
			for (int i = 0; i < phoneNumbers.length; i++) {
				SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
				SmsSingleSenderResult result = ssender.send
						(0, "86", phoneNumbers[0], msg, "", "");
				System.out.println(result);
			}

		} catch (HTTPException e) {
			// HTTP响应码错误
			e.printStackTrace();
		} catch (JSONException e) {
			// json解析错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络IO错误
			e.printStackTrace();
		}
	}
}
