package behavior.template;

//核心是骨架的设计，将某些操作延迟到子类实现
public abstract class AbstractSetting {
    public final String getSetting(String key) {//final 防止子类重写
        String value = lookupCache(key);
        if (value == null) {
            value = key;
            putIntoCache(key, value);
        }
        return value;
    }

    protected abstract String lookupCache(String key);//只有子类能实现

    protected abstract void putIntoCache(String key, String value);
}
