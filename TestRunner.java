import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestRunner {

   static JUnitCore junitCore;

   public static class MyListener extends RunListener {

      public void testRunStarted(final Description description) throws Exception {
         System.out.println("Number of tests to execute: " + description.testCount() + "\n");
      }

      public void testRunFinished(final Result result) throws Exception {
         System.out.println("\nNumber of tests executed: " + result.getRunCount() + "\n");
      }

      public void testStarted(final Description description) throws Exception {
         System.out.println("Starting >>> : " + description.getMethodName());
      }

      public void testFinished(final Description description) throws Exception {
         System.out.println("Finished <<< : " + description.getMethodName());
      }

      public void testFailure(final Failure failure) throws Exception {
         System.out.println("***** Failed : " + failure.getDescription().getMethodName());
      }

      public void testAssumptionFailure(final Failure failure) {
         System.out.println("***** Failed : " + failure.getDescription().getMethodName());
      }

      public void testIgnored(final Description description) throws Exception {
         System.out.println("***** Ignored : " + description.getMethodName());
      }
   }

   public static void main(final String[] args) {

      System.out.println("Running Junit Test Suite to validate LagestWord module.");
      junitCore = new JUnitCore();
      junitCore.addListener(new MyListener());

      final Result result = junitCore.run(LargestWordTestCases.class);

      for (final Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println("\nFinal Test Result:" + result.wasSuccessful());
   }
}