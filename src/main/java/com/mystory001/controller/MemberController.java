package com.mystory001.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mystory001.domain.MemberDTO;
import com.mystory001.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//MemberService 객체생성 → 멤버변수
	//@Inject - MemberService 클래스 찾기 - @Service 애노테이션 자동 찾기 - 자동으로 객체 생성
	//servlet-context에 conponent-scan 추가
	@Inject
	private MemberService memberService;
	
	//@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	@GetMapping("insert") //@RequestMapping("/member/*") 애노테이션 추가로 위의 코드보다 짧고 간결하게 사용할 수 있음
	public String insert() {
		System.out.println("MemberController insert()");
		
		return "/member/insert"; //주소 변경없이 이동
	}

	//@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	@PostMapping("/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		
		//회원가입 처리
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public String login(){
		System.out.println("MemberController login()");
		
		return "member/login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		
		//로그인 처리
		if((memberService.userCheck(memberDTO) !=null)) {
			//session이 없기 때문에 login처리가 안됨
			session.setAttribute("id", memberDTO.getId());
			
			return "redirect:/member/main";
		} 
		return "redirect:/member/login";
	}
	
	@GetMapping("/main")
	public String main(MemberDTO memberDTO) {
		System.out.println("MemberController main()");
		
		return "member/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("MemberController logout");
		
		session.invalidate();
		return "redirect:/member/main";
	}
	
	@GetMapping("/info")
	public String info(Model model, HttpSession session) { //model : 컨트롤러에서 생성한 데이터를 담아서 view로 전달할 때 사용하는 객체. request.setAttribute()와 유사. addAttribute("키",값)메소드를 사용하여 전달할 데이터 세팅
		System.out.println("MemberController info()");
		//id(세션값 가져오기) → MemberService에 MemberDTO memberDTO = getMember(id) 메소드 호출 → model.add("memberDTO",memberDTO)로 데이터 담아서 model.addAttribute("memberDTO",memberDTO);
		String id = (String)session.getAttribute("id");
		MemberDTO memberDTO = memberService.getMember(id);
		model.addAttribute("memberDTO", memberDTO);
		
		//주소 변경 없이 이동
		return "member/info";
	}
	
	@GetMapping("/update")
	public String update(Model model, HttpSession session) {
		System.out.println("MemberController update()");
		String id = (String)session.getAttribute("id");
		MemberDTO memberDTO = memberService.getMember(id);
		model.addAttribute("memberDTO", memberDTO);
		return "member/update";
	}
	
	@PostMapping("/updatePro")
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro");
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			memberService.updateMember(memberDTO);
			return "redirect:/member/main";
		}
		return "redirect:/member/update";
	}
	
	@GetMapping("/delete")
	public String delete() {
		System.out.println("MemberController delete()");
		return "member/delete";
	}
	
	@PostMapping("deletePro")
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			memberService.deleteMember(memberDTO);
			session.invalidate();
			return "/member/main";
		}
		return "/member/login";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		System.out.println("MemberController list()");
		List<MemberDTO> memberList = memberService.getMemberList();
		model.addAttribute("memberList",memberList);
		return "/member/list";
	}
	
}
