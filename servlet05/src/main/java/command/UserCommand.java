package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class UserCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		UserDAO dao = new UserDAO();
		String name = dao.select_name();
		int money = dao.select_money();
		
		request.setAttribute("name", name);
		request.setAttribute("money", money);
	}

}
