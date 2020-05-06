package cn.closer.admin.services.impl;

import cn.closer.admin.beans.CmsPrefrenceArea;
import cn.closer.admin.beans.CmsPrefrenceAreaExample;
import cn.closer.admin.dao.CmsPrefrenceAreaMapper;
import cn.closer.admin.services.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
