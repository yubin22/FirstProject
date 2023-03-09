package service;

import java.util.List;
import java.util.Map;

import model.LoginDTO;
import model.SaveLocationDAO;
import model.SaveLocationDTO;

public class SaveLocationServiceImpl implements SaveLocationService {
	
	private SaveLocationDAO saveLocationDAO;
	
	public void setSaveLocationDAO(SaveLocationDAO saveLocationDAO) {
		this.saveLocationDAO = saveLocationDAO;
	}

	//이미 저장된 것이 있는지 체크 (목록, 회원 확인)
	@Override
	public SaveLocationDTO checkSave(SaveLocationDTO save) {
		SaveLocationDTO result = saveLocationDAO.checkSave(save);
		return result;
	}

	//목록 추가 데이터, 저장하기
	@Override
	public int addSave(SaveLocationDTO save) {
		return saveLocationDAO.addSave(save);
	}

	//목록 삭제 (성공 시 1, 실패 시 0)
	@Override
	public int deleteSave(int cartId) {
		return saveLocationDAO.deleteSave(cartId);
	}

	//장바구니 정보 반환
	@Override
	public Map<String, SaveLocationDTO> getSaveList(SaveLocationDTO dto) {
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
		return saveLocationDAO.getSave(dto); 	//cart
	}

	//info에서 사용할 region의 상세정보
	@Override
	public SaveLocationDTO getRegion(SaveLocationDTO dto) {
		return saveLocationDAO.getRegion(dto);
	}
	
	//내 장바구니 정보 반환 String id
	@Override
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto) {
		return saveLocationDAO.getSaveList(dto);
	}

}