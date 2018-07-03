package exampro.config;

import exampro.config.core.SecurityWebApplicationInitializer;
import exampro.dao.*;
import exampro.dao.implementions.*;
import exampro.entity.*;
import exampro.reports.Reports;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@Import({SecurityWebApplicationInitializer.class})
@ComponentScan("exampro")
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setPrefix("");
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreemarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views");
        return freeMarkerConfigurer;
    }

    @Bean
    public TestDao getTestDao() {
        return new TestDaoImp();
    }

    @Bean
    public QuestionDao getQuestionDao() {
        return new QuestionDaoImp();
    }

    @Bean
    public AnswerDao getAnswerDao() {
        return new AnswerDaoImp();
    }

    @Bean
    public ResultDao getResultDao() {
        return new ResultDaoImp();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public org.springframework.jdbc.datasource.DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.5.248:3306/exams?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234567");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImp();
    }

    @Bean
    public Reports getReports() {
        return new Reports();
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[]{"examPro"});
        sessionFactory.setAnnotatedClasses(AnswerEntity.class, QuestionEntity.class, ResultDetailEntity.class, ResultEntity.class, TestEntity.class, UserEntity.class);
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    public CustomizeAuthenticationSuccessHandler getCustomizeAuthenticationSuccessHandler() {
        return new CustomizeAuthenticationSuccessHandler();
    }

    private final Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return hibernateProperties;
    }

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
    }
}
