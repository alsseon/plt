package com.spring.plt.expertpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.expertpage.service.ConsultingService;
import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

@Controller("consultingController")
public class ConsultingControllerImpl implements ConsultingController{
	@Autowired
	private ConsultingService consultingservice;
	
	@RequestMapping(value = "/expertpage/consulting.do",method = RequestMethod.GET)
	public ModelAndView prodlist(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text;charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			int total = consultingservice.listCount();
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			}else if(nowPage == null) {
				nowPage = "1";
			}else if(cntPerPage == null) {
				cntPerPage = "10";
			}
			System.out.println(nowPage);
			pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			List<ConsultingVO> conlist = consultingservice.listcon(pagevo);
			List<ConsultingVO> c_conlist = consultingservice.c_listcon(pagevo);
			List<ConsultingVO> w_conlist = consultingservice.w_listcon(pagevo);
			List<ConsultingVO> i_conlist = consultingservice.i_listcon(pagevo);
			List<ConsultingVO> d_conlist = consultingservice.d_listcon(pagevo);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("conlist",conlist);
			mav.addObject("w_conlist",w_conlist);
			mav.addObject("i_conlist",i_conlist);
			mav.addObject("c_conlist",c_conlist);
			mav.addObject("d_conlist",d_conlist);
			mav.addObject("pagevo",pagevo);
	
			
			return mav;
	}
	
	@RequestMapping(value="/expertpage/estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		consultingservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do");
		return mav;
	}
}
