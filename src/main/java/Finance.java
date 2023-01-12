

import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;
import java.util.Map;

public class Finance {


  public final static String BEST_LOAN_RATES = "bestLoanRates";
  public final static String SAVINGS_CALCULATOR = "savingsCalculator";
  public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

  public final static Map<String, String> commandsToUsage = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
      SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
      MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");

  private static boolean validateCommandArguments(String[] args){

    int len;
    int three = 3;
//    String
    switch (commandsToUsage.get(args[0])){
      case BEST_LOAN_RATES:  len = 1;
        break;
      case SAVINGS_CALCULATOR: len = three;
        break;
      case MORTGAGE_CALCULATOR: len = 4;
        break;
  }return false;
  }
  private static void executeCommand(String command, String[] arguments){
    switch (command){
      case BEST_LOAN_RATES:  System.out.println("Finding best loan rates ...");
        BestLoanRates.main(arguments);
        return;
      case SAVINGS_CALCULATOR: System.out.println("Finding your net savings ...");

        SavingsCalculator.main(arguments);
        return;
      case MORTGAGE_CALCULATOR: System.out.println("Finding your monthly payment ...");
        MortgageCalculator.main(arguments);
        return;
    }

  }
  public static void main(String[] args) {
    String command = args[0];
    boolean isValidCommand = validateCommandArguments(args);
    if (!commandsToUsage.containsKey(command)) {
      System.out.println(command + ": command not found");
      return;
    }
    if (!isValidCommand) {
      commandsToUsage.get(args[0]);
      return;
    }
//    for (int i = 1, Arrays.copyOfRange(validateCommandArguments(args,1,args.length)) > i, i++){
//      executeCommand(command, args[i]);
//    }
  }

}
