package model;

import java.util.ArrayList;

public interface LoginDAO { //저장된 걸 읽어만 옴.
	public LoginDTO getLogin(LoginDTO dto); //boolean으로 return할 수도 있음. dto => argument
	
	public void insertLogin(LoginDTO dto); //쓰기
	public int updateLogin(LoginDTO dto); //수정
	public int deleteLogin(LoginDTO dto); //삭제

	//아이디 중복 체크
	public LoginDTO selectId(LoginDTO dto);
	//회원목록
	public ArrayList<LoginDTO> selectAllId();
}
