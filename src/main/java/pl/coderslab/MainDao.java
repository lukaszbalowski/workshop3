package pl.coderslab;

public class MainDao {

    public static void main(String[] args) {

 UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("Mieczyslaw");
        user.setEmail("mieciu@email.com");
        userDao.create(user);
//
//        UserDao userDao = new UserDao();
//        User user = new User();
//
//        User[] all = userDao.findAll();
//        for (User u : all) {
//            System.out.println(u);
//        }




    }


}
