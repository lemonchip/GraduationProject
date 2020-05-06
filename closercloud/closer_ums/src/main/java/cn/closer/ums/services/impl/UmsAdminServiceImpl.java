package cn.closer.ums.services.impl;

import cn.closer.ums.beans.UmsAdmin;
import cn.closer.ums.dao.UmsAdminDao;
import cn.closer.ums.dto.UmsAdminParam;
import cn.closer.ums.services.UmsAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsAdminServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月10日 14:35:00
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminDao  umsAdminDao ;

    @Autowired
    public BCryptPasswordEncoder encoder;

    @Autowired
    private IdWorker idWorker ;

    public UmsAdmin getUmsAdminById(String id){
    /**
     * @title getUmsAdminById
     * @description
     * @author hekaichuan
     * @param [id]
     * @updateTime 2020/4/10 0010 14:41
     * @throws
     * @return: cn.closer.ums.beans.UmsAdmin
     */
        return  umsAdminDao.selectById(id) ;
    }

    @Override
    public Map<String,Object> login(String username, String password) {

        if(username == null || password == null){
            return null ;
        }
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.eq("username",username);
        queryWrapper.select("id","username","password");
        UmsAdmin umsAdmin = umsAdminDao.selectOne(queryWrapper) ;

        //比对密码，成功后返回id和邮箱，失败返回空
        if(umsAdmin!=null&&encoder.matches(password,umsAdmin.getPassword())){

            Map<String,Object> map = new HashMap<>() ;
            map.put("id",umsAdmin.getId());
            map.put("email",umsAdmin.getUsername());
            return map ;

        }else {

            return null ;
        }

    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        //UmsAdmin umsAdmin = new UmsAdmin();
        String id = idWorker.nextId()+"" ;
        umsAdmin.setId(id);

        umsAdmin.setPassword(encoder.encode(umsAdmin.getPassword()));

        if(umsAdminDao.insert(umsAdmin)>0){

            return umsAdmin;
        }else {
            return  null ;
        }



    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

}
