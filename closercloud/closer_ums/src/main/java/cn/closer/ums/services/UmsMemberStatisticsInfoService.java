package cn.closer.ums.services;

import cn.closer.ums.beans.UmsMemberStatisticsInfo;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberStatisticsInfoService.java
 * @Description TODO
 * @createTime 2020年04月13日 12:27:00
 */
public interface UmsMemberStatisticsInfoService {

    UmsMemberStatisticsInfo getUmsMemberStatisticsInfoById(String memberId);
}
