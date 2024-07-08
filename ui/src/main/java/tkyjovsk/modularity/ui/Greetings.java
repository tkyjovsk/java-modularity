package tkyjovsk.modularity.ui;

import java.util.ServiceLoader;
import tkyjovsk.modularity.api.GreetingInterface;

public class Greetings {

  public static void main(String[] args) {
    String person = "Tomas";
    ServiceLoader<GreetingInterface> services = ServiceLoader.load(GreetingInterface.class);
    if (!services.iterator().hasNext()) {
      throw new RuntimeException("No service implementations were found.");
    }
    for (GreetingInterface greetingService : services) {
      System.out.println(greetingService.greet(person));
    }
  }
}
