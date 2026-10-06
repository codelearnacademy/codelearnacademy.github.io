package es.educacion.orm.config;
import jakarta.persistence.*; import java.nio.file.Path; import java.util.*;
public final class EntityManagerFactories {
    private EntityManagerFactories(){}
    public static EntityManagerFactory from(Path properties){ return Persistence.createEntityManagerFactory("sqlitePU",new OrmConfig(properties).toJpaProperties()); }
    public static EntityManagerFactory forTest(Path db){ Map<String,Object> m=new HashMap<>();m.put("jakarta.persistence.jdbc.driver","org.sqlite.JDBC");m.put("jakarta.persistence.jdbc.url","jdbc:sqlite:"+db);m.put("hibernate.dialect","org.hibernate.community.dialect.SQLiteDialect");m.put("hibernate.hbm2ddl.auto","create");m.put("hibernate.show_sql","false");return Persistence.createEntityManagerFactory("sqlitePU",m); }
}