package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LoginDTO;
import model.SaveLocationDTO;
import service.SaveLocationService;

/**
 * service가 작동하는지
 * 
 * 0: 등록 실패
 * 1: 등록 성공
 * 2: 등록된 데이터 존재
 * @author anyware
 *
 */

//Controller를 상속또는 implements를 앋고 POJO방식으로 작성

@Controller
public class SaveLocationController {

	@Resource
	private SaveLocationService saveLocationService;
	
	//비회원 관광지 목록 페이지
		@RequestMapping("/spotList.sp")
		public String spotList(){
			System.out.println("spotList");
			return "spotList";
		}	
		
	//회원 관광지 목록 페이지
		@RequestMapping("/spotListMember.sp")
		public String spotListMember(){
			System.out.println("spotListMember");
			return "spotListMember";
		}	
		
	//비회원 관광지 상세 페이지로
		@RequestMapping("/spotInfo.sp")
		public String spotInfo(){
				System.out.println("spotInfo");
				return "spotInfo";
		}
	
	//회원 관광지 상세 페이지
		@RequestMapping("/spot.sp")
		public String spot(){
			System.out.println("spot");
			return "spot";
		}
		
	//관광지 저장 -> 내 장바구니
	@RequestMapping("/saveAction.sp")
	public String saveform(SaveLocationDTO save, Model model, String id) {
		
		System.out.println("saveAction");
		
		//관광지 저장 후 (성공 시 1, 실패 시 0), 장바구니 등록
		int result = saveLocationService.addSave(save);
		model.addAttribute("cartInfo", saveLocationService.getSaveList(id));
		System.out.println("addSave : "+ result);
		
		return "myList?id="+ save.getId();
	}
	
	//로그인 후 내 페이지 -> 내 장바구니
		@RequestMapping("/myList.sp")
		public String add(){
			System.out.println("myList");
			return "myList";
		}
	
	//계획세우기
		@RequestMapping("/makeList.sp")
		public String makeList(){
			System.out.println("makeList");
			return "makeList";
		}
	
	//삭제하기
		@RequestMapping("/delete.sp")
		public String delete(SaveLocationDTO save) {
			
			int result = saveLocationService.deleteSave(save.getCartId());		//save.getId()
			
			//장바구니 페이지로
			String res = "redirect:/myList.sp?id="+ save.getId();
			
			if (result == 0) {
				res = "fail";
			}
			return res;
		}

}



