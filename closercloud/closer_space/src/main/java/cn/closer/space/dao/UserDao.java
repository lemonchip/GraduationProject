package cn.closer.space.dao;

import cn.closer.space.beans.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Component
public interface UserDao extends BaseMapper<User> {

    @Update("update space_user set avatar = #{url} where id = #{id}")
    public void saveAvatar(@Param(value = "id") String id, @Param(value = "url") String url);

}
