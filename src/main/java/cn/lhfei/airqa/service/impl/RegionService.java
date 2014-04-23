package cn.lhfei.airqa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhfei.airqa.dao.IRegionDao;
import cn.lhfei.airqa.entity.Region;
import cn.lhfei.airqa.service.IRegionService;

@Service
public class RegionService implements IRegionService {

	@Autowired
	private IRegionDao regionDao;

	@Override
	public List<Region> findRegion(int level, int pid) {
		return regionDao.findRegion(level, pid);
	}
}
