package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductInfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//선택한 상품정보를 DB에서 조회해 온다
		//선택한 상품정보 조회 메소드 호출
		ProductDAO dao = new ProductDAO();
		int num = Integer.parseInt( request.getParameter("no") );
		ProductDTO dto = dao.product_info(num);
		
		//request에 attribute로 담는다
		request.setAttribute("info", dto);
	}

}
