package algorithms.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

/**
 * https://www.techiedelight.com/find-number-of-customers-who-could-not-get-any-computer/<p>
 * <p>
 * Given an integer representing the capacity of a cyber cafe and a sequence representing entry/exit logs of customers, <p>
 * find the total number of customers who could not get any computer.
 **/

public class CyberCafe {

    public int countUnattendedCustomers(String customerLogs, int capacity) {
        if (capacity == 0 || Objects.isNull(customerLogs) || customerLogs.isBlank()) {
            return 0;
        }

        var customerLogsCollection = customerLogs.split("");
        var customerQueue = new LinkedList<String>();
        var computerUsers = new ArrayList<String>(capacity);
        int unhappyCustomerCount = 0;

        for (String customer : customerLogsCollection) {
            var inLine = customerQueue.contains(customer);
            var usingComputer = computerUsers.contains(customer);


            if (usingComputer) {
                computerUsers.remove(customer);
                Optional.ofNullable(customerQueue.poll())
                        .ifPresent(computerUsers::add);

            } else if (inLine) {

                unhappyCustomerCount++;
                System.out.println("Customer " + customer + " left unhappy");
                customerQueue.remove(customer);

            } else if (computerUsers.size() < capacity) {
                computerUsers.add(customer);
            } else {
                customerQueue.offer(customer);
            }

        }

        return unhappyCustomerCount;
    }
}
