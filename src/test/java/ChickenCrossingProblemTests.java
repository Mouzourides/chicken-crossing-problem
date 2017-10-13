import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class ChickenCrossingProblemTests {
    ChickenCrossingProblem chickenCrossingProblem;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        chickenCrossingProblem = new ChickenCrossingProblem();
        chickenCrossingProblem.leftSide.clear();
        chickenCrossingProblem.rightSide.clear();
        chickenCrossingProblem.leftSide.add(Items.MAN);
        chickenCrossingProblem.leftSide.add(Items.FOX);
        chickenCrossingProblem.leftSide.add(Items.CHICKEN);
        chickenCrossingProblem.leftSide.add(Items.CORN);
    }


    @Test
    public void InvalidParametersTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 004: Invalid parameters");
        chickenCrossingProblem.move(Items.CORN);
    }

    @Ignore("Remove to run test")
    @Test
    public void InvalidParameters2Test() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 004: Invalid parameters");
        chickenCrossingProblem.move(Items.CORN, Items.CHICKEN);
    }

    @Ignore("Remove to run test")
    @Test
    public void MoveFoxRightTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 003: CHICKEN will eat the CORN");
        chickenCrossingProblem.move(Items.MAN, Items.FOX);
    }

    @Ignore("Remove to run test")
    @Test
    public void MoveCornRightTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 002: FOX will eat the CHICKEN");
        chickenCrossingProblem.move(Items.MAN, Items.CORN);
    }

    @Ignore("Remove to run test")
    @Test
    public void MoveManRightTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 001: CHICKEN will eat CORN and then FOX will eat the CHICKEN");
        chickenCrossingProblem.move(Items.MAN);
    }

    @Ignore("Remove to run test")
    @Test
    public void InvalidMoveTest() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Error 005: Invalid move");
        chickenCrossingProblem = new ChickenCrossingProblem();
        chickenCrossingProblem.move(Items.MAN, Items.CHICKEN);
        chickenCrossingProblem.move(Items.MAN, Items.CORN);
    }

    @Ignore("Remove to run test")
    @Test
    public void SolutionTest(){
        Set<Items> testSet = new HashSet<>();
        testSet.add(Items.MAN);
        testSet.add(Items.CHICKEN);
        testSet.add(Items.FOX);
        testSet.add(Items.CORN);
        try {
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN, Items.CHICKEN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN, Items.FOX);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN, Items.CHICKEN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN, Items.CORN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            chickenCrossingProblem.move(Items.MAN, Items.CHICKEN);
            System.out.println("Left: " + chickenCrossingProblem.getLeft() + "\nRight: " + chickenCrossingProblem.getRight() + "\n");

            assertEquals(testSet, chickenCrossingProblem.getRight());
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}


