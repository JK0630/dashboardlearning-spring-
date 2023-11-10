package kr.ac.kopo.dashboard.service;

import kr.ac.kopo.dashboard.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonService {
    private final CommonMapper commonMapper;
    public CommonService(CommonMapper commonMapper){
        this.commonMapper = commonMapper;
    }
    public Map<String,Object> getInoutStatus() {
        Map<String, Object> map = new HashMap<>();

        List<Map<String,Object>> list = commonMapper.selectInoutStatus();
        map.put("list", list);

        int totalDlcin= 0;
        int totalDlcout= 0;

        int totalPmcin= 0;
        int totalPmcout= 0;

        for (int i = 0; i <list.size(); i++) {
            totalDlcin += (int)list.get(i).get("dlc_in");
            totalDlcout += (int)list.get(i).get("dlc_out");

            totalPmcin += (int)list.get(i).get("pmc_in");
            totalPmcout += (int)list.get(i).get("pmc_out");
        }

        map.put("totalDlcin",totalDlcin);
        map.put("totalDlcout",totalDlcout);
        map.put("totalPmcin",totalPmcin);
        map.put("totalPmcout",totalPmcout);

        return map;
    }
}
