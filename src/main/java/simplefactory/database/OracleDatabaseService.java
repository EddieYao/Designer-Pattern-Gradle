package simplefactory.database;

public class OracleDatabaseService implements IDatabaseService {

    private String type = "oracle";
    @Override
    public void connectionDatabase(){
        System.out.println("连接oracle数据库");
    }

    @Override
    public String getType(){
        return type;
    }
}
