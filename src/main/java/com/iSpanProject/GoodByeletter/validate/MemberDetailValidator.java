package com.iSpanProject.GoodByeletter.validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;


public class MemberDetailValidator implements Validator {
	
	
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");
	


	@Override
	public boolean supports(Class<?> clazz) {
		
		return MemberDetail.class.isAssignableFrom(clazz);
		
	}

	@Override	// // Whitespace: space, tab, enter
	public void validate(Object target, Errors errors) {
		
		// 講義參考
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "customerBean.name.empty", "姓名欄位不正確");
//		ValidationUtils.rejectIfEmpty(errors, "password", "customerBean.password.empty");
//		ValidationUtils.rejectIfEmpty(errors, "password1", "customerBean.password1.empty");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "", "帳號欄位不正確");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "姓名欄位不正確");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "性別欄位不正確");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "County", "", "County欄位不正確");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "地址欄位不正確");
		
		
//		ValidationUtils.rejectIfEmpty(errors, "gender", "", "gender欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "address", "", "address欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
		MemberDetail memberDetail = (MemberDetail) target;
		
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
		
		if ( !errors.hasFieldErrors("Email") && memberDetail.getEmail() != null 
						&& !EMAIL_REGEX.matcher(memberDetail.getEmail()).matches()) {
			errors.rejectValue("Email", "", "email格式不正確");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
