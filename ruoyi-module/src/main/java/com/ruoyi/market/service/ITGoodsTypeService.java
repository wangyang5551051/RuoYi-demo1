package com.ruoyi.market.service;

import com.ruoyi.market.domain.TGoodsType;

import java.util.List;
import java.util.Map;

/**
 * 商品类型Service接口
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public interface ITGoodsTypeService 
{
    /**
     * 查询商品类型
     * 
     * @param id 商品类型ID
     * @return 商品类型
     */
    public TGoodsType selectTGoodsTypeById(Long id);

    /**
     * 查询商品类型列表
     * 
     * @param tGoodsType 商品类型
     * @return 商品类型集合
     */
    public List<TGoodsType> selectTGoodsTypeList(TGoodsType tGoodsType);

    /**
     * 新增商品类型
     * 
     * @param tGoodsType 商品类型
     * @return 结果
     */
    public int insertTGoodsType(TGoodsType tGoodsType);

    /**
     * 修改商品类型
     * 
     * @param tGoodsType 商品类型
     * @return 结果
     */
    public int updateTGoodsType(TGoodsType tGoodsType);

    /**
     * 批量删除商品类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTGoodsTypeByIds(String ids);

    /**
     * 删除商品类型信息
     * 
     * @param id 商品类型ID
     * @return 结果
     */
    public int deleteTGoodsTypeById(Long id);

    /**
     * 查询商品类型map
     * @return 商品类型集合
     */
    public List<Map<String,Long>> selectTGoodsTypeMap();
}
