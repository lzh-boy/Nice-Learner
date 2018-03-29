package com.example.learner.controller.Api;

import com.example.learner.util.FileUtil;
import com.example.learner.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by LiQian_Nice on 2018/3/29
 */
@Controller
@RequestMapping("/uploadfile")
public class UploadFileController {
    private Logger logger= LoggerFactory.getLogger(UploadFileController.class);
    @RequestMapping("/upload")
    public String upload() {
        return "/upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile file,HttpServletRequest request) {
      String dire="C:\\Users\\DELL\\AppData\\Local\\Temp\\tomcat-docbase.7056544654136940418.1000\\video\\";
      logger.info("上传地址："+dire);
      if (FileUtil.upload(file,dire)){

          return ResultUtil.success();
      }else {
          return ResultUtil.error(1);
      }
    }

    @RequestMapping("/uploads")
    public String uploads() {
        return "/multiupload";
    }
    @PostMapping("/uploads")
    @ResponseBody
    public String uploads(MultipartFile[] files,HttpServletRequest httpServletRequest) {

        String result = null;

        if (files.length == 0) {
            return "file is null";
        }

        for (MultipartFile file : files) {
            String originFileName = file.getOriginalFilename();
            String dire="C:\\Users\\DELL\\AppData\\Local\\Temp\\tomcat-docbase.7056544654136940418.1000\\video\\"+originFileName;
            String destFileLocation = "C:\\Users\\Administrator\\Desktop\\" + originFileName;
            File destFile = new File(dire);
            try {
                file.transferTo(destFile);
                result += "upload ok! upload file location: " + dire;
            } catch (Exception ex) {
                result = "upload false! reason: " + ex.getMessage();
            }
        }

        return result;
    }
}
