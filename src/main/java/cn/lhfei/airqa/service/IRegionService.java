package cn.lhfei.airqa.service;

import java.util.List;

import cn.lhfei.airqa.entity.Region;


public interface IRegionService {
	List<Region> findRegion(int level,int pid);
}
