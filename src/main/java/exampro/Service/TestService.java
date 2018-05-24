package exampro.Service;

import exampro.containerClasses.TestContainer;
import exampro.dao.QuestionDao;
import exampro.dao.TestDao;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    @Autowired
    QuestionDao questionDao;

    public TestContainer getTestContainer(int id){
        TestEntity testEntity = testDao.getTest(id);
        List<QuestionEntity> questionEntityList = questionDao.getAllByTestId(testEntity);
        TestContainer testContainer = new TestContainer(testEntity, questionEntityList);
        return testContainer;
    }

    public List<TestEntity> findAll() {
        return testDao.getAll();
    }

    public void saveOrUpdate(TestContainer testContainer){
        testDao.saveOrUpdate(testContainer.getTestEntity());
    }

    public void delete(int id) {
        testDao.delete(id);
    }
}
