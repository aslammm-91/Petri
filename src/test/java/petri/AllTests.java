package petri;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/** Lance tous les tests du projet. */
@Suite
@SelectClasses({TestPlace.class, TestTransition.class, TestArcEntrant.class, TestArcSortant.class,
        TestArcZero.class, TestArcVideur.class, TestReseauPetri.class})
public class AllTests {}
