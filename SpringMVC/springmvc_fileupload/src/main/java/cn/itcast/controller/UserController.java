package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.exception.ZfsException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload1")
    public String fileupload(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        //使用fileupload组件玩成文件上传
        //上传的位置
        //String path = "C:\\Idea\\daima-wenjian\\SpringMVC\\springmvc_fileupload\\src\\main\\webapp\\uploads";

        String uploads = request.getSession().getServletContext().getRealPath("uploads");
//        System.out.println(uploads);

        File file = new File(uploads);
        //判断路径是否存在
        if (!file.exists()){
            //不存在则创建
            file.mkdirs();
        }

        //解析request对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断,当前item是否是上传文件项
            if (item.isFormField()){
                // 说明是普通表单项
            }else {
                //说明是上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //完成文件上传
                String s = UUID.randomUUID().toString().replace("-","");
                filename=s+"_"+filename;
                item.write(new File(uploads,filename));
                //删除临时文件
                item.delete();
            }
        }


        return "success";
    }



    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传...");
        //使用fileupload组件玩成文件上传
        //上传的位置
        //String path = "C:\\Idea\\daima-wenjian\\SpringMVC\\springmvc_fileupload\\src\\main\\webapp\\uploads";

        String path = request.getSession().getServletContext().getRealPath("uploads");
//        System.out.println(path);

        File file = new File(path);
        //判断路径是否存在
        if (!file.exists()){
            //不存在则创建
            file.mkdirs();
        }

                //说明是上传文件项
                //获取上传文件的名称
                String filename = upload.getOriginalFilename();
                //完成文件上传
                String s = UUID.randomUUID().toString().replace("-","");
                filename=s+"_"+filename;
               upload.transferTo(new File(path,filename));


        return "success";
    }
    @RequestMapping("/getAddress")
    public void getAddress(){

    }
    @RequestMapping("/testExp")
    public String testExp() throws ZfsException{
        System.out.println("testExp执行了...");

        try {
            int i=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //向上抛出自定义异常信息
            throw new ZfsException("查询失败,出现错误");
        }

        return "success";
    }
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request,User user) {

        if ("tom".equals(user.getUsername()) && "123".equals(user.getPassword())) {

            request.getSession().setAttribute("user", user);
            return "/index.jsp";
        } else {
            return "/login.jsp";
        }

    }
}
