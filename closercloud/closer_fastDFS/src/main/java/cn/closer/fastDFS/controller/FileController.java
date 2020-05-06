package cn.closer.fastDFS.controller;

import cn.closer.fastDFS.beans.FastDFSFile;
import cn.closer.fastDFS.client.FastDFSClient;
import cn.closer.fastDFS.services.FileService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName FileController.java
 * @Description TODO
 * @createTime 2020年03月12日 18:48:00
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService ;

    @PostMapping(value = "/upload") //new annotation since 4.3
    public Map singleFileUpload(@RequestParam(value = "file") MultipartFile file) {

        Map<String,String> map = new HashMap<>() ;
        String path = "";

        if (file.isEmpty()) {

         //   return new Result(false,StatusCode.ERROR,"失败","文件不能为空");
            return map;
        }
        try {
            // Get the file and save it somewhere
            path=fileService.saveFile(file);
            System.out.println("path:"+path);
            //redirectAttributes.addFlashAttribute("message",
                   // "You successfully uploaded '" + file.getOriginalFilename() + "'");
            //redirectAttributes.addFlashAttribute("path",
                   // "file path url '" + path + "'");
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("upload file failed",e);
        }finally {

            System.out.println("path:"+path);

           // return path ;
            //Map<String,String> map = new HashMap<>() ;
            map.put("link",path) ;

            return map;
        }



    }
}
