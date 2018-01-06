package com.singh.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends GenericJPAModel {

        @Column(name = "FIRST_NAME", nullable = false)
        private String firstName;

        @Column(name = "LAST_NAME", nullable = false)
        private String lastName;

        @Column(name = "EMAIL", nullable = false)
        private String email;

        @Column(name = "CUSTOMER_PASSWORD", nullable = false)
        private String password;
        
        @Column(name = "GENDER", nullable = false)
        private String gender;
        
        @Column(name = "DOB", nullable = false)
        private Date dateOfBirth;

        public String getFirstName() {
          return firstName;
        }

        public void setFirstName(String firstName) {
          this.firstName = firstName;
        }

        public String getLastName() {
          return lastName;
        }

        public void setLastName(String lastName) {
          this.lastName = lastName;
        }

        public String getEmail() {
          return email;
        }

        public void setEmail(String email) {
          this.email = email;
        }

        public String getPassword() {
          return password;
        }

        public void setPassword(String password) {
          this.password = password;
        }

        public String getGender() {
          return gender;
        }

        public void setGender(String gender) {
          this.gender = gender;
        }

        public Date getDateOfBirth() {
          return dateOfBirth;
        }

        public void setDateOfBirth(Date dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
          return "User [firstName=" + firstName
              + ", lastName="
              + lastName
              + ", email="
              + email
              + ", password="
              + password
              + ", gender="
              + gender
              + ", dateOfBirth="
              + dateOfBirth
              + "]";
        }

}