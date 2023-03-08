package service;

import java.util.Map;

import model.LoginDTO;
import model.SaveLocationDTO;

//ServiceImpl에 Override
public interface SaveLocationService {

	SaveLocationDTO checkSave(SaveLocationDTO save);

	public int addSave(SaveLocationDTO save);
	
	//장바구니 삭제
	public int deleteSave(int cartId);
	
	//회원의 목록 정보 리스트
	public Map<String, SaveLocationDTO> getSaveList(LoginDTO dto); 

}
