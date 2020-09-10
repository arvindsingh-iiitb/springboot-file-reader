package com.sapient.filereader.service;

import com.sapient.filereader.entity.USStatesEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataServiceImpl implements CovidDataService{

    @Override
    public List<USStatesEntity> getUSStates() {

        CSVParser parser;
        List<USStatesEntity> usStatesEntities = new ArrayList<>();

        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

        try {
            parser = new CSVParser(new FileReader("C:\\Users\\arvsingh\\Desktop\\covid-19-data-master\\covid-19-data-master\\us-states.csv"), format);

            parser.forEach(record->{
                USStatesEntity usStatesEntity = new USStatesEntity();
                usStatesEntity.setDate(record.get("date"));
                usStatesEntity.setState(record.get("state"));
                usStatesEntity.setFips(record.get("fips"));
                usStatesEntity.setCases(record.get("cases"));
                usStatesEntity.setDeaths(record.get("deaths"));

                usStatesEntities.add(usStatesEntity);
            });

        } catch (IOException e) {
            System.out.println(e);
        }

        return usStatesEntities;
    }

    @Override
    public List<USStatesEntity> getUSData() {

        CSVParser parser;
        List<USStatesEntity> usStatesEntities = new ArrayList<>();

        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

        try {
            parser = new CSVParser(new FileReader("C:\\Users\\arvsingh\\Desktop\\covid-19-data-master\\covid-19-data-master\\us.csv"), format);

            parser.forEach(record->{
                USStatesEntity usStatesEntity = new USStatesEntity();
                usStatesEntity.setDate(record.get("date"));
                usStatesEntity.setCases(record.get("cases"));
                usStatesEntity.setDeaths(record.get("deaths"));

                usStatesEntities.add(usStatesEntity);
            });

        } catch (IOException e) {
            System.out.println(e);
        }

        return usStatesEntities;
    }
}
