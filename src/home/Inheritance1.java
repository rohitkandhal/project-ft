package home;

public class Inheritance1 {

	// Inheritance Test without Overriding
	
	public class SuperClass
	{
		public void foo(SuperClass superObj){
			System.out.println("Super class foo");
		}
	}
	
	public class SubClass extends SuperClass
	{
		public void foo(SubClass subObj)
		{
			System.out.println("Sub class foo");
		}
	}
	
	public void testInheritance1()
	{
		SuperClass superObj = new SuperClass();
		SubClass subObj = new SubClass();
		SuperClass subSuperObj = new SubClass();
	
		superObj.foo(superObj);		// Super class foo
		superObj.foo(subObj);		// Super class foo
		superObj.foo(subSuperObj);	// Super class foo
		
		subObj.foo(superObj); 		// Super class foo
		subObj.foo(subObj);			// Sub class foo
		subObj.foo(subSuperObj);	// Super class foo
		
		subSuperObj.foo(superObj);	// Super class foo
		subSuperObj.foo(subObj);	// Super class foo
		subSuperObj.foo(subSuperObj);	// Super class foo
		
	}
}
