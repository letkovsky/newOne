package MuitiThreds;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class OrderService {
    private HashMap<Long, Order> map = new HashMap<>();
    private Deque<Order> last = new LinkedList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();


    public void add(Order order) {
        try {
            lock.writeLock().lock();

            map.put(order.getId(), order);
            if (last.size() == 100) {
                last.removeLast();
            }
            last.addFirst(order);

        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
        }

    }


    public List<Order> findLast100() {
        try {
            lock.readLock().lock();

            return new ArrayList<>(last);
        } finally {
            lock.readLock().unlock();
        }
    }


    public Order getById(long id) {
        try {
            lock.readLock().lock();

            return map.get(id) != null ? map.get(id) : null;
        } finally {
            lock.readLock().unlock();
        }
    }


    public List<Order> getAll() {
        try {
            lock.readLock().lock();

            return new ArrayList<>(map.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void remove(Order order) {
        try {
            lock.writeLock().lock();

            map.remove(order.getId());
            last.remove(order);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void update(long id) {

        Order order = getById(id);
        // do some changes with order;


        try {
            lock.writeLock();
            map.put(order.getId(), order);

        } finally {
            lock.writeLock().unlock();
        }

    }


    public static void main(String[] args) {
        Thread thread1 = new Thread();
        int[] ints = new int[5];
        int length = ints.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

            list.add(0, i);
        }
        System.out.println(list);
        int[] ints1 = list.stream().mapToInt(Integer::intValue).toArray();
        int[] ints2 = list.stream().mapToInt(i -> i).toArray();


    }
}
