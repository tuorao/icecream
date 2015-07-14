package kr.ice.cream.controller;

import kr.ice.cream.dto.CustomerDTO;
import kr.ice.cream.service.CustomerJoinService;
import kr.ice.cream.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015-07-13.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerJoinService joinService;
    @Autowired
    CustomerLoginService loginService;

    /**
     * 회원 가입 페이지 호출 (webapp/WEB-INF/views/customer/join.jsp)
     * @return
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String CustomerJoinPage(){
        return "customer/join";
    }

    /**
     * 회원 가입 프로세스 (webapp/WEB-INF/views/customer/main.jsp 호출)
     * @param dto
     * @param mav
     * @return 1 성공, 0 실패
     */
    @RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
    public String CustomerJoinProcess(@ModelAttribute CustomerDTO dto, ModelAndView mav){
        mav.addObject("joincheck", joinService.join(dto));
        return "customer/main";
    }

    /**
     * 아이디 중복 체크
     * @param id
     * @return 1 중복 없음(사용가능), 0 중복 (사용불가)
     */
    @RequestMapping(value = "/idDupCheck", method = RequestMethod.POST)
    public int CustomerIdDupCheck(@RequestParam String id){
        return joinService.inDupCheck(id);
    }


    /**
     * 로그인 페이지 호출
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String CustomerLogin(){
        return "customer/login";
    }

    /**
     * 로그인 프로세스
     * @param id
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String CustomerLoginProcess(@RequestParam String id, @RequestParam String password, HttpSession session){
        CustomerDTO dto = loginService.login(id,password);
        session.setAttribute("customer",dto);
        return "customer/loginSuccess";
    }

    /**
     * 회원정보 변경 페이지 호출
     * @return
     */
    @RequestMapping(value = "/alter", method = RequestMethod.GET)
    public String CusstomerDropout(){
        return "customer/alter";
    }

    /**
     * 회원 탈퇴 프로세스
     * @param session
     * @return
     */
    @RequestMapping(value = "/dropoutProcess", method = RequestMethod.POST)
    public String CustomerDropoutProcess(HttpSession session){
        CustomerDTO dto = (CustomerDTO) session.getAttribute("customer");
        loginService.dropout(dto.getSrl());
        session.invalidate();
        return "customer/loginSuccess"; // 세션이 말소되었는지 확인하려고 일로 보냄
    }

    /**
     * 회원정보 변경 프로세스
     * @param dto
     * @param session
     * @param mav
     * @return
     */
    @RequestMapping(value = "/alterProcess", method = RequestMethod.POST)
    public String CustomerAlterProcess(@ModelAttribute CustomerDTO dto, HttpSession session, ModelAndView mav){
    	System.out.println(dto.getId());
        if(loginService.alter(dto)==1){
            session.removeAttribute("customer");
            session.setAttribute("customer", dto);
            mav.addObject("msg","success");
        } else {
            mav.addObject("msg","fail");
        }
        return "customer/loginSuccess";
    }
    
}
