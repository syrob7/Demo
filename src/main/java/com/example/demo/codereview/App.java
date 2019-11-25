package com.example.demo.codereview;

public class App {

    public static void main(String[] args) {
    }
/*
    Example 1

    @Transactional
    public void deactivateUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        if(user != null) {
            user.setActive(false);
            session.update(user);
        }
    }


    Example 2

    @Transactional(readonly=true)
    public List<User> getListOfUsersWithoutPassword() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT u FROM User u", User.class);

        List<User> users = query.list();
        users
                .stream()
                .forEach(u -> u.setPassword(null)
                );

        return users;
    }
*/

}
