package com.ruoyi.market.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.market.domain.TOutbound;
import com.ruoyi.market.service.ITOutboundService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库单Controller
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@Controller
@RequestMapping("/system/outbound")
public class TOutboundController extends BaseController
{
    private String prefix = "market/outbound";

    @Autowired
    private ITOutboundService tOutboundService;

    @RequiresPermissions("system:outbound:view")
    @GetMapping()
    public String outbound()
    {
        return prefix + "/outbound";
    }

    /**
     * 查询出库单列表
     */
    @RequiresPermissions("system:outbound:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TOutbound tOutbound)
    {
        startPage();
        List<TOutbound> list = tOutboundService.selectTOutboundList(tOutbound);
        return getDataTable(list);
    }

    /**
     * 导出出库单列表
     */
    @RequiresPermissions("system:outbound:export")
    @Log(title = "出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TOutbound tOutbound)
    {
        List<TOutbound> list = tOutboundService.selectTOutboundList(tOutbound);
        ExcelUtil<TOutbound> util = new ExcelUtil<TOutbound>(TOutbound.class);
        return util.exportExcel(list, "outbound");
    }

    /**
     * 新增出库单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出库单
     */
    @RequiresPermissions("system:outbound:add")
    @Log(title = "出库单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TOutbound tOutbound)
    {
        return toAjax(tOutboundService.insertTOutbound(tOutbound));
    }

    /**
     * 修改出库单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TOutbound tOutbound = tOutboundService.selectTOutboundById(id);
        mmap.put("tOutbound", tOutbound);
        return prefix + "/edit";
    }

    /**
     * 修改保存出库单
     */
    @RequiresPermissions("system:outbound:edit")
    @Log(title = "出库单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TOutbound tOutbound)
    {
        return toAjax(tOutboundService.updateTOutbound(tOutbound));
    }

    /**
     * 删除出库单
     */
    @RequiresPermissions("system:outbound:remove")
    @Log(title = "出库单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tOutboundService.deleteTOutboundByIds(ids));
    }
}
