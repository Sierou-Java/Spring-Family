package org.sierou;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.sierou.fastdfs.FastDFSClient;
import org.sierou.fastdfs.comm.utils.FastDFSUtils;
import org.sierou.fastdfs.comm.utils.UploadUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.util.StringUtils;

import java.io.IOException;

// springboot启动时会自动注入数据源和配置jpa
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringFamilyFastdfsApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    public static int port = 8080;

//    public static void main(String[] args) {
//        // 1、把FastDFS提供的jar包添加到工程中
//        // 2、初始化全局配置。加载一个配置文件。
//        try {
//            ClientGlobal.init("/project/Spring-Family-Parent/Spring-Family-FastDFS/src/main/resources/fdfs-client.conf");
//            // 3、创建一个TrackerClient对象。
//            TrackerClient trackerClient = new TrackerClient();
//            // 4、创建一个TrackerServer对象。
//            TrackerServer trackerServer = trackerClient.getConnection();
//            // 5、声明一个StorageServer对象，null。
//            StorageServer storageServer = null;
//            // 6、获得StorageClient对象。
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            // 7、直接调用StorageClient对象方法上传文件即可。
//            String[] strings = storageClient.upload_file("/documents/王洪悦/cx.jpg", "jpg", null);
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (MyException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception {
        //本程序端口、文件服务器地址、文件服务器端口、文件大小	eg. 8080 192.168.1.100 22122 100
//        for (String arg : args) {
//            System.out.println(arg);
//        }
//        if (args.length > 0) {
//            String port = args[0];
//            String trackerAddress = args[1];
//            String trackerPort = args[2];
//            String maxSize = args[3];
//            //
//            FastDFSUtils.trackerAddress = new String[(args.length / 2 - 1)];
//            FastDFSUtils.trackerPort = new int[(args.length / 2 - 1)];
//
//            SpringFamilyFastdfsApplication.setPort(port);
//            SpringFamilyFastdfsApplication.setTrackerServer(0, trackerAddress, trackerPort);
//            SpringFamilyFastdfsApplication.setMaxSize(maxSize);
//
//            if (args.length >= 6) {
//                int j = 1;
//                for (int i = 4; i < args.length; i++) {
//                    String tAddress = args[i];
//                    String tPort = args[i += 1];
//                    SpringFamilyFastdfsApplication.setTrackerServer(j, tAddress, tPort);
//                    j += 1;
//                }
//            }
//        }
        SpringApplication.run(SpringFamilyFastdfsApplication.class, args);
        System.out.println("-----> start success...");
    }

    /**
     * 端口修改
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(SpringFamilyFastdfsApplication.port);
    }

    /**
     * @param port
     * @throws Exception
     */
    public static void setPort(String port) throws Exception {
        if (StringUtils.isEmpty(port)) {
            throw new Exception("应用的端口号必须填写");
        }
        SpringFamilyFastdfsApplication.port = Integer.parseInt(port);
    }

    /**
     * @param maxSize
     * @throws Exception
     */
    public static void setMaxSize(String maxSize) throws Exception {
        if (StringUtils.isEmpty(maxSize)) {
            throw new Exception("文件大小必须填写");
        }
        int size = Integer.parseInt(maxSize);
        if (size <= 0) {
            throw new Exception("文件大小必须大于0");
        }
        UploadUtils.maxSize = (size * 1024 * 1024) + "";
    }

    /**
     * @param trackerAddress
     * @param trackerPort
     * @throws Exception
     */
    public static void setTrackerServer(int i, String trackerAddress, String trackerPort) throws Exception {
        if (StringUtils.isEmpty(trackerAddress) || StringUtils.isEmpty(trackerPort)) {
            throw new Exception("调度服务器的地址和端口必须填写");
        }
        FastDFSUtils.trackerAddress[i] = trackerAddress;
        FastDFSUtils.trackerPort[i] = Integer.parseInt(trackerPort);
    }
}
