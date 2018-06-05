package exampro.service;

import exampro.entity.Result;
import exampro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Set;

@Service
public class ResultService {

    @Autowired
    TestService testService;


        Result result = new Result();
        public void saveTestResult(MultiValueMap<String,String> selectedAnswers, int testId) {

        result.setTestEntity(testService.getTestEntity(testId));
        result.setUser(new User("Dima", "White"));
        result.setSqlDate(new java.sql.Date(System.currentTimeMillis()));


        Set<String> keys = selectedAnswers.keySet();

        for(String key : keys){
        }
    }
}
