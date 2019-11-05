package com.hong.ssm.service.impl;

import com.hong.ssm.domain.CsciBaseProject;
import com.hong.ssm.mapper.CsciBaseProjectMapper;
import com.hong.ssm.service.ICsciBaseProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础项目 服务实现类
 * </p>
 *
 * @author wanghong
 * @since 2019-11-05
 */
@Service
public class CsciBaseProjectServiceImpl extends ServiceImpl<CsciBaseProjectMapper, CsciBaseProject> implements ICsciBaseProjectService {

    @Autowired
    private CsciBaseProjectMapper csciBaseProjectMapper;

    @Override
    public CsciBaseProject findById(Long id) {
        return csciBaseProjectMapper.selectById(id);
    }
}
