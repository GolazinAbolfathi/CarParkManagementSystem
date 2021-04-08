package com.example.CarParkManagementSystem.dao;


import com.example.CarParkManagementSystem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository is annotated with @Repository already
public interface UsersDatabase extends MongoRepository<User, String> {
    // Basic methods are pre-defined in MongoRepository
    // Extras can be added here following the auto-generation
    // naming restrictions.
    User getUserByUsernameAndPassword(String username, String password);

    // If more complex queries are required, an actual implementation
    // class will need to be created.
    default String getFirstNameByUsernameAndPassword(String username, String password) {
        return getUserByUsernameAndPassword(username, password).getFirst_name();
    }
}
