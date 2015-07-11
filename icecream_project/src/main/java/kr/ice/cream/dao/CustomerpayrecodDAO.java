/*
* 작성일 : 2015. 7. 11.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dao;

import kr.ice.cream.dto.CustomerpayrecordDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerpayrecodDAO extends SqlSessionDaoSupport{

	/**
	 * 구매 기록을 입력
	 * @param dto
	 * @return 1 성공, 0 실패
	 */
	public int input(CustomerpayrecordDTO dto){
		return getSqlSession().insert("cpr.input", dto);
	}
}
