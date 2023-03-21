//package com.iSpanProject.GoodByeletter.controller.Lillian;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.iSpanProject.GoodByeletter.service.Lillian.RecaptchaService;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private RecaptchaService recaptchaService;
//
//    @PostMapping("/submit")
//    public String submitForm(@RequestParam("g-recaptcha-response") String response, @RequestParam("ip") String ip) {
//        if (recaptchaService.verifyRecaptcha(ip, response)) {
//            return "Form submitted successfully.";
//        } else {
//            return "Failed to submit form.
