import org.chocosolver.cutoffseq.GeometricalCutoffStrategy;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        Model m = new Model();
        IntVar[] vars = m.intVarArray(200, 0, 100);
        List<IntVar> varsList = Arrays.asList(vars);
        for (int i = 0; i < 25; i++) {
            Collections.shuffle(varsList);
            m.allDifferent(varsList.subList(0, 4).toArray(new IntVar[]{})).post();
        }

        Solver s = m.getSolver();
        s.setNoGoodRecordingFromRestarts();
        s.setRestarts(c -> s.getFailCount() > c, new GeometricalCutoffStrategy(10, 1.1), 100);
        while (s.solve()) {}
        s.printShortStatistics();
    }

}
