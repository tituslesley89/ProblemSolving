package find;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Activity {

    private int startTime,
    endTime;

    public Activity() {
    }

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public static List<Activity> createActivityFromList(List<Integer> startTimes, List<Integer> endTimes) {
        if(startTimes.size()!=endTimes.size())
            return new ArrayList<>();

        List<Activity> activityList = new ArrayList<>();

        IntStream.range(0,startTimes.size()).forEach(i -> {
            activityList.add(new Activity(startTimes.get(i), endTimes.get(i)));
        });
        return activityList;
    }
}
