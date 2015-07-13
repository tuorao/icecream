package kr.ice.cream.service;

import kr.ice.cream.dao.BasketDAO;
import kr.ice.cream.dto.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015-07-13.
 */
@Service
public class BasketService {

    @Autowired
    BasketDAO basketDao;

    /**
     * 장바구니에 아이템 입력
     * @param dto
     * @return
     */
    public int input(BasketDTO dto){
        return basketDao.input(dto);
    }

    /**
     * 장바구니 리스트 불러오기
     * @param customersrl
     * @return
     */
    public List<BasketDTO> pullList(int customersrl){
        return basketDao.pullList(customersrl);
    }

    /**
     * 장바구니 상태 변경
     * @param srl
     * @return 0 뷰에서 안나온다 1 뷰에서 나옴
     */
    public int alterStatus(int srl){
        return basketDao.alterStatus(srl);
    }
}

