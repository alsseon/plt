package com.spring.plt.expertpage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

public interface ConsultingService {
	public int listCount() throws Exception;
	public List<ConsultingVO> w_listcon(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> i_listcon(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> c_listcon(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> d_listcon(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> listcon(PageVO pagevo) throws DataAccessException;
	public int deleteesti(int no) throws Exception;
	public int status_n(int status, int no)throws Exception;
	public int status_y(int status, int no)throws Exception;
}
