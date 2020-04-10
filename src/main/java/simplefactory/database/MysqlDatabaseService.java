package simplefactory.database;

public class MysqlDatabaseService implements IDatabaseService {

    private String type = "mysql";

    @Override
    public void connectionDatabase(){
        System.out.println("连接mysql数据库");
    }

    @Override
    public String getType(){
        return type;
    }
}
