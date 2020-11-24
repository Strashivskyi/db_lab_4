package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    private final AmusementParkController amusementParkController = new AmusementParkController();
    private final AttractionController attractionController = new AttractionController();
    private final CityController cityController = new CityController();
    private final ClientController clientController = new ClientController();
    private final EmployeeController employeeController = new EmployeeController();
    private final PositionController positionController = new PositionController();
    private final RegionController regionController = new RegionController();
    private final TicketController ticketController = new TicketController();


    private final Map<String, Printable> menu = new LinkedHashMap<>();

    public View() {
        menu.put("11", this::getAllAmusementParks);
        menu.put("12", this::getAmusementParkById);
        menu.put("13", this::createAmusementPark);
        menu.put("14", this::updateAmusementPark);
        menu.put("15", this::deleteAmusementPark);

        menu.put("21", this::getAllAttractions);
        menu.put("22", this::getAttractionById);
        menu.put("23", this::createAttraction);
        menu.put("24", this::updateAttraction);
        menu.put("25", this::deleteAttraction);

        menu.put("31", this::getAllCities);
        menu.put("32", this::getCityById);
        menu.put("33", this::createCity);
        menu.put("34", this::updateCity);
        menu.put("35", this::deleteCity);

        menu.put("41", this::getAllClients);
        menu.put("42", this::getClientById);
        menu.put("43", this::createClient);
        menu.put("44", this::updateClient);
        menu.put("45", this::deleteClient);

        menu.put("51", this::getAllEmployees);
        menu.put("52", this::getEmployeeById);
        menu.put("53", this::createEmployee);
        menu.put("54", this::updateEmployee);
        menu.put("55", this::deleteEmployee);

        menu.put("61", this::getAllPositions);
        menu.put("62", this::getPositionById);
        menu.put("63", this::createPosition);
        menu.put("64", this::updatePosition);
        menu.put("65", this::deletePosition);

        menu.put("71", this::getAllRegions);
        menu.put("72", this::getRegionById);
        menu.put("73", this::createRegion);
        menu.put("74", this::updateRegion);
        menu.put("75", this::deleteRegion);

        menu.put("81", this::getAllTickets);
        menu.put("82", this::getTicketById);
        menu.put("83", this::createTicket);
        menu.put("84", this::updateTicket);
        menu.put("85", this::deleteTicket);

    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nChoose your option:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllAmusementParks() throws SQLException {
        System.out.println("\n[AMUSEMENT PARK / GET]");
        System.out.println(amusementParkController.findAll() + "\n");
    }

    private void getAmusementParkById() throws SQLException {
        System.out.println("\n[AMUSEMENT PARK / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(amusementParkController.findOne(id) + "\n");
    }

    private AmusementPark getAmusementParkInputs() {
        System.out.println("Enter capacity: ");
        Integer capacity = SCANNER.nextInt();
        System.out.println("Enter address: ");
        String adress = SCANNER.next();
        System.out.println("\nEnter amusement park name: ");
        String name = SCANNER.next();
        System.out.println("Enter city id: ");
        Integer cityId = SCANNER.nextInt();

        return new AmusementPark(capacity, adress, name, cityId);
    }

    private void createAmusementPark() throws SQLException {
        System.out.println("\n[AMUSEMENT PARK / CREATE]");
        AmusementPark amusementPark = getAmusementParkInputs();
        amusementParkController.create(amusementPark);
        System.out.println("AmusementPark was created\n");
    }

    private void updateAmusementPark() throws SQLException {
        System.out.println("\n[AMUSEMENT PARK / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        AmusementPark amusementPark = getAmusementParkInputs();
        amusementPark.setId(id);

        amusementParkController.update(amusementPark.getId(), amusementPark);
        System.out.println("AmusementPark with ID=" + id + " was updated\n");
    }

    private void deleteAmusementPark() throws SQLException {
        System.out.println("\n[AMUSEMENT PARK / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        amusementParkController.delete(id);
        System.out.println("AmusementPark with ID=" + id + " was deleted\n");
    }


    //    ATTRACTION
    private void getAllAttractions() throws SQLException {
        System.out.println("\nGETting Attraction...");
        System.out.println(attractionController.findAll() + "\n");
    }

    private void getAttractionById() throws SQLException {
        System.out.println("\nGETting Attraction... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(attractionController.findOne(id) + "\n");
    }

    private Attraction getAttractionInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter description: ");
        String description = SCANNER.next();
        System.out.println("\nEnter capacity in person number: ");
        Integer capacity = SCANNER.nextInt();
        System.out.println("\nEnter id of the amusement park: ");
        Integer amusementParkId = SCANNER.nextInt();
        System.out.println("\nEnter minimum age: ");
        Integer minimumAge = SCANNER.nextInt();
        return new Attraction(name, description, capacity, amusementParkId, minimumAge);
    }

    private void createAttraction() throws SQLException {
        System.out.println("\nCREATing Attraction...");
        Attraction attraction = getAttractionInputs();
        attractionController.create(attraction);
        System.out.println("Hurrey! Created a Attraction\n");
    }

    private void updateAttraction() throws SQLException {
        System.out.println("\nUPDATing Attraction... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Attraction attraction = getAttractionInputs();
        attraction.setId(id);

        attractionController.update(attraction.getId(), attraction);
        System.out.println("Updated Attraction with ID=" + id + " \n");
    }

    private void deleteAttraction() throws SQLException {
        System.out.println("\nDELETing Attraction... Enter ID: ");
        int id = SCANNER.nextInt();

        attractionController.delete(id);
        System.out.println("Deleted Attraction with ID=" + id + " \n");
    }


    //City
    private void getAllCities() throws SQLException {
        System.out.println("\nGETting city...");
        System.out.println(cityController.findAll() + "\n");
    }

    private void getCityById() throws SQLException {
        System.out.println("\nGETting City... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(attractionController.findOne(id) + "\n");
    }

    private City getCityInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter region id: ");
        Integer regionId = SCANNER.nextInt();

        return new City(regionId, name);
    }

    private void createCity() throws SQLException {
        System.out.println("\nCREATing City...");
        City city = getCityInputs();
        cityController.create(city);
        System.out.println("Hurrey! Created a City\n");
    }

    private void updateCity() throws SQLException {
        System.out.println("\nUPDATing City... Enter ID: ");
        Integer id = SCANNER.nextInt();
        City city = getCityInputs();
        city.setId(id);

        cityController.update(city.getId(), city);
        System.out.println("Updated City with ID=" + id + " \n");
    }

    private void deleteCity() throws SQLException {
        System.out.println("\nDELETing City... Enter ID: ");
        int id = SCANNER.nextInt();

        attractionController.delete(id);
        System.out.println("Deleted City with ID=" + id + " \n");
    }

    //Client
    private void getAllClients() throws SQLException {
        System.out.println("\nGETting city...");
        System.out.println(clientController.findAll() + "\n");
    }

    private void getClientById() throws SQLException {
        System.out.println("\nGETting City... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(clientController.findOne(id) + "\n");
    }

    private Client getClientInputs() {
        System.out.println("\nEnter first name: ");
        String firstName = SCANNER.next();
        System.out.println("\nEnter last name: ");
        String lastName = SCANNER.next();
        System.out.println("\nEnter birthday: ");
        String birthday = SCANNER.next();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        System.out.println("\nEnter gender: ");
        String gender = SCANNER.next();
        System.out.println("\nEnter city id: ");
        Integer cityId = SCANNER.nextInt();


        return new Client(firstName, lastName, birthday, address, gender, cityId);
    }

    private void createClient() throws SQLException {
        System.out.println("\nCREATing Client...");
        Client client = getClientInputs();
        clientController.create(client);
        System.out.println("Hurrey! Created a Client\n");
    }

    private void updateClient() throws SQLException {
        System.out.println("\nUPDATing Client... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Client client = getClientInputs();
        client.setId(id);

        clientController.update(client.getId(), client);
        System.out.println("Updated Client with ID=" + id + " \n");
    }

    private void deleteClient() throws SQLException {
        System.out.println("\nDELETing Client... Enter ID: ");
        int id = SCANNER.nextInt();

        clientController.delete(id);
        System.out.println("Deleted Client with ID=" + id + " \n");
    }


    //Position
    private void getAllPositions() throws SQLException {
        System.out.println("\n[Position / GET]");
        System.out.println(positionController.findAll() + "\n");
    }

    private void getPositionById() throws SQLException {
        System.out.println("\n[Position / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(positionController.findOne(id) + "\n");
    }

    private Position getPositionInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter description: ");
        String description = SCANNER.next();


        return new Position(name, description);
    }

    private void createPosition() throws SQLException {
        System.out.println("\n[Position / CREATE]");
        Position position = getPositionInputs();
        positionController.create(position);
        System.out.println("Position was created\n");
    }

    private void updatePosition() throws SQLException {
        System.out.println("\n[Position / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Position position = getPositionInputs();
        position.setId(id);

        positionController.update(position.getId(), position);
        System.out.println("Position with ID=" + id + " was updated\n");
    }

    private void deletePosition() throws SQLException {
        System.out.println("\n[Position / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        positionController.delete(id);
        System.out.println("Position with ID=" + id + " was deleted\n");
    }

    //Region
    private void getAllRegions() throws SQLException {
        System.out.println("\n[Region / GET]");
        System.out.println(regionController.findAll() + "\n");
    }

    private void getRegionById() throws SQLException {
        System.out.println("\n[region / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(regionController.findOne(id) + "\n");
    }

    private Region getRegionInputs() {
        System.out.println("\nEnter region name: ");
        String name = SCANNER.next();

        return new Region(name);
    }

    private void createRegion() throws SQLException {
        System.out.println("\n[Region / CREATE]");
        Region region = getRegionInputs();
        regionController.create(region);
        System.out.println("Region was created\n");
    }

    private void updateRegion() throws SQLException {
        System.out.println("\n[Region / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Region region = getRegionInputs();
        region.setId(id);

        regionController.update(region.getId(), region);
        System.out.println("region with ID=" + id + " was updated\n");
    }

    private void deleteRegion() throws SQLException {
        System.out.println("\n[Region / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        regionController.delete(id);
        System.out.println("Region with ID=" + id + " was deleted\n");
    }

    //Employee
    private void getAllEmployees() throws SQLException {
        System.out.println("\n[Employee / GET]");
        System.out.println(employeeController.findAll() + "\n");
    }

    private void getEmployeeById() throws SQLException {
        System.out.println("\n[Employee / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(employeeController.findOne(id) + "\n");
    }

    private Employee getEmployeeInputs() {
        System.out.println("\nEnter phone number: ");
        String phoneNumber = SCANNER.next();
        System.out.println("\nEnter email: ");
        String email = SCANNER.next();
        System.out.println("\nEnter birthday: ");
        String birthday = SCANNER.next();
        System.out.println("\nEnter gender: ");
        String gender = SCANNER.next();
        System.out.println("\nEnter position id: ");
        Integer positionId = SCANNER.nextInt();
        System.out.println("Enter first name: ");
        String firstName = SCANNER.next();
        System.out.println("Enter last name: ");
        String lastName = SCANNER.next();
        System.out.println("Enter city id: ");
        Integer cityId = SCANNER.nextInt();
        System.out.println("Enter amusement park id: ");
        Integer amusementParkId = SCANNER.nextInt();

        return new Employee(phoneNumber, email, birthday, gender, positionId, firstName, lastName, cityId, amusementParkId);
    }

    private void createEmployee() throws SQLException {
        System.out.println("\n[Employee / CREATE]");
        Employee employee = getEmployeeInputs();
        employeeController.create(employee);
        System.out.println("Employee was created\n");
    }

    private void updateEmployee() throws SQLException {
        System.out.println("\n[Employee / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Employee employee = getEmployeeInputs();
        employee.setId(id);

        employeeController.update(employee.getId(), employee);
        System.out.println("Employee with ID=" + id + " was updated\n");
    }

    private void deleteEmployee() throws SQLException {
        System.out.println("\n[Employee / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        employeeController.delete(id);
        System.out.println("Employee with ID=" + id + " was deleted\n");
    }

    //Ticket
    private void getAllTickets() throws SQLException {
        System.out.println("\n[Ticket / GET]");
        System.out.println(ticketController.findAll() + "\n");
    }

    private void getTicketById() throws SQLException {
        System.out.println("\n[Ticket / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ticketController.findOne(id) + "\n");
    }

    private Ticket getTicketInputs() {
        System.out.println("\nEnter arrival time: ");
        String arrivalTime = SCANNER.next();
        System.out.println("\nEnter departure time: ");
        String departureTime = SCANNER.next();
        System.out.println("\nEnter people number: ");
        Integer peopleNumber = SCANNER.nextInt();
        System.out.println("\nEnter kids nu,ber: ");
        Integer kidsNumber = SCANNER.nextInt();
        System.out.println("\nEnter price: ");
        Integer priceInUSD = SCANNER.nextInt();
        System.out.println("Enter client id: ");
        Integer clientId = SCANNER.nextInt();
        System.out.println("Enter amusement park id: ");
        Integer amusementParkId = SCANNER.nextInt();
        System.out.println("Enter payment time: ");
        String paymentTime = SCANNER.next();

        return new Ticket(arrivalTime, departureTime, peopleNumber, kidsNumber, priceInUSD, clientId, amusementParkId, paymentTime);
    }

    private void createTicket() throws SQLException {
        System.out.println("\n[Ticket / CREATE]");
        Ticket ticket = getTicketInputs();
        ticketController.create(ticket);
        System.out.println("Ticket was created\n");
    }

    private void updateTicket() throws SQLException {
        System.out.println("\n[Ticket / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Ticket ticket = getTicketInputs();
        ticket.setId(id);

        ticketController.update(ticket.getId(), ticket);
        System.out.println("Ticket with ID=" + id + " was updated\n");
    }

    private void deleteTicket() throws SQLException {
        System.out.println("\n[ticket / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        ticketController.delete(id);
        System.out.println("ticket with ID=" + id + " was deleted\n");
    }
}
