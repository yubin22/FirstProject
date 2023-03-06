package service;

import model.LoginDTO;

//ServiceImpl에 Override
public interface LoginService {

	LoginDTO getLogin(LoginDTO dto);
	
	public void insertLogin(LoginDTO dto);
	public int updateLogin(LoginDTO dto);
	public int deleteLogin(LoginDTO dto);

	//아이디 중복 검사
	public LoginDTO idCheck(LoginDTO dto);
}
