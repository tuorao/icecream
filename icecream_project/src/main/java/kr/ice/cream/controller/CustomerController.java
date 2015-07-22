package kr.ice.cream.controller;

import kr.ice.cream.dto.CustomerDTO;
import kr.ice.cream.dto.ItemtasteDTO;
import kr.ice.cream.service.CustomerJoinService;
import kr.ice.cream.service.CustomerLoginService;
import kr.ice.cream.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    ItemService service;

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
     * @return 1 성공, -1 실패
     */
    @RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
    public ModelAndView CustomerJoinProcess(@ModelAttribute CustomerDTO dto ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("joinResult",joinService.join(dto));
        mav.setViewName("customer/login");
        return mav;
    }

    /**
     * 아이디 중복 체크
     * @param id
     * @return 1 중복 없음(사용가능), 0 중복 (사용불가)
     */
    @RequestMapping(value = "/idDupCheck", method = RequestMethod.POST)
    public @ResponseBody int CustomerIdDupCheck(@RequestParam String id){
    	int a = joinService.inDupCheck(id);
        return a;
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
    public ModelAndView CustomerLoginProcess(@RequestParam String id, @RequestParam String password, HttpSession session){
        CustomerDTO dto = loginService.login(id,password);
        ModelAndView mav = new ModelAndView();
        if(dto!=null){
            session.setAttribute("customer",dto);
            mav.setViewName("customer/home");
        }else {
            mav.addObject("loginStatus","fail");
            mav.setViewName("customer/login");
        }
        return mav;
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
        if(loginService.alter(dto)==1){
            session.removeAttribute("customer");
            session.setAttribute("customer", dto);
            mav.addObject("msg","success");
        } else {
            mav.addObject("msg","fail");
        }
        return "customer/loginSuccess";
    }

    @RequestMapping(value = "/itemlist", method = RequestMethod.GET)
    public String CustomerItemlist(){
        return "customer/itemlistsort";
    }

    /**
     * 로그아웃
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String CustomerLogout(HttpSession session){
        session.invalidate();
        return "redirect:/customer/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String CustomerHome(){
        return "customer/home";
    }

}
