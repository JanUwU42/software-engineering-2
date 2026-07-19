// Invoker — triggers commands without knowing what they do
public class RemoteControl {
    private Command command;
    private Command lastCommand;

    public void setCommand(Command c) { command = c; }
    public void pressButton() { command.execute(); lastCommand = command; }
    public void pressUndo()   { lastCommand.undo(); }
}
