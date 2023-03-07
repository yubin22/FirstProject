package service;

import java.util.HashMap;
import java.util.List;

import model.SaveLocationDAO;
import model.SaveLocationDTO;

//ServiceImpl에 Override
public interface SaveLocationService {

	SaveLocationDTO checkSave(SaveLocationDTO save);

	public int addSave(SaveLocationDTO save);
	public int deleteSave(SaveLocationDTO save);
	
	//회원의 목록 정보 리스트
	public List<SaveLocationDTO> getSaveList(String id); 

}
