/*
* 작성일 : 2015. 7. 9.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dao;

import java.util.List;

import kr.ice.cream.dto.ItemlistDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ItemlistDAO extends SqlSessionDaoSupport{

	/**
	 * 주문 내역의 아이템 리스트 입력
	 * @param dto
	 * @return
	 */
	public int input(ItemlistDTO dto){
		return getSqlSession().insert("itemlist.input", dto);
	}
	
	/**
	 * 고유값으로 아이템 리스트 호출
	 * @param sort
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<ItemlistDTO> pullItemlist(String sort){
		return getSqlSession().selectList("itemlist.pullItemlist", sort);
	}
}
