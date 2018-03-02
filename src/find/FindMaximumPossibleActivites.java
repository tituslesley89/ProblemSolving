package find;

import util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaximumPossibleActivites {

    private static int findMaxiumPossibilities(List<Activity> activities) {
        if(activities.size() == 1) {

        }

        List<Activity> possibleActivities = new ArrayList<>();
        int currentTime = activities.get(0).getEndTime();
        possibleActivities.add(activities.get(0));

        for(int i=1; i<activities.size();i++) {
            if(currentTime <= activities.get(i).getStartTime()) {
                possibleActivities.add(activities.get(i));
                currentTime = activities.get(i).getEndTime();
            }
        }

        ConsoleUtil.println("Maximum possible activities that can be performed:");
        printActivies(possibleActivities);
        return possibleActivities.size();
    }

    private static void printActivies(List<Activity> activities) {
        ConsoleUtil.print("{");
        activities.forEach(activity -> {
            ConsoleUtil.print("\t"+activity.getStartTime()+",");
        });
        ConsoleUtil.print("}\n{");
        activities.forEach(activity -> {
            ConsoleUtil.print("\t"+activity.getEndTime()+",");
        });
        ConsoleUtil.print("}\n");
    }

    private static void runTest(List<Integer> startTimes, List<Integer> endTimes) {
        ConsoleUtil.println("Available Activates:");
        List<Activity> activities = Activity.createActivityFromList(startTimes, endTimes);
        findMaxiumPossibilities(activities);
    }

    public static void main(String[] args) {
        runTest(Arrays.asList(10, 12, 20), Arrays.asList(20,25,30));
        runTest(Arrays.asList(1, 3, 0, 5, 8, 5), Arrays.asList(2, 4, 6, 7, 9, 9));
    }
}
