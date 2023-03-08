package com.iSpanProject.GoodByeletter.validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;


public class LastNoteValidator implements Validator {
	
	
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");
	


	@Override
	public boolean supports(Class<?> clazz) {
		
		return LastNote.class.isAssignableFrom(clazz);
		
	}

	@Override	// // Whitespace: space, tab, enter
	public void validate(Object target, Errors errors) {
		
		// 講義參考
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "customerBean.name.empty", "姓名欄位不正確");
//		ValidationUtils.rejectIfEmpty(errors, "password", "customerBean.password.empty");
//		ValidationUtils.rejectIfEmpty(errors, "password1", "customerBean.password1.empty");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "notedetail", "", "內容欄位不正確不可為空");
		
		
//		ValidationUtils.rejectIfEmpty(errors, "gender", "", "gender欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "address", "", "address欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
		LastNote lastNote = (LastNote) target;
		
//		String name = memberDetailByRyu.getName();
//		if (name == null || name.trim().length() == 0) {
//			errors.rejectValue("name", "memberDetailByRyu.name.size");
//		}
		
		
		
		
		
//		if (memberDetailByRyu.getName() != null && memberDetailByRyu.getName().length() < 2 || memberDetailByRyu.getName().length() > 30) {
//			errors.rejectValue("name", "memberDetailByRyu.name.size", "找不到");
//		}
		
//		if (memberDetailByRyu.getGender() != null && memberDetailByRyu.getGender().length() < 2 || memberDetailByRyu.getGender().length() > 30) {
//			errors.rejectValue("gender", "memberDetailByRyu.gender.size");
//		}

//		if (memberDetailByRyu.getGender() != null && memberDetailByRyu.getGender().contains(" ")) {
//			errors.rejectValue("gender", "memberDetailByRyu.gender.space", "找不到");
//		}
		
//		if (memberDetailByRyu.getAddress() != null && memberDetailByRyu.getAddress().contains(" ")) {
//			errors.rejectValue("address", "memberDetailByRyu.address.space", "找不到");
//		}
		
		
		
		
		// 有密碼的話 用下列程式碼
		
//		if (memberDetailByRyu.getPassword() != null && memberDetailByRyu.getPassword().contains(" ")) {
//			errors.rejectValue("password", "customerBean.password.space");
//		}
//		
//
//		if (memberDetailByRyu.getPassword1() != null && memberDetailByRyu.getPassword1().contains(" ")) {
//			errors.rejectValue("password1", "customerBean.password1.space");
//		}
//		
//		if (memberDetailByRyu.memberDetailByRyu() != null && memberDetailByRyu.getPassword1().length() < 5 && memberDetailByRyu.getPassword1().length() > 15) {
//			errors.rejectValue("password1", "customerBean.password1.size");
//		}
//		
//		if (memberDetailByRyu.getPassword1() != null && memberDetailByRyu.getPassword() != null &&
//			!memberDetailByRyu.getPassword1().equals(memberDetailByRyu.getPassword())
//		) {
//			errors.rejectValue("password", "customerBean.password.mustEqual");
//		}
		
		if ( !errors.hasFieldErrors("recipientEmail") && lastNote.getRecipientEmail() != null 
						&& !EMAIL_REGEX.matcher(lastNote.getRecipientEmail()).matches()) {
			errors.rejectValue("recipientEmail", "", "email格式不正確");
		}
		
		if ( !errors.hasFieldErrors("verify1") && lastNote.getVerify1() != null 
				&& !EMAIL_REGEX.matcher(lastNote.getVerify1()).matches()) {
			errors.rejectValue("verify1", "", "email格式不正確");
		}
		
		if ( !errors.hasFieldErrors("verify2") && lastNote.getVerify2() != null 
				&& !EMAIL_REGEX.matcher(lastNote.getVerify2()).matches()) {
			errors.rejectValue("verify2", "", "email格式不正確");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
