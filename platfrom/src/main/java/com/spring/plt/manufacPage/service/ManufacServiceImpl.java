package com.spring.plt.manufacPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.manufacPage.vo.ManufacVO;
import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.manufacPage.dao.ManufacDAO;
import com.spring.plt.manufacPage.service.ManufacService;


@Service("manufacservice")
public class ManufacServiceImpl implements ManufacService{

		@Autowired
		private ManufacDAO manufacdao;
		@Autowired
		private PageVO pagevo;
		
		public List<ManufacVO> listesti(PageVO pagevo, String mamuId) throws DataAccessException{
			List<ManufacVO> estilist = null;
			estilist = manufacdao.selectAllEstiList(pagevo,mamuId);
			System.out.println("service, estiList" + estilist);
			return estilist;
		}
		public List<ManufacVO> w_estiList(PageVO pagevo, String mamuId) throws Exception{
			List<ManufacVO> estilist = null;
			estilist = manufacdao.selectWaitingEstiList(pagevo,mamuId);
			return estilist;
		}
		public List<ManufacVO> i_estiList(PageVO pagevo, String mamuId) throws Exception{
			List<ManufacVO> estilist = null;
			estilist = manufacdao.selectIngEstiList(pagevo,mamuId);
			return estilist;
		}
		public List<ManufacVO> c_estiList(PageVO pagevo, String mamuId) throws Exception{
			List<ManufacVO> estilist = null;
			estilist = manufacdao.selectComEstiList(pagevo,mamuId);
			return estilist;
		}
		public List<ManufacVO> d_estiList(PageVO pagevo, String mamuId) throws Exception{
			List<ManufacVO> estilist = null;
			estilist = manufacdao.selectDeEstiList(pagevo,mamuId);
			return estilist;
		}
		public int listCount() throws DataAccessException{
			return manufacdao.listCount();
		}
		public int deleteesti(int no) throws Exception {
			return manufacdao.deleteesti(no);
		}
		public int updatestatus(int quotestatus, int no)throws DataAccessException{
			return manufacdao.quotestatus(quotestatus,no);
		}
		public int updatestatus_de(int quotestatus, int no)throws DataAccessException{
			return manufacdao.quotestatus_de(quotestatus,no);
		}
		public int listCount_i(String manuId) throws Exception{
			return manufacdao.estilistCount_i(manuId);
		}
		public int listCount_w(String manuId) throws Exception{
			return manufacdao.estilistCount_w(manuId);
		}
		public int listCount_d(String manuId) throws Exception{
			return manufacdao.estilistCount_d(manuId);
		}
		public int listCount_c(String manuId) throws Exception{
			return manufacdao.estilistCount_c(manuId);
		}
		
		
	////////////////////////���� �߰��� ���� ��Ȳ ���� //////////////////////////////////////////
		public List<ManufacVO> ListProd(PageVO pagevo) throws DataAccessException{
			List<ManufacVO> ProdList = null;
			ProdList = manufacdao.SelectAllProdList(pagevo);
			return ProdList;
		}
		public List<ManufacVO> ListProd_Waiting(PageVO pagevo) throws DataAccessException{
			List<ManufacVO> ProdList_Waiting = null;
			ProdList_Waiting = manufacdao.SelectWaitingProdList(pagevo);
			return ProdList_Waiting;
		}
		
		
}
