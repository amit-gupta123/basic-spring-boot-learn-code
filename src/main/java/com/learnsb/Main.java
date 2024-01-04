package com.learnsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        Student amit = new Student(
                "Amit Gupta",
                1,
                "amit@gmail.com"
        );
        studentList.add(amit);
        Student anvi = new Student(
                "Anvi joshi",
                2,
                "anvi@gmail.com"
        );
       studentList.add(anvi);
    }



    public static void main(String[] args) {
        // this method return configurable context.
        System.out.println(studentList);
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public String greet(){
        return "hello";
    }

//    @GetMapping("/greet-json")
//    public GreetResponse greetJson(){
//        return new GreetResponse("Happy Learning");
//        // the key in json is parameter name in records.
//    }


    // this class is same as using the below record
//    class GreetResponse{
//        private final String greet;
//
//        public GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//        public String getGreet(){
//            // the response is going just because of this getter.
//            // otherwise you will get error.
//            return this.greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }


    // this is records
//    record GreetResponse(String greet){
//    }


    // define another endpoint

    @GetMapping("/intro")
    public IntroData getData(){
        return new IntroData(
                "Hi, Happy Learning",
                    List.of("Hindi","English","Punjabi","Bhojpuri","Haryanvi"),
                    new Person("Amit Gupta",24,30_000)
        );
    }
    record Person(String name, int age, int savings){}
    record IntroData(
                     String greet,
                     List<String> spokenLanguage,
                     Person person
                     ){}


    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentList;
    }

//    @GetMapping("student/{id}")
//    public int getId(@PathVariable int id){
//        Student student = studentList.stream().filter(student1->student1.id);
//    }

    static class Student{
        private int id;
        private String name;
        private String email;

        public Student(){}
        public Student(String name, int id, String email){
            this.name = name;
            this.id= id;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id && Objects.equals(name, student.name) && Objects.equals(email, student.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, email);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
        // Student class ends here
    }
    // Main class ends here
}
