package cn.closer.admin.dao;

import cn.closer.admin.beans.SmsHomeRecommendSubject;
import cn.closer.admin.beans.SmsHomeRecommendSubjectExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


import cn.closer.admin.beans.SmsHomeRecommendSubject;
import cn.closer.admin.beans.SmsHomeRecommendSubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SmsHomeRecommendSubjectMapper {
    long countByExample(SmsHomeRecommendSubjectExample example);

    int deleteByExample(SmsHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject record);

    int insertSelective(SmsHomeRecommendSubject record);

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByExample(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject record);

    int updateByPrimaryKey(SmsHomeRecommendSubject record);
}