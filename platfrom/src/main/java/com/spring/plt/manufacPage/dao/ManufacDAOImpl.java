package com.spring.plt.manufacPage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufacPage.dao.ManufacDAO;
import com.spring.plt.manufacPage.vo.ManufacVO;
import com.spring.plt.startuppage.vo.PageVO;

@Repository("manufacdao")
public class ManufacDAOImpl implements ManufacDAO{
		@Autowired
		private SqlSession sqlSession;
		@Override
		public int listCount() throws DataAccessException{
			int listCount = sqlSession.selectOne("mapper.manufacpage.listCount");
			
			return listCount;
		}
		@Override
		public List<ManufacVO> selectAllEstiList(PageVO pagevo, String manuId) throws DataAccessException{
			List<ManufacVO> estiList = null;
			Map<String, Object> estilistMap = new HashMap<String, Object>();
			estilistMap.put("pagevo", pagevo);
			estilistMap.put("manuId", manuId);
			estiList = sqlSession.selectList("mapper.manufacpage.selectAllEstilist",estilistMap);
			
			return estiList;
		}
		public List<ManufacVO> selectWaitingEstiList(PageVO pagevo, String manuId) throws Exception{
			List<ManufacVO> estiList = null;
			Map<String, Object> estilistMap = new HashMap<String, Object>();
			estilistMap.put("pagevo", pagevo);
			estilistMap.put("manuId", manuId);
			estiList = sqlSession.selectList("mapper.manufacpage.selectWaitingEstiList",estilistMap);
			return estiList;
		}
		public List<ManufacVO> selectIngEstiList(PageVO pagevo, String manuId) throws Exception{
			List<ManufacVO> estiList = null;
			Map<String, Object> estilistMap = new HashMap<String, Object>();
			estilistMap.put("pagevo", pagevo);
			estilistMap.put("manuId", manuId);
			estiList = sqlSession.selectList("mapper.manufacpage.selectIngEstiList",estilistMap);
			return estiList;
		}
		public List<ManufacVO> selectComEstiList(PageVO pagevo, String manuId) throws Exception{
			List<ManufacVO> estiList = null;
			Map<String, Object> estilistMap = new HashMap<String, Object>();
			estilistMap.put("pagevo", pagevo);
			estilistMap.put("manuId", manuId);
			estiList = sqlSession.selectList("mapper.manufacpage.selectComEstiList",estilistMap);
			return estiList;
		}
		public List<ManufacVO> selectDeEstiList(PageVO pagevo, String manuId) throws Exception{
			List<ManufacVO> estiList = null;
			Map<String, Object> estilistMap = new HashMap<String, Object>();
			estilistMap.put("pagevo", pagevo);
			estilistMap.put("manuId", manuId);
			estiList = sqlSession.selectList("mapper.manufacpage.selectDeEstiList",estilistMap);
			return estiList;
		}
		
		@Override
		public int deleteesti(int no) throws DataAccessException {
			int deleteesti = sqlSession.delete("mapper.manufacpage.deleteesti", no);
			
			return deleteesti;
		}
		@Override
		public int quotestatus(int quotestatus, int no) throws DataAccessException{
			int result = 0;
			if (quotestatus == 0) {
				result = sqlSession.update("mapper.manufacpage.upstatus_esti_ing",no); //������ ���������� ������Ʈ
				System.out.println("dao result" + result);
			}else if(quotestatus == 1) {
				result = sqlSession.update("mapper.manufacpage.upstatus_esti_com",no);//�Ϸ�� ������Ʈ��
			}
			return result;
		}
		public int quotestatus_de(int quotestatus, int no) throws DataAccessException{
			int result = 0;
			if (quotestatus == 0) {
				result = sqlSession.update("mapper.manufacpage.upstatus_esti_de",no);
			}
			return result;
		}
		@Override
		public int estilistCount_i(String manuId) throws Exception{
			int estilistCount_i = sqlSession.selectOne("mapper.manufacpage.estilistCount_i", manuId);
			return estilistCount_i;
		}
		@Override
		public int estilistCount_w(String manuId) throws Exception{
			int estilistCount_w = sqlSession.selectOne("mapper.manufacpage.estilistCount_w", manuId);
			return estilistCount_w;
		}
		@Override
		public int estilistCount_c(String manuId) throws Exception{
			int estilistCount_c = sqlSession.selectOne("mapper.manufacpage.estilistCount_c", manuId);
			return estilistCount_c;
		}
		@Override
		public int estilistCount_d(String manuId) throws Exception{
			int estilistCount_d = sqlSession.selectOne("mapper.manufacpage.estilistCount_d", manuId);
			return estilistCount_d;
		}
		
		
		
		
		
		
		
		
		
		
		
		@Override
		public List<ManufacVO> SelectAllProdList(PageVO pagevo) throws DataAccessException{
			List<ManufacVO> ProdList = null;
			ProdList = sqlSession.selectList("mapper.manufacpage.SelectAllProdList",pagevo);
			return ProdList;
		}
		@Override
		public List<ManufacVO> SelectWaitingProdList(PageVO pagevo) throws DataAccessException{
			List<ManufacVO> WaitingProdList = null;
			WaitingProdList = sqlSession.selectList("mapper.manufacpage.SelectWaitingProdList",pagevo);
			return WaitingProdList;
		} //������� �غ�
		@Override
		public List<ManufacVO> selectIngProdList(PageVO pagevo) throws DataAccessException{
			
			List<ManufacVO> i_prodList = null;
			i_prodList = sqlSession.selectList("mapper.manufacpage.selectIngProdList",pagevo);
			
			return i_prodList;
		}
		@Override
		public List<ManufacVO> selectComProdList(PageVO pagevo) throws DataAccessException{
			
			List<ManufacVO> c_prodList = null;
			c_prodList = sqlSession.selectList("mapper.manufacpage.selectComProdList",pagevo);
			
			return c_prodList;
		}
		@Override
		public List<ManufacVO> selectSailProdList(PageVO pagevo) throws DataAccessException{
			
			List<ManufacVO> s_prodList = null;
			s_prodList = sqlSession.selectList("mapper.manufacpage.selectSailProdList",pagevo);
			
			return s_prodList;
		}
		@Override
		public List<ManufacVO> selectEndProdList(PageVO pagevo) throws DataAccessException{
			
			List<ManufacVO> e_prodList = null;
			e_prodList = sqlSession.selectList("mapper.manufacpage.selectEndProdList",pagevo);
			
			return e_prodList;
		}
		@Override
		public List<ManufacVO> selectDeProdList(PageVO pagevo) throws DataAccessException{
			
			List<ManufacVO> d_prodList = null;
			d_prodList = sqlSession.selectList("mapper.manufacpage.selectDeProdList",pagevo);
			
			return d_prodList;
		}
		
}
