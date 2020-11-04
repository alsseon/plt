package com.spring.plt.manufacPage.controller;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.manufacPage.service.ManufacService;
import com.spring.plt.manufacPage.vo.ManufacVO;
import com.spring.plt.startuppage.vo.PageVO;

@Controller("manufaccontroller")
public class ManufacControllerImpl implements ManufacController{

		@Autowired
		private ManufacService manufacservice;
		@Autowired
		private ManufacVO manufac;
		@RequestMapping(value = {"/manufacpage/estilist.do","/manufacpage/prodlist.do" },method = RequestMethod.GET)
		private ModelAndView prodlist(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
				request.setCharacterEncoding("utf-8");
				response.setContentType("html/text; charset=utf-8");
				String viewName = (String)request.getAttribute("viewName");
				int total = manufacservice.listCount();
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
				System.out.println("빠진 값이 무엇이냐 manuId: "+manuId+" pagevo : "+ pagevo);
				List<ManufacVO> estilist = manufacservice.listesti(pagevo,manuId);
				List<ManufacVO> w_estiList = manufacservice.w_estiList(pagevo,manuId);
				List<ManufacVO> i_estiList = manufacservice.i_estiList(pagevo,manuId);
				List<ManufacVO> c_estiList = manufacservice.c_estiList(pagevo,manuId);
				List<ManufacVO> d_estiList = manufacservice.d_estiList(pagevo,manuId);

//				
				ModelAndView mav = new ModelAndView(viewName);
				mav.addObject("estilist",estilist);
				mav.addObject("w_estiList", w_estiList);
				mav.addObject("i_estiList", i_estiList);
				mav.addObject("c_estiList", c_estiList);
				mav.addObject("d_estiList", d_estiList);

				mav.addObject("pagevo",pagevo);
				return mav;
		}
		@RequestMapping(value="/manufacpage/estilist_del.do" , method = RequestMethod.GET)
		public ModelAndView deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
			request.setCharacterEncoding("utf-8");
			System.out.println("delete NO: "+no);
			manufacservice.deleteesti(no);
			ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do");
			return mav;
		}
		@RequestMapping(value="/manufacpage/com_estilist_del.do" , method = RequestMethod.GET)
		public ModelAndView com_deletestatus(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
			request.setCharacterEncoding("utf-8");
			System.out.println("delete NO: "+no);
			manufacservice.deleteesti(no);
			ModelAndView mav = new ModelAndView("redirect:/com_manufacpage/com_estilist.do");
			return mav;
		}
		@RequestMapping(value ="/manufacpage/estilist_updatestatus.do", method = RequestMethod.GET)
		public ModelAndView updatestatus(@RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
			request.setCharacterEncoding("utf-8");
			manufacservice.updatestatus(quotestatus,no);
			ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do");
			return mav;
		}
		
		@RequestMapping(value ="/manufacpage/estilist_updatestatus_de.do", method = RequestMethod.GET)
		public ModelAndView updatestatus_de(@RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
			request.setCharacterEncoding("utf-8");
			manufacservice.updatestatus_de(quotestatus,no);
			ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do");
		
			return mav;
			
		}
		@RequestMapping(value = "/manufacpage/estilist_more_w.do",method = RequestMethod.GET)
		private ModelAndView prodlist_w(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
			
				request.setCharacterEncoding("utf-8");
				response.setContentType("html/text; charset=utf-8");
				String viewName = (String)request.getAttribute("viewName");
				
				int total = manufacservice. listCount_w(manuId);
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
				List<ManufacVO> w_estiList = manufacservice.w_estiList(pagevo,manuId);
				ModelAndView mav = new ModelAndView(viewName);
				mav.addObject("w_estiList", w_estiList);
				mav.addObject("pagevo",pagevo);
				return mav;
		}
		
		@RequestMapping(value="manufacpage/estilist_more_ing.do", method=RequestMethod.GET)
			private ModelAndView prodlist_ing(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text; charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			int total = manufacservice. listCount_i(manuId);
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
			List<ManufacVO> i_estiList = manufacservice.i_estiList(pagevo,manuId);
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("i_estiList", i_estiList);
			mav.addObject("pagevo",pagevo);
			return mav;
		}
		@RequestMapping(value="/com_manufacpage/com_estilist.do", method=RequestMethod.GET)
		private ModelAndView prodlist_com(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_c(manuId);
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
		List<ManufacVO> c_estiList = manufacservice.c_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_estiList", c_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
		@RequestMapping(value="/manufacpage/estilist_more_de.do", method=RequestMethod.GET)
		private ModelAndView prodlist_de(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_d(manuId);
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
		List<ManufacVO> d_estiList = manufacservice.d_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_estiList", d_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
//////////////////////////////////////////////////	������ü ���� ����Ʈ	////////////////////////////////////////////////////////////////////////

}
