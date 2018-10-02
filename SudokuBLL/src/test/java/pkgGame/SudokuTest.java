package pkgTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgGame.Sudoku;
public class SudokuTest {
	@Test
	public void Sudoku_Test1() {

		try {
			Sudoku s1 = new Sudoku(9);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}
	@Test(expected = Exception.class)
	public void Sudoku_Test2() throws Exception {

		Sudoku s1 = new Sudoku(10);

	}
	@Test
	public void getRegionNbr_Test1() {
		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int ExpectedRegionNbr = 1;
		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2
		
		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertEquals(s1.getRegionNbr(3,0),ExpectedRegionNbr);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
	}
	@Test
	public void getRegionNbr_Test2() {
		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int ExpectedRegionNbr = 2;
		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2
		
		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertEquals(s1.getRegionNbr(0,3),ExpectedRegionNbr);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
	}
	@Test
	public void getRegionNbr_Test3() {
		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int ExpectedRegionNbr = 0;
		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2
		
		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertEquals(s1.getRegionNbr(0,0),ExpectedRegionNbr);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
	}
	@Test
	public void getRegion_Test1() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 3, 4, 1, 2 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(1);
			System.out.println(Arrays.toString(region));			
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}
	
	@Test
	public void getRegion_Test2() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 2, 1, 4, 3 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region at 0,2 = 2 1 4 3

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(0,2);
			System.out.println(Arrays.toString(region));			
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}
	
	@Test
	public void Sudoku_test1()
	{
		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
		{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
		{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertTrue(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}
	
	@Test
	public void Sudoku_test2()
	{
		int[][] puzzle = { { 5, 5, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
		{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
		{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}
	
	@Test
	public void Sudoku_test3()
	{
		int[][] puzzle = { 
				{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 5, 7, 2, 1, 9, 5, 3, 4, 8 }, 
				{ 5, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}
	
	@Test
	public void Sudoku_test4()
	{
		int[][] puzzle = { 
				{ 55, 3, 4, 6, 7, 8, 9, 1, 2 }, 
				{ 6, 7, 2, 1, 9, 5, 3, 4, 8 }, 
				{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
				{ 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
				{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
				{ 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
				{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}	
	
	@Test
	public void PartialSudoku_Test1()
	{
		//	This test will test a partial sudoku...  a zero in [0,0]...  everything else works
		//	but the first element in the puzzle is zero 
		
		int[][] puzzle = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
		{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
		{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertTrue(s1.isPartialSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}
	
	@Test
	public void PartialSudoku_Test2()
	{
		//	This test will test a partial sudoku...  
		//	Everything zero, but there's a duplciate value in the region (not row/column)
 
		
		int[][] puzzle = {
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isPartialSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
	}
	
	@Test
	public void PartialSudoku_Test3()
	{
		//	This is a working solution, make sure it fails isPartiaSudoku()
		
		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
		{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
		{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isPartialSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}
		
	}	
	@Test
	public void shuffleArray_test1()
	{
		Sudoku s1= null;
		
		int[][] puzzle = { 
				{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,5,1,2}};
		
		int [] Region1 = {1,2,3,4};
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleArray(Region1);
			 System.out.println(Arrays.toString(Region1));
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
			
			
		
	}
	
	@Test
	public void shuffleArray_test2()
	{
		Sudoku s1= null;
		
		int[][] puzzle = { 
				{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,5,1,2}};
		
		int [] Region2 = {4,3,2,1};
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleArray(Region2);
			 System.out.println(Arrays.toString(Region2));
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
			
			
		
	}
	
	@Test
	public void shuffleArray_test3()
	{
		Sudoku s1= null;
		
		int[][] puzzle = { 
				{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,5,1,2}};
		
		int [] Region3 = {2,1,4,3};
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleArray(Region3);
			 System.out.println(Arrays.toString(Region3));
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	@Test
	public void shuffleRegion_test1() {
		Sudoku s1= null;
		
		int[][] puzzle = {{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,4,1,2}};
		
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleRegion(2);
			 s1.printPuzzle();
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	@Test
	public void shuffleRegion_test2() {
		Sudoku s1= null;
		
		int[][] puzzle = {{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,4,1,2}};
		
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleRegion(0);
			 s1.printPuzzle();
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	@Test
	public void shuffleRegion_test3() {
		Sudoku s1= null;
		
		int[][] puzzle = {{1,2,3,4},{4,3,2,1},{2,1,4,3},{3,4,1,2}};
		
		try {
			 s1 = new Sudoku(puzzle);
			 s1.shuffleRegion(3);
			 s1.printPuzzle();
		} catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	@Test
	public void fillDiagonalRegions_Test1() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		try {
			s1 = new Sudoku(puzzle);
			s1.fillDiagonalRegions();
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	
	@Test
	public void fillDiagonalRegions_Test2() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
		
		try {
			s1 = new Sudoku(puzzle);
			s1.fillDiagonalRegions();
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	@Test
	public void fillDiagonalRegions_Test3() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		try {
			s1 = new Sudoku(puzzle);
			s1.fillDiagonalRegions();
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	
	@Test
	public void setRegion_Test1() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		try {
			int r=1;
			s1 = new Sudoku(puzzle);
			s1.setRegion(r);
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	
	@Test
	public void setRegion_Test2() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		try {
			int r=0;
			s1 = new Sudoku(puzzle);
			s1.setRegion(r);
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
	
	@Test
	public void setRegion_Test3() {
		Sudoku s1 = null;
		int[][] puzzle = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		try {
			int r=3;
			s1 = new Sudoku(puzzle);
			s1.setRegion(r);
			s1.printPuzzle();
		}
		catch (Exception e) {
			fail("Bad Sudoku");
		}
	}
}
