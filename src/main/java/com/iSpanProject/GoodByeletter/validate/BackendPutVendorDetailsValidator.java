package com.iSpanProject.GoodByeletter.validate;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;

@Component
public class BackendPutVendorDetailsValidator implements Validator {
	
	
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");
	


	@Override
	public boolean supports(Class<?> clazz) {
		
		return VendorDetails.class.isAssignableFrom(clazz);
		
	}

	@Override	// // Whitespace: space, tab, enter
	public void validate(Object target, Errors errors) {
		
		
		
		VendorDetails vendorDetails = (VendorDetails) target;
		
		
		
		// 講義參考
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "customerBean.name.empty", "姓名欄位不正確");
//		ValidationUtils.rejectIfEmpty(errors, "password", "customerBean.password.empty");
//		ValidationUtils.rejectIfEmpty(errors, "password1", "customerBean.password1.empty");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "", "帳號欄不能空白");
		
//		if (! errors.hasFieldErrors("account") && vendorDetails.getAccount().length() < 2) {
//			errors.rejectValue("account","", "帳號欄不能小於兩個字元(預設值)");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "", "廠商名欄位不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyType", "", "廠商類別欄位不正確");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "地址欄位不正確");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fileName", "", "帳號欄位不正確");
		
		
//		if (member.getCategory().getId() == -1) {
//			errors.rejectValue("category","member.category.length.error", "必須挑選分類欄的選項(預設值)");
//		}
//		if (member.getHobby().getId() == -1) {
//			errors.rejectValue("hobby","member.hobby.length.error", "必須挑選嗜好欄的選項(預設值)");
//		}
		
		
//		ValidationUtils.rejectIfEmpty(errors, "gender", "", "gender欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "address", "", "address欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "email", "", "email欄不能空白");
		
		
		
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
		
		if ( !errors.hasFieldErrors("email") && vendorDetails.getEmail() != null 
						&& !EMAIL_REGEX.matcher(vendorDetails.getEmail()).matches()) {
			errors.rejectValue("email", "", "email格式不正確");
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
