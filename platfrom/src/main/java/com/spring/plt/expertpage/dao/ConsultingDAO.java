package com.spring.plt.expertpage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

public interface ConsultingDAO {
	public int listCount() throws DataAccessException;
	public List<ConsultingVO> selectAllEstiList(PageVO pagevo) throws DataAccessException;
	public int deleteesti(int no) throws DataAccessException;
	public List<ConsultingVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> selectIngEstiList(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> selectComEstiList(PageVO pagevo) throws DataAccessException;
	public List<ConsultingVO> selectDeEstiList(PageVO pagevo) throws DataAccessException;
}
