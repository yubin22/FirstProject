package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.LoginDTO;
import model.SaveLocationDAO;
import model.SaveLocationDTO;

public class SaveLocationServiceImpl implements SaveLocationService {
	
	private SaveLocationDAO saveLocationDAO;
	
	public void setSaveLocationDAO(SaveLocationDAO saveLocationDAO) {
		this.saveLocationDAO = saveLocationDAO;
	}

	//목록, 회원 확인
	@Override
	public SaveLocationDTO checkSave(SaveLocationDTO save) {
		SaveLocationDTO result = saveLocationDAO.checkSave(save);
		return result;
	}

	//목록 추가 데이터
	@Override
	public int addSave(SaveLocationDTO save) {
		//장바구니 데이터 체크
		SaveLocationDTO checkcart = saveLocationDAO.checkSave(save);
		return saveLocationDAO.addSave(save);
	}

	//목록 삭제 (성공 시 1, 실패 시 0)
	@Override
	public int deleteSave(SaveLocationDTO save) {
		return saveLocationDAO.deleteSave(save);
	}

	//장바구니 정보 반환
	@Override
	public List<SaveLocationDTO> getSaveList(String id) {
		return saveLocationDAO.getSaveList(id); 	//saveLocationDAO.getSaveList(id)
	}

}