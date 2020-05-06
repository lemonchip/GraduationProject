package cn.closer.ums.services.impl;

import cn.closer.ums.beans.UmsMemberReceiveAddress;
import cn.closer.ums.beans.UmsMemberStatisticsInfo;
import cn.closer.ums.dao.UmsMemberStatisticsInfoDao;
import cn.closer.ums.services.UmsMemberStatisticsInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberStatisticsInfoServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月13日 12:27:00
 */
public class UmsMemberStatisticsInfoServiceImpl implements UmsMemberStatisticsInfoService {

    @Autowired
    private UmsMemberStatisticsInfoDao umsMemberStatisticsInfoDao ;

    @Override
    public UmsMemberStatisticsInfo getUmsMemberStatisticsInfoById(String memberId) {

        QueryWrapper<UmsMemberStatisticsInfo> queryWrapper = new QueryWrapper() ;

        queryWrapper.eq("member_id",memberId);
        return umsMemberStatisticsInfoDao.selectOne(queryWrapper);
    }
}
