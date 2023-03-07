package model;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class SaveLocationDAOImpl implements SaveLocationDAO {
	private SqlMapClientTemplate sqlMapClientTemplate; //org.springframework.orm.ibatis.SqlMapClientTemplate

	//wirte only
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	//목록 추가
	@Override
	public int addSave(SaveLocationDTO save) {
		return (int) sqlMapClientTemplate.insert("addSave", save);
	}

	//목록 삭제 (성공 시 1, 실패 시 0)
	@Override
	public int deleteSave(SaveLocationDTO save) {
		return sqlMapClientTemplate.delete("deleteSave", save);
	}

	//목록
	@Override
	public List<SaveLocationDTO> getSave(HashMap map) {
		return sqlMapClientTemplate.queryForList("getSave",map);
	}

	//목록, 회원 확인
	@Override
	public SaveLocationDTO checkSave(SaveLocationDTO save) {
		SaveLocationDTO result = (SaveLocationDTO) sqlMapClientTemplate.queryForObject("checkSave", save);
		return result;
	}

	//회원의 목록 정보 리스트
	@Override
	public List<SaveLocationDTO> getSaveList(String id) {
		return sqlMapClientTemplate.queryForList("getSaveList",id);
	}

}
