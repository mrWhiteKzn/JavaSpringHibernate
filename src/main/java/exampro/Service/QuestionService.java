package exampro.Service;

import exampro.dao.QuestionDao;
import exampro.entity.QuestionEntity;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {


    QuestionDao questionDao;

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void delete(int id){
        questionDao.delete(id);
    }

    public QuestionEntity getQuestion(int id){
        return questionDao.getQuestion(id);
    }

    public void saveOrUpdate(QuestionEntity questionEntity) { questionDao.saveOrUpdate(questionEntity); }
}
