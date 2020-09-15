package com.spring.plt.expertpage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.expertpage.dao.ConsultingDAO;
import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

@Service("consultingService")
public class ConsultingServiceImpl implements ConsultingService{
private ConsultingDAO consultingdao;
	
	public int listCount() throws DataAccessException{
		int result = consultingdao.listCount();
		System.out.println("service----: "+ result);
		return result;
	}
	public List<ConsultingVO> w_listcon(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> w_conlist = null;
		w_conlist = consultingdao.selectAllEstiList(pagevo);
		System.out.println("service" + w_conlist);
		return w_conlist;
	}
	public List<ConsultingVO> i_listcon(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> i_conlist = null;
		i_conlist = consultingdao.selectWaitEstiList(pagevo);
		System.out.println("service" + i_conlist);
		return i_conlist;
	}
	public List<ConsultingVO> c_listcon(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> c_conlist = null;
		c_conlist = consultingdao.selectComEstiList(pagevo);
		System.out.println("service" + c_conlist);
		return c_conlist;
	}
	public List<ConsultingVO> d_listcon(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> d_conlist = null;
		d_conlist = consultingdao.selectDeEstiList(pagevo);
		System.out.println("service" + d_conlist);
		return d_conlist;
	}
	public List<ConsultingVO> listcon(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> conlist = null;
		conlist = consultingdao.selectAllEstiList(pagevo);
		System.out.println("service" + conlist);
		return conlist;
	}
	public int deleteesti(int no) throws Exception{
		return consultingdao.deleteesti(no);
	}
}
