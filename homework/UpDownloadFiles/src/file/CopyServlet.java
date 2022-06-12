package file;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
 
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/CopyServlet")
public class CopyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CopyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//设置ContentType字段值
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			//获取文字内容
			String text = request.getParameter("text");
			System.out.println(text);
			//在服务器端创建文件
			String filepath = getServletContext().getRealPath("/copy.txt");
			System.out.println(filepath);
			File file = new File(filepath);
			file.getParentFile().mkdirs();
			file.createNewFile();
			//使用FileOutputStream打开服务器端的上传文件
			FileOutputStream out = new FileOutputStream(file);
			//流的对拷
			byte[] buffer = new byte[1024];//每次读取1个字节
			buffer = text.getBytes();
			int len = buffer.length;
			//开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
			out.write(buffer, 0, len);
			out.close();

			//返回前端页面
			response.sendRedirect("copy.jsp");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

