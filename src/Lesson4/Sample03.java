package Lesson4;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Sample03 {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     *
     * 5,6,7,8,10 - необязательные, опциональные задания.
     *
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {

        Core core = new Core(); //Backend

        MobileApp mobileApp = new MobileApp(core.getCustomerProvider(), core.getTicketProvider()); //Forntend
        mobileApp.searchTicket(new Date());
        Collection<Ticket> tickets = mobileApp.getTickets();
        mobileApp.buyTicket("1000000000001111");
        mobileApp.buyTicket("1000000000001111");
        mobileApp.buyTicket("1000000000001111");
        BusStation busStation = new BusStation(core.getTicketProvider());

    }

}

class Customer {
    private static int counter;
    private int id;
    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }
}

class Ticket{
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }
}

class Core{
    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core(){
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public PaymentProvider getPaymentProvider() {
        return paymentProvider;
    }

    public Database getDatabase() {
        return database;
    }
}

/**
 * База данных
 */
class Database{

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return ++counter;
    }

}

class TicketProvider{

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider){
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date){
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()){
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;
    }

    public boolean buyTicket(int clientId, String cardNo){
        double amount = database.getTicketAmount();
        int orderId = database.createTicketOrder(clientId);
        return paymentProvider.buy(orderId, cardNo, amount);
    }

    public boolean checkTicket(String qrcode){
        for (Ticket ticket : database.getTickets()){
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                return true;
            }
        }
        return false;
    }

}

class CustomerProvider{

    private final Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password){
        // Проверка логина и пароля
        //return database.getCustomers().stream().findFirst().get();
        return new Customer();
    }

}

class PaymentProvider {


    /**
     * Формирование заявки на проведение платежа
     * @param orderId
     * @param cardNo
     * @param amount
     * @return
     */
    public boolean buy(int orderId, String cardNo, double amount){

        // Посылаем запрос в процессинговую компанию, проводим платеж (ProcessingCompany)
        return true;
    }

}

/**
 * Мобильное приложение
 */
class MobileApp{

    private final Customer customer;
    private final TicketProvider ticketProvider;


    public MobileApp(CustomerProvider customerProvider, TicketProvider ticketProvider){
        this.ticketProvider = ticketProvider;
        customer = customerProvider.getCustomer("login", "password");
    }

    public void searchTicket(Date date){
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public Collection<Ticket> getTickets(){
        return customer.getTickets();
    }

    public boolean buyTicket(String cardNo){
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}

/**
 * Автобусная станция
 */
class BusStation {

    //TODO: 1. Доработать приложение (BusStation)
    //TODO: 2. Опишите контракты для любого модуля, например, TicketProvider.
    private TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public void setTicketProvider(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    /**Метод проверяет билет
     * @param qrCode
     */

    public void checkTicket(String qrCode){
        if (ticketProvider.checkTicket(qrCode)){
            System.out.println("Проходите!");
        }else {
            System.out.println("Вы не можете пройти!");
        }
    }
}

class ProcessingCompany{

    private Collection<Bank> banks = new ArrayList<>();

}

class Bank{

}





