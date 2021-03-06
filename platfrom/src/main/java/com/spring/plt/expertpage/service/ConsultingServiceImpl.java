package com.spring.plt.expertpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.expertpage.dao.ConsultingDAO;
import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

@Service("consultingService")
public class ConsultingServiceImpl implements ConsultingService{
	@Autowired 
	private ConsultingDAO consultingdao;
	@Autowired 
	private PageVO pagevo;

	
	public int listCount() throws Exception{
		System.out.println("service�� listCount()");
		int result = consultingdao.listCount();
		System.out.println("service���� result ���"+result);
		return result;
	}
	public int listCount_i(String expId) throws Exception{
		return consultingdao.listCount_i(expId);
	}
	public int listCount_w(String expId) throws Exception{
		return consultingdao.listCount_w(expId);
	}
	public int listCount_d(String expId) throws Exception{
		return consultingdao.listCount_d(expId);
	}
	public int listCount_c(String expId) throws Exception{
		return consultingdao.listCount_c(expId);
	}
	
	
	public List<ConsultingVO> w_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ConsultingVO> w_conlist = null;
		w_conlist = consultingdao.selectWaitEstiList(pagevo, expId);
		System.out.println("service" + w_conlist);
		return w_conlist;
	}
	public List<ConsultingVO> i_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ConsultingVO> i_conlist = null;
		i_conlist = consultingdao.selectIngEstiList(pagevo, expId);
		System.out.println("service" + i_conlist);
		return i_conlist;
	}
	public List<ConsultingVO> c_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ConsultingVO> c_conlist = null;
		c_conlist = consultingdao.selectComEstiList(pagevo, expId);
		System.out.println("service" + c_conlist);
		return c_conlist;
	}
	public List<ConsultingVO> d_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ConsultingVO> d_conlist = null;
		d_conlist = consultingdao.selectDeEstiList(pagevo, expId);
		System.out.println("service" + d_conlist);
		return d_conlist;
	}
	public List<ConsultingVO> listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ConsultingVO> conlist = null;
		conlist = consultingdao.selectAllEstiList(pagevo, expId);
		System.out.println("service" + conlist);
		return conlist;
	}
	public int deleteesti(int no) throws Exception{
		return consultingdao.deleteesti(no);
	}
	public int status_y(int status, int no)throws Exception{
		return consultingdao.status_y(status, no);
	}
	public int status_n(int status, int no)throws Exception{
		return consultingdao.status_n(status, no);
	
	}
}
