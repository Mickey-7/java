package com.example.Java_Guides_Lombok;

import com.example.Java_Guides_Lombok.domain.UserLombokModel;
import lombok.Cleanup;
import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;



@SpringBootApplication
public class JavaGuidesLombokApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(JavaGuidesLombokApplication.class, args);

		//Testing
		//As we installed Lombok plugin in eclipse so we can test Project Lombok annotations.
		//Let's create a main() method and test Lombok annotations.

		//test @AllArgsConstructor
		UserLombokModel lombokModel = new UserLombokModel(100L,"Ramesh","Fadatare",28,"Male", LocalDateTime.now());
		System.out.println(lombokModel);
		//@ToString
		//console output : UserLombokModel(id=100, firstName=Ramesh, lastName=Fadatare, age=28, gender=Male)
		//@ToString(exclude = "createdDatetime")
		//console output : UserLombokModel(id=100, firstName=Ramesh, lastName=Fadatare, age=28, gender=Male, createdDateTime=2020-04-14T14:08:19.236654600)


		//test @NoArgsConstructor
		UserLombokModel userLombokModel = new UserLombokModel();

		//test setter & getter
		userLombokModel.setId(700L);
		userLombokModel.setFirstName("Lombok");
		userLombokModel.setLastName("Dependency");
		userLombokModel.setAge(27);
		userLombokModel.setGender("Female");
		userLombokModel.setCreatedDateTime(LocalDateTime.now());

		System.out.println(userLombokModel.getId());
		System.out.println(userLombokModel.getFirstName());
		System.out.println(userLombokModel.getLastName());
		System.out.println(userLombokModel.getAge());
		System.out.println(userLombokModel.getGender());
		System.out.println(userLombokModel.getCreatedDateTime());

		System.out.println(userLombokModel.toString());

		//@Data is a convenient shortcut annotation that bundles the features of
		//@ToString, @EqualsAndHashCode, @Getter / @Setter, and @RequiredArgsConstructor together.


		//Project Lombok - Automatic Resource Management using @Cleanup
		//since java 7 - try/catch
		try {
			FileReader fileReader = new FileReader("src\\main\\READ ME.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String lines;

			while ((lines = bufferedReader.readLine()) != null){
				System.out.println(lines);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//with lombok
		@Cleanup
		FileReader fileReader1 = new FileReader("src\\main\\READ ME.txt");

		@Cleanup
		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		String lines1;

		//then just throw the exception for readline()
		while ((lines1 = bufferedReader1.readLine()) != null){
			System.out.println(lines1);
		}


		//Project Lombok - @NonNull Annotation Example
//		//without lombok
//		NonNullExampleWithOutLombok example = new NonNullExampleWithOutLombok(null);

		//with lombok - not null
		NonNullExampleWithLombok example1 = new NonNullExampleWithLombok("Java");
		//output
		//Java

		//with lombok - null
		NonNullExampleWithLombok example12 = new NonNullExampleWithLombok(null);
		//output
		//Exception in thread "main" java.lang.NullPointerException: name is marked non-null but is null
		//name is the variable used for the input String on the inner class below

	}


//	//without lombok
//	private static class NonNullExampleWithOutLombok {
//		private String name;
//		public NonNullExampleWithOutLombok(String name){
//			if (name==null){
//				throw new NullPointerException("without lombok - person is marked @NonNull but is null");
//			}
//			System.out.println(name);
//		}
//	}

	//with lombok
	private static class NonNullExampleWithLombok {
		private String name;
		public NonNullExampleWithLombok(@NonNull String name){
			System.out.println(name);
		}
	}






}
