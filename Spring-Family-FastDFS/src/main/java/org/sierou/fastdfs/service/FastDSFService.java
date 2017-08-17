package org.sierou.fastdfs.service;

import org.csource.fastdfs.FileInfo;
import org.sierou.fastdfs.dao.FastDFSDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * FastDSF 服务
 * @author xiaocai
 * 2016-10-14
 */
@Service
public class FastDSFService {
	
	@Autowired
	private FastDFSDao fastDFSDao;
	
	/**
	 * 上传
	 * 用于二进制文件的上传，便于统一调用接口
	 * @param fileByte	二进制文件
	 * @param fileName	文件名称
	 * @return
	 * @throws Exception
	 */
	public String upload(byte[] fileByte, String fileName) throws Exception{
		if(fileByte==null){
			throw new Exception("fileByte is null");
		}
		if(StringUtils.isEmpty(fileName)){
			throw new Exception("fileName is empty");
		}
		try {
			return fastDFSDao.uploadFile(fileByte, fileName);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	/**
	 * 下载
	 * 返回二进制流 供调用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public byte[] download(String fileId) throws Exception{
		if(StringUtils.isEmpty(fileId)){
			throw new Exception("fileId is null");
		}
		byte[] fileByte = fastDFSDao.downloadFile(fileId);
		return fileByte;
	}
	/**
	 * 删除接口
	 * @param fileid  服务器上的存储的文件id
	 * @return
	 * @throws Exception 
	 */
	public int delete(String fileId) throws Exception{
		return fastDFSDao.deleteFile(fileId);
	}
	/**
	 * 
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public FileInfo queryFileInfo(String fileId) throws Exception{
		return fastDFSDao.queryFileInfo(fileId);
	}

}
