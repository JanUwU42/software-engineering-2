// Concrete Command — encapsulates "turn light off" as an object
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) { this.light = light; }

    public void execute() { light.off(); }
}
