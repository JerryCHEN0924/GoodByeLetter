package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.LevelDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

@Service
@Transactional
public class YJCustomerDetailService {

	@Autowired
	private RegisterDao cusDao;
	@Autowired
	private YJCustomerDetailDao cdDao;
	@Autowired
	private LevelDao levDao;
	
	public void insert(YJCustomerDetail detail) {
		Optional<Level> optional = levDao.findById(2);
		Level lev1 = optional.get();
		detail.setPlevel(lev1);
		
		cdDao.save(detail);	
	}
	//更新Detail
	public void updateDetail(Integer memberId, YJCustomerDetail detail) {							
		
		cdDao.save(detail);
		
	}
	//依據memberId找detail
	public YJCustomerDetail findById(Integer memberId) {
			
		Optional<YJCustomerDetail> op = cdDao.findById(memberId);
		
		if(op.isEmpty()) { 
			return null;
		}
		return op.get();		
	}
	
	public YJCustomerDetail findByMemberId(Integer memberId) {
		YJCustomerDetail detail = cdDao.findDetailByMemberId(memberId);
		return detail;
	}
//	public YJCustomerDetail findDetailIdByAcc(String acc) {
//		Register acc1 = cusDao.findRegisterByAcc(acc);
//		YJCustomerDetail detail = cusDao.findRegisterByAcc(acc);
//		return
//		
//	}
}
