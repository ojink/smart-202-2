package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductAll implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 전체 상품목록을 조회해온다
		//:상품목록 조회 메소드 호출
		ProductDAO dao = new ProductDAO();
		List<ProductDTO>  list= dao.product_list();
		
		//화면에서 출력할 수 있도록 requset에 attribute 로 담는다
		request.setAttribute("list", list);
	}

}
