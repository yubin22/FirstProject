package service;

import java.util.HashMap;
import java.util.List;

import model.LoginDAO;
import model.LoginDTO;

public class LoginServiceImpl implements LoginService {
	
	private LoginDAO loginDAO;
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public LoginDTO getLogin(LoginDTO dto) { //id, pwd를 가져옴. 객체 단위로
		return loginDAO.getLogin(dto);
	}

	@Override
	public void insertLogin(LoginDTO dto) {
		loginDAO.insertLogin(dto);
	}

	@Override
	public int updateLogin(LoginDTO dto) {
		return loginDAO.updateLogin(dto);
	}

	@Override
	public int deleteLogin(LoginDTO dto) {
		return loginDAO.deleteLogin(dto);
	}

	//아이디 중복 체크
	@Override
	public LoginDTO idCheck(LoginDTO dto) {
		LoginDTO result = loginDAO.selectId(dto);
		return result;
	}

}