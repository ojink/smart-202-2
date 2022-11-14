package file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다운로드할 파일명 확인
		String filename = request.getParameter("filename");
		//해당 파일명으로 저장된 파일을 저장위치에서 찾기
		String file = getServletContext().getRealPath("upload")
							+ "/" + filename;
		//버퍼링해서 해당 파일을 스트림으로 읽는다.
		BufferedInputStream in 
			= new BufferedInputStream( new FileInputStream(file) );
		//다운로드할 파일의 마임타입 확인
		String mime = request.getServletContext().getMimeType(file);
		response.setContentType(mime);
		
		//첨부된 파일을 다운로드하는 것임을 지정
		response.setHeader("content-disposition", 
						"attachment; filename=" + filename);
		//쓰기작업하는 파일은 텍스트가 아니라 byte 데이터
		//:  OutputStream(Writer가 아니라)
		ServletOutputStream out = response.getOutputStream();
		byte buf[] = new byte[1024];
		/*
		while( true ) {
			int read = in.read(buf);
			if( read==-1) break;
			out.write(buf, 0, read); //1026 : 1024 -> 2
		}
		*/
		int read = 0;
		while( (read = in.read(buf)) != -1 ) {
			out.write(buf, 0, read); 
		}
		out.flush();
		out.close();
		in.close();
	}

}
