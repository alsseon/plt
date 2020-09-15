package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageService {
	public int deleteesti(int no) throws Exception;
	
	
	public List<StartupPageVO> listesti(PageVO pagevo) throws DataAccessException;  
	public int listCount() throws DataAccessException;
	public List<StartupPageVO> listprod(PageVO pagevo) throws DataAccessException;
	public List<StartupPageVO> listcon(PageVO pagevo) throws DataAccessException;
	public int w_listCount() throws DataAccessException;
	public int i_listCount() throws DataAccessException;
	public int c_listCount() throws DataAccessException;
	public int d_listCount() throws DataAccessException;
	
	public List<StartupPageVO> w_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> c_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> i_listesti(PageVO pagevo) throws DataAccessException; 
	public List<StartupPageVO> d_listesti(PageVO pagevo) throws DataAccessException; 
}
