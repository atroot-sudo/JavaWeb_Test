package com.theoldzheng.downLoad;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.18 20:01
 */
public class downloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.首先获取要下载的文件名
        String downloadFile = "QQ图片.jpg";

        //2.通过ServletContext对象来读取下载文件
        ServletContext servletContext = getServletContext();

        //3.获取要下载的文件的类型
        String mimeType = servletContext.getMimeType(downloadFile);
        System.out.println("要下载的文件的类型为： " + mimeType);

        //4.在文件回传前要告知浏览器客户端回传的文件类型
        resp.setContentType(mimeType);

        //5.告知客户端收到数据是用于下载不是展示  通过设置响应头的方式  attachment-附件 表示下载使用  fileName 表示要下载的文件名和上边保持一致
        //若不加该设置，那么浏览器只会将其输出到浏览器展示

        //在浏览器兼容中文的处理中，因为使用的编码格式不一样，将浏览器分为两大阵营 Firefox 和 其他。
        if (req.getHeader("User-Agent").contains("Firefox")){
            //如果请求头中包含Firefox字样则为Firefox浏览器 使用Base64编码
            //使用Base64编码解决附件下载的中文名问题
            //Base64有编码器和解码器，需要放入要编码和解码的字符
            BASE64Eecoder base64Encoder = new BASE64Encoder();
        }else{
            //没有则为其他浏览器  通过response来设置客户端浏览器的请求头为UTF-8
            resp.setHeader("Content-Disposition","attachment;fileName=" + URLEncoder.encode(downloadFile,"UTF-8"));

        }


        //6.开始进行流处理
        //通过servletContext来获取输入流inputStream
        InputStream is = servletContext.getResourceAsStream(downloadFile);
        ServletOutputStream os = resp.getOutputStream();

        //7.通过commons-io类来对流进行处理
        //输出到客户端
        IOUtils.copy(is, os);

    }
}















































