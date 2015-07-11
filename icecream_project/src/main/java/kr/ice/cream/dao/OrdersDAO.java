/*
* 작성일 : 2015. 7. 11.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dao;

import java.util.List;

import kr.ice.cream.dto.OrdersDTO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO extends SqlSessionDaoSupport{

	/**
	 * 주문 내용 입력, 가격은 아직 미입력 상태
	 * @param dto
	 * @return 1 성공, 0 실패
	 */
	public int input(OrdersDTO dto){
		return getSqlSession().insert("orders.input", dto);
	}

	/**
	 * 고객의 주문 내역 불러오기
	 * @param customersrl
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrdersDTO> pullCustomerOrder(int customersrl){
		return getSqlSession().selectList("orders.pullCustomerOrder", customersrl);
	}
	
	/**
	 * 전체 주문 내용에서 sort 리스트를 불러오기
	 * @param sort
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> pullAllSort(String sort){
		return getSqlSession().selectList("orders.pullAllSort", sort);
	}

	/**
	 * srl 값으로 하나의 주문 내역을 불러온다
	 * @param srl
	 * @return
	 */
	public OrdersDTO pullOrderInfo(int srl) {
		return (OrdersDTO) getSqlSession().selectOne("orders.pullOrderInfo", srl);
	}
	
	/**
	 * 주문 페이즈 변경
	 * @param srl
	 * @return
	 */
	public int alterPhase(int srl){
		return getSqlSession().update("orders.alterPhase", srl);
	}

	/**
	 * 주문 내역에서 미포함된 가격 정보를 입력한다
	 * @param dto
	 * @return 1 성공, 0 실패
	 */
	public int plusPrice(OrdersDTO dto) {
		return getSqlSession().update("orders.plusPrice", dto);
	}
}
