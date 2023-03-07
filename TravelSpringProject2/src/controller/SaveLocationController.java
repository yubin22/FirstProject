package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LoginDTO;
import model.SaveLocationDTO;
import service.SaveLocationService;

/**
 * service가 작동하는지
 * @author anyware
 *
 */

//Controller를 상속또는 implements를 앋고 POJO방식으로 작성

@Controller
public class SaveLocationController {

	@Resource
	private SaveLocationService saveLocationService;
	
	//관광지 상세 페이지
		@RequestMapping("/spot.sp")
		public String spot(){
			System.out.println("spot");
			return "spot";
		}
		
	//관광지 저장
	@RequestMapping("/saveAction.sp")
	public String saveform(SaveLocationDTO save, HttpServletRequest request) {
		
		//로그인 체크
		HttpSession session = request.getSession();
		LoginDTO result = (LoginDTO) session.getAttribute("login");
		if(result == null) {
			return "loginForm"; 	//로그인 정보가 없으면 로그인폼으로 감. 
		}
		
		//관광지 저장 후 (성공 시 1, 실패 시 0)
		int result1 = saveLocationService.addSave(save);
		request.setAttribute("save", result1);
		System.out.println("addSave : "+ result1);
		return "myList";
	}
	
	//내 장바구니
	@RequestMapping("/myList.sp")
	public String add(){
		System.out.println("myList");
		return "myList";
	}

}



