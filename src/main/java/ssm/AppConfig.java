package ssm;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // 表示这是一个配置类
@ComponentScan(basePackages = "ssm") // 扫描ssm包下的组件类
@EnableWebMvc
@PropertySource({"classpath:jdbc.properties"})
@MapperScan("ssm.dao.mapper") // 扫描此包下的所有mapper接口并注册实现bean
@EnableTransactionManagement 
public class AppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 假设控制器返回"customers"，则做如下拼接确定jsp路径
		// "/WEB-INF/jsp/" + "customers" + ".jsp"
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	@Bean
	@Primary // 首选
	public DataSource testDataSource(Environment env) { // 数据源的初始化依赖配置环境
		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driverClass = env.getProperty("jdbc.driver");
		
		DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// GET    /assets/bootstrap/css/bootstrap.min.css
		// 资源路径    /public/bootstrap/css/bootstrap.min.css
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
		registry.addResourceHandler("/customer-pictures/**").addResourceLocations("file:///D:/zhujunqi/upload/");
	}
	@Bean
	public MultipartResolver multipartResolver() { // 文件名必须要这么写，因为spring mvc会用这个id查找多部解析器
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(10 * 1024 * 1024); // 字节
		return mr;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(dataSource);
		return sf;
	}
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
