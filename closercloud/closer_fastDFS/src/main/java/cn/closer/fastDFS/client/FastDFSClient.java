package cn.closer.fastDFS.client;

import cn.closer.fastDFS.beans.FastDFSFile;
import org.csource.fastdfs.*;
import org.csource.common.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName FastDFSClient.java
 * @Description TODO
 * @createTime 2020年03月12日 16:29:00
 */
@Component
public class FastDFSClient {


    public static TrackerClient trackerClient;
    public static TrackerServer trackerServer ;
    public static StorageServer storageServer ;
    public static StorageClient storageClient;

    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();;
            ClientGlobal.init(filePath);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getTrackerServer();
            storageServer = trackerClient.getStoreStorage(trackerServer);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }


    //上传文件
    public static String[] upload(FastDFSFile file) {
        //logger.info("File Name: " + file.getName() + "File Length:" + file.getContent().length);
        System.out.println("File Name: " + file.getName() + "File Length:" + file.getContent().length);
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        try {
            storageClient = new StorageClient(trackerServer, storageServer);
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (IOException e) {
            e.printStackTrace();
           // logger.error("IO Exception when uploadind the file:" + file.getName(), e);
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("Non IO Exception when uploadind the file:" + file.getName(), e);
        }
      //  logger.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");
        if (uploadResults == null) {
            System.out.println("upload file fail, error code:" + storageClient.getErrorCode());
            //logger.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        System.out.println("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
        //logger.info("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
        return uploadResults;
    }

    //根据 groupName 和文件名获取文件信息。
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            storageClient = new StorageClient(trackerServer, storageServer);
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    //下载文件
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            storageClient = new StorageClient(trackerServer, storageServer);
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    //删除文件
    public static void deleteFile(String groupName, String remoteFileName)
            throws Exception {
        storageClient = new StorageClient(trackerServer, storageServer);
        int i = storageClient.delete_file(groupName, remoteFileName);
        //logger.info("delete file successfully!!!" + i);
        System.out.println("delete file successfully!!!" + i);
    }

    public static String getTrackerUrl() throws IOException {
        //单机构建
        return "http://"+trackerServer.getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }
}
