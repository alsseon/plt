package com.spring.plt.manufacPage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufacPage.vo.ManufacVO;
import com.spring.plt.startuppage.vo.PageVO;

public interface ManufacDAO {

	int listCount() throws DataAccessException;
	List<ManufacVO> selectAllEstiList(PageVO pagevo, String manuId) throws DataAccessException;
	int deleteesti(int no) throws DataAccessException;
	int quotestatus(int quotestatus, int no) throws DataAccessException;
	int quotestatus_de(int quotestatus, int no);
	List<ManufacVO> selectWaitingEstiList(PageVO pagevo, String manuId) throws Exception;
	public List<ManufacVO> selectIngEstiList(PageVO pagevo, String manuId) throws Exception;
	public List<ManufacVO> selectComEstiList(PageVO pagevo, String manuId) throws Exception;
	public List<ManufacVO> selectDeEstiList(PageVO pagevo, String manuId) throws Exception;
	
	////////////////////���� �߰��� ������Ȳ /////////////////////////
	
	List<ManufacVO> SelectAllProdList(PageVO pagevo) throws DataAccessException;
	List<ManufacVO> SelectWaitingProdList(PageVO pagevo) throws DataAccessException;

	List<ManufacVO> selectIngProdList(PageVO pagevo) throws DataAccessException;

	List<ManufacVO> selectComProdList(PageVO pagevo) throws DataAccessException;

	List<ManufacVO> selectSailProdList(PageVO pagevo) throws DataAccessException;

	List<ManufacVO> selectEndProdList(PageVO pagevo) throws DataAccessException;

	List<ManufacVO> selectDeProdList(PageVO pagevo) throws DataAccessException;

	int estilistCount_i(String manuId) throws Exception;
	int estilistCount_c(String manuId) throws Exception;
	int estilistCount_d(String manuId) throws Exception;
	int estilistCount_w(String manuId) throws Exception;
	



}
