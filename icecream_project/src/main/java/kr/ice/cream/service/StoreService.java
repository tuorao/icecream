/*
* 작성일 : 2015. 7. 9.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.service;

import kr.ice.cream.dao.StoreDAO;
import kr.ice.cream.dto.StoreDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO dao;
	
	public StoreDTO login(String id, String password){
		return dao.login(id, password);
	}

}
