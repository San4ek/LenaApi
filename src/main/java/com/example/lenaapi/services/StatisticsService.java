package com.example.lenaapi.services;

import com.example.lenaapi.entites.Active;
import com.example.lenaapi.models.StatisticsModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {

    private ActiveService activeService;

    public List<StatisticsModel> getAll() {

        List<StatisticsModel> statisticsModels=new ArrayList<>();

        for (Active.Type type : Active.Type.values()) {
             long writeOffValue=activeService.getCount(type, true);
             long inUsingValue=activeService.getCount(type, false);

             statisticsModels.add(new StatisticsModel(writeOffValue, inUsingValue, type.getName()));

             System.out.println(statisticsModels);
        }

        return statisticsModels;
    }
}
