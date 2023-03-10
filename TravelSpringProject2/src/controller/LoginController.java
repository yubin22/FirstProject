package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LoginDTO;
import model.SaveLocationDTO;
import service.LoginService;

//Controller를 상속또는 implements를 앋고 POJO방식으로 작성

@Controller
public class LoginController {

	@Resource
	private LoginService loginService;
	
	//login
	@RequestMapping("/loginForm.sp") //실제 존재 안해도 괜찮음. 최초 요청.
	public String writeform(){
		System.out.println("loginForm");
		return "loginForm"; // view/writeform.jsp 찾음.
	}//ModelAndView를 리턴하는것과 같음
	
	//로그인 정보 가져옴
	@RequestMapping("/loginAction.sp")
	public String read(LoginDTO dto, HttpSession session, HttpServletRequest request){ //requset -> session으로 변경

		System.out.println("loginAction");
		
		String req = request.getParameter("id");				//input id
		System.out.println("입력한 아이디 : "+req);
		String req1 = request.getParameter("pwd");				//input pwd
		System.out.println("입력한 비밀번호 : "+req1);
		LoginDTO result = loginService.getLogin(dto);		//읽기
		System.out.println(result);
			
			if(result == null) {
				System.out.println("loginFail");
			}else if ((result.getId().equals(req))&&(result.getPwd().equals(req1))) {		//input과 dto에 있는 값이 같을 경우 = 로그인 성공
				session.setAttribute("login", result);
				return "main"; //로그인 성공 시 메인으로
			}
			return "fail";
	}
	
	//로그아웃
	@RequestMapping("/logoutAction.sp")
	public String logoutAction(LoginDTO dto, HttpSession session){ //requset -> session으로 변경
		
		System.out.println("logout");
		
		session.invalidate(); //세션 정보 삭제
		return "redirect:/loginForm.sp"; 
	}
	
	//main페이지
		@RequestMapping("/main.sp") 
		public String main(){
			System.out.println("main");
			return "main"; // view/writeform.jsp 찾음.
		}//ModelAndView를 리턴하는것과 같음
		
	@RequestMapping("/mainAction.sp")
	public String mainAction(){ //requset -> session으로 변경
	
		System.out.println("mainAction");
		
		return "myPage";		// myPage에서 회원 정보 변경/탈퇴로 감.
	}
	
	//register
	@RequestMapping("/register.sp")
	public String write(){
		System.out.println("register");
		return "register";
	}
	
	@RequestMapping("/registerAction.sp")
	public String register(LoginDTO dto) {
		loginService.insertLogin(dto);
		System.out.println("register = "+ dto);
		return "redirect:/loginForm.sp";
	}
	
	//아이디 중복 체크
	@RequestMapping("/dbCheckId.sp")
	public String dbCheckId(LoginDTO dto, HttpServletRequest request) {
		System.out.println("요청한 아이디 : "+ dto.getId());
		LoginDTO result = loginService.idCheck(dto);
		request.setAttribute("result", result);  		 //${result. -> dto에 있는 결과
		request.setAttribute("param", result);		 //${param.
		return "dbCheckId";
	}
	
	//delete
	@RequestMapping("/deleteForm.sp")
	public String deleteform(){
		return "deleteForm";
	}
	
	@RequestMapping("/deleteAction.sp")
	public String delete(LoginDTO dto, HttpServletRequest request, HttpSession session, SaveLocationDTO save){
		System.out.println("deleteAction");
		
		LoginDTO resu = loginService.getLogin(dto); //글 읽기
		String req = request.getParameter("pwd");				//input pwd
		System.out.println("입력한 비밀번호 : "+req);
		
		int result = 0;
		String res = null;
		
		if((resu.getPwd().equals(req))){
			/*
			 * 저장된 여행지 delete 
			 * 
			 * locationnum은 db에 존재
			 * db(saved_location)에서 locationnum을 꺼내고
			 * logindto에 set
			 * deleteMyList
			 */
			/*int num = ((SaveLocationDTO) session.getAttribute("save")).getLocationNum();
			dto.setLocationNum(num);
			System.out.println("deleteMyList 전 :: "+ dto);
			result = loginService.deleteMyList(dto);
			System.out.println("deleteMyList 후 :: "+ dto);*/
			
			//회원 정보 delete
			result = loginService.deleteLogin(dto);
			res = "redirect:/deleteAfter.sp";
		}else if (result == 0) {
			res = "fail";

			return res;
		}
		return res;
	}
	
	//탈퇴 완료 메시지 보여줌
	@RequestMapping("/deleteAfter.sp") 
	public String deleteAfter(){
		System.out.println("deleteAfter");
		return "deleteAfter"; 
	}
	
	//update
	@RequestMapping("/update.sp")
	public String update(){
		return "update";
	}
	
	@RequestMapping("/updateForm.sp")
	public String updateform(LoginDTO dto, HttpSession session, HttpServletRequest request){
		LoginDTO result = loginService.getLogin(dto); //글 읽기
		String req = request.getParameter("pwd");				//input pwd
		System.out.println("입력한 비밀번호 : "+req);
		
		if((result.getPwd().equals(req))) {

			System.out.println(result);
			request.setAttribute("login", result);  //모델앤 뷰중에서 모델~
			return "updateForm";
			
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/updateAction.sp")
	public String updateAct(LoginDTO dto,HttpSession session, HttpServletRequest request){
		
//		String req = request.getParameter("id");				//input id
//		System.out.println("입력한 아이디 : "+req);
//		LoginDTO result1 = loginService.getLogin(dto);		//읽기
//		session.setAttribute("login", result1);
		
		int result = loginService.updateLogin(dto);
		System.out.println(result);
		
		String res = "redirect:/mainAction.sp";
		if (result == 0) {
			res = "fail";
		}
		return res;
	}
	
}



