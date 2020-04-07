package singleton_pattern;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
public class SingletonDCL {
    private volatile static SingletonDCL singleton;
    private SingletonDCL (){}
    public static SingletonDCL getSingleton() {
        if (singleton == null) {
            synchronized (SingletonDCL.class) {
                if (singleton == null) {
                    singleton = new SingletonDCL();
                }
            }
        }
        return singleton;
    }
}