package com.cognizant.memberportal.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.memberportal.DTO.ClaimStatusDTO;
import com.cognizant.memberportal.DTO.JwtResponse;
import com.cognizant.memberportal.DTO.UserLoginCredential;
import com.cognizant.memberportal.DTO.UserToken;
import com.cognizant.memberportal.model.MemberClaim;
import com.cognizant.memberportal.model.MemberPremium;
import com.cognizant.memberportal.model.MemberSubmitclaim;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class LoginController {

	@Autowired
	private RestTemplate restTemp;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Boolean check(String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token);
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		@SuppressWarnings("unused")
		ResponseEntity<JwtResponse> response1 = restTemp.exchange("http://localhost:8089/validate", HttpMethod.GET,
				httpEntity, JwtResponse.class);
		JwtResponse j = response1.getBody();
		return j.isValid();
	}
	
	String token;

	@PostMapping(value = "/auth")
	public ModelAndView goToAuth(HttpServletRequest request) {
		UserLoginCredential userLoginCredential = new UserLoginCredential();
		userLoginCredential.setUserid(request.getParameter("userid"));
		userLoginCredential.setPassword(request.getParameter("password"));
		ModelAndView mv = new ModelAndView();
		try {
		// String token;
		String token1 = restTemp.postForObject("http://localhost:8089/login", userLoginCredential, String.class);
		token = "Bearer" + " " + token1;
		// response.addHeader("token", token);
		System.out.println(token);
		
		
		if (check(token)) {
			System.out.println(token);
			mv.setViewName("home");	
			return mv;
		}
		}
		catch(Exception e){
			//ModelAndView mv = new ModelAndView();
			mv.addObject("message", "Invalid Credentials!!!!!");
			mv.setViewName("login");
			return mv;
		
		
		}
		
		return mv;
	}

	
	@GetMapping("/login")
	public ModelAndView showloginPage(){
		ModelAndView model=new ModelAndView("login");
		return model;
	}
	
	
	@GetMapping("/claimstatus")
	public ModelAndView getclaim(HttpServletRequest request){
		ModelAndView model=new ModelAndView();
		ClaimStatusDTO claim;
		System.out.println(request.getParameter("claimid"));
		System.out.println(request.getParameter("memberid"));
		System.out.println(request.getParameter("policyid"));
			try {
				claim= restTemp.getForObject("http://localhost:8020/member/getClaimStatus/"+request.getParameter("claimid")+"/"+request.getParameter("policyid")+"/"+request.getParameter("memberid"),ClaimStatusDTO.class);	
				System.out.println(claim.getClaimStatus());
				}
			catch(Exception e){
				model.addObject("Message", "Member or Policy or Claim not found"); 
			    model.setViewName("getclaimstatus");
			    return model;
			}
			model.addObject("ClaimStatusDTO",claim);
			model.setViewName("claimstatus");
			return model;
	}
	
	@GetMapping("/submitclaim")
	public ModelAndView showsubmitclaimPage(){
		ModelAndView model=new ModelAndView();
		try {
		if (check(token)) {
		model.setViewName("submitclaim");
		return model;
		}
		}
		catch(Exception e){
			//ModelAndView mv = new ModelAndView();
			model.addObject("tokenexpired", "Your Token is Expired!");
			model.setViewName("login");
			return model;
		
		
		}
		return model;
	}
	
	@PostMapping("/viewsubmittedclaim")
	public ModelAndView getstatus(HttpServletRequest request){
		
		//ClaimStatusDTO claim;
		int claimid =Integer.parseInt(request.getParameter("claimid"));
		int policyid =Integer.parseInt(request.getParameter("policyid"));
		int memid = Integer.parseInt(request.getParameter("memberid"));
		int providerid =Integer.parseInt(request.getParameter("providerid"));
		int benefitid = Integer.parseInt(request.getParameter("benefitid"));
		double claimamnt =Double.parseDouble(request.getParameter("claimamount"));
		double billamnt = Double.parseDouble(request.getParameter("billedamount"));
		String claimstatus = request.getParameter("claimstatus");
		String desc = request.getParameter("desc");
		
		MemberClaim submitclaim = new MemberClaim();
		submitclaim.setClaimId(claimid);
		
		submitclaim.setMemberId(memid);
		submitclaim.setBenefitId(benefitid);
		submitclaim.setPolicyId(policyid);
		submitclaim.setProviderId(providerid);
		submitclaim.setAmountClaimed(claimamnt);
		submitclaim.setAmountSettled(billamnt);
		submitclaim.setClaimStatus(claimstatus);
		submitclaim.setDescription(desc);
		
		System.out.println(submitclaim);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<MemberClaim> req = new HttpEntity<MemberClaim>(submitclaim,headers);
		ResponseEntity<MemberClaim> cc = restTemp.exchange("http://localhost:8020/member/submitClaim/", HttpMethod.POST,req,MemberClaim.class);
		System.out.println(cc);
		ModelAndView model=new ModelAndView();
		model.addObject("status", cc.getBody().getClaimStatus());	
		model.setViewName("viewsubmittedclaim");
		return model;
		
		

	}
	
	@GetMapping("/home")
	public ModelAndView showhomePage(){
		ModelAndView model=new ModelAndView();
		try {
		if (check(token)) {
		model.setViewName("home");
		return model;
		}
		}
		catch(Exception e){
			//ModelAndView mv = new ModelAndView();
			model.addObject("tokenexpired", "Your Token is Expired!");
			model.setViewName("login");
			return model;
		
		
		}
		return model;
	}
	
	@GetMapping("/getviewbills")
	public ModelAndView showgetviewbillsPage(){
		ModelAndView model=new ModelAndView();
		try {
		if (check(token)) {
		model.setViewName("getviewbills");
		return model;
		}
		}
		catch(Exception e){
			//ModelAndView mv = new ModelAndView();
			model.addObject("tokenexpired", "Your Token is Expired!");
			model.setViewName("login");
			return model;
		
		
		}
		return model;
	}
	@GetMapping("/getclaimstatus")
	public ModelAndView showgetclaimstatusPage(){
		ModelAndView model=new ModelAndView();
		try {
		if (check(token)) {
		model.setViewName("getclaimstatus");
		return model;
		}
		}
		catch(Exception e){
			//ModelAndView mv = new ModelAndView();
			model.addObject("tokenexpired", "Your Token is Expired!");
			model.setViewName("login");
			return model;
		
		
		}
		return model;
	}
	
	
	@GetMapping("/viewbills")
	public ModelAndView getBill(HttpServletRequest request) {
		ModelAndView model=new ModelAndView();
		MemberPremium premium;
		System.out.println(request.getParameter("memberid"));
		System.out.println(request.getParameter("policyid"));
			try {
				premium= restTemp.getForObject("http://localhost:8020/member/viewBills/"+request.getParameter("memberId")+"/"+request.getParameter("policyId"),MemberPremium.class);	
				System.out.println(premium.getMemberId());
				}
			catch(Exception e){
				model.addObject("Message", "Member or Policy not found"); 
			    model.setViewName("getviewbills");
			    return model;
			}
			model.addObject("MemberPremium",premium);
			model.setViewName("viewbills");
			return model;
	}
	@RequestMapping("/login-retry")
	public String loginRetry(Model model) {
		model.addAttribute("message", "Invalid Credentials");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String MemberPortal(HttpServletRequest request) {
		ResponseEntity<UserToken> response = null;	
			System.out.println("Inside token gen");
			response = restTemp.getForEntity("http://localhost:8084/login/"+request.getParameter("userid")+"/"+request.getParameter("password"), UserToken.class);
			System.out.println("got token");
			UserToken userToken = (UserToken) response.getBody();	
		    return "home";
		    }
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	
}


