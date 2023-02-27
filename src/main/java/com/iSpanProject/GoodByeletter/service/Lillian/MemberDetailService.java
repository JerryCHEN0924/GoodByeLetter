package com.iSpanProject.GoodByeletter.service.Lillian;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Lillian.MemberDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

@Service
@Transactional
public class MemberDetailService {
	
	@Autowired
	private MemberDetailDao mDao;
	
	public void insert(MemberDetail memberDetail) {
		mDao.save(memberDetail);
	}
}
