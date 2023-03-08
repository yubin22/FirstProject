package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	private SaveLocationService service;
	
	//비회원 관광지 목록 페이지
		@RequestMapping("/spotList.sp")
		public String spotList(HttpSession session, HttpServletRequest request){
			LoginDTO dto = (LoginDTO) session.getAttribute("login");
			Map<String, SaveLocationDTO> result = service.getSaveList(dto);
			Collection<SaveLocationDTO> list = (Collection<SaveLocationDTO>) result.values();
			request.setAttribute("map", list);
			System.out.println("spotList::"+((HashMap<String, SaveLocationDTO>) result).values());
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
	public String saveform(SaveLocationDTO save, Model model,LoginDTO login) {
		
		System.out.println("saveAction::" + save);
		/*
		 * 1. dto.id, dto.locationNum -> is Valid
		 * 2. select where id, locationNum을 통해 값이 존재 -> return 저장오류, 부재 -> insert 수행.
		 * 
		 */
		//관광지 저장 후 (성공 시 1, 실패 시 0), 장바구니 등록
		int result = service.addSave(save);
		model.addAttribute("map", service.getSaveList(login));
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
			
			int result = service.deleteSave(save.getCartId());		//save.getId()
			
			//장바구니 페이지로
			String res = "redirect:/myList.sp?id="+ save.getId();
			
			if (result == 0) {
				res = "fail";
			}
			return res;
		}

}



