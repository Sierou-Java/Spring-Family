package org.sierou.fastdfs.comm.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 文件上传工具类
 * @author xiaocai
 * @date 2016-10-17
 */
public class UploadUtils {
	
	/**
	 * 最大文件大小 
	 * 1M=1024*1024(B)=1048576
	 * 10M=10*1024*1024(B)=104857600 bytes
	 */
	public static String maxSize = "10485760";
	
	public UploadUtils() {
		
	}
	
	/**
	 *	
	 * 
	 * @param request
	 */
	public static String validateFile(HttpServletRequest request, MultipartFile file) {
		String errorInfo = "";
		String contentType = request.getContentType();
		if (file == null || !contentType.startsWith("multipart")) {
			errorInfo = "request not has multipart/form-data";
		} else if (Integer.parseInt(maxSize) < file.getSize()) {
			errorInfo = "The file maxSize is :[" + maxSize + "]";
		}else if (file !=null && StringUtils.isEmpty(file.getOriginalFilename())) {// 检查目录
			errorInfo = "the file is null";
		}
		return errorInfo;
	}
	
	/**
	 * 流转二进制
	 * 用于 统一 传到服务器端的均为二进制文件
	 * @param inStream
	 * @return
	 */
	public static byte[] getFileBuffer(InputStream inStream){  
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
		try {
			byte[] buff = new byte[1024];  
	        int rc = 0;  
	    	while ((rc = inStream.read(buff)) != -1) {
	            swapStream.write(buff, 0, rc);  
	        }  
		} catch (Exception e) {
			e.printStackTrace();
		}
        return swapStream.toByteArray();  
    }  
}
