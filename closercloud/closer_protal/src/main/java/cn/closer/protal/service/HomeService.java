package cn.closer.protal.service;

import cn.closer.protal.beans.HomeAdvertise;
import cn.closer.protal.beans.HomeFlash;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeService.java
 * @Description TODO
 * @createTime 2020年05月02日 10:13:00
 */
public interface HomeService {

    public List<HomeAdvertise> getHomeAdvertiseOn();

    public List<HomeFlash> getHomeFlash() ;
}
