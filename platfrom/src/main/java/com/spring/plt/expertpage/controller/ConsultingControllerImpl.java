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
	@Autowired
	private ConsultingVO consultingvo;
	
	@RequestMapping(value = "/expertpage/consulting.do",method = RequestMethod.GET)
	public ModelAndView prodlist(@RequestParam("expId")String expId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text;charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			System.out.println("++++++++++++++++++++++++");
			int total = consultingservice.listCount();
			System.out.println("-----------------------");
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
			List<ConsultingVO> conlist = consultingservice.listcon(pagevo,expId);
			List<ConsultingVO> c_conlist = consultingservice.c_listcon(pagevo,expId);
			List<ConsultingVO> w_conlist = consultingservice.w_listcon(pagevo,expId);
			List<ConsultingVO> i_conlist = consultingservice.i_listcon(pagevo,expId);
			List<ConsultingVO> d_conlist = consultingservice.d_listcon(pagevo,expId);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("conlist",conlist);
			mav.addObject("w_conlist",w_conlist);
			mav.addObject("i_conlist",i_conlist);
			mav.addObject("c_conlist",c_conlist);
			mav.addObject("d_conlist",d_conlist);
			mav.addObject("pagevo",pagevo);
	
			
			return mav;
	}
	
	
	@RequestMapping(value="/expertpage/con_wait.do",method = RequestMethod.GET)
	public ModelAndView con_wait(@RequestParam("expId")String expId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = consultingservice.listCount_w(expId);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ConsultingVO> w_conlist = consultingservice.w_listcon(pagevo,expId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("pagevo",pagevo);
		
		
		return mav;
	}
	
	@RequestMapping(value="/com_expertpage/com_consulting.do",method = RequestMethod.GET)
	public ModelAndView con_com(@RequestParam("expId")String expId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = consultingservice.listCount_c(expId);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ConsultingVO> c_conlist = consultingservice.c_listcon(pagevo,expId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("pagevo",pagevo);
		
		
		return mav;
	}
	@RequestMapping(value="/expertpage/con_ing.do",method = RequestMethod.GET)
	public ModelAndView con_ing(@RequestParam("expId")String expId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = consultingservice.listCount_i(expId);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ConsultingVO> i_conlist = consultingservice.i_listcon(pagevo,expId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("i_conlist",i_conlist);
		mav.addObject("pagevo",pagevo);
		
		
		return mav;
	}
	@RequestMapping(value="/expertpage/con_de.do",method = RequestMethod.GET)
	public ModelAndView con_de(@RequestParam("expId")String expId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = consultingservice.listCount_d(expId);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ConsultingVO> d_conlist = consultingservice.d_listcon(pagevo,expId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("pagevo",pagevo);
		
		
		return mav;
	}
	@RequestMapping(value="/expertpage/estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		consultingservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do");
		return mav;
	}
	@RequestMapping(value="/expertpage/com_estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView com_deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		consultingservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/com_expertpage/com_consulting.do");
		return mav;
	}
	@RequestMapping(value ="/expertpage/updatestatus_y.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		consultingservice.status_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do");
		return mav;
	}
	@RequestMapping(value ="/expertpage/updatestatus_n.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		consultingservice.status_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do");
	
		return mav;
	}


}
