package com.peony.impl.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peony.api.po.Msglog;
import com.peony.api.service.SmsSendManagerService;
import com.peony.api.util.DateUtils;
import com.peony.api.vo.search.SearchMsg;
import com.peony.impl.mapper.MsglogMapper;

@Service
public class SmsSendManagerServiceImpl implements SmsSendManagerService {
	@Autowired
	private MsglogMapper msglogMapper;

	@Override
	public int getDayCountByPhone(String phone) {
		Date now = new Date();
		Date start = DateUtils.dayStart(now);
		Date end = DateUtils.dayEnd(now);
		SearchMsg search = new SearchMsg(phone, start, end);
		int count = msglogMapper.getCountByCondition(search);
		return count;
	}

	@Override
	public int getCountByPhoneAndTime(String phone) {
		Date now = new Date();
		Date start = DateUtils.hourStart(now);
		Date end = DateUtils.hourEnd(now);
		SearchMsg search = new SearchMsg(phone, start, end);
		int count = msglogMapper.getCountByCondition(search);
		return count;
	}

	@Override
	public int saveSendLog(Msglog log) {
		return msglogMapper.insertSelective(log);
	}

}
