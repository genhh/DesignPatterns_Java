package behavior.template;


public class RedisSetting extends AbstractSetting {//用redis做缓存的相关设置
    @Override
    protected String lookupCache(String key) {
        return null;
    }

    @Override
    protected void putIntoCache(String key, String value) {

    }
}
