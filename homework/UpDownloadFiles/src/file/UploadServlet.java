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
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
			//创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置文件缓存目录，如果该目录不存在则新创建一个
			File f = new File("E:\\TempFolder");
			if (!f.exists()) {
				f.mkdirs();
			}
			//设置文件的缓存路径
			factory.setRepository(f);
			//创建ServletFileUpload对象
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			//设置字符编码
			fileupload.setHeaderEncoding("utf-8");
			//解析request，得到上传文件的FileItem对象
			List<FileItem> fileitems = fileupload.parseRequest(request);
			//获取字符流
			PrintWriter writer = response.getWriter();
			//遍历集合
			for (FileItem fileitem : fileitems) {
//				System.out.println(fileitem);
				if(!fileitem.isFormField()){
					//获取上传的文件名
					String filename = fileitem.getName();
					//处理上传文件
					if(filename != null && !filename.equals("")) {
//						writer.print("上传的文件名称是："+filename+"<br/>");
						//截取出文件名
						filename = filename.substring(filename.lastIndexOf("\\")+1);
						//文件名要唯一
//						filename = UUID.randomUUID().toString()+"_"+filename;
						//在创建服务器创建同名文件
						String webPath = "/download/";
						String filepath = getServletContext().getRealPath(webPath + filename);
						System.out.println(filepath);
						//创建文件
						File file = new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						//获得上传文件流
						InputStream in = fileitem.getInputStream();
						//使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out = new FileOutputStream(file);
						//流的对拷
						byte[] buffer = new byte[1024];//每次读取1个字节
						int len;
						//开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
						while ((len = in.read(buffer)) > 0) {
							out.write(buffer, 0, len);
						}
						//关闭流
						in.close();
						out.close();
						//删除临时文件
						fileitem.delete();
//						writer.print("上传文件成功！<br/>");
					}
				}
			}
			
			String path = "D:\\tomcat\\apache-tomcat-9.0.63\\webapps\\UpDownloadFiles\\download"; // 路径
	        File file2 = new File(path);//获取路径  F:测试目录
	        if (!file2.exists()) {
	            System.out.println(path + " not exists");//不存在就输出
	            return;
	        }

	        File file[] = file2.listFiles();//用数组接收
	        String[] files = new String [20];
	        for (int i = 0; i < file.length; i++) {//循环遍历
	            File fs = file[i];//获取数组中的第i个
	            files[i] = fs.getName();
	            System.out.println(files[i]);//直接输出
	        }
	        
			request.getSession().setAttribute("files",files);
            request.getRequestDispatcher("upload.jsp").forward(request,response);
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

