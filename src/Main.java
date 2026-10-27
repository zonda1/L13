import java.util.*;

class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> uniqCountries = new HashSet<>();
        Address add1 = new Address("Russia", "Moscow");
        Address add2 = new Address("Poland", "Warsaw");
        Address add3 = new Address("China", "Urumchi");

        costPerAddress.put(add1, 20);
        costPerAddress.put(add2, 25);
        costPerAddress.put(add3, 40);

        int total = 0;

        while (true) {
            System.out.println();
            System.out.println("Заполнение нового заказа.");
            System.out.println("Введите страну: ");
            String country = scanner.nextLine();
            System.out.println("Введите город: ");
            String city = scanner.nextLine();
            System.out.println("Введите вес (кг): ");
            String weight = scanner.nextLine();

//            System.out.println("input Address obj: " + new Address(country, city));
            boolean success = false;
//            for (Address key : costPerAddress.keySet()) {
//                System.out.println("- " + key);
//                if (key.equals(new Address(country, city))) {
//                    success = true;
//                    int sum = costPerAddress.get(key) * Integer.parseInt(weight);
//                    total += sum;
//                    System.out.println("Стоимость доставки составит: " + sum + " руб.");
//                    System.out.println("Общая стоимость всех доставок: " + total + " руб.");
//                    break;
//                }
//            }

            for (Map.Entry<Address, Integer> kv : costPerAddress.entrySet()) {
//                System.out.println("- " + kv.getKey());
                if (kv.getKey().equals(new Address(country, city))) {
                    success = true;
                    int sum = kv.getValue() * Integer.parseInt(weight);
                    total += sum;
                    uniqCountries.add(country);
                    System.out.println("Стоимость доставки составит: " + sum + " руб.");
                    System.out.println("Общая стоимость всех доставок: " + total + " руб.");
                    System.out.println("Количество уникальных стран куда были оформлены доставки: " + uniqCountries.size());
                    break;
                }
            }
            if (!success) System.out.println("Доставки по этому адресу нет");
        }
    }
}