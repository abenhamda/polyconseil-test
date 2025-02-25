package fr.polyconseil;

public class Process {

    private final String pid;
    private final int start;
    private int time;

    public String getPid() {
        return pid;
    }

    public int getStart() {
        return start;
    }

    public int getTime() {
        return time;
    }

    public void decrimentTime() {
        this.time--;
    }

    public boolean isNotFinished() {
        return this.time > 0;
    }

    public Process(String pid, int start, int time) {
        this.pid = pid;
        this.start = start;
        this.time = time;
    }

    @Override
    public String toString() {
        return STR."Process{pid='\{pid}', start=\{start}, time=\{time}}";
    }
}
