package cn.closer.space.dao;

import cn.closer.space.beans.UserSimpleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserSimpleInfoDao.java
 * @Description TODO
 * @createTime 2020年03月09日 14:38:00
 */
@Repository
public interface UserSimpleInfoDao extends BaseMapper<UserSimpleInfoDao> {


    UserSimpleInfo getById(String id) ;


}
