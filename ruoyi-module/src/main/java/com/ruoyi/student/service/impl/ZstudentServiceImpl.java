package com.ruoyi.student.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.student.domain.Zstudent;
import com.ruoyi.student.mapper.ZstudentMapper;
import com.ruoyi.student.service.ZstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class ZstudentServiceImpl implements ZstudentService {
    @Autowired
    private ZstudentMapper zstudentMapper;
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Zstudent selectZstudentById(Long id) {
        return zstudentMapper.selectZstudentById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zstudent 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Zstudent> selectZstudentList(Zstudent zstudent) {
//        QueryWrapper<Zstudent> queryWrapper4 = new QueryWrapper<>();
//        queryWrapper4.lambda().like(Zstudent::getName,zstudent.getName());
//        List<Zstudent> id = zstudentMapper.selectList(queryWrapper4);
        return zstudentMapper.selectZstudentList(zstudent);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zstudent 【请填写功能名称】
     * @return 结果
     */
    @Override
    @Transactional
    public int insertZstudent(Zstudent zstudent) {
        zstudentMapper.insertZstudent(zstudent);
        return 1;
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param zstudent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZstudent(Zstudent zstudent) {
        zstudentMapper.updateZstudent(zstudent);
        return 1;
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteZstudentByIds(String ids) {
        return zstudentMapper.deleteZstudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZstudentById(Long id) {
        return zstudentMapper.deleteZstudentById(id);
    }
}
