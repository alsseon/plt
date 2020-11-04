package com.spring.plt.manufacPage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufacPage.vo.ManufacVO;
import com.spring.plt.startuppage.vo.PageVO;

public interface ManufacService {
	int listCount();
	List<ManufacVO> listesti(PageVO pagevo,String manuId);
	int deleteesti(int no) throws Exception;
	int updatestatus(int quotestatus, int no);
	int updatestatus_de(int quotestatus, int no);
	List<ManufacVO> w_estiList(PageVO pagevo, String manuId) throws Exception;
	List<ManufacVO> i_estiList(PageVO pagevo,String manuId) throws Exception;
	List<ManufacVO> c_estiList(PageVO pagevo,String manuId) throws Exception;
	List<ManufacVO> d_estiList(PageVO pagevo,String manuId) throws Exception;
	int listCount_d(String manuId) throws Exception;
	int listCount_i(String manuId) throws Exception;
	int listCount_w(String manuId) throws Exception;
	int listCount_c(String manuId) throws Exception;
	
////////////���� �߰��� ������ü ������Ȳ ����/////////////////////////////
	public List<ManufacVO> ListProd(PageVO pagevo) throws DataAccessException;
	public List<ManufacVO> ListProd_Waiting(PageVO pagevo) throws DataAccessException;
	
}
