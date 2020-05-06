package cn.closer.fastDFS.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName FileService.java
 * @Description TODO
 * @createTime 2020年03月13日 11:36:00
 */
public interface FileService {

    String saveFile(MultipartFile multipartFile) ;
}
