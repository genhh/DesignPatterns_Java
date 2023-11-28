package behavior.command;

public class AddCommand implements Command{
    TextEditor textEditor;
    public AddCommand(TextEditor textEditor){
        this.textEditor = textEditor;
    }
    @Override
    public void execute() {
        textEditor.add("add success");
        System.out.println("add success");
    }
}
