package enumTest;

public class ColorEnum {
    public static void main(String[] args) {
        enmuTest(ColorEnum2.BLACK);
        enmuTest2(DataBase.mysql);
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
    }
}