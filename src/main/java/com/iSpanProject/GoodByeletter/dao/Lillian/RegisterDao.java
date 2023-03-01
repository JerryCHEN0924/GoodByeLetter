package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;




public interface RegisterDao extends JpaRepository<Register, Integer>{

<<<<<<< HEAD
		
	@Query("from Register where account = :acc and passwod = :pwd")
	public Register findRegisterByAccAndPwd(@Param(value="acc")String account,@Param(value="pwd")String password);
	
=======
>>>>>>> cfe05aa490c9edba01a31550bb2e785b03eb97a0
}
