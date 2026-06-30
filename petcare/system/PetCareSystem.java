

package petcare.system;
import java.util.*;



public class PetCareSystem {
    static ArrayList<service> list = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
   
    public static void main(String[] args) {
     
   int choice = 0;
        fillList();
        System.out.println("\u001B[45m<<Wellcome to Pet care system>>");

        do {
            try {
                menu();
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        AddService();
                        break;
                    case 2:
                        removeService();
                        break;
                    case 3:
                        DisplyService();
                        break;
                    case 4:
                        newOrder();

                        break;
                    case 5:
                        showOrder();

                        break;
                    case 6:
                        cancelOrder();

                        break;
                    case 7:

                        Product_Purchase();

                        break;
                    case 8:
                        saveService();
                        break;
                    case 9:
                        readService();
                        break;
                    case 10:
                        GUI.main(null);
                        break;

                    default:
                        System.out.println("invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.err.println("InputMismatchException : invalid input");
                input.nextLine();
            } catch (NullPointerException e) {
                System.err.println("NullPointerException");
                input.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("ArrayIndexOutOfBoundsException");
                input.nextLine();
            } catch (Exception ex) {
                System.err.println(ex);
                input.nextLine();
            }

        } while (choice != 11);
    }    

public static void fillList() {
        service s1 = new VeterinaryService(1, "pet zone Veterinary clinic", "VeterinaryService", "Parvovirus");
        service s2 = new PlayingService(2, "playing time!!", "PlayingService", 5);
        list.add(s1);
        list.add(s2);
    }
public static void menu() {
        System.out.println("1. Add Service\n2. Remove Service\n3. Display Service\n4. New Order\n5. Show Order\n6. Cancel Order\n7. Product Purchase\n8. Save Orders\n9. Read From File\n10. GUI\n11. Exit");

    } 
 public static void AddService() {
        System.out.println("1. VeterinaryService\n2. PlayingService\nChoose service to add");
        int add = input.nextInt();

        if (add < 1 || add > 2) {
            System.out.println("Invalid choice ");
        } else {

            System.out.println("enter servicr NO: ");
            int SERVICE_NO = input.nextInt();
            System.out.println("enter service name: ");
            String ServiceName = input.next();
            System.out.println("enter service type: ");
            String ServiceType = input.next();

            if (add == 1) {
                System.out.println("enter vaccineName");
                String vaccineName = input.next();

                list.add(new VeterinaryService(SERVICE_NO, ServiceName, ServiceType, vaccineName));
                System.out.println("The service have been added");
            } else if (add == 2) {
                System.out.println("enter Play Time Duration meniutes ");
                int PlayTimeDuration = input.nextInt();
                list.add(new PlayingService(SERVICE_NO, ServiceName, ServiceType, PlayTimeDuration));
                System.out.println("The service have been added");
            }
        }

    } 
 public static void removeService() {
        System.out.println("enter index to remove: ");
        int index = input.nextInt();
        if (index < 0 || index >= list.size()) {
            System.out.println("invalid index");
        } else {
            list.remove(index);
            System.out.println("Done");

        }

    }
 public static void DisplyService() {
        for (service a : list) {

            
            System.out.println(a);

            a.CalcPrice();
            a.acceptableSpecies();
            System.out.println("----------------------------------------------");
            if (a instanceof PlayingService) {
                ((PlayingService) a).DisplayGamesList();
            } else if (a instanceof VeterinaryService) {
                ((VeterinaryService) a).ListVaccineOptions();
            }
            System.out.println("----------------------------------------------");
        }

    }
 
public static void newOrder() {
        System.out.println("enter the number of services you want ...(1..2) ");
        int number = input.nextInt();
        if (number < 1 || number > Buyable.MAX_SERVICE_PRICE) {
            System.out.println("invalid number!..");

        }
        service[] serv = new service[number];
        System.out.println("enter " + number + " service NO");

        int c = 0;
        while (c < number) {
            System.out.printf("\nenter service %d NO", (c + 1));
            int service_NO = input.nextInt();
            
            boolean isFound = false;
            for (service x : list) {
                if (x.getServiceNo() == service_NO) {
                    serv[c] = x;
                    isFound = true;
                    break;

                }
            }
            if (!isFound) {
                System.out.println("invalid serviceNO");
            } else {
                c++;
            }

        } 
        
        System.out.println("");
        System.out.println("Enter your pet name: ");
        String name = input.next();
        System.out.println("Enter your pet Species: ");
        String Species = input.next();
        System.out.println("Enter your pet gender: ");
        String gender = input.next();
        System.out.println("Enter your pet age: ");
        int age = input.nextInt();
         
        System.out.println("");
        System.out.println("Enter your name: ");
        String Oname = input.next();
        System.out.println("Ente your contactInfo: ");
        String contact = input.next();
        Owner o = new Owner(Oname, contact);
        Pet p = new Pet(name, Species, gender, age, o);

        Order or = new Order(serv, o, "");

        System.out.println("do you want to confirm your order? (Y,N): ");
        String ans = input.next();
        if (ans.equals("Y") || ans.equals("y")) {
            or.Orderverification();
            orderList.add(or);
            System.out.println(orderList);
        } else {
            or.Ordercancelation();
        }

    }



public static void showOrder() {
        System.out.println("Enter the order_id");
        int OrId = input.nextInt();
        boolean f = false;
        for (Order o : orderList) {
            if (o.getOrderId() == OrId) {
                System.out.println(o);
                f = true;
            }
            if (f == false) {
                System.out.println("the order id " + OrId + "is not found");
            }

        }
    }

 
 
 public static void cancelOrder() {
        System.out.println(" Enter the order_id ");
        int OrId = input.nextInt();
        boolean f = false;
        for (Order o : orderList) {
            if (o.getOrderId() == OrId) {
                o.Ordercancelation();
                System.out.println(o);
                f = true;
            }
            if (f == false) {
                System.out.println("the order id " + OrId + " is not found");
            }
        }
    }
 public static void Product_Purchase() {
        ArrayList<Item> item = new ArrayList<>();

        item.add(new Item(1, "Brush", 5));
        item.add(new Item(2, "shampo", 30));
        item.add(new Item(3, "dry food", 100));
        for (int i = 0; i < item.size(); i++) {
            System.out.println(i + ":" + item.get(i));
            System.out.println("-----------------------------");
        }
        System.out.println("enter the item index");
        int index = input.nextInt();
        if (index < 0 || index >= item.size()) {
            System.out.println("invalid index");
        } else {
            Item i = item.get(index);
            System.out.printf("the total of the items is : %.2f SR\n", i.CalcPrice());
            System.out.println("thanks for shoping!");
        }

    }
public static void saveService() {
        WriteText cf = new WriteText();
        cf.openTextFile("Services.txt");
        if (list.isEmpty()) {
            System.out.println("No services yet.");
        } else {
            for (service cl : list) {
                cf.writeToFile(cl);
            }
        }
        cf.closeFile();
        System.out.println("All services saved to the text file Services.txt");

    } 
 public static void readService() {

        ReadTextFile c = new ReadTextFile();
        c.openTextFile("Services.txt");
        c.readFromFile();
        c.closeFile();

    }
 
 
}


