package cn.closer.ums.services.impl;

import cn.closer.ums.beans.UmsMember;
import cn.closer.ums.beans.UmsMemberLoginLog;
import cn.closer.ums.dao.UmsMemberDao;
import cn.closer.ums.services.UmsMemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月13日 11:10:00
 */
@Service
@Transactional
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberDao umsMemberDao ;

    @Autowired
    private IdWorker idWorker ;

    @Autowired
    public BCryptPasswordEncoder encoder;

    @Override
    public UmsMember getUmsMemberById(String id) {

        return umsMemberDao.selectById(id);
    }

    @Override
    public boolean updateUmsMember(UmsMember umsMember) {


        return false;
    }

    @Override
    public String insertUmsMember(UmsMember umsMember) {

        String id = idWorker.nextId()+"" ;
        umsMember.setCreateTime(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date()));
        umsMember.setId(id);
        umsMember.setPassword(encoder.encode(umsMember.getPassword()));//加密
        umsMember.setGrowth(0);
        umsMember.setIntegration(0);
        umsMember.setGender(0);
        umsMember.setLuckeyCount(0);
        umsMember.setHistoryIntegration(0);
        umsMember.setStatus(1);

        umsMemberDao.insert(umsMember) ;
        return id;
    }

    @Override
    public String umsMemberSignUp(UmsMember umsMember) {

        String id ;
        if ((id = this.insertUmsMember(umsMember))!=null){
            return id ;
        }
        return null ;

    }



    @Override
    public Map<String, Object> userSignIn(UmsMember umsMember) {
        /**
         * @title userSignIn
         * @description 登录方法
         * @author hekaichuan
         * @param [umsMember]
         * @updateTime 2020/4/13 0013 11:55
         * @throws
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */

        QueryWrapper<UmsMember> queryWrapper = new QueryWrapper() ;

        //登录
        if(umsMember.getUsername()!=null){
//

            queryWrapper.eq("username",umsMember.getUsername());

        }

         queryWrapper.select("id","password");

        UmsMember umsMemberTemp = umsMemberDao.selectOne(queryWrapper);

        //比对密码，成功后返回id和用户名，失败返回空
        if(umsMemberTemp!=null&&encoder.matches(umsMemberTemp.getPassword(),umsMemberTemp.getPassword())){

            Map<String,Object> map = new HashMap<>() ;
            map.put("id",umsMemberTemp.getId());
            map.put("username",umsMemberTemp.getUsername());

            //设置登录信息
            UmsMemberLoginLog umsMemberLoginLog = new UmsMemberLoginLog();
            umsMemberLoginLog.setMemberId(umsMemberTemp.getId());
            this.setMemberLoginLog(umsMemberLoginLog);

            return map ;

        }else {

            return null ;
        }


    }

    @Override
    public void setMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog) {
        String id = idWorker.nextId()+"" ;
        umsMemberLoginLog.setCreateTime(new Date());
        umsMemberLoginLog.setId(id);

    }
}
