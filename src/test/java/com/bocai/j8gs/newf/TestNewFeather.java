package com.bocai.j8gs.newf;

import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class TestNewFeather {
    @Test
    public void testOptional() {
        final Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        final Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();
    }

    @Test
    public void testDateTime() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println();

        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);
        System.out.println();

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);
        System.out.println();

        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
        System.out.println(datetime);
        System.out.println(datetimeFromClock);
        System.out.println();

        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDatetime);
        System.out.println(zonedDatetimeFromClock);
        System.out.println(zonedDatetimeFromZone);
        System.out.println();

        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println();
    }

    @Test
    public void testBase64() {
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);
    }

    @Test
    public void testParallelArrays() {
        final int len = 10_000_000;
        final Long[] arrayOfLong1 = new Long[len];

        Arrays.parallelSetAll(arrayOfLong1, index -> ThreadLocalRandom.current().nextLong(1000000));
        final Long[] arrayOfLong2 = Arrays.copyOf(arrayOfLong1, len);

        Arrays.stream(arrayOfLong1).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();

        final long start1 = Clock.systemUTC().millis();
        Arrays.sort(arrayOfLong1);
        final long end1 = Clock.systemUTC().millis();
        Arrays.stream(arrayOfLong1).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();

        final long start2 = Clock.systemUTC().millis();
        Arrays.parallelSort(arrayOfLong2);
        final long end2 = Clock.systemUTC().millis();
        Arrays.stream(arrayOfLong2).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("Arrays.sort cost " + (end1 - start1) + "ms, Arrays.parallelSort cost " + (end2 - start2) + "ms");
    }
}
