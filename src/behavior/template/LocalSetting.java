package behavior.template;

public class LocalSetting extends AbstractSetting{//用map作为缓存的设置
    @Override
    protected String lookupCache(String key) {
        return null;
    }

    @Override
    protected void putIntoCache(String key, String value) {

    }
}
