package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void exec( HttpServletRequest request
						, HttpServletResponse response );
}
