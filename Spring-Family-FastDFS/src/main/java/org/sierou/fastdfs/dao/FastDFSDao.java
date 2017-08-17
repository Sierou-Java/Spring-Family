package org.sierou.fastdfs.dao;

import org.csource.fastdfs.FileInfo;
import org.sierou.fastdfs.comm.utils.FastDFSUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * FastDFSDao 持久化
 * @author xiaocai
 * 2016-10-14
 */
@Service
public class FastDFSDao {
	
	/**
	 * 
	 * @param fileByte	文件流的二进制
	 * @param fileName	文件名
	 * @return
	 * @throws Exception 
	 */
	public String uploadFile(byte[] fileByte, String fileName) throws Exception{
	    try {  
	    	//建立连接  
	    	FastDFSUtils.initClient();
		    //上传文件 并 返回存储id
	        return FastDFSUtils.client.upload_file1(fileByte, fileName, null);  
	    } catch (Exception e) {  
	    	throw new Exception(e.getMessage());
	    }  finally {
			try {
				if(FastDFSUtils.trackerServer!=null){
					FastDFSUtils.trackerServer.close();
				}
			} catch (IOException e) {
				throw new Exception(e.getMessage());
			}
		}
	}  
	/**
	 * 
	 * @param fileId
	 * @return
	 * @throws Exception 
	 */
	public byte[] downloadFile(String fileId) throws Exception{
	    try {  
	    	//建立连接  
	    	FastDFSUtils.initClient();
		    //根据文件Id下载 得到相应的二进制文件
	        return FastDFSUtils.client.download_file1(fileId);  
	    } catch (Exception e) {  
	    	throw new Exception(e.getMessage());
	    }  finally {
			try {
				if(FastDFSUtils.trackerServer!=null){
					FastDFSUtils.trackerServer.close();
				}
			} catch (IOException e) {
				throw new Exception(e.getMessage());
			}
		}
	} 
	/**
	 * 
	 * @param fileId
	 * @return
	 * @throws Exception 
	 */
	public int deleteFile(String fileId) throws Exception{
	    try {  
	    	//建立连接  
	    	FastDFSUtils.initClient();
	    	//如果文件服务器中不存在，则返回-1表示文件不存在，源生接口返回为2
	    	if(this.queryFileInfo(fileId)==null){
	    		return -1;
	    	}
		    //根据 存储的 id 进行删除相应的文件。
	        return FastDFSUtils.client.delete_file1(fileId);
	    } catch (Exception e) {  
	    	throw new Exception(e.getMessage());
	    }  finally {
			try {
				if(FastDFSUtils.trackerServer!=null){
					FastDFSUtils.trackerServer.close();
				}
			} catch (IOException e) {
				throw new Exception(e.getMessage());
			}
		}
	} 
	/**
	 * 
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public FileInfo queryFileInfo(String fileId) throws Exception{
	    try {  
	    	//建立连接  
	    	FastDFSUtils.initClient();
		    //根据 存储的 id 进行获取相应的文件详情。
	        return FastDFSUtils.client.query_file_info1(fileId);
	    } catch (Exception e) {  
	    	throw new Exception(e.getMessage());
	    }  finally {
			try {
				if(FastDFSUtils.trackerServer!=null){
					FastDFSUtils.trackerServer.close();
				}
			} catch (IOException e) {
				throw new Exception(e.getMessage());
			}
		}
	} 
}
