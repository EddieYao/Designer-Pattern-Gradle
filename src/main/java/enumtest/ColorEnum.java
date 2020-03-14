package enumtest;

public class ColorEnum {
    public static void main(String[] args) {
        // 枚举类switch case
        enmuTest(ColorEnum2.BLACK);
        enmuTest2(DataBase.mysql);
        // 前端传入枚举类（字符串），可直接获取枚举数值
        System.out.println(DataBase.valueOf("mysql").returnCode());
        // 传入枚举类数值获取枚举类
        System.out.println("--------------");
        System.out.println(DataBase.getById(1));
        // 根据传入id获取值
        System.out.println(MessageEnum.getValueById(0));
    }

    public static void enmuTest(ColorEnum2 type) {
        switch (type) {
            case RED:
                System.out.println("red");
                break;
            case BLACK:
                System.out.println("black");
                break;
        }
    }

    public static void enmuTest2(DataBase type) {
        switch (type) {
            case mysql:
                System.out.println(type.returnCode());
                System.out.println("mysql");
                break;
            case oracle:
                System.out.println(type.returnCode());
                System.out.println("oracle");
                break;
            default:
                System.out.println("noResult");
                break;
        }
    }

    public enum ColorEnum2 {
        GREEN,
        RED,
        ORANGE,
        WHITE,
        BLACK
    }

    public enum DataBase {
        mysql(0),
        oracle(1);
        private int code;

        DataBase(int code) {
            this.code = code;
        }

        int returnCode() {
            return code;
        }

        public static DataBase getById(Integer id) {
            for (DataBase transactType : values()) {
                if (transactType.code == id) {
                    //获取指定的枚举
                    return transactType;
                }
            }
            return null;
        }
    }
    public enum MessageEnum {
        success_0(0,"success"),
        fail_1(1,"fial");
        private int code;
        private String message;

        MessageEnum(int code,String message) {
            this.code = code;
            this.message = message;
        }

        int returnCode() {
            return code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public static MessageEnum getEnumById(Integer id) {
            for (MessageEnum transactType : values()) {
                if (transactType.code == id) {
                    //获取指定的枚举
                    return transactType;
                }
            }
            return null;
        }
        public static String getValueById(Integer id) {
            for (MessageEnum transactType : values()) {
                if (transactType.code == id) {
                    //获取指定的枚举
                    return transactType.message;
                }
            }
            return null;
        }
    }
}