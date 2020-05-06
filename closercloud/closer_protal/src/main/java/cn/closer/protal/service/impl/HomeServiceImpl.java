package cn.closer.protal.service.impl;

import cn.closer.protal.beans.HomeAdvertise;
import cn.closer.protal.beans.HomeFlash;
import cn.closer.protal.dao.HomeAdvertiseDao;
import cn.closer.protal.dao.HomeFlashDao;
import cn.closer.protal.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeServiceImpl.java
 * @Description TODO
 * @createTime 2020年05月02日 10:14:00
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeAdvertiseDao homeAdvertiseDao ;

    @Autowired
    private HomeFlashDao homeFlashDao ;

    @Override
    public List<HomeAdvertise> getHomeAdvertiseOn() {

        return homeAdvertiseDao.getHomeAdvertiseByStatusOn();
    }

    @Override
    public List<HomeFlash> getHomeFlash() {
        return homeFlashDao.getHomeFlashs();
    }
}
