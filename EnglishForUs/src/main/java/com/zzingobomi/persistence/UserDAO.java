package com.zzingobomi.persistence;

import java.util.Date;

import com.zzingobomi.domain.UserVO;
import com.zzingobomi.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);

}
