package cn.closer.space.services;

import cn.closer.space.beans.User;
import cn.closer.space.beans.UserLogin;
import cn.closer.space.beans.UserSimpleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserService extends IService<User> {

     String saveUser(User user) ;

     Map<String,Object> userSignIn(UserLogin userLogin);

     String userSignUp(User user) ;

     void sendCodeEmail(String email);

     UserSimpleInfo getuserSimpleById(String id);

     void UpdateAvatar(String id ,String avatar);

     boolean checkEmail(String email) ;


}
