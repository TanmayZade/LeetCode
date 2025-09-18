import java.util.*;

class TaskManager {
    // taskId -> [userId, taskId, priority] (latest)
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
        int cmp = Integer.compare(b.get(2), a.get(2)); // higher priority first
        if (cmp == 0) return Integer.compare(b.get(1), a.get(1)); // then higher taskId
        return cmp;
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) {
            List<Integer> copy = new ArrayList<>(t);
            hm.put(copy.get(1), copy);
            pq.add(new ArrayList<>(copy));
        }
    }

    public void add(int userId, int taskId, int priority) {
        List<Integer> task = new ArrayList<>(Arrays.asList(userId, taskId, priority));
        hm.put(taskId, task);           // latest version
        pq.add(new ArrayList<>(task));  // add to PQ (old versions may remain)
    }

    public void edit(int taskId, int newPriority) {
        if (!hm.containsKey(taskId)) return;
        List<Integer> task = hm.get(taskId);
        task.set(2, newPriority);       // update latest
        pq.add(new ArrayList<>(task));  // push new version onto PQ
    }

    public void rmv(int taskId) {
        hm.remove(taskId);              // lazy-delete: mark removed
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            List<Integer> top = pq.poll();
            Integer taskId = top.get(1);
            List<Integer> latest = hm.get(taskId);

            if (latest == null) continue;                 // removed
            if (!latest.get(2).equals(top.get(2))) continue; // old priority

            // Valid: return the latest userId (not the possibly-stale top.get(0))
            hm.remove(taskId); // consume task
            return latest.get(0);
        }
        return -1;
    }
}
