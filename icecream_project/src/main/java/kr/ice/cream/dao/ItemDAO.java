/*
* 작성일 : 2015. 7. 9.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dao;

import java.util.List;

import kr.ice.cream.dto.ItemDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO extends SqlSessionDaoSupport{
	
	/**
	 * 아이템 추가
	 * @param item
	 * @return 1 성공, 0 실패
	 * ** 사진 업로드 필요함
	 */
	public int insert(ItemDTO item){
		return getSqlSession().insert("item.insert", item);
	}
	
	/**
	 * 아이템 전체 리스트 불러오기
	 * @return List<ItemDTO> != null 성공, List<ItemDTO> == null 실패
	 */
	@SuppressWarnings("unchecked")
	public List<ItemDTO> pullAllItem(){
		return getSqlSession().selectList("item.pullAllItem");
	}
	
	/**
	 * 아이템 정보 불러오기
	 * @param srl
	 * @return ItemDTO != null 성공, ItemDTO == null 실패
	 */
	public ItemDTO pullItem(int srl){
		return (ItemDTO) getSqlSession().selectOne("item.pullItem", srl);
	}
	
	/**
	 * 아이템 가격 불러오기
	 * @param srl
	 * @return price != 0 성공, price ==0 실패
	 */
	public int pullPrice(int srl){
		return (Integer) getSqlSession().selectOne("item.pullPrice", srl);
	}
	
	
}
