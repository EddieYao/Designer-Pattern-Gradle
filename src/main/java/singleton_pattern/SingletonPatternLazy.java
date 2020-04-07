package singleton_pattern;

/**
 * 懒汉式，线程安全
 */
public class SingletonPatternLazy {
    private static SingletonPatternLazy instance;

    private SingletonPatternLazy() {
    }

    public static synchronized SingletonPatternLazy getInstance() {
        if (instance == null) {
            instance = new SingletonPatternLazy();
        }
        return instance;
    }

}
