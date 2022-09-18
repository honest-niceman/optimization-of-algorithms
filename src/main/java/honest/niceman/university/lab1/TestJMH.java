package honest.niceman.university.lab1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@Fork(value = 1)
@Measurement(iterations = 3)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
public class TestJMH {
    public static final int SIZE = 1_000_000;
    public static final Main M = new Main();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestJMH.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    private final int[] arr1 = new int[SIZE];
    private final int[] arr2 = new int[SIZE];

    @Setup
    public void setup() {
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt();
        }
    }

    @Benchmark
    public void JavaHashSet() {
        M.findIntersection(arr1, arr2);
    }

    @Benchmark
    public void MyHashSet() {
        M.findIntersectionMySet(arr1, arr2);
    }
}
