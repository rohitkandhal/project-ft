package home;

public class Inheritance2 {

	// Inheritance Test with Overriding

	public class SuperClass {
		public void foo(SuperClass superObj) {
			System.out.println("Super class foo");
		}
	}

	public class SubClass extends SuperClass {
		public void foo(SubClass subObj) {
			System.out.println("Sub class foo");
		}

		public void foo(SuperClass superObj) {
			System.out.println("Overriden: Sub class Super class obj");
		}
	}

	public void testInheritance2() {
		SuperClass superObj = new SuperClass();
		SubClass subObj = new SubClass();
		SuperClass subSuperObj = new SubClass();

		superObj.foo(superObj); 	// Super class foo
		superObj.foo(subObj); 		// Super class foo
		superObj.foo(subSuperObj);	// Super class foo

		subObj.foo(superObj); 		// Overriden: Sub class Super class obj
		subObj.foo(subObj); 		// Sub class foo
		subObj.foo(subSuperObj); 	// Overriden: Sub class Super class obj
		
		subSuperObj.foo(superObj); 	// Overriden: Sub class Super class obj
		subSuperObj.foo(subObj); 	// Overriden: Sub class Super class obj
		subSuperObj.foo(subSuperObj); // Overriden: Sub class Super class obj
	}

}
