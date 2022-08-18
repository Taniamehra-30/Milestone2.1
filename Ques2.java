Description:

Create 3 different examples according to your choice for following

· Constructor based Dependency Injection

· Setter based Dependency Injection

· Field or Property-based Dependency Injection
===========================================================
HAND CLASS
package com.godigit.Demo2;

public class Hand {
	@Override
	//toString function 
	public String toString() {
		return "Hand [fingers=" + fingers + ", nails=" + nails + ", thumbs=" + thumbs + "]";
	}
	private int fingers;
	private String nails;
	private String thumbs;
	//get method for variables
	public int getFingers() {
		return fingers;
	}
	public String getNails() {
		return nails;
	}
	public String getThumbs() {
		return thumbs;
	}
	//default constructor
	public Hand() {
		super();
		
	}
	//parameterized constructor 
	public Hand(int fingers, String nails, String thumbs) {
		super();
		this.fingers = fingers;
		this.nails = nails;
		this.thumbs = thumbs;
	}
}
==============================================================================
HUMAN CLASS
package com.godigit.Demo2;
public class Human {
	
	private int eyes;
	private int ears;
	private int nose;
	private Hand hand;
	//Getter method
	public int getEyes()
	{
		return eyes;
	}
	public int getEars() 
	{
		return ears;
	}
	public int getNose() 
	{
		return nose;
	}
	public Hand getHands() 
	{
		return hand;
	}//Parameterized constructor
	public Human(int eyes, int ears, int nose, Hand hand) {
		//calling super class
		super();
		this.eyes = eyes;
		this.ears = ears;
		this.nose = nose;
		this.hand = hand;
	}
	}
==============================================================================
HEART CLASS(MAIN.CLASS)
package com.godigit.Demo2;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Heart {
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		//creating Human class object
		Human human= (Human)context.getBean("hooman");
		//printing output
		System.out.println("Eyes="+human.getEyes());
		System.out.println("Ears="+human.getEars());
		System.out.println("Nose="+human.getNose());
		System.out.println("Hands="+human.getHands());
}
	}
==============================================================================
BEAN.XML FILE
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
   
   <bean id="hands" class="com.godigit.Demo2.Hand">
   <constructor-arg name="fingers" value="10"></constructor-arg>
    <constructor-arg name="nails" value="ten"></constructor-arg>
   <constructor-arg name="thumbs" value="two"></constructor-arg>
   </bean>
   <bean id="hooman" class="com.godigit.Demo2.Human">
    <constructor-arg name="eyes" value="2"></constructor-arg>
    <constructor-arg name="ears" value="2"></constructor-arg>
   <constructor-arg name="nose" value="1"></constructor-arg>
   <constructor-arg name="hand" ref="hands"></constructor-arg>
   </bean>
   </beans>
 

============================================================
SOL 2
=================

package com.digit.setter;

public class Shape {
    private String square;
    public String getSquare() {
        return square;
    }
    public void setSquare(String square) {
        this.square = square;
    }
    public String getCircle() {
        return circle;
    }
    public void setCircle(String circle) {
        this.circle = circle;
    }
    private String circle;
}




package com.digit.setter;

public class Draw {
        private Shape shape;
        public Shape getShape() {
            return shape;
        }
        public void setShape(Shape shape) {
            this.shape = shape;
        }
        public String getSun() {
            return sun;
        }
        public void setSun(String sun) {
            this.sun = sun;
        }
        private String sun;
        public void show() {
            System.out.print("sun is being drawn");
        }
}



package com.digit.setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {

   public static void main(String[] args) {
        //ApplicationContext is used to manage the object instead of directly creating objects
        //ClassPathXmlApplicationContext is a way to load the classPath to the Test class
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        //creating object of Draw class and fetching properties of eat class from bean.xml
          Draw d = (Draw) context.getBean("draw");
          System.out.println(d.getSun());
          d.show();
    }

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns = "http://www.springframework.org/schema/beans"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
   
   <bean id="draw" class="com.digit.setter.Draw" autowire="byName">
   <property name="sun" value="yes"></property>
   </bean>
   <bean id="shape" class="com.digit.setter.Shape">
   </bean>  
    </beans>
 

=============================================================
Sol 3
=================
package com.digit.field;

public class Age {
    private String month;
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    private String year;
    @Override
    public String toString() {
        return "Age [month=" + month + ", year=" + year + "]";
    }
}


package com.digit.field;
public class Person {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Age getAge() {
        return age;
    }
    public void setAge(Age age) {
        this.age = age;
    }
    private Age age;

}


package com.digit.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
//ApplicationContext is used to manage the object instead of directly creating objects
//ClassPathXmlApplicationContext is a way to load the classPath to the Test class     
   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");        
//creating object of Person class and fetching properties of eat class from bean.xml    
      Person pe = (Person) context.getBean("person");    
      System.out.println(pe.getName());    }

}


<?xml version="1.0" encoding="UTF-8"?>
<!--bean.xml file to assign unique IDs to different beans and to control the creation  of objects with different values without impacting any of the Spring source files -->  
<beans xmlns = "http://www.springframework.org/schema/beans"   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"   xsi:schemaLocation = "http://www.springframework.org/schema/beans   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
<bean id="person" class="com.digit.field.Person" autowire="byType">
<property name="name" value="Tania"></property>
</bean>
<bean id="age" class="com.digit.field.Age"></bean>
</beans>

 


















