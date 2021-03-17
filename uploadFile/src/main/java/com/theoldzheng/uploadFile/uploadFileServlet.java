package com.theoldzheng.uploadFile;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.17 20:33
 */
public class uploadFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一步先进行判断上传的数据是不是多短类型的数据 判断encType="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建FileItemFactory工厂实现类 作用:可以设置缓存大小以及临时文件保存位置.
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类  指定使用缓存区与临时文件存储位置.
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //用于解析request对象，得到所有上传项.每一个FileItem就相当于一个上传项
                List<FileItem> list = servletFileUpload.parseRequest(req);

                //对list进行遍历，分别对表单项进行处理
                for (FileItem fileItems : list) {
                    //判断表单项，如果是普通表单项返回true
                    if (fileItems.isFormField()) {
                        System.out.println("表单项的属性值为：" + fileItems.getFieldName());
                        //解决乱码问题
                        String string = fileItems.getString("UTF-8");
                        System.out.println(string);
                    } else {
                        //上传文件
                        String fieldName = fileItems.getFieldName();
                        String fileName = fileItems.getName();
                        System.out.println("上传的文件属性：" + fieldName);
                        System.out.println("上传的文件名：" + fileName);

                        try {
                            fileItems.write(new File("D:\\zyd" + "上传文件.jpg"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }

    }
}
