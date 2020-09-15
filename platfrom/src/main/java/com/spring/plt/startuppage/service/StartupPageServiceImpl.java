package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.startuppage.dao.StartupPageDAO;
import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Service("startuppageservice")
public class StartupPageServiceImpl implements StartupPageService{
	@Autowired
	private StartupPageDAO startuppagedao;
	@Autowired
	private PageVO pagevo;
	
	public int deleteesti(int no) throws Exception{
		return startuppagedao.deleteesti(no); //철회 삭제 기능
	}
	
	public List<StartupPageVO> listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> estilist = null;
		estilist = startuppagedao.selectAllEstiList(pagevo);
		return estilist; 
	}
	public List<StartupPageVO> w_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_estilist = null;
		w_estilist = startuppagedao.selectWaitEstiList(pagevo);
		return w_estilist;
	}
	public List<StartupPageVO> c_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_estilist = null;
		c_estilist = startuppagedao.selectComEstiList(pagevo);
		return c_estilist;
	}
	public List<StartupPageVO> i_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_estilist = null;
		i_estilist = startuppagedao.selectIngEstiList(pagevo);
		return i_estilist;
	}
	public List<StartupPageVO> d_listesti(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_estilist = null;
		d_estilist = startuppagedao.selectDeEstiList(pagevo);
		return d_estilist;
	}
	
	
	public int listCount() throws DataAccessException{
		return startuppagedao.listCount();
	}
	public List<StartupPageVO> listprod(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> prodlist = null;
		prodlist = startuppagedao.selectAllProdList(pagevo);
		return prodlist;
	}
	public List<StartupPageVO> listcon(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> conlist = null;
		conlist = startuppagedao.selectAllConList(pagevo);
		return conlist;
	}
	@Override
	public int w_listCount() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int i_listCount() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int c_listCount() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int d_listCount() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
}
