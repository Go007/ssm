package com.hong.ssm.service;

import com.hong.ssm.domain.CsciBaseProject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 基础项目 服务类
 * </p>
 *
 * @author wanghong
 * @since 2019-11-05
 */
public interface ICsciBaseProjectService extends IService<CsciBaseProject> {
    CsciBaseProject findById(Long id);
}
