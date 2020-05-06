package cn.closer.fastDFS.services.imp;

import cn.closer.fastDFS.beans.FastDFSFile;
import cn.closer.fastDFS.client.FastDFSClient;
import cn.closer.fastDFS.services.FileService;
import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import jdk.internal.instrumentation.TypeMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName FileServiceImp.java
 * @Description TODO
 * @createTime 2020年03月13日 11:36:00
 */
@Service
public class FileServiceImp implements FileService {

    public String saveFile(MultipartFile multipartFile) {
        String[] fileAbsolutePath={};
        String fileName=multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        String path = "" ;
        byte[] file_buff = null;

        try {
            InputStream inputStream=multipartFile.getInputStream();
            if(inputStream!=null){
                int len1 = inputStream.available();
                file_buff = new byte[len1];
                inputStream.read(file_buff);
            }
            inputStream.close();
            FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
            try {
                fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
            } catch (Exception e) {
                e.printStackTrace();
                //logger.error("upload file Exception!",e);
            }
            if (fileAbsolutePath==null) {
                System.out.println("upload file failed,please upload again!");
                //logger.error("upload file failed,please upload again!");
            }
             path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];


        }catch (IOException e){
            e.printStackTrace();
        }

        finally {

            return path;
        }

    }
}
