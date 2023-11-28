package behavior.command;

//把服务端执行命令和调用方发送命令分开
//一般如果要支持undo 和 redo 时使用此模式最佳
public interface Command {
    void execute();
}
