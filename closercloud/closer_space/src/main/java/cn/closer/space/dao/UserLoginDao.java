package cn.closer.space.dao;

import cn.closer.space.beans.UserLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserLoginDao.java
 * @Description TODO
 * @createTime 2020年03月08日 12:36:00
 */

@Mapper
@Component
public interface UserLoginDao extends BaseMapper<UserLogin> {

}
