package kr.ac.kopo.dashboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonMapper {
    List<Map<String, Object>> selectInoutStatus();
}
