package shop.bean;

import mybatis.dao.ShopDAO;
import mybatis.vo.ProductVO;

public class ShopBean {
	//사용자가 선택한 category라는 파라미터 값이 저장될 곳
	private String category;//메뉴에서 클릭하면 바로 여기로 자동
							//저장되도록 해야한다.
	
	//각 카테고리별로 선별된 제품들을 저장할 배열
	private ProductVO[] p_list; //진열대와 같다
	
	//제품 상세보기 기능에서 받는 제품번호를 저장할 곳
	private String p_num;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProductVO[] getP_list() {
		return p_list;
	}

	public void setP_list(ProductVO[] p_list) {
		this.p_list = p_list;
	}

	public String getP_num() {
		return p_num;
	}

	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	
	//카테고리별로 검색된 제품들을 DAO로부터 p_list에 저장한다.
	public void searchProduct() {
		//이미 category는 특정값이 들어가 있는 상태다.
		p_list = ShopDAO.getList(category);
	}
	
	//사용자가 제품을 하나 선택해서 상세보기를 할 때
	//제품번호(p_num)를 이용하게 된다. 그래서
	//현재객체의 멤버변수에 자동으로 저장되고 그 p_num을
	//이용하여 p_list에서 검색한 후 반환하는 기능
	
	public ProductVO getProduct(){
		ProductVO vo = null;
		
		//p_list에서 p_num으로 검색
		for(ProductVO pvo : p_list) {
			if(pvo.getP_num().equals(p_num)) {
				vo = pvo;//검색된 객체의 주소를 반환변수 vo에 저장
				break;//반복문 탈출
			}
				
		}
		
		return vo;
	}
	
}
