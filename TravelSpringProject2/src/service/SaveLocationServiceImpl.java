package service;

import java.util.List;

import model.SaveLocationDAO;
import model.SaveLocationDTO;

public class SaveLocationServiceImpl implements SaveLocationService {
	
	private SaveLocationDAO saveLocationDAO;
	
	public void setSaveLocationDAO(SaveLocationDAO saveLocationDAO) {
		this.saveLocationDAO = saveLocationDAO;
	}

	//장바구니 정보 반환
	@Override
	public List<SaveLocationDTO> getList(SaveLocationDTO dto) {
//		List<SaveLocationDTO> cart = saveLocationDAO.getSave(id);
//		
//		for(SaveLocationDTO dto : cart) {
//			
//			/* 이미지 정보 얻기 */
//			int locationNum = dto.getLocationNum();
//			
//			List<SaveLocationDTO> imageList = null;
//			
//			dto.setImageList(imageList);
//		}
		return saveLocationDAO.getList(dto); 	//cart
	}

	//info에서 사용할 locationName의 상세정보
	@Override
	public SaveLocationDTO getName(SaveLocationDTO dto) {
		return saveLocationDAO.getName(dto);
	}
	
	//내 장바구니 정보 반환 String id
	@Override
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto) {
		return saveLocationDAO.getMyList(dto);
	}

	//여행지 목록 추가 데이터, 저장하기
	@Override
	public void addSave(SaveLocationDTO save) {
		saveLocationDAO.addSave(save);
	}
	
	//이미 저장된 것이 있는지 체크 (목록, 회원 확인)
	@Override
	public SaveLocationDTO checkSave(SaveLocationDTO save) {
		SaveLocationDTO result = saveLocationDAO.checkSave(save);
		return result;
	}

	//여행지 삭제 (성공 시 1, 실패 시 0)
	@Override
	public int deleteSave(SaveLocationDTO dto) {
		return saveLocationDAO.deleteSave(dto);
	}

}