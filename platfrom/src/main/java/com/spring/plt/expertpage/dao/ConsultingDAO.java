package com.spring.plt.expertpage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

public interface ConsultingDAO {
	public List<ConsultingVO> selectAllEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public int deleteesti(int no) throws DataAccessException;
	public List<ConsultingVO> selectWaitEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ConsultingVO> selectIngEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ConsultingVO> selectComEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ConsultingVO> selectDeEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public int status_n(int status, int no) throws DataAccessException;
	public int status_y(int status, int no) throws DataAccessException;
	int listCount_i(String expId) throws Exception;
	int listCount_w(String expId) throws Exception;
	int listCount_c(String expId) throws Exception;
	int listCount_d(String expId) throws Exception;
	int listCount() throws Exception;
	
}
