// Invoker — triggers commands without knowing what they do
public class RemoteControl {
    private Command command;

    public void setCommand(Command c) { command = c; }
    public void pressButton() { command.execute(); }
}
