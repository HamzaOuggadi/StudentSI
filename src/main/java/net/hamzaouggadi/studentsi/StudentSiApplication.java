package net.hamzaouggadi.studentsi;

import com.github.javafaker.Faker;
import net.hamzaouggadi.studentsi.entities.Student;
import net.hamzaouggadi.studentsi.enums.Gender;
import net.hamzaouggadi.studentsi.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class StudentSiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(StudentRepository studentRepository) {
        return args -> {
            Faker faker = new Faker();

            for (int i = 0; i < 10; i++) {

                Random random = new Random();

                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();

                Student student = Student.builder()
                        .fullName(firstName + " " + lastName)
                        .email(firstName + lastName + "@gmail.com")
                        .phoneNumber(faker.phoneNumber().phoneNumber())
                        .gender(random.nextBoolean() ? Gender.MALE : Gender.FEMALE)
                        .build();

                studentRepository.save(student);
            }
        };
    }

}
