package com.bicycleapp.demo.model;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Tablo olarak tasarlanmış bir veritabanı tablosunu temsil etmek için
 * kullanılan bir Java sınıfıdır. "users" adlı bir veritabanı tablosunu temsil
 * eder. @Entity, bu sınıfın bir JPA varlığı olduğunu belirtir. @Table, varlığın
 * karşılık geldiği veritabanı tablosunun adını belirtir.
 * 
 * Sınıfın özellikleri tabloda bulunan sütunlara karşılık gelir. Örneğin,
 * "first_name" adlı bir sütun, "firstName" özelliği ile eşleştirilir. Aynı
 * şekilde, "email" adlı bir sütun, "email" özelliği ile eşleştirilir. @Id, bu
 * sınıfın birincil anahtarının "id" özelliğinin değerine göre oluşturulacağını
 * belirtir. @GeneratedValue, birincil anahtarın otomatik olarak
 * oluşturulacağını belirtir.
 * 
 * @Lazy, bu sınıfın yalnızca ihtiyaç duyulduğunda yüklenmesi gerektiğini
 * belirtir. Bu, sınıfın özelliklerine erişildiğinde yalnızca o zaman yüklenir.
 * Bu, uygulamanın performansını artırabilir.
 * 
 * Sınıfın kurucu metodları, özelliklerin değerlerini ayarlamak için kullanılır.
 * Sınıfın diğer özelliklerine erişmek için get ve set metotları vardır.
 * 
 * Bu sınıf, bir veritabanı tablosunu temsil etmek için kullanılan ve
 * özelliklerin sütunlara karşılık geldiği bir JPA varlığıdır.
 */
@Entity
@Table(name = "users")
@Lazy
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // getter ve setter metodları

}
