package es.educacion.orm.config;
import es.educacion.orm.repository.RepositoryException;
import java.io.*; import java.nio.file.*; import java.util.*;
public final class OrmConfig {
    private final Properties p=new Properties();
    public OrmConfig(Path path){ try(InputStream in=Files.newInputStream(path)){p.load(in);}catch(IOException e){throw new RepositoryException("Error leyendo configuración ORM: "+path,e);} }
    public String get(String key){String v=p.getProperty(key);if(v==null) throw new IllegalArgumentException("No existe la propiedad: "+key);return v;}
    public Map<String,Object> toJpaProperties(){ Map<String,Object> m=new HashMap<>(); m.put("jakarta.persistence.jdbc.driver","org.sqlite.JDBC");m.put("jakarta.persistence.jdbc.url",get("database.url"));m.put("hibernate.dialect",get("hibernate.dialect"));m.put("hibernate.hbm2ddl.auto",get("hibernate.hbm2ddl.auto"));m.put("hibernate.show_sql",get("hibernate.show_sql"));m.put("hibernate.format_sql",get("hibernate.format_sql"));return m; }
}