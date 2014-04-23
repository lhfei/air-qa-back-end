package cn.lhfei.airqa.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lhfei.airqa.entity.Region;
import cn.lhfei.airqa.service.IRegionService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController {

	private static final Logger logger = LoggerFactory
			.getLogger(RegionController.class);

	@RequestMapping(value = "/findRegion")
	public @ResponseBody
	List<Region> findRegion(int pid, int level) {
		return regionService.findRegion(level, pid);
	}

	@Autowired
	private IRegionService regionService;

}
