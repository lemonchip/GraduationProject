package cn.closer.ums.services;

import cn.closer.ums.beans.UmsMemberReceiveAddress;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberReceiveAddresService.java
 * @Description TODO
 * @createTime 2020年04月13日 12:10:00
 */
public interface UmsMemberReceiveAddresService {

    List<UmsMemberReceiveAddress> getAllMemberReceiveAddresById(String memberId);

    int saveMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    int deleteMemberReceiveAddressById(String id) ;

    int updateMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);
}
