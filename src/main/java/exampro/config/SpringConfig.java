package exampro.config;

import exampro.config.core.SecurityWebApplicationInitializer;
import exampro.dao.*;
import exampro.dao.implementions.*;
import exampro.entity.*;
import exampro.reports.Reports;
import exampro.service.UserService;
import exampro.service.UserServiceImp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
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
@PropertySource("classpath:application.properties")
@ComponentScan("exampro")
public class SpringConfig extends WebMvcConfigurerAdapter implements EnvironmentAware {

    @Autowired
    Environment env;

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
        sessionFactory.setAnnotatedClasses(AnswerEntity.class,
                QuestionEntity.class,
                ResultDetailEntity.class,
                ResultEntity.class,
                TestEntity.class,
                UserEntity.class);
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    private final Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return hibernateProperties;
    }

    @Bean
    public org.springframework.jdbc.datasource.DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public PropertyPlaceholderConfigurer getLocaltions() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application.properties"));
        return ppc;
    }

    @Bean
    public CustomizeAuthenticationSuccessHandler getCustomizeAuthenticationSuccessHandler() {
        return new CustomizeAuthenticationSuccessHandler();
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImp();
    }

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/js/");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
