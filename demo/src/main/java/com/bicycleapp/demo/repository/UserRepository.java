package com.bicycleapp.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bicycleapp.demo.model.User;


/*
 * UserRepository sınıfını oluşturduk: JPARepository sınıfını genişleten bir arayüz. 
 * Bu, veritabanı işlemlerini gerçekleştirmek için kullanacağımız CRUD işlevlerini içeriyor.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
/*
 * CRUD, Create (Oluşturma), Read (Okuma), Update (Güncelleme) ve Delete (Silme)
 * işlemlerini ifade eden bir kısaltmadır. Veri tabanları ve veri tabanı
 * işlemleri ile ilgili kullanılır. CRUD işlemleri, bir web uygulaması gibi
 * birçok farklı yazılımda kullanılabilir.
 * 
 * Create (Oluşturma): Veritabanına yeni kayıt eklemek için kullanılır. Yeni bir
 * kayıt oluşturulur ve veri tabanına kaydedilir.
 * 
 * Read (Okuma): Veri tabanından kayıtları okumak için kullanılır. Okunan
 * kayıtlar kullanıcıya gösterilir.
 * 
 * Update (Güncelleme): Veri tabanında bulunan bir kaydı güncellemek için
 * kullanılır. Mevcut bir kayıt, yeni bilgilerle güncellenir ve veri tabanına
 * kaydedilir.
 * 
 * Delete (Silme): Veri tabanından bir kaydı silmek için kullanılır. Kayıt veri
 * tabanından silinir ve artık görüntülenemez veya kullanılamaz.
 */