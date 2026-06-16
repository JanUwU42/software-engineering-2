public class Main {

    // --- Receiver ---
    static class Light {
        private final String location;

        Light(String location) { this.location = location; }

        void on()  { System.out.println(location + " light is ON"); }
        void off() { System.out.println(location + " light is OFF"); }
    }

    // --- Command Interface ---
    interface Command {
        void execute();
        void undo();
    }

    // --- Concrete Commands ---
    static class LightOnCommand implements Command {
        private final Light light;

        LightOnCommand(Light light) { this.light = light; }

        public void execute() { light.on(); }
        public void undo()    { light.off(); }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        LightOffCommand(Light light) { this.light = light; }

        public void execute() { light.off(); }
        public void undo()    { light.on(); }
    }

    // --- Invoker ---
    static class RemoteControl {
        private Command command;

        void setCommand(Command command) { this.command = command; }
        void pressButton() { command.execute(); }
        void pressUndo()   { command.undo(); }
    }

    // --- Demo ---
    public static void main(String[] args) {
        Light livingRoom = new Light("Living Room");

        Command lightOn  = new LightOnCommand(livingRoom);
        Command lightOff = new LightOffCommand(livingRoom);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();   // Living Room light is ON

        remote.setCommand(lightOff);
        remote.pressButton();   // Living Room light is OFF

        remote.pressUndo();     // Living Room light is ON
    }
}
