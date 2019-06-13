package com.pactera.jep.service.base.web.controller;

import com.pactera.jep.autoconfigure.web.controller.BaseRestController;
import com.pactera.jep.orm.Filter;
import com.pactera.jep.orm.Order;
import com.pactera.jep.orm.Page;
import com.pactera.jep.core.exception.ServiceException;
import com.pactera.jep.service.base.model.RoomHouseInfo;
import com.pactera.jep.service.base.service.RoomHouseInfoService;
import com.pactera.jep.web.code.WebCode;
import com.pactera.jep.web.code.WebHeaderCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roomHouseInfo")
public class RoomHouseInfoRestController extends BaseRestController<RoomHouseInfo> {
    private static Logger logger = LoggerFactory.getLogger(RoomHouseInfoRestController.class);

    @Autowired
    private RoomHouseInfoService service;

    /**
     * 为列表页面做数据准备
     */
    @Override
    protected void prepareQuery(@ApiIgnore @RequestHeader(WebHeaderCode.X_USER_TOKEN) String token, Page<RoomHouseInfo> page, List<Filter> filters, List<Order> orders, HttpServletRequest request) {
        service.query(page, filters, orders);
    }

    @ApiOperation(value = "保存一条数据")
	@PostMapping(value = "/save")
	public Map<String, Object> save(@RequestBody RoomHouseInfo saveInfo) {
		Map<String, Object> tips = new HashMap<>();

		try
		{
			boolean	 exists = service.exists(new Filter.Builder().eq("id", saveInfo.getId()).build());
			if(exists)
			{
				service.update(saveInfo);
				tips.put(WebCode.SUCCESS, true);
				tips.put(WebCode.MSG, WebCode.SUCCESS_SAVE);
			}else {
				service.insert(saveInfo);
				tips.put(WebCode.SUCCESS, true);
				tips.put(WebCode.MSG, WebCode.SUCCESS_SAVE);
			}
		}
		catch (ServiceException e)
		{
			logger.error("error:",e);
			tips.put(WebCode.SUCCESS, false);
			tips.put(WebCode.MSG, WebCode.FAILURE_SAVE);
		}
		return tips;
	}

	/**
	 * 删除
	 * @param id id
	 * @return map
	 */
	@ApiOperation(value = "根据编码删除一条数据")
	@DeleteMapping(value = "/remove/{id}")
	public Map<String, Object> remove(@PathVariable String id){
		Map<String, Object> tips = new HashMap<>();
		try
		{
			service.deleteByPrimaryKey(id);
			tips.put(WebCode.SUCCESS, true);
			tips.put(WebCode.MSG, WebCode.SUCCESS_DELETE);
		}
		catch (ServiceException e)
		{
			logger.error("error:",e);
			tips.put(WebCode.SUCCESS, false);
			tips.put(WebCode.MSG, WebCode.FAILURE_DELETE);
		}
		return tips;
	}
}
