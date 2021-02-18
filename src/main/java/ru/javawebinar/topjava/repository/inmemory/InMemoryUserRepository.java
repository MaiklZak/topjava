package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private final Map<Integer, User> usersMap = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return usersMap.remove(id) != null;
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        if (user.getId() == null) {
            int id = counter.incrementAndGet();
            user.setId(id);
        }
        return usersMap.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return usersMap.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        List<User> list = new ArrayList<>(usersMap.values());
        list.sort(Comparator.comparing(User::getName).thenComparing(User::getEmail));
        return list;
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        return usersMap.values().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
