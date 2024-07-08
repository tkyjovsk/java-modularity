import tkyjovsk.modularity.api.GreetingInterface;
import tkyjovsk.modularity.en.EnglishGreeting;

module tkyjovsk.modularity.en {
  requires tkyjovsk.modularity.api;
  exports tkyjovsk.modularity.en;
  provides GreetingInterface with EnglishGreeting;
}
