package com.iSpanProject.GoodByeletter.service.YiJie;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

@Service
@Transactional
public class PictureService {

	@Autowired
	private YJCustomerDetailDao dDao;
	
	
	
}
