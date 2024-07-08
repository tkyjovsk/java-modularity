package tkyjovsk.modularity.en;

import tkyjovsk.modularity.api.GreetingInterface;

public class EnglishGreeting implements GreetingInterface {

  @Override
  public String greet(String whom) {
    return String.format("Hello %s!", whom);
  }

}
