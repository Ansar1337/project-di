package comp;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.*;

@ApplicationScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Computer implements IComputer {

    private String name;
    private IMouse mouse;
    @NonNull
    protected IMonitor monitor; // a specific object will be substituted into this variable (this may not be known to the variable itself)

    @Inject
    public Computer(IMouse mouse, IMonitor monitor) {
        this.mouse = mouse;
        this.monitor = monitor;
    }

    @Override
    public void on() {
        System.out.println("Компьютер включился " + name + ", используется монитор " + monitor.getName());
    }

    @Override
    public void off() {
        System.out.println("Компьютер выключился " + name + ", используется монитор " + monitor.getName());
    }
}