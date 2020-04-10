package simplefactory.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 单例模式创建工厂对象
 * @author yyq
 */
public class DatabaseFactory {
    private static DatabaseFactory databaseFactory;
    private static Map<String,IDatabaseService> serviceMap;

    // 单例模式创建工厂类
    public static synchronized DatabaseFactory getInstance() {
        if (databaseFactory == null) {
            databaseFactory = new DatabaseFactory();
            List<IDatabaseService> serverList = new ArrayList<>();
            serverList.add(new MysqlDatabaseService());
            serverList.add(new OracleDatabaseService());
            serviceMap = serverList.stream().collect(Collectors.toMap(IDatabaseService::getType, iDatabaseService -> iDatabaseService));
        }
        return databaseFactory;
    }
    public IDatabaseService getService(String type){
        return serviceMap.get(type);
    }
}
