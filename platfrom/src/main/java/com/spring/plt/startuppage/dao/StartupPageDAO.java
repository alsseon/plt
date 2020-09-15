package com.spring.plt.startuppage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageDAO {

	List<StartupPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException;

	int listCount() throws DataAccessException;

	List<StartupPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectAllConList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectIngEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectComEstiList(PageVO pagevo) throws DataAccessException;

	List<StartupPageVO> selectDeEstiList(PageVO pagevo) throws DataAccessException;

	int deleteesti(int no) throws DataAccessException;

}
