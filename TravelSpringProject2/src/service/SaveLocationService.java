package service;

import java.util.List;
import java.util.Map;

import model.LoginDTO;
import model.SaveLocationDTO;

//ServiceImpl에 Override
public interface SaveLocationService {
	
	// 여행지 리스트.
	public List<SaveLocationDTO> getList(SaveLocationDTO dto);
	
	//특정 locationName
	public SaveLocationDTO getName(SaveLocationDTO dto);
	
	// 내 여행지 리스트.
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto);
	
	//저장하기
	public void addSave(SaveLocationDTO save);
	
	//이미 저장된 것이 있는지 체크
	SaveLocationDTO checkSave(SaveLocationDTO save);
	
	//장바구니 삭제
	public int deleteSave(SaveLocationDTO dto);

}
