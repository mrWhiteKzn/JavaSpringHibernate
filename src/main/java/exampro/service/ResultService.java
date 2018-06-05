package exampro.service;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Set;

@Service
public class ResultService {

    @Autowired
    TestService testService;

    @Autowired
    ResultDao resultDao;



    public void saveTestResult(MultiValueMap<String, String> selectedAnswers, int testId) {

        ResultEntity result = new ResultEntity();

        result.setTestEntity(testService.getTestEntity(testId));
        result.setUserEntity(new UserEntity("Dima", "White"));
        result.setSqlDate(new java.sql.Date(System.currentTimeMillis()));

        Set<String> keys = selectedAnswers.keySet();

        for(String key : keys){
            ResultDetailEntity resultDetailEntity = new ResultDetailEntity();

            //остановился тут
            resultDetailEntity.setAnswerEntity();
            System.out.println("KEY: " + key);
            System.out.println("VALUE: "+selectedAnswers.get(key));
        }

        resultDao.saveResult(result);

        for (String key : keys) {
        }
    }
}
