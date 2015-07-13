package kr.ice.cream.dao;

import kr.ice.cream.dto.BasketDTO;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015-07-13.
 */
@Repository
public class BasketDAO extends SqlSessionDaoSupport{

    /**
     * 장바구니에 아이템 압력
     * @param dto
     * @return 1 성공, 0 실패
     */
    public int input(BasketDTO dto) {
        return getSqlSession().insert("basket.input", dto);
    }

    /**
     * status가 1인 상태의 장바구니 내용을 불러온다
     * @param customersrl
     * @return
     */
    public List<BasketDTO> pullList(int customersrl){
        return getSqlSession().selectList("basket.pullList", customersrl);
    }

    /**
     * 장바구니 상태 변경
     * @param srl
     * @return
     */
    public int alterStatus(int srl){
        return getSqlSession().update("basket.alterStatus", srl);
    }
}
