package org.sierou.fastdfs.comm.utils;

import org.csource.fastdfs.*;

import java.net.InetSocketAddress;
import java.net.URL;

/**
 * FastDFSDao 持久化
 * @author xiaocai
 * 2016-10-14
 */
public class FastDFSUtils {
	
	public static TrackerClient tracker = null;  
	public static TrackerServer trackerServer = null;  
	public static StorageServer storageServer = null;  
	public static StorageClient1 client = null;   
	
//	public static String trackerAddress = "";
//	public static int trackerPort = 22122;
	
	public static String[] trackerAddress = null;
	public static int[] trackerPort = null;
	
	/**
	 * 
	 * @return
	 */
	public static StorageClient1 initClient(){
//		1.读取配置文件进行初始化连接
//		String fdfsConf = FastDFSUtils.class.getResource("/fdfs_client.conf").toString();
//		fdfsConf = fdfsConf.substring(fdfsConf.indexOf("/") + 1);
		String fdfsConf = FastDFSUtils.class.getClassLoader().getResource("fdfs-client.conf").getPath();
		try {
			ClientGlobal.init(fdfsConf);
			
//			2.根据传送进来的动态参数进行初始化连接
//			FastDFSUtils.ClientGlobalInit();
//			FastDFSUtils.reloadTrackerServer();
            //初始化....
			FastDFSUtils.tracker = new TrackerClient();  
			FastDFSUtils.trackerServer = tracker.getConnection();  
			FastDFSUtils.storageServer = null;  
			FastDFSUtils.client = new StorageClient1(trackerServer, storageServer);  
		    return client;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String fdfsConf = FastDFSUtils.class.getResource("/fdfs-client.conf").toString();
		fdfsConf = fdfsConf.substring(fdfsConf.indexOf("/") + 1);
		System.out.println(fdfsConf);
	}
	/**
	 * 
	 */
	public static void reloadTrackerServer(){
	//	if(!StringUtils.isEmpty(FastDFSUtils.trackerAddress) && 
	//		!StringUtils.isEmpty(FastDFSUtils.trackerPort)){
	//		InetSocketAddress[] tracker_servers = new InetSocketAddress[1];  
	//    	tracker_servers[0] = new InetSocketAddress(FastDFSUtils.trackerAddress, FastDFSUtils.trackerPort);
	//    	ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));
	//	}
		if(FastDFSUtils.trackerAddress.length>0 && 
				FastDFSUtils.trackerPort.length>0){
			InetSocketAddress[] tracker_servers = new InetSocketAddress[FastDFSUtils.trackerAddress.length];  
			for(int i=0;i<FastDFSUtils.trackerAddress.length;i++){
				tracker_servers[i] = new InetSocketAddress(FastDFSUtils.trackerAddress[i], FastDFSUtils.trackerPort[i]);
			}
		    ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));
		}
	}
	
	public static void ClientGlobalInit(){
		//连接超时的时限，单位为毫秒  
		ClientGlobal.setG_connect_timeout(2000);  
		//网络超时的时限，单位为毫秒  
		ClientGlobal.setG_network_timeout(30000);  
		ClientGlobal.setG_anti_steal_token(false);  
		//字符集  
		ClientGlobal.setG_charset("UTF-8");  
		ClientGlobal.setG_secret_key("FastDFS1234567890"); 
		//HTTP访问服务的端口号    
		ClientGlobal.setG_tracker_http_port(9091);
	}
	
	
	
}
