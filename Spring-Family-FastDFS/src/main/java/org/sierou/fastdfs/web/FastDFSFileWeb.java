package org.sierou.fastdfs.web;


import org.sierou.fastdfs.comm.utils.UploadUtils;
import org.sierou.fastdfs.service.FastDSFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * FastDFS view端直接调用使用
 *
 * @author xiaocai
 *         2016-10-17
 */
@RestController    //此注解定义此类下面的全部为@ResponseBody接口
@RequestMapping("/fdfs/file")
public class FastDFSFileWeb {

    @Autowired
    private FastDSFService fastDSFService;

    /**
     *
     */
    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile multipart, HttpServletRequest request) throws Exception {
        String msg = UploadUtils.validateFile(request, multipart);
        if (StringUtils.isEmpty(msg)) {
            try {
                String fileName = multipart.getOriginalFilename();
                if (!StringUtils.isEmpty(fileName)) {
                    fileName = fileName.substring(0, fileName.lastIndexOf("."));
                }
                try {

                    String extName = fileName.substring(fileName.indexOf(".") + 1);
                    return "ext = " + extName + "fileName = " + fileName;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                InputStream inputStream = multipart.getInputStream();
                if (inputStream == null) {
                    return "upload fails.is not has File";
                }
                //将得到的文件流转二进制，便于后面直接将二进制存到fdfs服务器
                byte[] fileByte = UploadUtils.getFileBuffer(inputStream);
                return fastDSFService.upload(fileByte, fileName);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        } else {
            throw new Exception(msg);
        }
    }

    /**
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("download")
    public void doDownload(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        String fileId = request.getParameter("fileId");
        String fileName = request.getParameter("fileName");
        if (StringUtils.isEmpty(fileName)) {
            throw new Exception("fileName is null");
        }
        try {
            byte fileByte[] = fastDSFService.download(fileId);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(fileByte);
            OutputStream outputStream = null;
            try {
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                outputStream = response.getOutputStream();
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = inputStream.read(b)) != -1) {
                    outputStream.write(b, 0, nRead);
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    throw new Exception(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(HttpServletRequest request) throws Exception {
        String fileId = request.getParameter("fileId");
        //删除文件服务器上的数据里面的数据
        return fastDSFService.delete(fileId) + "";
    }

}
