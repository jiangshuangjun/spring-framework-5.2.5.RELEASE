package springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
class JavaConfig {

	@Bean
	public Person person() {
		return new Person("李小龙", 33);
	}

}

class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

/**
 * @author jiangShuangjun
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext ac1 = new AnnotationConfigApplicationContext(JavaConfig.class);
		Person person = (Person) ac1.getBean("person");
		System.out.println(person);
	}
}
