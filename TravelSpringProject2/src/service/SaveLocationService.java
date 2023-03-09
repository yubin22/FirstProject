package service;

import java.util.List;
import java.util.Map;

import model.LoginDTO;
import model.SaveLocationDTO;

//ServiceImpl에 Override
public interface SaveLocationService {

	//저장하기
	public int addSave(SaveLocationDTO save);
	
	//이미 저장된 것이 있는지 체크
	SaveLocationDTO checkSave(SaveLocationDTO save);
	
	//장바구니 삭제
	public int deleteSave(int cartId);
	
	// 여행지 리스트에 사용.
	public Map<String, SaveLocationDTO> getSaveList(SaveLocationDTO dto);
	
	// 내 여행지 리스트에 사용.
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto);
	
	//특정 region을 가져와야함
	public SaveLocationDTO getRegion(SaveLocationDTO dto);

}
