package exampro.dao;

import exampro.entity.TestEntity;
import java.util.List;

public interface TestDao {

    TestEntity getTest(int id);

    List<TestEntity> getAll();

    void saveOrUpdate(TestEntity testEntity);

    void delete(int id);

}
