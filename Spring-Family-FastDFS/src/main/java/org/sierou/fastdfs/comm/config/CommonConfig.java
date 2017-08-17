package org.sierou.fastdfs.comm.config;

import org.sierou.fastdfs.comm.utils.UploadUtils;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 此处配置spring boot的文件限制大小
 * @author xiaocai
 *
 */
@Configuration
public class CommonConfig {
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(1024L * 1024L * Integer.parseInt(UploadUtils.maxSize));
        return factory.createMultipartConfig();
    }
}
