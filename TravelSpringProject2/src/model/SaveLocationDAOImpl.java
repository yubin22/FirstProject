package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class SaveLocationDAOImpl implements SaveLocationDAO {
	private SqlMapClientTemplate sqlMapClientTemplate; //org.springframework.orm.ibatis.SqlMapClientTemplate

	//wirte only
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	//여행지 장바구니 목록
	@Override
	public List<SaveLocationDTO> getList(SaveLocationDTO dto) {
		List<SaveLocationDTO>  result = sqlMapClientTemplate.queryForList("getList");
		System.out.println(result);
		return result;
	}

	//info에서 사용할 locationName의 상세정보
	@Override
	public SaveLocationDTO getName(SaveLocationDTO dto) {
		return (SaveLocationDTO) sqlMapClientTemplate.queryForObject("getName", dto);
	}
	
	//id별 여행지 목록
	@Override
	public List<SaveLocationDTO> getMyList(SaveLocationDTO dto) {
		return sqlMapClientTemplate.queryForList("getMyList",dto);
	}
	
	//목록 추가
	@Override
	public void addSave(SaveLocationDTO save) {
		sqlMapClientTemplate.insert("addSave", save);
	}
		
	//목록, 회원 확인
	@Override
	public SaveLocationDTO checkSave(SaveLocationDTO save) {
		SaveLocationDTO result = (SaveLocationDTO) sqlMapClientTemplate.queryForObject("checkSave", save);
		return result;
	}

	//목록 삭제 (성공 시 1, 실패 시 0)
	@Override
	public int deleteSave(SaveLocationDTO dto) {
		return sqlMapClientTemplate.delete("deleteSave", dto);
	}
	
}
