package com.peony.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.peony.api.util.PeonyMessageUtil2;
import com.peony.api.vo.MsgResult2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peony.api.constant.SmsConstant;
import com.peony.api.po.Msglog;
import com.peony.api.service.SmsSendManagerService;
import com.peony.api.util.HttpClientUtil;
import com.peony.api.util.JsonUtil;
import com.peony.api.util.PropertiesUtil;
import com.peony.api.vo.MsgRS;
import com.peony.api.vo.ResultMsg;
import com.peony.api.vo.SendMsg;

@Controller
@RequestMapping("/smsmanager")
public class SmsSendCountroller {
    @Autowired
    private SmsSendManagerService smsSendManagerService;

    private ResultMsg issend(String phone, ResultMsg rt ) {
        int dayCount = smsSendManagerService.getDayCountByPhone(phone);
        if (dayCount >= 2) {
            rt.setErrorCode(1);
            rt.setErrorMsg("一天只能发送2条");
            return rt;
        } else {
            int count = smsSendManagerService.getCountByPhoneAndTime(phone);
            if (count >= 2) {
                rt.setErrorCode(1);
                rt.setErrorMsg("一小时内发送2条");
                return rt;
            }
        }
        return rt;
    }

    /**
     * 短信发送
     *
     * @param request
     * @return
     */
    @RequestMapping("/send")
    public @ResponseBody
    ResultMsg send(HttpServletRequest request, SendMsg smsg) {
        ResultMsg rt = new ResultMsg();
        String phone = smsg.getPhone();
        String content = smsg.getSendContent();
        ///////// 检查是否能够发送，一小时内3条 一天5条
        if (issend(phone,rt).getErrorCode() != 1) {
            HttpClientUtil httpClient = HttpClientUtil.getInstance();
            Map<String, String> params = new HashMap<>();
            params.put("sign", PropertiesUtil.getSmsPropertiesVal(SmsConstant.SIGN));
            params.put("phone", phone);
            params.put("content", content);
            String rsStr = httpClient.sendHttpPost(PropertiesUtil.getSmsPropertiesVal(SmsConstant.SENDURL), params);
            MsgRS msg = JsonUtil.getObjectByJSON(rsStr, MsgRS.class);
            if (msg.isError()) {
                rt.setErrorCode(1);
                rt.setErrorMsg(msg.getMessage());
            } else {
                Msglog log = new Msglog();
                log.setPhone(phone);
                log.setCreatetime(new Date());
                smsSendManagerService.saveSendLog(log);
            }
        }
        return rt;
    }

    @RequestMapping("/send2")
    public @ResponseBody
    ResultMsg send2(HttpServletRequest request, SendMsg smsg) {
        ResultMsg rt = new ResultMsg();
        String phone = smsg.getPhone();
        String content = smsg.getSendContent();
        ///////// 检查是否能够发送，一小时内3条 一天5条
        if (issend(phone,rt).getErrorCode() != 1) {
            if(!content.endsWith("【山大二院】")){
                content=content+"【山大二院】";
            }
            MsgResult2 msgResult2 = PeonyMessageUtil2.sendMessage(phone, content);
            if(msgResult2.getCode()==500||!"Success".equals(msgResult2.getReturnstatus())){
               rt.setErrorCode(1);
               rt.setErrorMsg(msgResult2.getMessage());
            }else{
                Msglog log = new Msglog();
                log.setPhone(phone);
                log.setCreatetime(new Date());
                smsSendManagerService.saveSendLog(log);
            }
        }
        return rt;
    }
}
