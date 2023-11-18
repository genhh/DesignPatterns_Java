package create.singleton;

public class Singleton {
    //Java 双重检测有可能会导致崩溃，有可能会有两个引用短时间内创建成功，
    //1饿汉式
    /*
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }*/

    //2懒汉式 线程不安全
    /*
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null)instance = new Singleton();
        return instance;
    }*/

    //3懒汉式 线程安全
    /*
    private static Singleton instance = null;
    private Singleton(){}
    public synchronized static Singleton getInstance(){
        if(instance==null)instance = new Singleton();
        return instance;
    }*/

    //4 双重校验，java不安全
    private static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    //5 唯一枚举
    public enum World{
        instance;
        private String name = "world";
        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
