package cn.closer.space.services.Imp;

import cn.closer.space.beans.User;
import cn.closer.space.beans.UserInfo;
import cn.closer.space.beans.UserLogin;
import cn.closer.space.beans.UserSimpleInfo;
import cn.closer.space.dao.UserDao;
import cn.closer.space.dao.UserInfoDao;
import cn.closer.space.dao.UserLoginDao;
import cn.closer.space.dao.UserSimpleInfoDao;
import cn.closer.space.services.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class UserServiceImp extends ServiceImpl<UserDao,User> implements UserService {

    @Autowired
    private IdWorker idWorker ;

    @Autowired
    public BCryptPasswordEncoder encoder;

    @Autowired
    private UserInfoDao userInfoDao ;

    @Autowired
    private UserLoginDao userLoginDao ;

    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    private UserSimpleInfoDao userSimpleInfoDao ;

    @Autowired
    private UserDao userDao ;


    public String saveUser(User user){

        /**
         * @title save
         * @description 插入一个用户
         * @author hekaichuan
         * @param [user]
         * @updateTime 2020/3/7 0007 15:47
         * @throws
         * @return: boolean
         */
        String id = idWorker.nextId()+"" ;
        user.setId(id); //设置ID
        user.setPassword(encoder.encode(user.getPassword())); //加密

        //完善详细信息
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setFanscount(0);
        userInfo.setFollowcount(0);
        userInfoDao.insert(userInfo);

        //设置登录信息
        UserLogin userLogin = new UserLogin() ;
        userLogin.setUsername(user.getUsername());
        userLogin.setEmail(user.getEmail());
        userLogin.setMobile(user.getMobile());
        userLogin.setPassword(user.getPassword());
        userLogin.setUserId(id);
        userLoginDao.insert(userLogin);

        if(super.save(user)==true) {

            return user.getId() ;
        }
        else {
            return null ;
        }
    }

    public Map<String,Object> userSignIn(UserLogin userLogin){
        /**
         * @title userSignIn
         * @description 登录方法
         * @author hekaichuan
         * @param [userLogin]
         * @updateTime 2020/3/8 0008 13:35
         * @throws
         * @return: Map<String,String>  :用户ID,用户email
         */
        //
//        if(userLogin.getMobile()==null&&userLogin.getEmail()==null){
//            return null ;
//        }

        QueryWrapper<UserLogin> queryWrapper = new QueryWrapper<>() ;

        //用手机号登录
        if(userLogin.getMobile()!=null){


            queryWrapper.eq("mobile",userLogin.getMobile());
        }

        //用邮箱号登录
        if(userLogin.getEmail()!=null){
//

            queryWrapper.eq("email",userLogin.getEmail());

        }
        //用用户名登录
        if(userLogin.getUsername()!=null){
//

            queryWrapper.eq("username",userLogin.getUsername());

        }

        queryWrapper.select("user_id","password");

        UserLogin userLoginA = userLoginDao.selectOne(queryWrapper) ;

        //比对密码，成功后返回id和邮箱，失败返回空
        if(userLoginA!=null&&encoder.matches(userLogin.getPassword(),userLoginA.getPassword())){

            Map<String,Object> map = new HashMap<>() ;
            map.put("id",userLoginA.getUserId());
            map.put("email",userLogin.getEmail());
            return map ;

        }else {

            return null ;
        }
    }

    public String userSignUp(User user){
        /**
         * @title userSignUp
         * @description 注册服务
         * @author hekaichuan
         * @param [user]
         * @updateTime 2020/3/8 0008 15:13
         * @throws
         * @return: java.lang.String
         */
        String id ;
        if ((id = this.saveUser(user))!=null){
            return id ;
        }
        return null ;
    }


    public void sendCodeEmail(String email){
        /**
         * @title sendCodeEmail
         * @description 发送邮件验证码
         * @author hekaichuan
         * @param [email]
         * @updateTime 2020/3/8 0008 19:40
         * @throws
         */

        //产生6位随机字符
        String checkCode = RandomStringUtils.random(6,"ABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890");
        //保存在缓存
        redisTemplate.opsForValue().set("checkcode"+email,checkCode,10,TimeUnit.MINUTES);

        //发送邮件
        String message = "您的注册验证码为："+checkCode;
        Map<String,String> map = new HashMap<>();
        map.put("email",email);
        map.put("tittle","来自Closer的邮件验证码");
        map.put("message",message);


       // return  mailService.sendSimpleMail(email,"来自Closer的邮件验证码",message);

        //发给消息队列
        rabbitTemplate
                .convertAndSend("closerTopic","closer.space.checkcode.email",map);


    }

   // @Cacheable(value = "user_simple_info",key = "#id")
    public UserSimpleInfo getuserSimpleById(String id){
        /**
         * @title getuserSimpleById
         * @description 拿到一个简略的用户信息
         * @author hekaichuan
         * @param [id]
         * @updateTime 2020/3/9 0009 19:00
         * @throws
         * @return: cn.closer.space.beans.UserSimpleInfo
         */
       return userSimpleInfoDao.getById(id) ;
    }

    public void UpdateAvatar(String id ,String avatar){
        /**
         * @title UpdataAvatar
         * @description
         * @author hekaichuan
         * @param [id, avatar]
         * @updateTime 2020/3/13 0013 12:47
         * @throws
         */
        System.out.println("avatar:"+avatar);

        userDao.saveAvatar(id,avatar);

    }

    public boolean checkEmail(String email){

        QueryWrapper<UserLogin> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.eq("email",email);
        queryWrapper.select("email") ;
        UserLogin userLogin = userLoginDao.selectOne(queryWrapper) ;

        if(userLogin!=null){

            return false ;
        }else {
            return true ;
        }


    }
}
