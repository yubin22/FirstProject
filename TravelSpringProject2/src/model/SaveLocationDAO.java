package model;
import java.util.List;
import java.util.Map;

public interface SaveLocationDAO { 
	
	//목록 추가insert (성공 시 1, 실패 시 0)
	public int addSave(SaveLocationDTO save);
	
	//목록 삭제 (성공 시 1, 실패 시 0)
	public int deleteSave(int cartId);
	
	//목록 (데이터를 리스트로 받아옴)
	public Map<String, SaveLocationDTO> getSave(LoginDTO dto);
	
	//목록, 회원 확인 (장소, 회원 넘겨 값이 있는지 확인)
	public SaveLocationDTO checkSave(SaveLocationDTO save);
	
	//회원의 목록 정보 리스트
	public List<SaveLocationDTO> getSaveList(String id);
}
