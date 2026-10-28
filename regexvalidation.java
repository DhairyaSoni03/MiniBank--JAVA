import java.util.regex.*;

class Validator {
    public static boolean isValidMobile(String s) {
        return s.matches("[6-9]\\d{9}");
    }

    public static boolean isValidEmail(String s) {
        return s.matches("[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}");
    }

    public static boolean isValidPan(String s) {
        return s.matches("[A-Z]{5}[0-9]{4}[A-Z]");
    }

    public static boolean isValidIfsc(String s) {
        return s.matches("[A-Z]{4}0[A-Z0-9]{6}");
    }
}
enum TransactionType { DEPOSIT, WITHDRAW, TRANSFER }

record Command(TransactionType type, String accountNumber, long amount) {}


class CommandParser {
    public static Command parse(String line) {
        String[] parts = line.trim().split("\\s+");
        TransactionType type = TransactionType.valueOf(parts[0].toUpperCase());
        String accountNumber = parts[1];
        long amount = Long.parseLong(parts[2]);
        return new Command(type, accountNumber, amount);
    }
}

class Account {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public Account(String accountNumber, String holderName, long balance) {
        this.accountNumber = accountNumber;
        this.ownerName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return ownerName; }
    public double getBalance() { return balance; }
}


class StatementFormatter {
    public static String buildStatement(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("---- MiniBank Statement ----\n");
        sb.append("Account No : ").append(account.getAccountNumber()).append("\n");
        sb.append("Holder     : ").append(account.getHolderName()).append("\n");
        sb.append("Balance    : ").append(account.getBalance()).append("\n");
        sb.append("-----------------------------");
        return sb.toString();
    }
}


public class regexvalidation {
    public static void main(String[] args) {
        System.out.println("Mobile valid   : " + Validator.isValidMobile("9876543210"));
        System.out.println("Mobile invalid : " + Validator.isValidMobile("12345"));

        System.out.println("Email valid    : " + Validator.isValidEmail("test@example.com"));
        System.out.println("Email invalid  : " + Validator.isValidEmail("test@@com"));

        System.out.println("PAN valid      : " + Validator.isValidPan("ABCDE1234F"));
        System.out.println("PAN invalid    : " + Validator.isValidPan("ABCD1234F"));

        System.out.println("IFSC valid     : " + Validator.isValidIfsc("HDFC0001234"));
        System.out.println("IFSC invalid   : " + Validator.isValidIfsc("HDFC1234"));

        Command cmd = CommandParser.parse("DEPOSIT AC0001 500");
        System.out.println("Type   : " + cmd.type());
        System.out.println("Acc No : " + cmd.accountNumber());
        System.out.println("Amount : " + cmd.amount());

        Account acc = new Account("AC0001", "Brahma", 1500);
        System.out.println(StatementFormatter.buildStatement(acc));
    }
}