package cn.closer.admin.dao;

import cn.closer.admin.beans.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品审核日志自定义Dao
 * Created by macro on 2018/4/27.
 */
@Mapper
public interface PmsProductVertifyRecordDao {
    int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
