package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
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
	
	// 전체 여행지 목록 페이지 (locationName이 보일 페이지)
		@RequestMapping("/spotList.sp")
		public String spotList(HttpSession session, HttpServletRequest request, SaveLocationDTO dto){
			/*
			 * select num, name dto에 담김
			 */
			List< SaveLocationDTO> result = service.getList(dto);
			System.out.println("spotList::"+result);
			request.setAttribute("list", result);
			return "spotList";
		}
		
	//여행지 상세 페이지로 (특정 locationName이 보일 페이지)
		@RequestMapping("/spotInfo.sp")
		public String spotInfo(SaveLocationDTO dto, HttpServletRequest request){
			/*
			 * 전체 여행지 목록에서 특정 locationNum을 select
			 */
			SaveLocationDTO result = service.getName(dto);
			System.out.println("spotInfo :: "+ result);
			request.setAttribute("info", result);
			return "spotInfo";
		}
	
	/*//여행지 상세 페이지 (로그인 유무 체크 페이지)
		@RequestMapping("/spot.sp")
		public String spot(HttpServletRequest request, SaveLocationDTO dto){
			
			SaveLocationDTO result = service.getName(dto);
			System.out.println("spot :: "+ result);
			request.setAttribute("spot", result);
			
			return "spot";
		}*/
		
	//여행지 저장 -> 내 장바구니
		@RequestMapping("/saveAction.sp")
		public String saveform(HttpSession session, LoginDTO login, SaveLocationDTO dto) {
			/*
			 * 1. 로그인 유무 판단  	
			 * 2-1. 로그인 안 했으면 로그인 폼으로
			 * 2-2. 로그인 했으면		id는 session Login DTO
			 * 3. 로그인한 id에 locationNum이 있는지 
			 * 4-1. locationNum이 없으면 저장		SaveLocationDTO에 id, num setting
			 * 4-2. locationNum이 있으면 저장 안 함 = fail로 가서 back
			 * select where id, locationNum을 통해 값이 존재 -> return 저장오류, 부재 -> insert 수행.
			 */
			
			login = (LoginDTO) session.getAttribute("login");
//			String result = dto.getId();
			
			if(login==null) 
			{
				//로그인 안 함.
				return "loginForm";
			}else 
			{
				//로그인 함.
				String id = ((LoginDTO) session.getAttribute("login")).getId();
				//id.getId();
				dto.setId(id);
				SaveLocationDTO res = service.checkSave(dto);
				//res.getLocationNum()).equals()
					if(res != null)
					{
						//존재
						return "fail";
					}else 
					{
						//존재 안 함
						service.addSave(dto);
						session.setAttribute("save", dto);
						System.out.println("addSave : "+ dto);
						return "myList.sp?id="+dto.getId();
					}
			}
		}
	
	//로그인 후 내 페이지 -> 내 장바구니
		@RequestMapping("/myList.sp")
		public String add(SaveLocationDTO dto, HttpServletRequest request, HttpSession session) {			
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			String res = "";
			if(login!=null) 
			{
				dto.setId(login.getId());
				System.out.println("delete :: "+ dto);
				/*
				 * id에 저장된 location 정보
				 * myList.sp?id 로 페이지 이동
				 *  
				 */
				List<SaveLocationDTO> result = service.getMyList(dto);
				request.setAttribute("save", result);
				System.out.println("myList :: "+ result);
				return "myList"; 		// ?id="+ save.getId();
			
		}else  res = "loginForm";
		return res;
	}//return (login!=null) ? service.getMyList(dto, request):"loginForm";
		
	//삭제하기
		@RequestMapping("/delete.sp")
		public String delete(SaveLocationDTO save, HttpSession session) {			
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			String res = "";
			if(login!=null) 
			{
				save.setId(login.getId());
				System.out.println("delete :: "+ save);
				
				int result = service.deleteSave(save);	
				res = (result == 0) ? "fail" : "redirect:/myList.sp";
			}else 
			{
				res = "loginForm";
			}
			return res;
	}
	
	//계획세우기
		@RequestMapping("/makeList.sp")
		public String makeList(){
			System.out.println("makeList");
			return "makeList";
		}

}