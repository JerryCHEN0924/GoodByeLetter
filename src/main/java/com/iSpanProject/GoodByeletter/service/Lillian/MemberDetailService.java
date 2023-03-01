package com.iSpanProject.GoodByeletter.service.Lillian;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.LevelDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.MemberDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

@Service
@Transactional
public class MemberDetailService {
	
	@Autowired
	private MemberDetailDao mDao;
	
	@Autowired
	private LevelDao lDao;
	
	public void insert(MemberDetail memberDetail) {
	
		Optional<Level> optional = lDao.findById(1);
		Level l1 = optional.get();
		memberDetail.setFK_Plevel(l1);
		
		mDao.save(memberDetail);

}

	
}
