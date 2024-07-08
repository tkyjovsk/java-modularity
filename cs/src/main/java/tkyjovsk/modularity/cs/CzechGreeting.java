package tkyjovsk.modularity.cs;

import tkyjovsk.modularity.api.GreetingInterface;

public class CzechGreeting implements GreetingInterface {

  @Override
  public String greet(String whom) {
    return String.format("Ahoj %s!", whom);
  }

}
