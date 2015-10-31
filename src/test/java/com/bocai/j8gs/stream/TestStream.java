package com.bocai.j8gs.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.bocai.j8gs.stream.Streams.Status;
import com.bocai.j8gs.stream.Streams.Task;

public class TestStream {
    @Test
    public void testStream() {
        final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));

        final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        System.out.println("Total points: " + totalPointsOfOpenTasks);

        final double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()).reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        final Collection<String> result = tasks.stream().mapToInt(Task::getPoints).asLongStream().mapToDouble(points -> points / totalPoints).boxed().mapToLong(weigth -> (long) (weigth * 100))
                .mapToObj(percentage -> percentage + "%").collect(Collectors.toList());
        System.out.println(result);
    }
}
