package org.sierou.fastdfs.web;


import org.csource.fastdfs.FileInfo;
import org.sierou.fastdfs.comm.utils.UploadUtils;
import org.sierou.fastdfs.service.FastDSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * FastDFS 程序应用调用二进制形式
 * 接口形式供调用
 * @author xiaocai
 * 2016-10-17
 *
 */
@RestController    //此注解定义此类下面的全部为@ResponseBody接口
@RequestMapping("/fdfs/byte")
public class FastDFSByteWeb {

	@Autowired
	private FastDSFService fastDSFService;
	
	/**
	 * 
	 */
	@RequestMapping("upload")
	public String upload(HttpServletRequest request) throws Exception{
		InputStream servletInputStream = request.getInputStream();
		String fileName = System.currentTimeMillis()+"";
		byte[] fileByte = UploadUtils.getFileBuffer(servletInputStream);
		return fastDSFService.upload(fileByte,fileName);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("download")
	public void doDownload( HttpServletRequest request,
			 HttpServletResponse response) {
		try {
			String fileId = request.getParameter("fileId");
			response.getOutputStream().write(fastDSFService.download(fileId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("delete")
	public String delete(HttpServletRequest request) throws Exception {
		String fileId = request.getParameter("fileId");
		//删除文件服务器上的数据里面的数据
		return fastDSFService.delete(fileId)+"";
	}
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryFileInfo")
	public FileInfo queryFileInfo(HttpServletRequest request) throws Exception {
		String fileId = request.getParameter("fileId");
		//删除文件服务器上的数据里面的数据
		return fastDSFService.queryFileInfo(fileId);
	}
	
	
}
