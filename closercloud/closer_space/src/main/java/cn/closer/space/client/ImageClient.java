package cn.closer.space.client;

import cn.closer.space.config.MultipartSupportConfig;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName ImageClient.java
 * @Description TODO
 * @createTime 2020年03月13日 12:17:00
 */
@FeignClient(value = "closer-fastDFS",configuration = MultipartSupportConfig.class)
public interface ImageClient {

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //new annotation since 4.3
    public String singleFileUpload(@RequestPart(value = "file") MultipartFile file) ;



}
