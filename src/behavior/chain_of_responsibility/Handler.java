package behavior.chain_of_responsibility;

public interface Handler {
    Boolean process(Request request);//true成功 false失败 null交给下一级
}
