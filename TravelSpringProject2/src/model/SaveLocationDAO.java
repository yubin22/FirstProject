package model;
import java.util.List;
import java.util.Map;

public interface SaveLocationDAO { 
	
	//여행지 장바구니 목록
	public List<SaveLocationDTO> getList(SaveLocationDTO dto);

	//info에서 사용할 locationName의 상세정보
	public SaveLocationDTO getName(SaveLocationDTO dto);
	
	//목록 (데이터를 리스트로 받아옴) /id별 여행지 목록
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto);

	//목록 추가insert (성공 시 1, 실패 시 0)
	public void addSave(SaveLocationDTO save);
	
	//목록, 회원 확인 (장소, 회원 넘겨 값이 있는지 확인)
	public SaveLocationDTO checkSave(SaveLocationDTO save);
		
	//목록 삭제 (성공 시 1, 실패 시 0)
	public int deleteSave(SaveLocationDTO dto);
}
