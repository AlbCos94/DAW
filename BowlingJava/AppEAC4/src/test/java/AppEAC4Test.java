import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 *
 * @author ioc
 */
public class AppEAC4Test {

    private final static String MESSAGE_ASK_ANYTHING = "Introdueixi alguna cosa";
    private final static String MESSAGE_ERROR = "Error en la entrada";
    private final static String MESSAGE_TEST_INPUT = "This message tests the input";
    private final static float FLOAT_TEST_INPUT = 6.3f;
    private final static int INT_TEST_INPUT = 6;    
    private final static int TEST_PLAYERS_NUMBER = 2;
    public static final int POINTS_NO_PLAYED = -1;
    public static final int INDEX_NAME = 0;
    public static final int INDEX_LAST_NAME = 1;
    public static final int INDEX_AGE = 2;
    public static final int THROWS_NUMBER = 10;
    public static final int MAX_POINTS = 10;
    public static final int PLAYERS_MATRIX_COLUMNS = 3;

    private static AppEAC4 appEAC4;

    int[][] pointsMatrix;
    String[][] playersData;

    public AppEAC4Test() {
    } 

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        appEAC4 = new AppEAC4();
    }
    
    @AfterEach
    public void tearDown() {
    }

    private void provideInput(String data) {
        if (data != null) {
            ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
        }
    }   

    /**
     * Test of initializePoints method, of class AppBowling.
     */
    @Test
    public void testInitializePointsOK() {
        System.out.println("initializePoints");
        pointsMatrix = appEAC4.initializePoints(TEST_PLAYERS_NUMBER);        assertEquals(TEST_PLAYERS_NUMBER, pointsMatrix.length);
        assertEquals(THROWS_NUMBER, pointsMatrix[0].length);
        for (int[] row: pointsMatrix) {
            for (int point: row) {
                assertEquals(POINTS_NO_PLAYED, point);
            }
        }
    }

    @Test
    public void testInitializePointsNullIfPlayersNegative() {
        System.out.println("initializePoints");
        int playersNumber = -1;
        appEAC4.initializePoints(playersNumber);
        assertNull(pointsMatrix);
    }

    /**
     * Test of initializePlayers method, of class AppBowling.
     */
    @Test
    public void testInitializePlayersOK() {
        System.out.println("initializePlayers");
        playersData = appEAC4.initializePlayers(TEST_PLAYERS_NUMBER);;
        assertEquals(TEST_PLAYERS_NUMBER, playersData.length);
        assertEquals(PLAYERS_MATRIX_COLUMNS, playersData[0].length);
        for (String[] row: playersData) {
            for (String playerData: row) {
                assertEquals("", playerData);
            }
        }
    }

    @Test
    public void testInitializePlayersNullIfPlayersNegative() {
        System.out.println("initializePlayers");
        int playersNumber = -1;
        appEAC4.initializePlayers(playersNumber);
        assertNull(playersData);
    }

    /**
     * Test of askForString method, of class AppBowling.
     */
    @Test
    public void testAskForStringOK() {
        System.out.println("testAskForStringOK");
        provideInput(MESSAGE_TEST_INPUT);
        String result = appEAC4.askForString(MESSAGE_ASK_ANYTHING, MESSAGE_ERROR);
        assertEquals(MESSAGE_TEST_INPUT, result);
    }

    @Test
    public void testAskForStringNotOKIfEmpty() {
        System.out.println("testAskForStringNotOKIfEmpty");
        provideInput("\n" + MESSAGE_TEST_INPUT);
        String result = appEAC4.askForString(MESSAGE_ASK_ANYTHING, MESSAGE_ERROR);
        assertEquals(MESSAGE_TEST_INPUT, result);
    }

    /**
     * Test of askForInteger method, of class AppBowling.
     */
    @Test
    public void testAskForIntegerOK() {
        System.out.println("testAskForIntegerOK");
        provideInput(String.valueOf(INT_TEST_INPUT)+"\n");
        int result = appEAC4.askForInteger(MESSAGE_ASK_ANYTHING, MESSAGE_ERROR);
        assertEquals(INT_TEST_INPUT, result);
    }
    
    @Test
    public void testAskForIntegerNotOKIfString() {
        System.out.println("testAskForIntegerNotOKIfString");
        provideInput(MESSAGE_TEST_INPUT + "\n" + String.valueOf(INT_TEST_INPUT)+"\n");
        int result = appEAC4.askForInteger(MESSAGE_ASK_ANYTHING, MESSAGE_ERROR);
        assertEquals(INT_TEST_INPUT, result);
    }
 
    @Test
    public void testAskForIntegerNotOKIfFloat() {
        System.out.println("testAskForIntegerNotOKIfFloat");
        provideInput(FLOAT_TEST_INPUT + "\n" + String.valueOf(INT_TEST_INPUT)+"\n");
        int result = appEAC4.askForInteger(MESSAGE_ASK_ANYTHING, MESSAGE_ERROR);
        assertEquals(INT_TEST_INPUT, result);
    }

    /**
     * Test of insertPlayerNames method, of class AppBowling.
     */
    @Test
    public void testInsertPlayerNames_NullArray() {
        String[][] playersData = null;
        int rowNumber = 0;
        String name = "John";
        String lastName = "Doe";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // Since the array is null, no changes should be made
        assertArrayEquals(null, playersData);
    }

    @Test
    public void testInsertPlayerNames_InvalidRowNumber_Negative() {
        String[][] playersData = new String[3][3];
        int rowNumber = -1;
        String name = "John";
        String lastName = "Doe";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the row number is invalid
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_InvalidRowNumber_GreaterThanLength() {
        String[][] playersData = new String[3][3];
        int rowNumber = 4;
        String name = "John";
        String lastName = "Doe";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the row number is invalid
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_NullName() {
        String[][] playersData = new String[3][3];
        int rowNumber = 0;
        String name = null;
        String lastName = "Doe";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the name is null
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_EmptyName() {
        String[][] playersData = new String[3][3];
        int rowNumber = 0;
        String name = "";
        String lastName = "Doe";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the name is empty
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_NullLastName() {
        String[][] playersData = new String[3][3];
        int rowNumber = 0;
        String name = "John";
        String lastName = null;
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the last name is null
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_EmptyLastName() {
        String[][] playersData = new String[3][3];
        int rowNumber = 0;
        String name = "John";
        String lastName = "";
        int age = 30;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the last name is empty
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_NegativeAge() {
        String[][] playersData = new String[3][3];
        int rowNumber = 0;
        String name = "John";
        String lastName = "Doe";
        int age = -10;

        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);

        // No changes should be made since the age is negative
        assertArrayEquals(new String[3][3], playersData);
    }

    @Test
    public void testInsertPlayerNames_ValidData() {
        String[][] playersData = new String[3][3];
        int rowNumber = 1;
        String name = "Jane";
        String lastName = "Smith";
        int age = 25;
    
        appEAC4.insertPlayerNames(playersData, rowNumber, name, lastName, age);
    
        String[][] expectedData = new String[3][3];
        expectedData[rowNumber][INDEX_NAME] = name;
        expectedData[rowNumber][INDEX_LAST_NAME] = lastName;
        expectedData[rowNumber][INDEX_AGE] = String.valueOf(age);
    
        assertArrayEquals(expectedData, playersData);
    }
    
    /* 
     * Test of setRoundPoints method, of class AppBowling.
     */
    @Test
    public void testSetRoundPoints_NullMatrix() {
        int[][] pointsMatrix = null;
        int rowIndex = 0;
        int round = 1;
        int points = 5;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the matrix is null
        assertNull(pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidRowIndex_Negative() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = -1;
        int round = 1;
        int points = 5;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the row index is invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidRowIndex_GreaterThanLength() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = pointsMatrix.length;
        int round = 1;
        int points = 5;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the row index is invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidRound_LessthanOne() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = 0;
        int round = 0;
        int points = 5;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the round is invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidRound_GreaterThanThrows() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = 0;
        int round = THROWS_NUMBER + 1;
        int points = 5;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the round is invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidPoints_Negative() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = 0;
        int round = 1;
        int points = -2;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the points are invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_InvalidPoints_GreaterThanMax() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = 0;
        int round = 1;
        int points = MAX_POINTS + 1;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        // No changes should be made since the points are invalid
        assertArrayEquals(new int[2][THROWS_NUMBER], pointsMatrix);
    }

    @Test
    public void testSetRoundPoints_ValidData() {
        int[][] pointsMatrix = new int[2][THROWS_NUMBER];
        int rowIndex = 1;
        int round = 2;
        int points = 8;

        appEAC4.setRoundPoints(pointsMatrix, rowIndex, round, points);

        int[][] expectedMatrix = new int[2][THROWS_NUMBER];
        expectedMatrix[rowIndex][round - 1] = points;

        assertArrayEquals(expectedMatrix, pointsMatrix);
    }

    /* 
     * Test of showRounds method, of class AppBowling.
     */
    @Test
    public void testShowRounds_NullPlayersData() {
        String[][] playersData = null;
        int[][] pointsMatrix = new int[2][3];

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        appEAC4.showRounds(playersData, pointsMatrix);

        System.setOut(System.out); // Restore standard output

        assertEquals("", outContent.toString());
    }

    @Test
    public void testShowRounds_NullPointsMatrix() {
        String[][] playersData = new String[2][2];
        int[][] pointsMatrix = null;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        appEAC4.showRounds(playersData, pointsMatrix);

        System.setOut(System.out); // Restore standard output

        assertEquals("", outContent.toString());
    }

    @Test
    public void testShowRounds_DifferentArrayLengths() {
        String[][] playersData = new String[2][2];
        int[][] pointsMatrix = new int[3][3];

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        appEAC4.showRounds(playersData, pointsMatrix);

        System.setOut(System.out); // Restore standard output

        assertEquals("", outContent.toString());
    }

    @Test
    public void testShowRounds_EmptyData() {
        String[][] playersData = new String[0][0];
        int[][] pointsMatrix = new int[0][0];

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        appEAC4.showRounds(playersData, pointsMatrix);

        System.setOut(System.out); // Restore standard output

        // Since data is empty, no output is expected
        assertEquals("", outContent.toString());
    }
}
