import tkyjovsk.modularity.api.GreetingInterface;
import tkyjovsk.modularity.cs.CzechGreeting;

module tkyjovsk.modularity.cs {
  requires tkyjovsk.modularity.api;
  exports tkyjovsk.modularity.cs;
  provides GreetingInterface with CzechGreeting;
}
