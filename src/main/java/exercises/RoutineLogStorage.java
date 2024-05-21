package exercises;

import java.util.List;

public class RoutineLogStorage {
    private List<RoutineLog> routineLogs;

    public RoutineLogStorage(List<RoutineLog> routineLogs) {
        this.routineLogs = routineLogs;
    }

    public final void addLog(RoutineLog log) {
        routineLogs.add(log);
    }

    public final List<RoutineLog> getLogs() {
        return routineLogs;
    }
}
