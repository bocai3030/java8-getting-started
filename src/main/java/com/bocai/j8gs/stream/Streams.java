package com.bocai.j8gs.stream;

public class Streams {
    public enum Status {
        OPEN, CLOSED
    };

    public static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return this.points;
        }

        public Status getStatus() {
            return this.status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", this.status, this.points);
        }
    }
}
