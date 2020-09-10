package com.sapient.filereader.service;

import com.sapient.filereader.entity.USStatesEntity;

import java.util.List;

public interface CovidDataService {

    List<USStatesEntity> getUSStates();

    List<USStatesEntity> getUSData();
}
