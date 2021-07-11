package com.jjf.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    private final static String FILESERVER = "http://192.168.102.124:8090/upload/";

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public Map<String, String> fileUpload(MultipartFile headPhoto, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<String, String>();

        // 获取文件保存目录
//        String realPath = request.getServletContext().getRealPath("/upload");
//        File dir = new File(realPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }

        String originalFilename = headPhoto.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = uuid + extendsName;

        // 第一个版本，上传到本地服务器上
//        File file = new File(dir, newFileName);
//        headPhoto.transferTo(file);


        // 第二个版本，上传到其他服务器上
        String path = FILESERVER + newFileName;
        Client client = Client.create();
        WebResource webResource = client.resource(path);
        webResource.put(String.class, headPhoto.getBytes());

        map.put("message", "上传成功");
        map.put("newFileName", newFileName);
        map.put("filePath", path);
        map.put("fileType", headPhoto.getContentType());

        return map;
    }

    @RequestMapping("fileDownload.do")
    public void fileDownload(String photo, String filetype, HttpServletResponse response) throws IOException {
        // 设置响应头
        // 告诉浏览器要将数据保存到磁盘上,不在浏览器上直接解析
        response.setHeader("Content-Disposition", "attachment;filename=" + photo);
        // 告诉浏览下载的文件类型
        response.setContentType(filetype);
        // 获取一个文件的输入流
        InputStream inputStream = new URL(FILESERVER + photo).openStream();
        // 获取一个指向浏览器的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 向浏览器响应文件即可
        IOUtils.copy(inputStream, outputStream);
    }
}
