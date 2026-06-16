public class Main {

    // --- Receiver ---
    static class Light {
        void on()  { System.out.println("Light is ON"); }
        void off() { System.out.println("Light is OFF"); }
    }

    // --- Command Interface ---
    interface Command { void execute(); }

    // --- Concrete Commands ---
    static class LightOnCommand implements Command {
        private final Light light;
        LightOnCommand(Light light) { this.light = light; }
        public void execute() { light.on(); }
    }

    static class LightOffCommand implements Command {
        private final Light light;
        LightOffCommand(Light light) { this.light = light; }
        public void execute() { light.off(); }
    }

    // --- Invoker ---
    static class RemoteControl {
        private Command command;
        void setCommand(Command c) { command = c; }
        void pressButton() { command.execute(); }
    }

    // --- Demo ---
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}
