package cn.closer.space.dao;

import cn.closer.space.beans.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserInfoDao.java
 * @Description TODO
 * @createTime 2020年03月08日 12:11:00
 */
@Mapper
@Component
public interface UserInfoDao extends BaseMapper<UserInfo> {


}
