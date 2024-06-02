package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.ProductVO;

public class ShopDAO {
	
	//나중에 useBean으로 등록해서 사용할 객체
	
	public static ProductVO[] getList(String category) {
		ProductVO[] ar = null;
		
		// 인자로 받은 카테고리 값(comm01, ele002, sp003) 중 하나를
		// 받아서 shop_t라는 테이블로부터 해당 제품들을 검색한다.
		SqlSession ss = FactoryService.getFactory().openSession();
		
		List<ProductVO> list =ss.selectList("shop.list", category);
		
		ss.close();
		
		//list의 요소들을 배열로 변환하자!
		//list가 null이 아니면 list에 있는 것들을 배열화 시킨다.
		//!list.isEmpty()  => list.size>0으로 해도 됨
		if(list != null && !list.isEmpty()) {
			//ar을 list의 크기만큼 배열을 생성하자!
			ar = new ProductVO[list.size()];
			/*
			int i=0;
			for(ProductVO vo : list) {
				ar[i] = vo;
				i++;
			};*/
			
			//list의 요소들을 한번에 배열에 복사한다.(for 문 안돌려도 됨)
			list.toArray(ar);
		}
		
		return ar;
	}
}
