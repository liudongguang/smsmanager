package com.peony.api.service;

import com.peony.api.po.Msglog;

public interface SmsSendManagerService {

	int getDayCountByPhone(String phone);

	int getCountByPhoneAndTime(String phone);

	int saveSendLog(Msglog log);

}
