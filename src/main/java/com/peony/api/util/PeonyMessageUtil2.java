package com.peony.api.util;


import com.peony.api.vo.MsgResult2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PeonyMessageUtil2 {
	private static Properties peonyProperties = new Properties();
	private static Properties hospitalInterfaceProperties = new Properties();
	private static String sign;
	private static String sendServer;

	/*deng added*/
	private static String action ;
	private static String userid ;
	private static String account;
	private static String password;
	/*deng*/




	static {
		ClassPathResource hospitalInterface = new ClassPathResource("hisinterface.properties");
		try {
			hospitalInterfaceProperties.load(hospitalInterface.getInputStream());
			//StringBuilder mstr=new StringBuilder(hospitalInterfaceProperties.getProperty("msg.userName"));
			//mstr.append(hospitalInterfaceProperties.getProperty("msg.password"));
			//sign=MD5Util.string2MD5(mstr.toString());
			///
			sendServer=hospitalInterfaceProperties.getProperty("msg.sendServer");
			action=hospitalInterfaceProperties.getProperty("msg.action");
			userid=hospitalInterfaceProperties.getProperty("msg.userid");
			account=hospitalInterfaceProperties.getProperty("msg.account");
			password=hospitalInterfaceProperties.getProperty("msg.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static MsgResult2 sendMessage(String phoneNum, String content){
		if(StringUtils.isBlank(phoneNum)){
			MsgResult2 msgObj=new MsgResult2();
			msgObj.setCode(500);
			msgObj.setMessage("无手机号！");
			return msgObj;
		}
		HttpClientUtil htc=HttpClientUtil.getInstance();
		Map<String,String> param=new HashMap<>();
		//param.put("sign",sign);
		//param.put("phone",phoneNum);
		param.put("content",content);

		/*deng added*/
		param.put("action",action);
		param.put("userid",userid);
		param.put("account",account);
		param.put("password",password);
		param.put("mobile",phoneNum);
		/*deng*/
		String rsMsg=htc.sendHttpPost(sendServer,param);
		//String rsMsg="{\"returnstatus\":\"Success\",\"message\":\"操作成功\",\"remainpoint\":\"5\",\"taskID\":\"1712143956374926\",\"successCounts\":\"1\"}";
		//System.out.println(rsMsg);
		MsgResult2 msgObj=JsonUtil.getObjectByJSON(rsMsg,MsgResult2.class);
		return msgObj;
	}
	public static void main(String[] args) {
		MsgResult2 msgResult = PeonyMessageUtil2.sendMessage("17615827028","您好，请回复数字评价本次住院情况：1、满意  2、不满意。可在数字后附上说明或致电88197777。祝您早日康复。【山大二院】");
		System.out.println(msgResult);
//		System.out.println("******************************************");
//
//		if(msgResult.getErrmsg()==null){
//			//通信成功的情况下
//
//			if(msgResult != null&&msgResult.getReturnstatus() == null){
//				System.out.println("no status");
//			}else if(msgResult==null){
//				System.out.println("msgResult=NULL");
//			}else if(msgResult!=null&&msgResult.getReturnstatus().equals("Faild")){
//				System.out.println("Faild");
//			}else if(msgResult!=null&&msgResult.getReturnstatus().equals("Success")){
//				System.out.println(msgResult.getSuccessCounts());
//			}
//		}else{
//			System.out.println("msgResult.getErrmsg()");
//		}



	}
}
