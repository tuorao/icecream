package kr.ice.cream.service;

import kr.ice.cream.dao.CustomerDAO;
import kr.ice.cream.dao.CustomertasteDAO;
import kr.ice.cream.dto.CustomerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by Administrator on 2015-07-12.
 */
@Service
public class CustomerLoginService {

    @Autowired
    CustomerDAO customerDao;
    @Autowired
    CustomertasteDAO customertasteDao;
    @Autowired
    PlatformTransactionManager transactionManager;

    /**
     * 로그인
     * @param id
     * @param password
     * @return
     */
    public CustomerDTO login(String id, String password){
        return customerDao.login(id,password);
    }

    /**
     * 회원탈퇴 맛 성향도 같이지움
     * @param srl
     * @return 1 성공, 0 실패
     */
    public int dropout(int srl){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        int res = 0;
        try {
            if(customertasteDao.delete(srl)==1){
                res = customerDao.dropout(srl);
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        transactionManager.commit(status);

        return res;
    }

    /**
     * 회원 정보 변경
     * @param dto
     * @return 1 성공, 0 실패
     */
    public int alter(CustomerDTO dto){
        return customerDao.alter(dto);
    }


}
