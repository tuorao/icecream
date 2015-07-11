/*
* 작성일 : 2015. 7. 10.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dao;


import kr.ice.cream.dto.CustomertasteDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CustomertasteDAO extends SqlSessionDaoSupport{

	/**
	 * 고객의 선호 맛 성향 입력
	 * @param dto
	 * @return 1 성공, 0 실패
	 */
	public int insert(CustomertasteDTO dto){
		return getSqlSession().insert("customertaste.insert", dto);
	}
	
	/**
	 * 고객 맛 성향 정보 변경
	 * @param dto
	 * @return 1 성공, 0 실패
	 * customersrl 은 세션에서 받아온다
	 */
	public int alter(CustomertasteDTO dto) {
		return getSqlSession().update("customertaste.alter", dto);
	}
	
	/**
	 * 고객 맛 성향 정보 가져오기
	 * @param srl
	 * @return CustomertasteDTO 성공, null 실패
	 */
	public CustomertasteDTO pullTaste(int srl) {
		return (CustomertasteDTO) getSqlSession().selectOne("customertaste.pullTaste", srl);
	}
	
	/**
	 * 고객 맛 성향 정보 삭제 - 회원탈퇴와 연동하여 쓰인다
	 * @param srl
	 * @return 1 성공, 0 실패
	 */
	public int delete(int srl){
		return getSqlSession().delete("customertaste.delete", srl);
	}
}
