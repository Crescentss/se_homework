package file;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
 
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/PasteServlet")
public class PasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//设置ContentType字段值
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			String path = "D:\\tomcat\\apache-tomcat-9.0.63\\webapps\\UpDownloadFiles\\copy.txt"; // 路径   
	        //创建FileReader对象，指定要读取的文件
			FileInputStream fin = new FileInputStream(path);
	        InputStreamReader reader = new InputStreamReader(fin);
	        BufferedReader buffReader = new BufferedReader(reader);
	        //通过循环来判断是否读取到文件的末尾
	        String text = "";
	        while((text = buffReader.readLine())!=null) {
	        //把文字返回前端
				request.getSession().setAttribute("text",text);
	            request.getRequestDispatcher("copy.jsp").forward(request,response);
	        }
	        //关闭流
	        buffReader.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

