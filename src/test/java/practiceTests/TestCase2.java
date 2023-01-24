package practiceTests;

public class TestCase2 {
	public static void main(String[] args) {
		TestCase2 test = new TestCase2();
		test.testB();
	}
	
	public void testB() {
		System.out.println("Inside Test B");
		TestCase3 tests = new TestCase3();
		tests.testA();
	}
}