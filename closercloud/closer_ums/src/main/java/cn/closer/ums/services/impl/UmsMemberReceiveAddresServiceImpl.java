package cn.closer.ums.services.impl;

import cn.closer.ums.beans.UmsMember;
import cn.closer.ums.beans.UmsMemberReceiveAddress;
import cn.closer.ums.dao.UmsMemberReceiveAddressDao;
import cn.closer.ums.services.UmsMemberReceiveAddresService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberReceiveAddresServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月13日 12:10:00
 */
public class UmsMemberReceiveAddresServiceImpl implements UmsMemberReceiveAddresService {

    @Autowired
    private UmsMemberReceiveAddressDao umsMemberReceiveAddressDao ;

    @Override
    public List<UmsMemberReceiveAddress> getAllMemberReceiveAddresById(String memberId) {
        QueryWrapper<UmsMemberReceiveAddress> queryWrapper = new QueryWrapper() ;

        queryWrapper.eq("member_id",memberId);

        return umsMemberReceiveAddressDao.selectList(queryWrapper);
    }

    @Override
    public int saveMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {


        return umsMemberReceiveAddressDao.insert(umsMemberReceiveAddress);
    }

    @Override
    public int deleteMemberReceiveAddressById(String id) {

        QueryWrapper<UmsMemberReceiveAddress> queryWrapper = new QueryWrapper() ;

        queryWrapper.eq("id",id);

        return umsMemberReceiveAddressDao.delete(queryWrapper);


    }

    @Override
    public int updateMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {

        return 1;
    }
}
