# ReadMe

The project aims to reproduce a bug in the module `choco-sat` of the Choco solver.

## Commands

The command to build the project is:
```bash
gradle build
```

The command to run the project is:
```bash
java -cp build/libs/chocobug-1.0-SNAPSHOT.jar Example
```

The execution should return the error:
```
Exception in thread "main" java.lang.IllegalAccessError: class org.chocosolver.solver.constraints.nary.sat.PropNogoods tried to access field org.chocosolver.sat.SatSolver.ok_ (org.chocosolver.solver.constraints.nary.sat.PropNogoods and org.chocosolver.sat.SatSolver are in unnamed module of loader 'app')
	at org.chocosolver.solver.constraints.nary.sat.PropNogoods.propagate(PropNogoods.java:156)
	at org.chocosolver.solver.propagation.PropagationEngine.execute(PropagationEngine.java:225)
	at org.chocosolver.solver.propagation.PropagationEngine.activatePropagators(PropagationEngine.java:209)
	at org.chocosolver.solver.propagation.PropagationEngine.propagate(PropagationEngine.java:173)
	at org.chocosolver.solver.search.loop.propagate.PropagateBasic.execute(PropagateBasic.java:46)
	at org.chocosolver.solver.Solver.initialize(Solver.java:367)
	at org.chocosolver.solver.Solver.solve(Solver.java:255)
	at Example.main(Example.java:24)
```

The interesting files are:
`org.chocosolver.solver.constraints.nary.sat.PropNogoods.java` of the module `choco-solver` and `SatSolver` of the module `choco-sat`.

