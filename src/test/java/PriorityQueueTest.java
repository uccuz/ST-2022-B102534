import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;


import java.util.PriorityQueue;
import java.util.stream.Stream;

class PriorityQueueTest {

    static Stream<Arguments> streamProvider() {
        // Return stream
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{5, 6, 7, 8}, new int[]{5, 6, 7, 8}),
                Arguments.of(new int[]{2, 5, 4, 3}, new int[]{2, 3, 4, 5}),
                Arguments.of(new int[]{9, 8, 7, 6}, new int[]{6, 7, 8, 9}),
                Arguments.of(new int[]{9, 4, 8, 7}, new int[]{4, 7, 8, 9})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int [] correct_array) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] result = new int[random_array.length];

        // Random_array add to PriorityQueue
        for(int num : random_array) {
            pq.offer(num);
        }
        // Get PriorityQueue result
        for(int i = 0; pq.size()!=0; i++){
            result[i] = pq.poll();
        }
        assertArrayEquals(correct_array, result);
    }

    // 3 unique Exceptions
    @Test
    public void NullPointerExceptionTest() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue pq = new PriorityQueue(1);
            pq.offer(null);
        });
    }

    @Test
    public void IllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue pq = new PriorityQueue(0);
        });
    }

    @Test
    public void ClassCastExceptionTest() {
        assertThrows(ClassCastException.class, () -> {
            PriorityQueue pq = new PriorityQueue();
            pq.offer("hi");
            pq.offer(1234);
        });
    }

}