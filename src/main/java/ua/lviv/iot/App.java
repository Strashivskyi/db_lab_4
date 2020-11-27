package ua.lviv.iot;

import org.hibernate.Session;
import ua.lviv.iot.util.HibernateUtil;
import ua.lviv.iot.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
