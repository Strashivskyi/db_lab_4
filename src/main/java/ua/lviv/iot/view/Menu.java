package ua.lviv.iot.view;

public class Menu {
    public void displayMenu() {
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("                 Enter your XY to choose the option, where:");
        System.out.println("////////////////////////////////////////////////////////////////////////");
        System.out.println("  X - entity number:               |         Y - CRUD number:");
        System.out.println("  1 - amusement park               |         1 - GET ALL");
        System.out.println("  2 - attraction                   |         2 - GET ONE");
        System.out.println("  3 - city                         |         3 - CREATE");
        System.out.println("  4 - client                       |         4 - UPDATE");
        System.out.println("  5 - employee                     |         5 - DELETE");
        System.out.println("  6 - position");
        System.out.println("  7 - region");
        System.out.println("  8 - ticket");
        System.out.println("E.G. 12 = get one amusement park");
        System.out.println("     45 = delete a client");
        System.out.println("     83 = create a ticket");
        System.out.println("=======================================================================");
    }
}
