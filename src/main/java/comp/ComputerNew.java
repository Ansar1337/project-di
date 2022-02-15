package comp;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.*;

@ApplicationScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerNew implements IComputer {

    private String name;
    private IMouse mouse;
    @NonNull
    protected IMonitor monitor; // в эту переменную будет подставлен конкретный объект (это может быть неизвестно самой переменной)

    @Override
    public void on() {
        System.out.println("Компьютер включился " + name + ", используется монитор " + monitor.getName());
    }

    @Override
    public void off() {
        System.out.println("Компьютер выключился " + name + ", используется монитор " + monitor.getName());
    }
}