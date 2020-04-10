package simplefactory.database;

public class main {
    public static void main(String[] args) {
        String type = "mysql";
        DatabaseFactory.getInstance().getService(type).connectionDatabase();
        int TOTAL = 100;
        Thread evenThread = new Thread() {
            String type2;
            int i = 0;

            @Override
            public void run() {
                while (i <= TOTAL) {
                    if (i % 2 == 0){
                        type2 = "oracle";
                    }else {
                        type2 = "mysql";
                    }
                    DatabaseFactory.getInstance().getService(type2).connectionDatabase();
                    i ++ ;
                }
            }
        };
        evenThread.start();
    }
}
