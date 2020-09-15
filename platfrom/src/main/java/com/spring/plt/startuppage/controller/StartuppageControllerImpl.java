package com.spring.plt.startuppage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.startuppage.service.StartupPageService;
import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Controller("startuppagecontroller")
public class StartuppageControllerImpl implements StartuppageController{
	@Autowired
	private StartupPageService startuppageservice;
	@Autowired
	private StartupPageVO startuppagevo;    // /startuppage/*list.do
	@RequestMapping(value = {"/startuppage/manu_prodlist.do","/startuppage/consultinglist.do","/startuppage/manu_estilist.do"}, method = RequestMethod.GET)
	private ModelAndView prodlist(PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text;charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			int total = startuppageservice.listCount();
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			}else if(nowPage == null) {
				nowPage = "1";
			}else if(cntPerPage == null) {
				cntPerPage = "10";
			}
			pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			List<StartupPageVO> prodlist = startuppageservice.listprod(pagevo);
			List<StartupPageVO> conlist = startuppageservice.listcon(pagevo);
			List<StartupPageVO> estilist = startuppageservice.listesti(pagevo);
			List<StartupPageVO> w_estilist = startuppageservice.w_listesti(pagevo);
			List<StartupPageVO> c_estilist = startuppageservice.c_listesti(pagevo);
			List<StartupPageVO> d_estilist = startuppageservice.d_listesti(pagevo);
			List<StartupPageVO> i_estilist = startuppageservice.i_listesti(pagevo);
			
			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prodlist",prodlist);
			mav.addObject("conlist",conlist);
			mav.addObject("estilist",estilist);
			mav.addObject("w_estilist",w_estilist);
			mav.addObject("c_estilist",c_estilist);
			mav.addObject("d_estilist",d_estilist);
			mav.addObject("i_estilist",i_estilist);
			
			System.out.println(prodlist);
			return mav;
	}

	@RequestMapping(value="/startuppage/estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		startuppageservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
		return mav;
	}
}
