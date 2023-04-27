package data.repositories;

import shitta.data.model.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shitta.data.repositories.PackageRepository;
import shitta.data.repositories.PackageRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {

    private PackageRepository packageRepository;

    @BeforeEach

    public void setUp(){
        packageRepository = new PackageRepositoryImpl();
    }

    @Test
    @DisplayName("Create new Package Test")
    public void saveOnePackage_countIsOneTes(){

        Package aPackage = new Package();

        assertEquals(0, packageRepository.count());
        packageRepository.save(aPackage);

        assertEquals(1, packageRepository.count());

    }

    @Test
    @DisplayName("Generate ID test")
    public void saveOnePackage_IdIsOneTest(){
        Package aPackage = new Package();

        assertEquals(0, aPackage.getId());
        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());

    }

    @Test
    @DisplayName("Find by id test")
    public void saveOnePackage_findPackageById_returnSavedPackageTest(){
        Package aPackage = new Package();
        aPackage.setPayOnDelivery(true);
        packageRepository.save(aPackage);
        Package foundPackage = packageRepository.findById(1);
        assertEquals(1, foundPackage.getId());
        assertEquals(true, foundPackage.isPayOnDelivery());
        assertEquals(aPackage, foundPackage);

    }

    @Test
    @DisplayName("Update test")
    public void saveTwoItemsWithSame_countIsOneTest(){
        Package aPackage = new Package();
        aPackage.setWeightGram(34);
        packageRepository.save(aPackage);
        Package savedPackage = packageRepository.findById(1);
        assertEquals(aPackage, savedPackage);
//        packageRepository.save(aPackage);

        Package secondPackage = new Package();
        secondPackage.setId(1);
        secondPackage.setWeightGram(22);
        packageRepository.save(secondPackage);
        Package foundPackage = packageRepository.findById(1);

        assertEquals(foundPackage, secondPackage);
        assertNotEquals(foundPackage, aPackage);

    }

}