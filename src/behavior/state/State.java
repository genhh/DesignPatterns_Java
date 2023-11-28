package behavior.state;

public interface State {//把不同状态的逻辑分离到不同的状态类中
    public String init();
    public String reply(String input);
}
