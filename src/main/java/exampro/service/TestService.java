package exampro.service;

import exampro.containerClasses.TestContainer;
import exampro.dao.AnswerDao;
import exampro.dao.QuestionDao;
import exampro.dao.TestDao;
import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    private TestDao testDao;
    private QuestionDao questionDao;
    private AnswerDao answerDao;

    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TestEntity getTestEntity(int id){
        return testDao.getTest(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TestContainer getTestContainer(int id){
        TestEntity testEntity = testDao.getTest(id);
        List<QuestionEntity> questionEntityList = questionDao.getAllByTestId(testEntity);
        return new TestContainer(testEntity, questionEntityList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<TestEntity> findAll() {
        return testDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(TestContainer testContainer){
        testDao.saveOrUpdate(testContainer.getTestEntity());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(int id) {
        testDao.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(QuestionEntity questionEntity, int id) {
        questionDao.saveOrUpdate(questionEntity, id);

        for (AnswerEntity answerEntity : questionEntity.getAnswerEntityList()) {
            answerEntity.setQuestionEntity(questionEntity);
            answerDao.saveOrUpdate(answerEntity, questionEntity);
        }
    }
}
